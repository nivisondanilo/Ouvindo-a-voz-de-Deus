package com.example.data.content

import com.example.model.BadgeDefinition
import com.example.model.DailyInspiration
import com.example.model.ExplorerLevel
import com.example.model.ReadingPlan
import com.example.model.ReadingPlanDay
import com.example.model.StudyLesson
import java.util.Calendar

object StudyCatalog {
    val allLessons: List<StudyLesson> = ouvindoVozLessonsPart1 + ouvindoVozLessonsPart2

    fun getLesson(number: Int): StudyLesson =
        allLessons.firstOrNull { it.number == number } ?: allLessons.first()

    val levels: List<ExplorerLevel> = listOf(
        ExplorerLevel(1, 0, "Explorador Curioso", "Curious Explorer", "Explorador Curioso"),
        ExplorerLevel(2, 250, "Aprendiz da Palavra", "Word Apprentice", "Aprendiz de la Palabra"),
        ExplorerLevel(3, 600, "Guardião da Fé", "Faith Guardian", "Guardián de la Fe"),
        ExplorerLevel(4, 1100, "Detetive das Profecias", "Prophecy Detective", "Detective de Profecías"),
        ExplorerLevel(5, 1750, "Mensageiro da Luz", "Messenger of Light", "Mensajero de la Luz"),
        ExplorerLevel(6, 2500, "Embaixador do Reino", "Kingdom Ambassador", "Embajador del Reino")
    )

    fun levelForXp(xp: Int): ExplorerLevel {
        return levels.lastOrNull { xp >= it.minXp } ?: levels.first()
    }

    fun nextLevelForXp(xp: Int): ExplorerLevel? {
        return levels.firstOrNull { it.minXp > xp }
    }

    val badges: List<BadgeDefinition> = listOf(
        BadgeDefinition(
            id = "first_step",
            titlePt = "Primeiro Passo",
            titleEn = "First Step",
            titleEs = "Primer Paso",
            descPt = "Concluiu sua 1ª lição de Ouvindo a Voz de Deus.",
            descEn = "Completed your 1st Hearing God's Voice lesson.",
            descEs = "Completaste tu 1ª lección de Oyendo la Voz de Dios.",
            xpBonus = 50
        ),
        BadgeDefinition(
            id = "streak_3",
            titlePt = "Chama Constante",
            titleEn = "Steady Flame",
            titleEs = "Llama Constante",
            descPt = "Estudou por 3 dias seguidos com fidelidade!",
            descEn = "Studied faithfully for 3 days in a row!",
            descEs = "¡Estudiaste fielmente durante 3 días seguidos!",
            xpBonus = 80
        ),
        BadgeDefinition(
            id = "foundations_master",
            titlePt = "Alicerce Firme",
            titleEn = "Firm Foundation",
            titleEs = "Cimiento Firme",
            descPt = "Completou 5 lições dos Fundamentos da Fé.",
            descEn = "Completed 5 Foundations of Faith lessons.",
            descEs = "Completaste 5 lecciones de Fundamentos de Fe.",
            xpBonus = 100
        ),
        BadgeDefinition(
            id = "prophecy_scout",
            titlePt = "Olhar Profético",
            titleEn = "Prophecy Scout",
            titleEs = "Visión Profética",
            descPt = "Completou 3 lições de Profecias e Esperança.",
            descEn = "Completed 3 Prophecy & Hope lessons.",
            descEs = "Completaste 3 lecciones de Profecías y Esperanza.",
            xpBonus = 120
        ),
        BadgeDefinition(
            id = "note_keeper",
            titlePt = "Escriba Dedicado",
            titleEn = "Devoted Scribe",
            titleEs = "Escriba Dedicado",
            descPt = "Criou 3 ou mais anotações pessoais na Bíblia Offline.",
            descEn = "Created 3 or more personal notes in the Offline Bible.",
            descEs = "Creaste 3 o más notas personales en la Biblia Offline.",
            xpBonus = 75
        ),
        BadgeDefinition(
            id = "quiz_ace",
            titlePt = "Mente Brilhante",
            titleEn = "Sharp Mind",
            titleEs = "Mente Brillante",
            descPt = "Gabaritou (100%) pelo menos 5 questionários!",
            descEn = "Scored 100% on at least 5 quizzes!",
            descEs = "¡Obtuviste 100% en al menos 5 cuestionarios!",
            xpBonus = 120
        ),
        BadgeDefinition(
            id = "halfway_hero",
            titlePt = "Meio Caminho",
            titleEn = "Halfway Hero",
            titleEs = "Mitad del Camino",
            descPt = "Alcançou 14 das 27 lições concluídas!",
            descEn = "Reached 14 of 27 completed lessons!",
            descEs = "¡Alcanzaste 14 de las 27 lecciones completadas!",
            xpBonus = 150
        ),
        BadgeDefinition(
            id = "voice_ambassador",
            titlePt = "Ouvinte da Voz",
            titleEn = "Voice Listener",
            titleEs = "Oyente de la Voz",
            descPt = "Concluiu todas as 27 lições do curso completo!",
            descEn = "Completed all 27 lessons of the full course!",
            descEs = "¡Completaste las 27 lecciones del curso completo!",
            xpBonus = 300
        )
    )

