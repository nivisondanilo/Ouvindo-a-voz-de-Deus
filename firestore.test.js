const {
  initializeTestEnvironment,
  assertFails,
  assertSucceeds,
} = require("@firebase/rules-unit-testing");
const { test, before, after, beforeEach } = require("node:test");
const fs = require("node:fs");

let testEnv;
const PROJECT_ID = process.env.GCP_PROJECT || "demo-no-project";
const ALICE_UID = "alice_youth_123";
const BOB_UID = "bob_youth_456";

const [emulatorHost, emulatorPortStr] = (
  process.env.FIRESTORE_EMULATOR_HOST || "127.0.0.1:8085"
).split(":");
const emulatorPort = parseInt(emulatorPortStr, 10);

before(async () => {
  const rules = fs.readFileSync("./firestore.rules", "utf8");
  testEnv = await initializeTestEnvironment({
    projectId: PROJECT_ID,
    firestore: {
      rules,
      host: emulatorHost,
      port: emulatorPort,
    },
  });
});

after(async () => {
  if (testEnv) {
    await testEnv.cleanup();
  }
});

beforeEach(async () => {
  if (testEnv) {
    await testEnv.clearFirestore();
  }
});

test("Unauthenticated user cannot read or write any user backup data", async () => {
  const unauthDb = testEnv.unauthenticatedContext().firestore();
  const now = new Date(Date.now() - 1000);

  await assertFails(unauthDb.collection("users").doc(ALICE_UID).get());
  await assertFails(
    unauthDb.collection("users").doc(ALICE_UID).set({
      userId: ALICE_UID,
      displayName: "Alice",
      xp: 100,
      streakDays: 2,
      totalStudySeconds: 300,
      completedLessonIds: [1],
      unlockedBadgeIds: ["first_step"],
      selectedPlanId: "plan_7",
      completedPlanDays: [1],
      preferredLanguage: "pt",
      createdAt: now,
      updatedAt: now,
    })
  );
  await assertFails(
    unauthDb
      .collection("users")
      .doc(ALICE_UID)
      .collection("bible_notes")
      .get()
  );
});

test("Owner can create and update user backup profile, but cannot mutate createdAt or inject ghost fields", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();
  const created = new Date(Date.now() - 5000);

  await assertSucceeds(
    aliceDb.collection("users").doc(ALICE_UID).set({
      userId: ALICE_UID,
      displayName: "Lucas",
      xp: 250,
      streakDays: 4,
      totalStudySeconds: 900,
      completedLessonIds: [1, 2],
      unlockedBadgeIds: ["first_step"],
      selectedPlanId: "plan_7",
      completedPlanDays: [1, 2],
      preferredLanguage: "pt",
      createdAt: created,
      updatedAt: created,
    })
  );

  await assertSucceeds(
    aliceDb.collection("users").doc(ALICE_UID).update({
      xp: 350,
      completedLessonIds: [1, 2, 3],
      updatedAt: new Date(Date.now() - 1000),
    })
  );

  // Reject ghost field
  await assertFails(
    aliceDb.collection("users").doc(ALICE_UID).update({
      xp: 400,
      isAdmin: true,
      updatedAt: new Date(Date.now() - 1000),
    })
  );

  // Reject immutable createdAt overwrite
  await assertFails(
    aliceDb.collection("users").doc(ALICE_UID).update({
      createdAt: new Date(Date.now() - 500),
      updatedAt: new Date(Date.now() - 500),
    })
  );

  // Reject future timestamp
  await assertFails(
    aliceDb.collection("users").doc(ALICE_UID).update({
      updatedAt: new Date(Date.now() + 60000),
    })
  );
});

test("Cross-user isolation blocks reading or modifying another user's backup", async () => {
  const bobDb = testEnv.authenticatedContext(BOB_UID).firestore();
  const created = new Date(Date.now() - 5000);

  await assertSucceeds(
    bobDb.collection("users").doc(BOB_UID).set({
      userId: BOB_UID,
      displayName: "Bob",
      xp: 50,
      streakDays: 1,
      totalStudySeconds: 120,
      completedLessonIds: [],
      unlockedBadgeIds: [],
      selectedPlanId: "plan_14",
      completedPlanDays: [],
      preferredLanguage: "en",
      createdAt: created,
      updatedAt: created,
    })
  );

  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();
  await assertFails(aliceDb.collection("users").doc(BOB_UID).get());
  await assertFails(
    aliceDb.collection("users").doc(BOB_UID).update({ xp: 9999, updatedAt: new Date(Date.now() - 1000) })
  );
  await assertFails(
    aliceDb.collection("users").doc(BOB_UID).collection("bible_notes").get()
  );
});

test("Owner can manage lesson_progress and bible_notes subcollections without @DocumentId id key", async () => {
  const aliceDb = testEnv.authenticatedContext(ALICE_UID).firestore();
  const created = new Date(Date.now() - 5000);

  await assertSucceeds(
    aliceDb
      .collection("users")
      .doc(ALICE_UID)
      .collection("lesson_progress")
      .doc("lesson_1")
      .set({
        lessonNumber: 1,
        completed: true,
        quizScore: 4,
        quizTotal: 4,
        studySeconds: 240,
        createdAt: created,
        updatedAt: created,
      })
  );

  await assertSucceeds(
    aliceDb
      .collection("users")
      .doc(ALICE_UID)
      .collection("lesson_progress")
      .doc("lesson_1")
      .update({
        studySeconds: 300,
        updatedAt: new Date(Date.now() - 1000),
      })
  );

  await assertSucceeds(
    aliceDb
      .collection("users")
      .doc(ALICE_UID)
      .collection("lesson_progress")
      .get()
  );

  await assertSucceeds(
    aliceDb
      .collection("users")
      .doc(ALICE_UID)
      .collection("bible_notes")
      .doc("gen_1_1")
      .set({
        bookId: "gen",
        chapter: 1,
        verse: 1,
        referenceLabel: "Gênesis 1:1",
        noteText: "Deus criou tudo com amor!",
        highlightColor: "gold",
        createdAt: created,
        updatedAt: created,
      })
  );

  await assertSucceeds(
    aliceDb
      .collection("users")
      .doc(ALICE_UID)
      .collection("bible_notes")
      .doc("gen_1_1")
      .update({
        noteText: "Deus criou os céus e a terra com propósito.",
        highlightColor: "emerald",
        updatedAt: new Date(Date.now() - 1000),
      })
  );

  // Reject unexpected @DocumentId `id` field
  await assertFails(
    aliceDb
      .collection("users")
      .doc(ALICE_UID)
      .collection("bible_notes")
      .doc("gen_1_2")
      .set({
        id: "gen_1_2",
        bookId: "gen",
        chapter: 1,
        verse: 2,
        referenceLabel: "Gênesis 1:2",
        noteText: "Test",
        highlightColor: "none",
        createdAt: created,
        updatedAt: created,
      })
  );
});
