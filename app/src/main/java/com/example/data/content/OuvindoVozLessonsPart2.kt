package com.example.data.content

import com.example.model.KeyVerseRef
import com.example.model.QuizQuestion
import com.example.model.StudyCategory
import com.example.model.StudyHeaderArt
import com.example.model.StudyLesson
import com.example.model.StudyThoughtBlock

val ouvindoVozLessonsPart2: List<StudyLesson> = listOf(
    StudyLesson(
        number = 15,
        title = "A Lei Moral",
        subtitle = "Os Dez Mandamentos como expressão viva do amor de Deus",
        category = StudyCategory.CHRISTIAN_LIFE,
        headerArt = StudyHeaderArt.BIBLE_NIGHT,
        estimatedMinutes = 9,
        xpReward = 120,
        blogIntro = "Alguns jovens olham para os Dez Mandamentos achando que são uma lista chata de proibições para tirar a diversão da vida. Mas pense bem: e se os Dez Mandamentos fossem, na verdade, a descrição do próprio caráter amoroso de Jesus? Quando Deus diz 'não matarás', Ele protege a vida; quando diz 'honra pai e mãe', protege sua família; quando diz 'não mentirás', protege a confiança entre amigos!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Amor a Deus nos 4 primeiros mandamentos",
                studyText = "Os Dez Mandamentos estão em Êxodo 20:1-17 e começam lembrando que Deus primeiro nos libertou da escravidão! Os quatro primeiros ensinam como amar a Deus: colocá-Lo em 1º lugar (1º), não adorar imagens (2º), respeitar Seu santo nome (3º) e guardar o sábado como encontro semanal com Ele (4º).",
                bibleRefs = listOf(
                    KeyVerseRef("exo", 20, 1, "Êxodo 20:1-8", "Eu sou o Senhor, teu Deus... Não terás outros deuses diante de mim.", endVerse = 8)
                ),
                question = QuizQuestion(
                    question = "Sobre o que tratam os quatro primeiros mandamentos de Êxodo 20?",
                    options = listOf(
                        "Nosso relacionamento de amor e adoração exclusiva a Deus",
                        "Apenas regras de construção",
                        "Comércio antigo"
                    ),
                    correctIndex = 0,
                    explanation = "A primeira tábua da Lei regula nossa fidelidade e amor vertical ao Criador.",
                    verseRef = "Êxodo 20:3-11"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. Amor ao próximo nos 6 últimos mandamentos",
                studyText = "Do quinto ao décimo mandamento, Deus protege o respeito entre nós: honrar pai e mãe (5º), proteger a vida (6º), guardar a fidelidade no lar (7º), respeitar o que é dos outros (8º), falar sempre a verdade sem difamar (9º) e ter coração contente sem cobiça (10º).",
                bibleRefs = listOf(
                    KeyVerseRef("exo", 20, 12, "Êxodo 20:12-17", "Honra teu pai e tua mãe... Não matarás... Não furtarás.", endVerse = 17)
                ),
                question = QuizQuestion(
                    question = "Quantos mandamentos tratam diretamente do respeito e amor ao próximo?",
                    options = listOf("2 mandamentos", "6 mandamentos (do 5º ao 10º)", "Apenas 1"),
                    correctIndex = 1,
                    explanation = "Seis mandamentos protegem a família, a vida, a pureza, a propriedade e a verdade.",
                    verseRef = "Êxodo 20:12-17"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. O resumo perfeito feito por Jesus",
                studyText = "Quando perguntaram a Jesus qual era o maior mandamento, Ele resumiu as duas tábuas da Lei em Mateus 22:37-40: amar a Deus de todo o coração e amar ao próximo como a si mesmo! E em João 14:15 Ele conectou amor e obediência para sempre: 'Se me amais, guardareis os meus mandamentos.'",
                bibleRefs = listOf(
                    KeyVerseRef("mat", 22, 37, "Mateus 22:37-40", "Amarás o Senhor, teu Deus... e o teu próximo como a ti mesmo.", endVerse = 40),
                    KeyVerseRef("jhn", 14, 15, "João 14:15", "Se me amais, guardareis os meus mandamentos.")
                ),
                question = QuizQuestion(
                    question = "Segundo João 14:15, qual deve ser o motivo pelo qual guardamos os mandamentos?",
                    options = listOf("Medo de punição", "Amor sincero por Jesus", "Competição religiosa"),
                    correctIndex = 1,
                    explanation = "A obediência cristã nasce do amor e da amizade com Cristo.",
                    verseRef = "João 14:15"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 15 • Um Espelho que Mostra Jesus",
                studyText = "A Lei Moral funciona como um espelho: mostra onde precisamos melhorar, mas não tem poder para limpar nosso rosto — quem limpa e nos transforma é Jesus! Com o Espírito Santo gravando a Lei em nosso coração, obedecer se torna liberdade e alegria.",
                bibleRefs = listOf(
                    KeyVerseRef("jhn", 14, 15, "João 14:15", "Se me amais, guardareis os meus mandamentos.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Qual afirmação resume a relação entre amor e Lei Moral?",
                    options = listOf(
                        "Quem ama realmente não precisa de princípios",
                        "O amor não destrói os Dez Mandamentos — o amor os cumpre com alegria",
                        "A Lei salva sem Jesus"
                    ),
                    correctIndex = 1,
                    explanation = "Mateus 22:37-40 e João 14:15 mostram que amar a Deus se expressa guardando Seus mandamentos.",
                    verseRef = "Mateus 22:37-40"
                )
            )
        ),
        motivationalMessage = "Obedecer a Deus por amor transforma dever pesado em alegria leve e segura!",
        youtubePlaylistIndex = 15,
        youtubeVideoTitle = "Estudo 15 • A Lei Moral"
    ),

    StudyLesson(
        number = 16,
        title = "O Mandamento Esquecido",
        subtitle = "O sábado bíblico: um encontro semanal com o Criador",
        category = StudyCategory.CHRISTIAN_LIFE,
        headerArt = StudyHeaderArt.HERO_STUDY,
        estimatedMinutes = 9,
        xpReward = 125,
        blogIntro = "No meio de uma semana cheia de tarefas, provas, telas e pressa, existe apenas um mandamento que Deus começa dizendo: 'Lembra-te!' Por que Deus usou exatamente essa palavra no quarto mandamento? Porque sabia que a correria do mundo tentaria nos fazer esquecer o dia santo que Ele separou lá no Jardim do Éden para descansar conosco e renovar nossas forças!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Instituído na Criação antes do pecado",
                studyText = "O sábado não foi inventado apenas para os judeus no Sinai! Gênesis 2:2-3 mostra que logo no sétimo dia da história da Terra — quando só existiam Adão e Eva representando toda a humanidade — Deus descansou, abençoou e santificou o sétimo dia. É um presente universal desde o Éden.",
                bibleRefs = listOf(
                    KeyVerseRef("gen", 2, 2, "Gênesis 2:2-3", "E abençoou Deus o dia sétimo e o santificou.", endVerse = 3)
                ),
                question = QuizQuestion(
                    question = "Quando e para quem o sábado foi originalmente criado por Deus?",
                    options = listOf(
                        "Na semana da Criação, no Éden, para toda a humanidade",
                        "Séculos depois, apenas para uma tribo",
                        "Depois dos apóstolos"
                    ),
                    correctIndex = 0,
                    explanation = "Gênesis 2:2-3 prova que o sábado nasceu na Criação, muito antes de existir qualquer nação.",
                    verseRef = "Gênesis 2:2-3"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. O centro dos Dez Mandamentos",
                studyText = "Em Êxodo 20:8-11, Deus reafirma o quarto mandamento com carinho e precisão: trabalhamos seis dias, mas 'o sétimo dia é o sábado do Senhor, teu Deus'. De pôr do sol de sexta-feira a pôr do sol de sábado, paramos os afazeres comuns para adorar, descansar e lembrar que Deus é o nosso Criador e Redentor.",
                bibleRefs = listOf(
                    KeyVerseRef("exo", 20, 8, "Êxodo 20:8-11", "Lembra-te do dia de sábado, para o santificar... o sétimo dia é o sábado do Senhor.", endVerse = 11)
                ),
                question = QuizQuestion(
                    question = "Qual motivo o próprio quarto mandamento apresenta em Êxodo 20:11 para guardarmos o sábado?",
                    options = listOf(
                        "É o memorial da Criação feita pelo Senhor em seis dias",
                        "É um feriado comercial",
                        "Serve apenas para dormir o dia inteiro"
                    ),
                    correctIndex = 0,
                    explanation = "O sábado é a assinatura semanal do Criador dos céus e da Terra.",
                    verseRef = "Êxodo 20:8-11"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Como Jesus guardava e ensinava sobre o sábado?",
                studyText = "Lucas 4:16 registra que era o costume regular de Jesus ir à sinagoga no sábado adorar a Deus e ler as Escrituras! Em Marcos 2:27-28, Jesus tirou todos os pesos exagerados que homens haviam colocado e declarou que o sábado foi feito para o bem do ser humano — e que Ele próprio é o Senhor do sábado!",
                bibleRefs = listOf(
                    KeyVerseRef("luk", 4, 16, "Lucas 4:16", "Entrou, num sábado, na sinagoga, segundo o seu costume, e levantou-se para ler."),
                    KeyVerseRef("mrk", 2, 27, "Marcos 2:27-28", "O sábado foi estabelecido por causa do homem... o Filho do Homem é senhor também do sábado.", endVerse = 28)
                ),
                question = QuizQuestion(
                    question = "Qual era o costume de Jesus aos sábados segundo Lucas 4:16 e Marcos 2:27?",
                    options = listOf(
                        "Trabalhar normalmente ignorando o dia",
                        "Adorar a Deus, fazer o bem e mostrar que o sábado é um presente para o ser humano",
                        "Substituir por outro dia"
                    ),
                    correctIndex = 1,
                    explanation = "Jesus guardou o sábado perfeitamente e mostrou que ele é um dia de alegria, adoração e serviço.",
                    verseRef = "Lucas 4:16; Marcos 2:27"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 16 • O Abraço Semanal de Deus",
                studyText = "Para crianças e adolescentes adventistas, o sábado é o melhor dia da semana! É tempo de desligar das correrias, conversar com amigos na igreja, caminhar na natureza, cantar, visitar quem precisa e passar horas preciosas com a família e com Jesus.",
                bibleRefs = listOf(
                    KeyVerseRef("exo", 20, 8, "Êxodo 20:8", "Lembra-te do dia de sábado, para o santificar.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Qual é o sétimo dia bíblico santificado por Deus e guardado por Jesus?",
                    options = listOf(
                        "O sábado (sétimo dia da semana)",
                        "O domingo (primeiro dia da semana)",
                        "Qualquer dia escolhido aleatoriamente"
                    ),
                    correctIndex = 0,
                    explanation = "Da Criação até a eternidade, o sábado é o sétimo dia separado por Deus.",
                    verseRef = "Gênesis 2:3; Êxodo 20:10"
                )
            )
        ),
        motivationalMessage = "O sábado é o convite semanal de Jesus dizendo: 'Deixe as correrias de lado e venha descansar comigo!'",
        youtubePlaylistIndex = 16,
        youtubeVideoTitle = "Estudo 16 • O Mandamento Esquecido"
    ),

    StudyLesson(
        number = 17,
        title = "Do Sábado para o Domingo",
        subtitle = "O que a Bíblia e a história revelam sobre a mudança do dia",
        category = StudyCategory.PROPHECY,
        headerArt = StudyHeaderArt.PROPHECY,
        estimatedMinutes = 9,
        xpReward = 125,
        blogIntro = "Se o sábado está claramente escrito nos Dez Mandamentos e foi guardado por Jesus, por que a maioria das igrejas hoje guarda o domingo? Será que Jesus ou os apóstolos mudaram o dia depois da ressurreição? Vamos investigar a Bíblia e a própria história com honestidade e coragem — e descobrir o que a profecia de Daniel já havia avisado séculos antes!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Os seguidores de Jesus após a cruz",
                studyText = "Se Jesus tivesse mandado trocar o sábado pelo domingo antes de morrer, Suas seguidoras mais próximas saberiam disso! Porém, Lucas 23:56 registra que após sepultarem Jesus na sexta-feira, as mulheres voltaram para casa e 'no sábado, descansaram, segundo o mandamento'. Nem Jesus nem os apóstolos jamais mudaram o quarto mandamento!",
                bibleRefs = listOf(
                    KeyVerseRef("luk", 23, 56, "Lucas 23:56", "E, no sábado, descansaram, segundo o mandamento.")
                ),
                question = QuizQuestion(
                    question = "O que as seguidoras de Jesus fizeram no sábado após a crucificação (Lucas 23:56)?",
                    options = listOf(
                        "Passaram a guardar o domingo apenas",
                        "Descansaram no sábado segundo o mandamento",
                        "Esqueceram da Lei"
                    ),
                    correctIndex = 1,
                    explanation = "Após a morte de Cristo, os discípulos continuaram observando normalmente o sábado bíblico.",
                    verseRef = "Lucas 23:56"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. A profecia de Daniel 7:25 e a mudança histórica",
                studyText = "Em Daniel 7:25, Deus avisou profeticamente que um poder religioso-político que surgiria após a queda de Roma 'cuidará em mudar os tempos e a lei'. A história confirma que séculos depois dos apóstolos — especialmente a partir do decreto do imperador Constantino em 321 d.C. e concílios posteriores — a tradição humana transferiu a observância oficial para o domingo, o antigo 'dia do sol'.",
                bibleRefs = listOf(
                    KeyVerseRef("dan", 7, 25, "Daniel 7:25", "Proferirá palavras contra o Altíssimo... e cuidará em mudar os tempos e a lei.")
                ),
                question = QuizQuestion(
                    question = "O que a profecia de Daniel 7:25 previu que um poder tentaria fazer?",
                    options = listOf(
                        "Traduzir a Bíblia para todos os idiomas",
                        "Mudar os tempos e a lei de Deus",
                        "Restaurar o Éden"
                    ),
                    correctIndex = 1,
                    explanation = "A mudança do sábado para o domingo não veio da Bíblia, mas de tradições e decretos humanos previstos por Daniel.",
                    verseRef = "Daniel 7:25"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Obedecer a Deus ou à tradição humana?",
                studyText = "Quando pressionados a deixar a Palavra de Deus de lado para seguir ordens humanas, Pedro e os apóstolos responderam firmes em Atos 5:29: 'Antes, importa obedecer a Deus do que aos homens.' E em Isaías 66:22-23, Deus confirma que na Nova Terra toda a carne continuará adorando perante Ele 'de um sábado a outro'!",
                bibleRefs = listOf(
                    KeyVerseRef("act", 5, 29, "Atos 5:29", "Antes, importa obedecer a Deus do que aos homens."),
                    KeyVerseRef("isa", 66, 22, "Isaías 66:22-23", "De um sábado a outro, virá toda a carne a adorar perante mim, diz o Senhor.", endVerse = 23)
                ),
                question = QuizQuestion(
                    question = "Que dia será guardado para adoração eterna na Nova Terra segundo Isaías 66:23?",
                    options = listOf("De um sábado a outro", "Apenas feriados anuais", "Nenhum dia específico"),
                    correctIndex = 0,
                    explanation = "O sábado vai da Criação até a Nova Terra sem jamais ter sido cancelado por Deus.",
                    verseRef = "Isaías 66:22-23"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 17 • Coragem Para Seguir a Bíblia",
                studyText = "Deus tem filhos sinceros em muitas igrejas que ainda não conheceram a história completa do sábado. Mas quando você descobre na Bíblia que Deus nunca mudou o sétimo dia, Seu convite amoroso é para seguir o exemplo de Jesus com gentileza, respeito e fidelidade!",
                bibleRefs = listOf(
                    KeyVerseRef("act", 5, 29, "Atos 5:29", "Antes, importa obedecer a Deus do que aos homens.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: De onde veio a mudança do sábado para o domingo?",
                    options = listOf(
                        "De uma ordem direta de Jesus em Mateus",
                        "De tradições humanas e decretos civis séculos depois dos apóstolos, prevista em Daniel 7:25",
                        "Do Monte Sinai"
                    ),
                    correctIndex = 1,
                    explanation = "Somente a Bíblia deve guiar nossa fé; o sábado continua sendo o dia santo de Deus.",
                    verseRef = "Daniel 7:25; Lucas 23:56"
                )
            )
        ),
        motivationalMessage = "Seguir a Bíblia com amor e coragem faz de você uma testemunha brilhante da verdade de Deus!",
        youtubePlaylistIndex = 17,
        youtubeVideoTitle = "Estudo 17 • Do Sábado para o Domingo"
    ),

    StudyLesson(
        number = 18,
        title = "Princípios de Saúde",
        subtitle = "Cuidando do seu corpo como templo do Espírito Santo",
        category = StudyCategory.CHRISTIAN_LIFE,
        headerArt = StudyHeaderArt.HERO_STUDY,
        estimatedMinutes = 8,
        xpReward = 115,
        blogIntro = "Você sabia que Deus se importa até com o que você come, bebe e quantas horas dorme à noite? Os adventistas são conhecidos mundialmente pela saúde e longevidade porque seguem a Bíblia de forma integral: corpo, mente e espírito funcionam juntos! Cuidar da saúde não é vaidade nem mania — é gratidão por um corpo emprestado por Deus para ser a casa do Espírito Santo.",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Seu corpo é santuário do Espírito Santo",
                studyText = "Em 1 Coríntios 6:19-20, Paulo faz uma pergunta poderosa: 'Acaso, não sabeis que o vosso corpo é santuário do Espírito Santo?' Fomos comprados pelo alto preço da cruz! Por isso, até ao comer, beber ou escolher hábitos diários (1 Coríntios 10:31), podemos glorificar a Deus evitando álcool, cigarro, drogas e excessos que prejudicam a mente.",
                bibleRefs = listOf(
                    KeyVerseRef("1co", 6, 19, "1 Coríntios 6:19-20", "O vosso corpo é santuário do Espírito Santo... glorificai a Deus no vosso corpo.", endVerse = 20),
                    KeyVerseRef("1co", 10, 31, "1 Coríntios 10:31", "Quer comais, quer bebais... fazei tudo para a glória de Deus.")
                ),
                question = QuizQuestion(
                    question = "Como 1 Coríntios 6:19 descreve o corpo do cristão?",
                    options = listOf(
                        "Uma casa qualquer sem dono",
                        "Santuário (templo) do Espírito Santo, comprado por Deus",
                        "Algo separado da espiritualidade"
                    ),
                    correctIndex = 1,
                    explanation = "Cuidar bem do corpo mantém nossa mente lúcida para ouvir a Voz de Deus.",
                    verseRef = "1 Coríntios 6:19-20"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. O jovem Daniel disse 'não' para se destacar",
                studyText = "Na Babilônia, o adolescente Daniel e seus três amigos enfrentaram pressão para comer comidas impróprias e beber o vinho do rei. Daniel resolveu firmemente não se contaminar (Daniel 1:8), escolheu alimentos simples e saudáveis com água pura — e ao final do teste estavam mais saudáveis e 10 vezes mais sábios que todos!",
                bibleRefs = listOf(
                    KeyVerseRef("dan", 1, 8, "Daniel 1:8, 12", "Resolveu Daniel, firmemente, não contaminar-se... dêem-nos legumes a comer e água a beber.", endVerse = 12)
                ),
                question = QuizQuestion(
                    question = "Que decisão corajosa o adolescente Daniel tomou em Daniel 1:8-17?",
                    options = listOf(
                        "Seguir a moda da corte para não parecer estranho",
                        "Recusar alimentos prejudiciais e vinho, escolhendo alimentação saudável e água",
                        "Parar de comer totalmente"
                    ),
                    correctIndex = 1,
                    explanation = "Deus abençoou a fidelidade de Daniel e seus amigos com saúde brilhante e sabedoria.",
                    verseRef = "Daniel 1:8-17"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Temperança e os 8 Remédios Naturais",
                studyText = "Em 1 Coríntios 9:25, Paulo compara o cristão a um atleta disciplinado que se domina em tudo. A mensagem adventista resume o cuidado diário em 8 remédios naturais deixados por Deus: ar puro, luz solar, água pura, alimentação equilibrada (frutas, grãos, verduras, evitando carnes impuras), exercício físico, descanso adequado, temperança (moderação no que é bom e abstinência do que faz mal) e confiança em Deus!",
                bibleRefs = listOf(
                    KeyVerseRef("1co", 9, 25, "1 Coríntios 9:25", "Todo atleta em tudo se domina; aqueles, para alcançar uma coroa corruptível; nós, porém, a incorruptível.")
                ),
                question = QuizQuestion(
                    question = "O que significa temperança cristã na prática?",
                    options = listOf(
                        "Fazer tudo sem limites",
                        "Autocontrole: usar com equilíbrio o que faz bem e evitar totalmente o que destrói a saúde",
                        "Nunca praticar esportes"
                    ),
                    correctIndex = 1,
                    explanation = "Temperança protege corpo e mente como um atleta comprometido com Jesus.",
                    verseRef = "1 Coríntios 9:25"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 18 • Mente Clara para Ouvir Deus",
                studyText = "Quando dormimos bem, bebemos água, praticamos exercícios ao sol e escolhemos alimentos saudáveis, até nosso humor e disposição para estudar e orar melhoram! Deus quer ver você cheio de energia e alegria servindo a Ele.",
                bibleRefs = listOf(
                    KeyVerseRef("1co", 10, 31, "1 Coríntios 10:31", "Fazei tudo para a glória de Deus.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Por que os adventistas valorizam tanto uma vida saudável?",
                    options = listOf(
                        "Porque o corpo é templo do Espírito Santo e uma mente saudável ouve Deus com mais clareza",
                        "Apenas por estética",
                        "Porque salva sozinho"
                    ),
                    correctIndex = 0,
                    explanation = "Honramos o Criador cuidando com carinho da saúde física, mental e espiritual.",
                    verseRef = "1 Coríntios 6:19; 10:31"
                )
            )
        ),
        motivationalMessage = "Cuide bem da casa onde o Espírito Santo mora: beba água, respire ar puro e agradeça por sua vida!",
        youtubePlaylistIndex = 18,
        youtubeVideoTitle = "Estudo 18 • Princípios de Saúde"
    ),

    StudyLesson(
        number = 19,
        title = "O Dom de Profecia",
        subtitle = "Como Deus orienta Sua igreja através da história até o fim",
        category = StudyCategory.MISSION,
        headerArt = StudyHeaderArt.PROPHECY,
        estimatedMinutes = 8,
        xpReward = 120,
        blogIntro = "Em tempos de tantas informações contraditórias, será que Deus ainda se importa em orientar Sua igreja nos últimos dias? Em Amós 3:7, Deus promete que não faz nada sem antes revelar aos Seus servos, os profetas. Os adventistas creem que o dom de profecia é uma das marcas bíblicas da igreja verdadeira no tempo do fim — sempre testado pela Bíblia e exaltando a Jesus!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. A promessa de orientação profética",
                studyText = "Ao longo de toda a Bíblia, sempre que o povo de Deus enfrentou momentos decisivos (como o Dilúvio, a saída do Egito ou a vinda de Jesus), Deus levantou profetas. Amós 3:7 declara que o Senhor sempre revela Seus planos aos profetas por amor ao Seu povo.",
                bibleRefs = listOf(
                    KeyVerseRef("amo", 3, 7, "Amós 3:7", "Certamente, o Senhor Deus não fará coisa alguma, sem primeiro revelar o seu segredo aos seus servos, os profetas.")
                ),
                question = QuizQuestion(
                    question = "O que Amós 3:7 revela sobre o cuidado de Deus ao guiar Seu povo?",
                    options = listOf(
                        "Deus esconde tudo até o último segundo",
                        "Ele revela Seus segredos e alertas por meio dos profetas",
                        "Só houve profetas em um único século"
                    ),
                    correctIndex = 1,
                    explanation = "Deus sempre avisa e orienta Sua igreja com antecedência por amor.",
                    verseRef = "Amós 3:7"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. O Espírito de Profecia na igreja do fim",
                studyText = "Em Apocalipse 12:17, o dragão se ira contra os últimos filhos fiéis de Deus — aqueles que 'guardam os mandamentos de Deus e têm o testemunho de Jesus'. E Apocalipse 19:10 dá a definição exata dessa expressão: 'O testemunho de Jesus é o espírito da profecia!' Entre os adventistas, reconhecemos esse dom no ministério de Ellen G. White, cujos conselhos sempre apontam para a Bíblia e Jesus.",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 12, 17, "Apocalipse 12:17", "Os que guardam os mandamentos de Deus e têm o testemunho de Jesus."),
                    KeyVerseRef("rev", 19, 10, "Apocalipse 19:10", "Pois o testemunho de Jesus é o espírito da profecia.")
                ),
                question = QuizQuestion(
                    question = "Como Apocalipse 19:10 define 'o testemunho de Jesus'?",
                    options = listOf("Uma festa antiga", "O espírito da profecia", "Uma opinião pessoal"),
                    correctIndex = 1,
                    explanation = "A própria Bíblia interpreta que o testemunho de Jesus é o dom profético atuando na igreja.",
                    verseRef = "Apocalipse 19:10"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Como testar quem fala em nome de Deus?",
                studyText = "A Bíblia alerta contra falsos profetas e dá testes objetivos! O teste principal está em Isaías 8:20: 'À lei e ao testemunho! Se eles não falarem desta maneira, jamais verão a alva.' Um verdadeiro dom profético nunca substitui ou contradiz a Bíblia — ele é como uma 'luz menor' que nos guia diretamente de volta para a 'luz maior', que é a Palavra de Deus.",
                bibleRefs = listOf(
                    KeyVerseRef("isa", 8, 20, "Isaías 8:20", "À lei e ao testemunho! Se eles não falarem desta maneira, jamais verão a alva.")
                ),
                question = QuizQuestion(
                    question = "Qual é o teste supremo em Isaías 8:20 para saber se uma mensagem profética vem de Deus?",
                    options = listOf(
                        "Estar em total acordo com a Lei e as Escrituras Sagradas",
                        "Ter muitos seguidores famosos",
                        "Trazer novidades contrárias à Bíblia"
                    ),
                    correctIndex = 0,
                    explanation = "A Bíblia é sempre a autoridade máxima pela qual qualquer ensino deve ser testado.",
                    verseRef = "Isaías 8:20"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 19 • A Bíblia Sempre no Centro",
                studyText = "Lembre-se sempre desta verdade adventista: os escritos proféticos nunca ficam acima nem no lugar da Bíblia! Eles funcionam como um telescópio que nos ajuda a enxergar com mais nitidez as belezas de Jesus e das Escrituras Sagradas.",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 19, 10, "Apocalipse 19:10", "Adora a Deus. Pois o testemunho de Jesus é o espírito da profecia.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Um verdadeiro dom de profecia moderno substitui a Bíblia?",
                    options = listOf(
                        "Sim, torna a Bíblia antiga",
                        "Não — nunca substitui a Bíblia, mas conduz as pessoas a amarem e obedecerem à Bíblia",
                        "Sim, apenas para jovens"
                    ),
                    correctIndex = 1,
                    explanation = "A Palavra de Deus permanece nossa única regra infalível de fé e prática.",
                    verseRef = "Isaías 8:20; Apocalipse 19:10"
                )
            )
        ),
        motivationalMessage = "Deus nunca deixa Seus filhos caminhando no escuro — Ele envia orientação segura pela Sua Palavra!",
        youtubePlaylistIndex = 19,
        youtubeVideoTitle = "Estudo 19 • O Dom de Profecia"
    ),

    StudyLesson(
        number = 20,
        title = "O Dízimo",
        subtitle = "Gratidão prática reconhecendo que tudo pertence a Deus",
        category = StudyCategory.CHRISTIAN_LIFE,
        headerArt = StudyHeaderArt.BADGE_TROPHY,
        estimatedMinutes = 8,
        xpReward = 115,
        blogIntro = "Será que Deus precisa do nosso dinheiro? Claro que não — Ele é dono de todo o ouro, prata e galáxias! Então por que a Bíblia ensina sobre devolver o dízimo (10% do que recebemos)? Porque o dízimo é um treinamento do coração contra o egoísmo: lembra quem nos deu saúde, inteligência e provisão, além de sustentar a pregação do evangelho no mundo todo.",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. A décima parte é santa ao Senhor",
                studyText = "Em Levítico 27:30, a Bíblia estabelece claramente o princípio: 'Todas as dízimas da terra... são do Senhor; santas são ao Senhor.' Devolver 10% (um em cada dez reais da sua mesada, salário ou renda) não é dar um presente nosso a Deus — é devolver fielmente a parte que Ele reservou para lembrar que tudo o mais vem dEle!",
                bibleRefs = listOf(
                    KeyVerseRef("lev", 27, 30, "Levítico 27:30", "Todas as dízimas da terra... são do Senhor; santas são ao Senhor.")
                ),
                question = QuizQuestion(
                    question = "Qual porcentagem corresponde ao dízimo bíblico segundo Levítico 27:30?",
                    options = listOf("50%", "10% (a décima parte)", "1%"),
                    correctIndex = 1,
                    explanation = "Dízimo significa literalmente a décima parte, separada como santa ao Senhor.",
                    verseRef = "Levítico 27:30"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. Para que o dízimo é utilizado?",
                studyText = "No Antigo Testamento, o dízimo sustentava os levitas que trabalhavam no santuário. No Novo Testamento, Paulo confirma em 1 Coríntios 9:14 que o mesmo princípio continua valendo: os que pregam o evangelho são sustentados pelo sistema do dízimo! Na Igreja Adventista, os dízimos são sagrados e usados exclusivamente para sustentar pastores, missionários e o avanço mundial da pregação.",
                bibleRefs = listOf(
                    KeyVerseRef("1co", 9, 14, "1 Coríntios 9:14", "Assim ordenou também o Senhor aos que pregam o evangelho que vivam do evangelho.")
                ),
                question = QuizQuestion(
                    question = "Qual é o destino bíblico correto dos dízimos (1 Coríntios 9:14)?",
                    options = listOf(
                        "Sustentar o ministério da pregação do evangelho",
                        "Gastos aleatórios sem critério",
                        "Guardar sem uso"
                    ),
                    correctIndex = 0,
                    explanation = "O dízimo garante que obreiros e missionários levem a Voz de Deus a todas as nações.",
                    verseRef = "1 Coríntios 9:14"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Jesus aprovou o dízimo e Deus faz um convite especial",
                studyText = "Em Mateus 23:23, Jesus disse que devemos praticar justiça, misericórdia e fé sem omitir a fidelidade no dízimo! E em Malaquias 3:10, Deus faz o único desafio desse tipo em toda a Bíblia: 'Provai-me nisto... se eu não vos abrir as janelas do céu e não derramar sobre vós bênção sem medida.'",
                bibleRefs = listOf(
                    KeyVerseRef("mat", 23, 23, "Mateus 23:23", "Devíeis, porém, fazer estas coisas, sem omitir aquelas."),
                    KeyVerseRef("mal", 3, 10, "Malaquias 3:10", "Trazei todos os dízimos à casa do Tesouro... e provai-me nisto.")
                ),
                question = QuizQuestion(
                    question = "O que Jesus ensinou sobre o dízimo em Mateus 23:23?",
                    options = listOf(
                        "Que não precisa mais ser praticado",
                        "Que deve ser praticado junto com justiça, misericórdia e fé",
                        "Que substitui o amor ao próximo"
                    ),
                    correctIndex = 1,
                    explanation = "Fidelidade financeira e amor ao próximo caminham juntos na vida do discípulo.",
                    verseRef = "Mateus 23:23"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 20 • Fidelidade que Liberta do Egoísmo",
                studyText = "Aprender desde criança e adolescente a devolver os 10% ao Senhor ensina organização, confiança e gratidão! Quem coloca Deus em primeiro lugar descobre que 90% com a bênção de Deus rendem e trazem muito mais paz do que 100% longe dEle.",
                bibleRefs = listOf(
                    KeyVerseRef("mal", 3, 10, "Malaquias 3:10", "Se eu não vos abrir as janelas do céu e não derramar sobre vós bênção sem medida.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: O dízimo serve para 'comprar' bênçãos ou expressar fidelidade?",
                    options = listOf(
                        "É um ato de fé, obediência e gratidão reconhecendo Deus como Dono de tudo",
                        "É um pagamento para ganhar pontos no Céu",
                        "Só vale para adultos ricos"
                    ),
                    correctIndex = 0,
                    explanation = "Devolvemos o dízimo por gratidão a quem já nos deu a vida e todas as bênçãos.",
                    verseRef = "Malaquias 3:10; Levítico 27:30"
                )
            )
        ),
        motivationalMessage = "Colocar Deus em primeiro lugar nos seus planos sempre traz paz e provisão inesperadas!",
        youtubePlaylistIndex = 20,
        youtubeVideoTitle = "Estudo 20 • O Dízimo"
    ),

    StudyLesson(
        number = 21,
        title = "Oferta, um Ato de Adoração",
        subtitle = "Generosidade alegre que transforma vidas e missões",
        category = StudyCategory.CHRISTIAN_LIFE,
        headerArt = StudyHeaderArt.BADGE_TROPHY,
        estimatedMinutes = 7,
        xpReward = 110,
        blogIntro = "Enquanto o dízimo tem porcentagem exata definida por Deus (10%), as ofertas nascem inteiramente do seu coração agradecido! Ofertar é adorar a Deus compartilhando recursos para manter igrejas locais, projetos sociais, escolas, livros missionários e ajuda aos necessitados. Até duas moedinhas dadas com amor valem ouro aos olhos de Jesus!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. O segredo do ofertante feliz",
                studyText = "Em 2 Coríntios 9:7, Paulo revela o segredo da oferta verdadeira: cada pessoa deve contribuir conforme propôs no coração — nunca reclamando nem por obrigação! A frase final aquece o coração: 'porque Deus ama a quem dá com alegria.' Quando ofertamos sorrindo, nos parecemos com o Pai que deu o Seu próprio Filho!",
                bibleRefs = listOf(
                    KeyVerseRef("2co", 9, 7, "2 Coríntios 9:7", "Cada um contribua segundo tiver proposto no coração... porque Deus ama a quem dá com alegria.")
                ),
                question = QuizQuestion(
                    question = "Que tipo de atitude ao ofertar agrada a Deus segundo 2 Coríntios 9:7?",
                    options = listOf(
                        "Dar com alegria após decidir livremente no coração",
                        "Dar reclamando por pressão",
                        "Dar apenas para aparecer diante dos amigos"
                    ),
                    correctIndex = 0,
                    explanation = "A alegria e liberdade do coração transformam qualquer oferta em adoração verdadeira.",
                    verseRef = "2 Coríntios 9:7"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. Mais feliz quem dá do que quem recebe",
                studyText = "Em um mundo que diz 'acumule tudo só para você', Jesus ensinou o oposto! Em Atos 20:35, Paulo recorda palavras preciosas de Jesus: 'Mais bem-aventurado é dar que receber.' Quem aprende a ser generoso com ofertas, tempo e bondade descobre uma felicidade que nenhuma compra no shopping consegue produzir.",
                bibleRefs = listOf(
                    KeyVerseRef("act", 20, 35, "Atos 20:35", "Mais bem-aventurado é dar que receber.")
                ),
                question = QuizQuestion(
                    question = "Qual frase de Jesus citada em Atos 20:35 mostra o valor da generosidade?",
                    options = listOf(
                        "'Guarde tudo antes que falte'",
                        "'Mais bem-aventurado é dar que receber'",
                        "'Só ajude quando sobrar muito'"
                    ),
                    correctIndex = 1,
                    explanation = "A generosidade traz alegria profunda porque reflete o coração doador de Cristo.",
                    verseRef = "Atos 20:35"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                isReview = true,
                heading = "Revisão do Estudo 21 • Dízimos e Ofertas Juntos",
                studyText = "O dízimo (10%) reconhece a fidelidade a Deus e sustenta o ministério pastoral; as ofertas (proporção livre escolhida por você) expressam gratidão extra e apoiam a igreja local, projetos solidários e missões mundiais. Planeje sua oferta com alegria antes mesmo de ir à igreja!",
                bibleRefs = listOf(
                    KeyVerseRef("2co", 9, 7, "2 Coríntios 9:7", "Deus ama a quem dá com alegria.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Qual é a diferença prática entre o dízimo e a oferta?",
                    options = listOf(
                        "Não existe diferença",
                        "O dízimo é 10% definido por Deus; a oferta tem valor livre escolhido com alegria para apoiar projetos e missões",
                        "A oferta é obrigatória e o dízimo é opcional"
                    ),
                    correctIndex = 1,
                    explanation = "Ambos são atos de adoração e gratidão a Deus que abençoam quem dá e quem recebe.",
                    verseRef = "2 Coríntios 9:7; Levítico 27:30"
                )
            )
        ),
        motivationalMessage = "Mãos abertas para ajudar são mãos parecidas com as do Salvador Jesus!",
        youtubePlaylistIndex = 21,
        youtubeVideoTitle = "Estudo 21 • Oferta, um Ato de Adoração"
    ),

    StudyLesson(
        number = 22,
        title = "Como Identificar a Igreja Verdadeira",
        subtitle = "As características proféticas do povo remanescente de Deus",
        category = StudyCategory.MISSION,
        headerArt = StudyHeaderArt.PROPHECY,
        estimatedMinutes = 9,
        xpReward = 125,
        blogIntro = "Com tantas denominações diferentes dizendo coisas opostas, como um jovem sincero pode saber qual movimento segue fielmente a Bíblia inteira nos últimos dias? Deus não nos deixou adivinhando! Em Apocalipse 12 e 14, Ele desenhou um 'retrato falado' profético claríssimo do Seu povo remanescente no tempo do fim — e convida você a fazer parte dessa família de fé.",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Guardam os mandamentos e têm o testemunho de Jesus",
                studyText = "Apocalipse 12:17 mostra os sinais exatos do povo remanescente dos últimos dias: eles 'guardam os mandamentos de Deus e têm o testemunho de Jesus'. Ou seja, não escolhem só 9 mandamentos (guardam todos os 10, inclusive o sábado!) e valorizam o dom profético que orienta a igreja.",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 12, 17, "Apocalipse 12:17", "Os que guardam os mandamentos de Deus e têm o testemunho de Jesus.")
                ),
                question = QuizQuestion(
                    question = "Quais duas marcas caracterizam o povo remanescente em Apocalipse 12:17?",
                    options = listOf(
                        "Templos grandes e riqueza",
                        "Guardam os mandamentos de Deus e têm o testemunho de Jesus",
                        "Roupas antigas e isolamento"
                    ),
                    correctIndex = 1,
                    explanation = "Obediência aos mandamentos de Deus (incluindo o sábado) e o espírito de profecia identificam o remanescente.",
                    verseRef = "Apocalipse 12:17"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. Proclamam as três mensagens angélicas ao mundo",
                studyText = "Em Apocalipse 14:6-12, Deus comissiona Sua igreja final para levar o evangelho eterno a toda nação, tribo, língua e povo! O chamado convida o mundo a adorar o Criador porque chegou a hora do juízo, abandonar confusões espirituais e perseverar guardando os mandamentos de Deus e a fé em Jesus.",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 14, 6, "Apocalipse 14:6-7, 12", "Tendo um evangelho eterno... Aqui está a perseverança dos santos, os que guardam os mandamentos de Deus e a fé em Jesus.", endVerse = 12)
                ),
                question = QuizQuestion(
                    question = "Em que capítulo bíblico encontramos a mensagem dos três anjos e o retrato dos santos finais?",
                    options = listOf("Apocalipse capítulo 14", "Rute capítulo 1", "Provérbios capítulo 3"),
                    correctIndex = 0,
                    explanation = "Apocalipse 14:6-12 apresenta o chamado missionário e profético da Igreja Adventista.",
                    verseRef = "Apocalipse 14:6-12"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Um só rebanho reunido pela voz do Bom Pastor",
                studyText = "Isso não significa arrogância contra ninguém! Em João 10:16, Jesus lembra com ternura: 'Ainda tenho outras ovelhas, não deste aprisco... elas ouvirão a minha voz; então, haverá um rebanho e um pastor.' Deus tem filhos sinceros em toda parte, e está chamando cada um pela Sua Voz para a verdade completa da Bíblia!",
                bibleRefs = listOf(
                    KeyVerseRef("jhn", 10, 16, "João 10:16", "Elas ouvirão a minha voz; então, haverá um rebanho e um pastor."),
                    KeyVerseRef("eph", 5, 23, "Efésios 5:23", "Cristo é o cabeça da igreja, sendo este mesmo o salvador do corpo.")
                ),
                question = QuizQuestion(
                    question = "Quem é o único Pastor e Cabeça da igreja segundo João 10:16 e Efésios 5:23?",
                    options = listOf("Jesus Cristo", "Um líder político", "Uma instituição humana"),
                    correctIndex = 0,
                    explanation = "Jesus Cristo é o Pastor supremo que reúne Seus filhos sinceros pela Sua Palavra.",
                    verseRef = "João 10:16; Efésios 5:23"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 22 • Fé em Jesus + Obediência Bíblica",
                studyText = "Não devemos escolher igreja apenas pela música, amizade ou comodidade — o critério seguro é perguntar: 'Essa igreja ensina tudo o que está na Bíblia?' Ao unir salvação pela graça, guarda de todos os Dez Mandamentos (incluindo o sábado), dom profético, saúde e esperança na Volta de Cristo, encontramos o movimento profético de Apocalipse 14!",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 14, 12, "Apocalipse 14:12", "Os que guardam os mandamentos de Deus e a fé em Jesus.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Qual critério seguro nos ajuda a identificar o povo fiel de Deus no fim dos tempos?",
                    options = listOf(
                        "Popularidade e tamanho do prédio",
                        "Fidelidade integral à Bíblia, guarda dos mandamentos, fé em Jesus e missão mundial de Apocalipse 14",
                        "Seguir tradições antigas sem conferir na Bíblia"
                    ),
                    correctIndex = 1,
                    explanation = "A fidelidade às Escrituras e a fé viva em Jesus são as marcas inconfundíveis.",
                    verseRef = "Apocalipse 12:17; 14:12"
                )
            )
        ),
        motivationalMessage = "Fazer parte do rebanho de Jesus é caminhar na verdade da Bíblia com o coração cheio de amor!",
        youtubePlaylistIndex = 22,
        youtubeVideoTitle = "Estudo 22 • Como Identificar a Igreja Verdadeira"
    ),

    StudyLesson(
        number = 23,
        title = "Por que Devo Ser Batizado?",
        subtitle = "O mergulho público que celebra uma nova vida com Jesus",
        category = StudyCategory.MISSION,
        headerArt = StudyHeaderArt.HERO_STUDY,
        estimatedMinutes = 8,
        xpReward = 130,
        blogIntro = "Existe um dia na vida de um jovem cristão que nunca mais se esquece: o dia do batismo! Mas por que Jesus ordenou o batismo, e por que os adventistas batizam por imersão (mergulho completo na água) apenas quando a pessoa tem consciência para crer e decidir? Vamos abrir a Bíblia e descobrir a beleza simbólica desse compromisso público com Jesus!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. O exemplo perfeito de Jesus no Rio Jordão",
                studyText = "Embora Jesus nunca tivesse pecado, Ele caminhou até o rio Jordão para ser batizado por João Batista como nosso exemplo! Mateus 3:16 conta que, 'batizado Jesus, saiu logo da água' — provando que Ele entrou e foi imerso na água do rio. E o Pai abriu os céus dizendo: 'Este é o meu Filho amado!'",
                bibleRefs = listOf(
                    KeyVerseRef("mat", 3, 16, "Mateus 3:16-17", "Batizado Jesus, saiu logo da água, e eis que se lhe abriram os céus.", endVerse = 17)
                ),
                question = QuizQuestion(
                    question = "De que modo Jesus foi batizado no rio Jordão segundo Mateus 3:16?",
                    options = listOf(
                        "Por imersão — entrou e saiu logo da água",
                        "Apenas com gotas na testa",
                        "Sem entrar na água"
                    ),
                    correctIndex = 0,
                    explanation = "A própria palavra grega 'baptizo' significa mergulhar/imergir totalmente.",
                    verseRef = "Mateus 3:16"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. Morte, sepultamento e ressurreição simbólicos",
                studyText = "Em Romanos 6:4, Paulo explica por que o mergulho completo é indispensável: descer às águas simboliza morrer e ser sepultado para a velha vida de pecado; levantar da água simboliza ressuscitar com Jesus para andar em novidade de vida! Algumas gotinhas não simbolizam um sepultamento — somente a imersão expressa essa linda mensagem.",
                bibleRefs = listOf(
                    KeyVerseRef("rom", 6, 4, "Romanos 6:4", "Fomos, pois, sepultados com ele na morte pelo batismo; para que... andemos nós em novidade de vida.")
                ),
                question = QuizQuestion(
                    question = "O que o ato de descer e subir da água simboliza segundo Romanos 6:4?",
                    options = listOf(
                        "Um ritual de higiene física",
                        "Sepultamento da velha vida e ressurreição para uma nova vida com Cristo",
                        "Uma formatura que encerra o estudo"
                    ),
                    correctIndex = 1,
                    explanation = "Pelo batismo declaramos publicamente que morremos para o pecado e vivemos para Jesus!",
                    verseRef = "Romanos 6:4"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Escolha consciente de fé e arrependimento",
                studyText = "Na Bíblia, ninguém era batizado sem antes ouvir a Palavra, crer em Jesus e se arrepender (Marcos 16:16; Atos 2:38). Por isso não batizamos bebês recém-nascidos — bebês são abençoados e consagrados em oração como Jesus fez, mas o batismo é uma decisão pessoal consciente de crianças maiores, adolescentes e adultos!",
                bibleRefs = listOf(
                    KeyVerseRef("mrk", 16, 16, "Marcos 16:16", "Quem crer e for batizado será salvo."),
                    KeyVerseRef("act", 2, 38, "Atos 2:38", "Arrependei-vos, e cada um de vós seja batizado em nome de Jesus Cristo.")
                ),
                question = QuizQuestion(
                    question = "O que deve acontecer antes do batismo segundo Marcos 16:16 e Atos 2:38?",
                    options = listOf(
                        "A pessoa precisa aprender, crer em Jesus e arrepender-se conscientemente",
                        "Não precisa compreender nada",
                        "Apenas completar 40 anos"
                    ),
                    correctIndex = 0,
                    explanation = "O batismo é uma decisão pessoal consciente de fé e entrega a Jesus Cristo.",
                    verseRef = "Marcos 16:16; Atos 2:38"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 23 • A Grande Comissão de Cristo",
                studyText = "Em Mateus 28:19, Jesus ordenou fazer discípulos ensinando a Palavra e batizando em nome do Pai, do Filho e do Espírito Santo. O batismo não marca o fim do aprendizado — é o começo oficial da sua aventura pública na família de Deus!",
                bibleRefs = listOf(
                    KeyVerseRef("mat", 28, 19, "Mateus 28:19", "Ide, portanto, fazei discípulos de todas as nações, batizando-os em nome do Pai, e do Filho, e do Espírito Santo.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Em nome de quem o batismo bíblico é realizado (Mateus 28:19)?",
                    options = listOf(
                        "Em nome do Pai, do Filho e do Espírito Santo",
                        "Em nome do pastor local",
                        "Em nome dos anjos"
                    ),
                    correctIndex = 0,
                    explanation = "Toda a Trindade celebra e acompanha a aliança do batismo cristão.",
                    verseRef = "Mateus 28:19"
                )
            )
        ),
        motivationalMessage = "Se você ama a Jesus e sente Seu chamado ao coração, converse com seus pais ou pastor sobre o batismo!",
        youtubePlaylistIndex = 23,
        youtubeVideoTitle = "Estudo 23 • Por que Devo Ser Batizado?"
    ),

    StudyLesson(
        number = 24,
        title = "Princípios de Vida Cristã",
        subtitle = "Escolhas diárias que refletem Jesus na escola e em casa",
        category = StudyCategory.CHRISTIAN_LIFE,
        headerArt = StudyHeaderArt.HERO_STUDY,
        estimatedMinutes = 8,
        xpReward = 115,
        blogIntro = "Como ser um cristão autêntico na sala de aula, nas redes sociais, na escolha de músicas, séries, jogos, roupas e amizades? Seguir a Jesus não significa viver triste ou esquisito! Significa ter critérios inteligentes e corajosos para proteger sua mente, seu coração e sua alegria — vivendo em paz sem precisar copiar tudo o que a multidão faz.",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Não seguir a boiada, mas renovar a mente",
                studyText = "Em Romanos 12:2, Paulo dá um conselho direto aos jovens cristãos: 'E não vos conformeis com este século, mas transformai-vos pela renovação da vossa mente.' Não precisamos seguir modas que destroem nossa dignidade ou paz só para sermos aceitos — Jesus renova nossa mente para escolhermos o que é realmente bom e perfeito!",
                bibleRefs = listOf(
                    KeyVerseRef("rom", 12, 2, "Romanos 12:2", "Não vos conformeis com este século, mas transformai-vos pela renovação da vossa mente.")
                ),
                question = QuizQuestion(
                    question = "O que Romanos 12:2 nos orienta a fazer diante dos costumes deste mundo?",
                    options = listOf(
                        "Copiar tudo para não parecer diferente",
                        "Não nos conformar ao mundo, mas transformar-nos pela renovação da mente",
                        "Viver isolados sem falar com ninguém"
                    ),
                    correctIndex = 1,
                    explanation = "A transformação cristã começa dentro da mente renovada pela Palavra de Deus.",
                    verseRef = "Romanos 12:2"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. O filtro inteligente de Filipenses 4:8",
                studyText = "Quando estiver em dúvida sobre assistir a um vídeo, ouvir uma música, entrar em um jogo ou conversar sobre alguém, passe tudo pelo filtro de 6 perguntas de Filipenses 4:8: É verdadeiro? É respeitável? É justo? É puro? É amável? É de boa fama? Se passar nesse filtro, alimentará sua mente com luz!",
                bibleRefs = listOf(
                    KeyVerseRef("php", 4, 8, "Filipenses 4:8", "Tudo o que é verdadeiro, tudo o que é respeitável, tudo o que é justo, tudo o que é puro, tudo o que é amável, tudo o que é de boa fama, seja isso o que ocupe o vosso pensamento.")
                ),
                question = QuizQuestion(
                    question = "Qual filtro prático Filipenses 4:8 oferece para escolhermos entretenimento e pensamentos?",
                    options = listOf(
                        "O que tiver mais visualizações",
                        "O que é verdadeiro, respeitável, justo, puro, amável e de boa fama",
                        "Qualquer coisa popular"
                    ),
                    correctIndex = 1,
                    explanation = "Aquilo que contemplamos molda nosso caráter; Filipenses 4:8 protege o coração!",
                    verseRef = "Filipenses 4:8"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                isReview = true,
                heading = "Revisão do Estudo 24 • Brilhar com Simplicidade e Alegria",
                studyText = "Vestir-se com modéstia e bom gosto, falar palavras que constroem (nunca bullying ou palavrões), respeitar autoridades e escolher diversões saudáveis tornam você uma pessoa confiável, alegre e cheia da paz de Deus!",
                bibleRefs = listOf(
                    KeyVerseRef("php", 4, 13, "Filipenses 4:13", "Tudo posso naquele que me fortalece.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: De onde vem a força para dizer 'não' às pressões erradas dos colegas?",
                    options = listOf(
                        "De Cristo que nos fortalece diariamente (Filipenses 4:13)",
                        "De brigar com todo mundo",
                        "De fingir concordar"
                    ),
                    correctIndex = 0,
                    explanation = "Com Cristo fortalecendo nosso interior, mantemos valores firmes com simpatia e coragem.",
                    verseRef = "Filipenses 4:8, 13"
                )
            )
        ),
        motivationalMessage = "Suas pequenas escolhas diárias estão construindo o caráter luminoso que você levará para o Céu!",
        youtubePlaylistIndex = 24,
        youtubeVideoTitle = "Estudo 24 • Princípios de Vida Cristã"
    ),

    StudyLesson(
        number = 25,
        title = "Educação Cristã",
        subtitle = "Desenvolvendo mente, corpo e coração para servir",
        category = StudyCategory.CHRISTIAN_LIFE,
        headerArt = StudyHeaderArt.HERO_STUDY,
        estimatedMinutes = 8,
        xpReward = 115,
        blogIntro = "Para que serve estudar matemática, ciências, idiomas e história se estamos esperando a volta de Jesus? Para os adventistas, a verdadeira educação é muito mais do que passar em provas ou conseguir um emprego: ela visa restaurar no ser humano a imagem do Criador! A escola, a igreja e a família trabalham juntas para desenvolver o aluno por inteiro — e o aprendizado continuará pela eternidade!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. O modelo de crescimento integral de Jesus",
                studyText = "Lucas 2:52 resume toda a adolescência de Jesus em quatro dimensões perfeitas: Ele crescia em sabedoria (mente), em estatura (corpo), em graça diante de Deus (espiritualidade) e diante dos homens (relacionamentos saudáveis). Uma educação verdadeiramente cristã cuida de todas essas quatro áreas equilibradamente!",
                bibleRefs = listOf(
                    KeyVerseRef("luk", 2, 52, "Lucas 2:52", "E crescia Jesus em sabedoria, estatura e graça, diante de Deus e dos homens.")
                ),
                question = QuizQuestion(
                    question = "Quais quatro áreas do desenvolvimento humano aparecem na juventude de Jesus (Lucas 2:52)?",
                    options = listOf(
                        "Apenas notas escolares",
                        "Sabedoria (mente), estatura (corpo), graça diante de Deus (fé) e diante das pessoas (social)",
                        "Somente força física"
                    ),
                    correctIndex = 1,
                    explanation = "A educação cristã desenvolve mente, corpo, coração e amizades em harmonia.",
                    verseRef = "Lucas 2:52"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. O ponto de partida da verdadeira sabedoria",
                studyText = "Você pode decorar muitos livros, mas sem Deus falta o alicerce da vida! Provérbios 9:10 declara que 'o temor (respeito amoroso) do Senhor é o princípio da sabedoria'. E Provérbios 22:6 destaca a importância de ensinar a criança e o adolescente no caminho do bem desde cedo.",
                bibleRefs = listOf(
                    KeyVerseRef("pro", 9, 10, "Provérbios 9:10", "O temor do Senhor é o princípio da sabedoria."),
                    KeyVerseRef("pro", 22, 6, "Provérbios 22:6", "Ensina a criança no caminho em que deve andar.")
                ),
                question = QuizQuestion(
                    question = "Qual é o princípio da verdadeira sabedoria segundo Provérbios 9:10?",
                    options = listOf(
                        "O respeito e relacionamento amoroso com o Senhor",
                        "Ganhar todas as discussões",
                        "Ter a maior nota apenas"
                    ),
                    correctIndex = 0,
                    explanation = "Conhecer a Deus coloca todo o conhecimento humano na direção certa para servir.",
                    verseRef = "Provérbios 9:10"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                isReview = true,
                heading = "Revisão do Estudo 25 • Aprender Agora e na Eternidade",
                studyText = "Dedique-se aos seus estudos escolares com capricho, honestidade e gratidão! Cada habilidade que você desenvolve hoje — ler bem, programar, cuidar de pessoas, tocar música ou construir — pode ser usada como instrumento nas mãos de Deus para abençoar o próximo.",
                bibleRefs = listOf(
                    KeyVerseRef("luk", 2, 52, "Lucas 2:52", "Crescia Jesus em sabedoria, estatura e graça.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Qual é o propósito maior da Educação Cristã?",
                    options = listOf(
                        "Competir para ser melhor que os colegas",
                        "Desenvolver mente, corpo e caráter segundo o exemplo de Jesus para servir a Deus e ao próximo",
                        "Decorar datas apenas"
                    ),
                    correctIndex = 1,
                    explanation = "Servir com amor e excelência é o maior diploma que um jovem cristão pode conquistar.",
                    verseRef = "Lucas 2:52; Provérbios 22:6"
                )
            )
        ),
        motivationalMessage = "Você recebeu uma mente criativa de Deus — estude com dedicação e use seus talentos para o bem!",
        youtubePlaylistIndex = 25,
        youtubeVideoTitle = "Estudo 25 • Educação Cristã"
    ),

    StudyLesson(
        number = 26,
        title = "A Vida no Espírito",
        subtitle = "O poder do Espírito Santo produzindo frutos em você",
        category = StudyCategory.CHRISTIAN_LIFE,
        headerArt = StudyHeaderArt.BIBLE_NIGHT,
        estimatedMinutes = 8,
        xpReward = 125,
        blogIntro = "Já tentou mudar um hábito difícil ou controlar a raiva apenas com força de vontade e acabou falhando? É que a vida cristã não é um esforço solitário! Antes de subir ao Céu, Jesus prometeu não nos deixar órfãos: Ele enviou o Espírito Santo — a terceira Pessoa da Trindade — para morar em nós, dar poder para testemunhar e cultivar em nosso caráter os nove lindos sabores do Fruto do Espírito!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Os nove aspectos do Fruto do Espírito",
                studyText = "Quando o Espírito Santo guia nossa vida, não produzimos apenas barulho — produzimos caráter parecido com o de Jesus! Gálatas 5:22-23 lista esse fruto maravilhoso: amor, alegria, paz, longanimidade (paciência), benignidade (gentileza), bondade, fidelidade, mansidão e domínio próprio. Que perfil incrível para qualquer adolescente!",
                bibleRefs = listOf(
                    KeyVerseRef("gal", 5, 22, "Gálatas 5:22-23", "Mas o fruto do Espírito é: amor, alegria, paz, longanimidade, benignidade, bondade, fidelidade, mansidão, domínio próprio.", endVerse = 23)
                ),
                question = QuizQuestion(
                    question = "Qual virtude encabeça o Fruto do Espírito em Gálatas 5:22?",
                    options = listOf("Amor (junto com alegria, paz, paciência e domínio próprio)", "Orgulho", "Popularidade"),
                    correctIndex = 0,
                    explanation = "O amor é a raiz de todo o Fruto do Espírito Santo no coração rendido a Cristo.",
                    verseRef = "Gálatas 5:22-23"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. Poder para ser testemunha de Jesus",
                studyText = "Às vezes temos vergonha ou medo de falar sobre nossa fé na escola ou entre amigos. Em Atos 1:8, Jesus garantiu aos discípulos ainda tímidos: 'Mas recebereis poder, ao descer sobre vós o Espírito Santo, e sereis minhas testemunhas.' O mesmo Espírito que fortaleceu os apóstolos dá coragem e sabedoria a você hoje!",
                bibleRefs = listOf(
                    KeyVerseRef("act", 1, 8, "Atos 1:8", "Recebereis poder, ao descer sobre vós o Espírito Santo, e sereis minhas testemunhas.")
                ),
                question = QuizQuestion(
                    question = "Para que o Espírito Santo concede poder aos discípulos em Atos 1:8?",
                    options = listOf(
                        "Para serem testemunhas vivas de Jesus em todo lugar",
                        "Para discutir sem amor",
                        "Para se esconderem do mundo"
                    ),
                    correctIndex = 0,
                    explanation = "O Espírito Santo capacita nossa vida e palavras para refletirmos o amor de Jesus.",
                    verseRef = "Atos 1:8"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                isReview = true,
                heading = "Revisão do Estudo 26 • Pedindo o Espírito Todo Dia",
                studyText = "Em Lucas 11:13, Jesus prometeu que o Pai celestial dará o Espírito Santo com alegria a quem Lhe pedir! Comece cada manhã orando: 'Senhor, enche meu coração com o Teu Espírito hoje!' Assim você vencerá tentações, terá paz nos estudos e espalhará a gentileza de Jesus.",
                bibleRefs = listOf(
                    KeyVerseRef("gal", 5, 22, "Gálatas 5:22", "O fruto do Espírito é: amor, alegria, paz...")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Como o caráter cristão descrito em Gálatas 5:22 é desenvolvido?",
                    options = listOf(
                        "Pelo esforço isolado sem oração",
                        "Pela comunhão diária com Cristo permitindo que o Espírito Santo produza Seu fruto em nós",
                        "Apenas na idade adulta"
                    ),
                    correctIndex = 1,
                    explanation = "Somos ramos ligados à Videira (Jesus), e o Espírito faz o fruto crescer naturalmente!",
                    verseRef = "Gálatas 5:22-23; Atos 1:8"
                )
            )
        ),
        motivationalMessage = "Você nunca enfrenta um desafio sozinho: o Espírito Santo caminha ao seu lado em cada passo!",
        youtubePlaylistIndex = 26,
        youtubeVideoTitle = "Estudo 26 • A Vida no Espírito"
    ),

    StudyLesson(
        number = 27,
        title = "Um Ministério para Todos",
        subtitle = "Você também foi chamado para compartilhar a Voz de Deus!",
        category = StudyCategory.MISSION,
        headerArt = StudyHeaderArt.BADGE_TROPHY,
        estimatedMinutes = 9,
        xpReward = 150,
        blogIntro = "Chegamos ao estudo 27 — o fechamento glorioso de toda a nossa jornada por 'Ouvindo a Voz de Deus'! Algumas pessoas acham que pregar o evangelho é tarefa só de pastores ou adultos formados. Que engano! Na Bíblia, cada criança, adolescente e jovem que conhece Jesus torna-se um embaixador e missionário. Você tem um ministério único que ninguém mais pode cumprir no seu lugar!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Sacerdócio real de todas as idades",
                studyText = "Em 1 Pedro 2:9, o apóstolo dirige um título nobre a toda a igreja — não apenas aos líderes: 'Vós, porém, sois raça eleita, sacerdócio real, nação santa, povo de propriedade exclusiva de Deus, a fim de proclamardes as virtudes daquele que vos chamou das trevas para a sua maravilhosa luz.' Cada amigo de Jesus tem uma missão!",
                bibleRefs = listOf(
                    KeyVerseRef("1pe", 2, 9, "1 Pedro 2:9", "Vós, porém, sois raça eleita, sacerdócio real... a fim de proclamardes as virtudes daquele que vos chamou.")
                ),
                question = QuizQuestion(
                    question = "Quem faz parte do 'sacerdócio real' chamado para proclamar as virtudes de Deus (1 Pedro 2:9)?",
                    options = listOf(
                        "Apenas pastores antigos",
                        "Todo o povo de Deus — crianças, jovens e adultos que pertencem a Cristo",
                        "Somente pessoas idosas"
                    ),
                    correctIndex = 1,
                    explanation = "Todos os cristãos têm o privilégio e a missão de testemunhar do amor de Deus.",
                    verseRef = "1 Pedro 2:9"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. Não deixe ninguém desprezar a sua juventude",
                studyText = "Paulo escreveu diretamente a um jovem líder chamado Timóteo em 1 Timóteo 4:12: 'Ninguém despreze a tua mocidade; pelo contrário, torna-te padrão dos fiéis, na palavra, no procedimento, no amor, na fé, na pureza.' Você não precisa esperar crescer para ajudar colegas, orar por amigos, convidar alguém para estudar a Bíblia ou praticar atos de bondade!",
                bibleRefs = listOf(
                    KeyVerseRef("1tm", 4, 12, "1 Timóteo 4:12", "Ninguém despreze a tua mocidade; pelo contrário, torna-te padrão dos fiéis.")
                ),
                question = QuizQuestion(
                    question = "Qual desafio Paulo deixou aos jovens em 1 Timóteo 4:12?",
                    options = listOf(
                        "Esperar fazer 30 anos para servir",
                        "Ser exemplo fiel desde a juventude nas palavras, atitudes, amor, fé e pureza",
                        "Esconder que é cristão na escola"
                    ),
                    correctIndex = 1,
                    explanation = "Jovens e crianças podem ser os missionários mais vibrantes e influentes da igreja!",
                    verseRef = "1 Timóteo 4:12"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. A promessa de companhia diária até o fim",
                studyText = "Na Grande Comissão de Mateus 28:19-20, Jesus envia Seus discípulos para ensinar tudo o que Ele ordenou e termina com a garantia mais reconfortante de toda a Bíblia: 'E eis que estou convosco todos os dias até à consumação do século.' Ele nunca manda você ir sozinho — Ele vai com você!",
                bibleRefs = listOf(
                    KeyVerseRef("mat", 28, 19, "Mateus 28:19-20", "Ide, portanto, fazei discípulos... E eis que estou convosco todos os dias até à consumação do século.", endVerse = 20)
                ),
                question = QuizQuestion(
                    question = "Qual promessa Jesus deixou ao final da Grande Comissão em Mateus 28:20?",
                    options = listOf(
                        "'Estou convosco todos os dias até à consumação do século'",
                        "'Tentem se virar sozinhos'",
                        "'Só apareço aos domingos'"
                    ),
                    correctIndex = 0,
                    explanation = "A presença contínua de Cristo garante força e alegria em nossa missão diária.",
                    verseRef = "Mateus 28:19-20"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão Final • Embaixador de Ouvindo a Voz de Deus",
                studyText = "Parabéns por chegar ao Estudo 27! Você percorreu toda a mensagem bíblica adventista: da Criação ao Grande Conflito, da Cruz ao Santuário Celestial, dos Mandamentos e do Sábado à Saúde, da Morte como sono à Volta Gloriosa de Jesus e à Nova Terra. Agora é a sua vez de compartilhar o que aprendeu — convide um amigo ou familiar para estudar junto com você!",
                bibleRefs = listOf(
                    KeyVerseRef("1tm", 4, 12, "1 Timóteo 4:12", "Torna-te padrão dos fiéis."),
                    KeyVerseRef("rev", 22, 20, "Apocalipse 22:20", "Amém! Vem, Senhor Jesus!")
                ),
                question = QuizQuestion(
                    question = "Revisão Final do Curso: Qual é o chamado principal ao concluir os 27 estudos?",
                    options = listOf(
                        "Guardar o conhecimento só para si",
                        "Viver em amizade diária com Jesus e compartilhar Sua Palavra com amor ao seu redor",
                        "Parar de ler a Bíblia"
                    ),
                    correctIndex = 1,
                    explanation = "O verdadeiro discípulo continua ouvindo a Voz de Deus todos os dias e abençoando outras vidas!",
                    verseRef = "Mateus 28:19-20; 1 Pedro 2:9"
                )
            )
        ),
        motivationalMessage = "Parabéns, Embaixador do Reino! Continue ouvindo a Voz de Deus e iluminando o mundo ao seu redor!",
        youtubePlaylistIndex = 27,
        youtubeVideoTitle = "Estudo 27 • Um Ministério para Todos"
    )
)