    val readingPlans: List<ReadingPlan> = listOf(
        ReadingPlan(
            id = "plan_7",
            titlePt = "Trilha Rápida • 7 Dias",
            titleEn = "Quick Trail • 7 Days",
            titleEs = "Ruta Rápida • 7 Días",
            subtitlePt = "7 passos essenciais sobre a Bíblia, Criação, Salvação e Volta de Jesus.",
            subtitleEn = "7 essential steps on the Bible, Creation, Salvation, and Jesus' Return.",
            subtitleEs = "7 pasos esenciales sobre la Biblia, Creación, Salvación y Regreso de Jesús.",
            days = listOf(
                ReadingPlanDay(1, "A Carta de Deus", 1, "Salmos 119", "psa", 119),
                ReadingPlanDay(2, "O Mundo Perfeito", 2, "Gênesis 1", "gen", 1),
                ReadingPlanDay(3, "Por que Existe Dor?", 3, "Gênesis 3", "gen", 3),
                ReadingPlanDay(4, "O Grande Resgate", 4, "João 3", "jhn", 3),
                ReadingPlanDay(5, "Coração Renovado", 5, "1 João 1", "1jn", 1),
                ReadingPlanDay(6, "O Grande Retorno", 7, "João 14", "jhn", 14),
                ReadingPlanDay(7, "Nosso Lar Eterno", 10, "Apocalipse 21", "rev", 21)
            )
        ),
        ReadingPlan(
            id = "plan_14",
            titlePt = "Jornada Jovem • 14 Dias",
            titleEn = "Youth Journey • 14 Days",
            titleEs = "Jornada Joven • 14 Días",
            subtitlePt = "Duas semanas mergulhando em graça, mandamentos, santuário e profecia.",
            subtitleEn = "Two weeks exploring grace, commandments, sanctuary, and prophecy.",
            subtitleEs = "Dos semanas explorando gracia, mandamientos, santuario y profecía.",
            days = (1..14).map { day ->
                val lesson = getLesson(day)
                val firstRef = lesson.keyVerses.firstOrNull()
                ReadingPlanDay(
                    dayNumber = day,
                    title = lesson.title,
                    lessonNumber = lesson.number,
                    bibleRef = firstRef?.reference ?: "Salmos 23",
                    bookId = firstRef?.bookId ?: "psa",
                    chapter = firstRef?.chapter ?: 23
                )
            }
        ),
        ReadingPlan(
            id = "plan_27",
            titlePt = "Curso Completo • 27 Dias",
            titleEn = "Full Course • 27 Days",
            titleEs = "Curso Completo • 27 Días",
            subtitlePt = "Uma lição por dia até dominar todo o guia Ouvindo a Voz de Deus.",
            subtitleEn = "One lesson per day until mastering the full Hearing God's Voice guide.",
            subtitleEs = "Una lección por día hasta dominar toda la guía Oyendo la Voz de Dios.",
            days = allLessons.map { lesson ->
                val firstRef = lesson.keyVerses.firstOrNull()
                ReadingPlanDay(
                    dayNumber = lesson.number,
                    title = lesson.title,
                    lessonNumber = lesson.number,
                    bibleRef = firstRef?.reference ?: "Salmos 1",
                    bookId = firstRef?.bookId ?: "psa",
                    chapter = firstRef?.chapter ?: 1
                )
            }
        )
    )

    fun getPlan(planId: String): ReadingPlan =
        readingPlans.firstOrNull { it.id == planId } ?: readingPlans.first()

    val dailyInspirations: List<DailyInspiration> = listOf(
        DailyInspiration(
            verseRef = "Salmos 119:105",
            verseText = "Lâmpada para os meus pés é a tua palavra e luz, para os meus caminhos.",
            motivationPt = "Comece hoje ouvindo a Voz de Deus — Ele ilumina cada passo da sua jornada!",
            motivationEn = "Start today by hearing God's Voice — He lights up every step of your journey!",
            motivationEs = "¡Comienza hoy escuchando la Voz de Dios — Él ilumina cada paso de tu camino!"
        ),
        DailyInspiration(
            verseRef = "1 Timóteo 4:12",
            verseText = "Ninguém despreze a tua mocidade; pelo contrário, torna-te padrão dos fiéis.",
            motivationPt = "Você não precisa esperar crescer para ser luz! Sua fé inspira quem está ao seu redor.",
            motivationEn = "You don't have to wait until you grow up to shine! Your faith inspires those around you.",
            motivationEs = "¡No tienes que esperar a crecer para brillar! Tu fe inspira a quienes te rodean."
        ),
        DailyInspiration(
            verseRef = "João 3:16",
            verseText = "Porque Deus amou ao mundo de tal maneira que deu o seu Filho unigênito.",
            motivationPt = "Nunca duvide do seu valor: Jesus deu tudo por você porque você é muito amado!",
            motivationEn = "Never doubt your worth: Jesus gave everything for you because you are deeply loved!",
            motivationEs = "Nunca dudes de tu valor: ¡Jesús dio todo por ti porque eres muy amado!"
        ),
        DailyInspiration(
            verseRef = "Filipenses 4:13",
            verseText = "Tudo posso naquele que me fortalece.",
            motivationPt = "Tem um desafio difícil hoje? Respire fundo, ore e siga com a força de Cristo!",
            motivationEn = "Facing a tough challenge today? Take a breath, pray, and move forward in Christ's strength!",
            motivationEs = "¿Tienes un reto difícil hoy? ¡Respira hondo, ora y avanza con la fuerza de Cristo!"
        ),
        DailyInspiration(
            verseRef = "Salmos 23:1",
            verseText = "O Senhor é o meu pastor; nada me faltará.",
            motivationPt = "Como um bom Pastor, Jesus cuida de cada detalhe do seu dia. Confie nEle!",
            motivationEn = "Like a Good Shepherd, Jesus cares for every detail of your day. Trust Him!",
            motivationEs = "Como un Buen Pastor, Jesús cuida cada detalle de tu día. ¡Confía en Él!"
        ),
        DailyInspiration(
            verseRef = "Josué 1:9",
            verseText = "Sê forte e corajoso; não temas, nem te espantes, porque o Senhor, teu Deus, é contigo.",
            motivationPt = "Coragem não é ausência de medo — é caminhar sabendo que Deus está segurando sua mão!",
            motivationEn = "Courage isn't having no fear — it's walking forward knowing God holds your hand!",
            motivationEs = "¡Valentía no es no tener miedo — es caminar sabiendo que Dios sostiene tu mano!"
        ),
        DailyInspiration(
            verseRef = "Apocalipse 21:4",
            verseText = "E lhes enxugará dos olhos toda lágrima, e a morte já não existirá.",
            motivationPt = "Mantenha os olhos na esperança: Jesus está preparando um lar perfeito para nós!",
            motivationEn = "Keep your eyes on hope: Jesus is preparing a perfect forever home for us!",
            motivationEs = "¡Mantén tus ojos en la esperanza: Jesús está preparando un hogar perfecto para nosotros!"
        )
    )

    fun inspirationForToday(): DailyInspiration {
        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        return dailyInspirations[dayOfYear % dailyInspirations.size]
    }
}
