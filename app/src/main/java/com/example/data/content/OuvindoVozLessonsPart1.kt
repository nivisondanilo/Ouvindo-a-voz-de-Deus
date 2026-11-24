package com.example.data.content

import com.example.model.KeyVerseRef
import com.example.model.QuizQuestion
import com.example.model.StudyCategory
import com.example.model.StudyHeaderArt
import com.example.model.StudyLesson
import com.example.model.StudyThoughtBlock

val ouvindoVozLessonsPart1: List<StudyLesson> = listOf(
    StudyLesson(
        number = 1,
        title = "A Bíblia Sagrada",
        subtitle = "A carta de amor e verdade de Deus escrita para você",
        category = StudyCategory.FOUNDATIONS,
        headerArt = StudyHeaderArt.HERO_STUDY,
        estimatedMinutes = 12,
        xpReward = 150,
        blogIntro = "Você já imaginou receber um guia completo escrito pelo próprio Criador do Universo, explicando de onde viemos, por que existe sofrimento e como ter um futuro eterno ao lado de Jesus? Para os adventistas do sétimo dia, a Bíblia Sagrada não é apenas um livro antigo de histórias bonitas: ela é a Palavra viva de Deus, nossa única regra de fé e prática. Ao longo de cerca de 1.600 anos, Deus usou aproximadamente 40 autores diferentes — reis, pastores, pescadores, médicos e profetas — para compor uma única mensagem harmoniosa dividida em 66 livros (39 no Antigo Testamento e 27 no Novo Testamento). Prepare seu coração, clique nas referências bíblicas abaixo para ler cada texto na íntegra e avance pensamento por pensamento!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Como Jesus considerava a Escritura Sagrada?",
                studyText = "Em um mundo cheio de opiniões que mudam todos os dias nas redes sociais, precisamos de um ponto firme que nunca falha. Na oração sacerdotal pouco antes da cruz, Jesus levantou os olhos ao Pai e declarou com toda clareza o valor absoluto das Escrituras. Para Cristo, a Palavra de Deus não contém apenas algumas ideias boas: ela mesma é a verdade capaz de santificar e transformar a mente humana.",
                bibleRefs = listOf(
                    KeyVerseRef("jhn", 17, 17, "João 17:17", "Santifica-os na verdade; a tua palavra é a verdade.")
                ),
                question = QuizQuestion(
                    question = "Segundo Jesus em João 17:17, o que é a Palavra de Deus?",
                    options = listOf(
                        "Apenas um livro de poesias antigas",
                        "A própria verdade que santifica a vida",
                        "Um conjunto de regras humanas opcionais"
                    ),
                    correctIndex = 1,
                    explanation = "Jesus afirmou categoricamente ao Pai: 'Santifica-os na verdade; a tua palavra é a verdade.'",
                    verseRef = "João 17:17"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. Precisamos de orientação para compreender a Bíblia?",
                studyText = "Quando abrimos um livro profundo ou viajamos por uma trilha desconhecida, contar com um guia faz toda a diferença. No livro de Atos, um oficial da Etiópia viajava em sua carruagem lendo o profeta Isaías em voz alta, mas não conseguia entender de quem o texto falava. Deus enviou Filipe para caminhar ao lado dele e explicar as Escrituras. Isso mostra que o estudo em comunidade, com professores, pais, amigos da igreja e guias bíblicos, é um presente de Deus — embora a decisão pessoal dependa sempre de você.",
                bibleRefs = listOf(
                    KeyVerseRef("act", 8, 26, "Atos 8:26-31", "Como poderei entender, se alguém não me explicar?", endVerse = 31)
                ),
                question = QuizQuestion(
                    question = "O que o etíope respondeu a Filipe quando perguntado se entendia o que estava lendo?",
                    options = listOf(
                        "Disse que ninguém precisava ajudar",
                        "Respondeu: 'Como poderei entender, se alguém não me explicar?'",
                        "Fechou o rolo e desistiu da leitura"
                    ),
                    correctIndex = 1,
                    explanation = "Com humildade, o etíope reconheceu que precisava de ajuda para compreender as profecias sobre Jesus.",
                    verseRef = "Atos 8:30-31"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Qual é o método correto para estudar a Bíblia?",
                studyText = "Algumas pessoas cometem o erro de pegar um versículo isolado para defender qualquer ideia. Porém, a própria Bíblia ensina como ela deve ser estudada! Em Isaías 28:10 aprendemos o princípio de comparar passagem com passagem: 'preceito sobre preceito, regra sobre regra, um pouco aqui, um pouco ali'. Quando reunimos tudo o que a Bíblia diz sobre um assunto, as peças do quebra-cabeça se encaixam perfeitamente e a Bíblia explica a si mesma.",
                bibleRefs = listOf(
                    KeyVerseRef("isa", 28, 10, "Isaías 28:10", "Preceito sobre preceito, regra sobre regra; um pouco aqui, um pouco ali.")
                ),
                question = QuizQuestion(
                    question = "Como Isaías 28:10 recomenda estudar e compreender a Palavra de Deus?",
                    options = listOf(
                        "Comparando preceito sobre preceito, um pouco aqui e um pouco ali",
                        "Lendo apenas um versículo solto por mês",
                        "Escolhendo somente os textos mais curtos"
                    ),
                    correctIndex = 0,
                    explanation = "A Bíblia interpreta a própria Bíblia quando comparamos textos relacionados sobre cada tema.",
                    verseRef = "Isaías 28:10"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                heading = "4. Qual é o propósito central das Escrituras?",
                studyText = "Você já leu uma história inteira procurando quem é o personagem principal? Na Bíblia, cada capítulo — desde Gênesis até Apocalipse — aponta para uma Pessoa maravilhosa: Jesus Cristo! Quando os líderes religiosos examinavam a Lei apenas para parecerem inteligentes, Jesus lembrou-lhes que o grande objetivo das Escrituras é testificar dEle e revelar o caminho da vida eterna.",
                bibleRefs = listOf(
                    KeyVerseRef("jhn", 5, 39, "João 5:39", "Examinais as Escrituras, porque julgais ter nelas a vida eterna, e são elas mesmas que testificam de mim.")
                ),
                question = QuizQuestion(
                    question = "De quem todas as Escrituras testificam segundo João 5:39?",
                    options = listOf(
                        "Apenas dos antigos reis de Israel",
                        "De Jesus Cristo, nosso Salvador",
                        "Somente das leis cerimoniais"
                    ),
                    correctIndex = 1,
                    explanation = "Jesus declarou: 'São elas mesmas que testificam de mim.' Cristo é o centro de toda a Bíblia!",
                    verseRef = "João 5:39"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 5,
                heading = "5. Quem ilumina nossa mente para entender a verdade?",
                studyText = "Antes de abrir a Bíblia, vale muito a pena fazer uma oração simples pedindo ajuda ao Autor do livro! Jesus prometeu enviar o Espírito da Verdade para guiar Seus filhos a toda a verdade espiritual. E quando essa verdade entra no coração, ela não aprisiona — pelo contrário, liberta o jovem e a criança do medo, da mentira e da culpa.",
                bibleRefs = listOf(
                    KeyVerseRef("jhn", 16, 13, "João 16:13", "Quando vier, porém, o Espírito da verdade, ele vos guiará a toda a verdade."),
                    KeyVerseRef("jhn", 8, 32, "João 8:32", "E conhecereis a verdade, e a verdade vos libertará.")
                ),
                question = QuizQuestion(
                    question = "Quem Jesus prometeu enviar para nos guiar a toda a verdade (João 16:13)?",
                    options = listOf(
                        "O Espírito da verdade (Espírito Santo)",
                        "Um filósofo famoso",
                        "Apenas a nossa própria intuição"
                    ),
                    correctIndex = 0,
                    explanation = "O Espírito Santo é o mesmo que inspirou a Bíblia e ilumina nossa mente hoje para compreendê-la.",
                    verseRef = "João 16:13"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 6,
                heading = "6. Qual é a origem divina e a inspiração da Bíblia?",
                studyText = "Às vezes alguém pergunta: 'Mas a Bíblia não foi escrita por seres humanos?'. Sim, os escritores usaram mãos humanas, culturas e estilos próprios, mas não escreveram por vontade própria ou inventaram ideias! O apóstolo Pedro explica que homens santos falaram da parte de Deus, movidos pelo Espírito Santo — como o vento que sopra nas velas de um barco, conduzindo o navio ao destino seguro.",
                bibleRefs = listOf(
                    KeyVerseRef("2pe", 1, 21, "2 Pedro 1:21", "Homens santos falaram da parte de Deus, movidos pelo Espírito Santo.")
                ),
                question = QuizQuestion(
                    question = "Segundo 2 Pedro 1:21, de onde vieram as profecias e ensinos bíblicos?",
                    options = listOf(
                        "Da imaginação criativa de poetas",
                        "De homens santos movidos pelo Espírito Santo de Deus",
                        "De decretos de imperadores"
                    ),
                    correctIndex = 1,
                    explanation = "Nenhuma profecia veio por vontade humana; o Espírito Santo moveu os escritores.",
                    verseRef = "2 Pedro 1:21"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 7,
                heading = "7. Que parte da Bíblia é inspirada e para que ela serve?",
                studyText = "Não podemos escolher só as páginas de que gostamos e ignorar o resto! O apóstolo Paulo escreveu ao jovem Timóteo garantindo que TODA a Escritura é inspirada por Deus. Ela funciona como um treinamento completo para crianças, adolescentes e adultos: ensina o caminho certo, mostra quando erramos, corrige nossos passos e nos educa na justiça para estarmos prontos para toda boa obra.",
                bibleRefs = listOf(
                    KeyVerseRef("2tm", 3, 16, "2 Timóteo 3:16-17", "Toda a Escritura é inspirada por Deus e útil para o ensino, para a repreensão, para a correção, para a educação na justiça.", endVerse = 17)
                ),
                question = QuizQuestion(
                    question = "Quanto da Escritura é inspirado por Deus segundo 2 Timóteo 3:16?",
                    options = listOf(
                        "Apenas o Novo Testamento",
                        "Toda a Escritura (Antigo e Novo Testamentos)",
                        "Somente os Salmos"
                    ),
                    correctIndex = 1,
                    explanation = "Paulo afirma: 'Toda a Escritura é inspirada por Deus e útil para o ensino...'",
                    verseRef = "2 Timóteo 3:16"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 8,
                heading = "8. Qual parte da Bíblia foi escrita pelo próprio dedo de Deus?",
                studyText = "Em toda a história da humanidade, houve um momento absolutamente especial no alto do Monte Sinai. Deus não apenas inspirou Moisés — Ele mesmo gravou Suas palavras eternas em duas tábuas de pedra! Essa lei moral — os Dez Mandamentos — reflete o caráter imutável do Criador e permanece como base eterna do Seu governo de amor.",
                bibleRefs = listOf(
                    KeyVerseRef("exo", 31, 18, "Êxodo 31:18", "Deu a Moisés as duas tábuas do Testemunho, tábuas de pedra, escritas pelo dedo de Deus.")
                ),
                question = QuizQuestion(
                    question = "O que Deus entregou a Moisés escrito pelo Seu próprio dedo (Êxodo 31:18)?",
                    options = listOf(
                        "Um mapa de batalha",
                        "As duas tábuas de pedra do Testemunho (Dez Mandamentos)",
                        "Um rolo de papiro temporário"
                    ),
                    correctIndex = 1,
                    explanation = "Os Dez Mandamentos foram escritos pelo próprio dedo de Deus em pedra, mostrando sua permanência eterna.",
                    verseRef = "Êxodo 31:18"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 9,
                heading = "9. Alguém tem autoridade para mudar ou retirar textos da Bíblia?",
                studyText = "Em Malaquias 3:6, Deus declara: 'Porque eu, o Senhor, não mudo.' Se o caráter de Deus nunca muda, Sua Palavra também não pode ser editada ao gosto da moda! No último capítulo de toda a Bíblia, Jesus deixou uma advertência solene: ninguém deve acrescentar nem tirar nada das palavras da profecia, para manter pura a mensagem da salvação.",
                bibleRefs = listOf(
                    KeyVerseRef("mal", 3, 6, "Malaquias 3:6", "Porque eu, o Senhor, não mudo."),
                    KeyVerseRef("rev", 22, 18, "Apocalipse 22:18-19", "Se alguém lhes fizer qualquer acréscimo... e se alguém tirar qualquer coisa...", endVerse = 19)
                ),
                question = QuizQuestion(
                    question = "O que Apocalipse 22:18-19 ensina sobre acrescentar ou tirar palavras das Escrituras?",
                    options = listOf(
                        "Cada geração pode editar como preferir",
                        "Há uma advertência solene para não acrescentar nem retirar nada da Palavra",
                        "Apenas traduções antigas contam"
                    ),
                    correctIndex = 1,
                    explanation = "A Palavra de Deus deve ser preservada fielmente sem acréscimos humanos nem cortes.",
                    verseRef = "Apocalipse 22:18-19"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 10,
                heading = "10. Podemos confiar na pureza e proteção da Palavra?",
                studyText = "Na internet circulam notícias falsas todos os dias, mas com Deus é totalmente diferente. O livro de Provérbios garante que toda palavra de Deus é pura — provada como ouro no fogo, sem erro nem engano. Para quem confia nEle, a Bíblia se torna um escudo protetor contra tentações, dúvidas e falsos ensinos.",
                bibleRefs = listOf(
                    KeyVerseRef("pro", 30, 5, "Provérbios 30:5-6", "Toda palavra de Deus é pura; ele é escudo para os que nele confiam.", endVerse = 6)
                ),
                question = QuizQuestion(
                    question = "O que Deus é para aqueles que confiam na Sua Palavra pura (Provérbios 30:5)?",
                    options = listOf(
                        "Um observador distante",
                        "Um escudo seguro que protege quem nEle confia",
                        "Um enigma impossível"
                    ),
                    correctIndex = 1,
                    explanation = "'Toda palavra de Deus é pura; ele é escudo para os que nele confiam.'",
                    verseRef = "Provérbios 30:5-6"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 11,
                heading = "11. Qual é o impacto prático da Bíblia no dia a dia do jovem?",
                studyText = "Não basta saber fatos sobre a Bíblia; o melhor acontece quando deixamos essa luz iluminar nossas escolhas diárias! O Salmo 119 responde diretamente a pergunta de milhões de adolescentes: como guardar puro o seu caminho em meio às pressões? Guardando as palavras de Deus no coração! A Bíblia funciona como uma lanterna potente em trilha escura: mostra exatamente o próximo passo seguro.",
                bibleRefs = listOf(
                    KeyVerseRef("psa", 119, 105, "Salmos 119:105", "Lâmpada para os meus pés é a tua palavra e luz, para os meus caminhos."),
                    KeyVerseRef("psa", 119, 9, "Salmos 119:9, 11", "De que maneira poderá o jovem guardar puro o seu caminho? Observando-o segundo a tua palavra.", endVerse = 11)
                ),
                question = QuizQuestion(
                    question = "Segundo o Salmo 119:9, 11 e 105, como o jovem guarda puro o seu caminho?",
                    options = listOf(
                        "Observando e guardando a Palavra de Deus no coração, como luz para os passos",
                        "Seguindo a opinião da maioria",
                        "Apenas evitando sair de casa"
                    ),
                    correctIndex = 0,
                    explanation = "Guardar a Palavra no coração protege o jovem do pecado e ilumina cada decisão.",
                    verseRef = "Salmos 119:9, 11, 105"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 12,
                isReview = true,
                heading = "Revisão do Estudo 1 • Conhecendo a Bíblia Sagrada",
                studyText = "Parabéns por percorrer todas as 11 perguntas deste primeiro estudo! Recapitulando o que descobrimos: a Bíblia possui 66 livros (39 no Antigo Testamento e 27 no Novo Testamento), escritos por cerca de 40 autores ao longo de aproximadamente 1.600 anos sob inspiração do Espírito Santo. Seu tema central é Jesus Cristo, sua mensagem é pura e imutável, e quando a lemos diariamente em oração, ela transforma nossa mente e ilumina nossos passos!",
                bibleRefs = listOf(
                    KeyVerseRef("jos", 1, 8, "Josué 1:8", "Medita nele dia e noite, para que tenhas cuidado de fazer segundo tudo quanto nele está escrito.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Quantos livros formam a Bíblia Sagrada e qual é a divisão entre os Testamentos?",
                    options = listOf(
                        "50 livros (25 no AT e 25 no NT)",
                        "66 livros (39 no Antigo Testamento e 27 no Novo Testamento)",
                        "77 livros escritos em 10 anos"
                    ),
                    correctIndex = 1,
                    explanation = "A Bíblia tem 66 livros ao todo: 39 no Antigo Testamento e 27 no Novo Testamento, formando uma unidade inspirada por Deus.",
                    verseRef = "2 Timóteo 3:16"
                )
            )
        ),
        motivationalMessage = "Decisão de hoje: reserve alguns minutos diários para ler a Bíblia e ouvir a Voz de Deus falando direto ao seu coração!",
        youtubePlaylistIndex = 1,
        youtubeVideoTitle = "Estudo 1 • A Bíblia Sagrada"
    ),

    StudyLesson(
        number = 2,
        title = "A Beleza da Criação Divina",
        subtitle = "O artista do universo planejou o mundo e você com amor",
        category = StudyCategory.FOUNDATIONS,
        headerArt = StudyHeaderArt.HERO_STUDY,
        estimatedMinutes = 8,
        xpReward = 110,
        blogIntro = "Olhe pela janela ou observe o céu estrelado à noite: de onde surgiu tanta ordem, cor, música e vida? Para os adventistas do sétimo dia, o relato de Gênesis não é uma fábula simbólica — é a história real de um Deus amoroso que criou os céus e a Terra em seis dias literais e descansou no sétimo dia. Cada flor, golfinho, montanha e batida do seu coração carrega a assinatura do Criador!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Como o universo passou a existir?",
                studyText = "A primeira frase da Bíblia responde à maior pergunta da ciência e da filosofia: 'No princípio, criou Deus os céus e a terra.' Deus não precisou de fábricas nem de bilhões de anos de tentativa e erro. O Salmo 33 explica que Ele simplesmente falou, e tudo passou a existir pelo poder infinito da Sua Palavra!",
                bibleRefs = listOf(
                    KeyVerseRef("gen", 1, 1, "Gênesis 1:1-3", "No princípio, criou Deus os céus e a terra... Disse Deus: Haja luz; e houve luz.", endVerse = 3),
                    KeyVerseRef("psa", 33, 6, "Salmos 33:6, 9", "Pois ele falou, e tudo se fez; ele ordenou, e tudo passou a existir.", endVerse = 9)
                ),
                question = QuizQuestion(
                    question = "Por meio de que Deus trouxe o universo e a Terra à existência?",
                    options = listOf("Pelo poder da Sua Palavra criadora", "Por acidentes aleatórios", "Pedindo ajuda a outras galáxias"),
                    correctIndex = 0,
                    explanation = "Gênesis 1 e Salmos 33:9 mostram que Deus falou, e tudo se fez instantaneamente.",
                    verseRef = "Salmos 33:9"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. O que a natureza ao nosso redor revela sobre Deus?",
                studyText = "Quando admiramos um pôr do sol colorido ou as estrelas no espaço, estamos lendo o 'segundo livro' de Deus: a natureza! O salmista Davi escreveu que os céus proclamam a glória de Deus sem precisar de palavras. Tudo na criação revela organização, beleza e o cuidado de um Pai que ama surpreender Seus filhos.",
                bibleRefs = listOf(
                    KeyVerseRef("psa", 19, 1, "Salmos 19:1", "Os céus proclamam a glória de Deus, e o firmamento anuncia as obras das suas mãos.")
                ),
                question = QuizQuestion(
                    question = "O que os céus e o firmamento anunciam segundo Salmos 19:1?",
                    options = listOf("A glória e a sabedoria de Deus", "Apenas mudanças climáticas", "O acaso do universo"),
                    correctIndex = 0,
                    explanation = "A criação inteira testemunha a majestade e o amor do Criador.",
                    verseRef = "Salmos 19:1"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Qual é o seu valor especial diante do Criador?",
                studyText = "Nos cinco primeiros dias, Deus criou luz, atmosfera, mares, plantas, sol, lua, estrelas, peixes e aves usando Sua palavra. Mas no sexto dia, Ele fez algo íntimo e especial: modelou o ser humano com Suas próprias mãos, soprou fôlego de vida e nos criou à Sua própria imagem e semelhança! Isso significa que você tem valor infinito — não é um acidente, mas um filho planejado por Deus.",
                bibleRefs = listOf(
                    KeyVerseRef("gen", 1, 26, "Gênesis 1:26-27", "Criou Deus, pois, o homem à sua imagem, à imagem de Deus o criou.", endVerse = 27)
                ),
                question = QuizQuestion(
                    question = "À imagem de quem Deus criou o ser humano no sexto dia?",
                    options = listOf("Dos animais terrestres", "À imagem e semelhança do próprio Deus", "Das estrelas"),
                    correctIndex = 1,
                    explanation = "Fomos feitos à imagem de Deus, capazes de pensar, escolher e amar.",
                    verseRef = "Gênesis 1:27"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                heading = "4. Como era o mundo quando Deus terminou a criação?",
                studyText = "Ao contemplar toda a Terra recém-criada no final do sexto dia, Deus declarou que tudo era 'muito bom'! Não havia doenças, espinhos, medo, morte nem tristeza. Em seguida, no sétimo dia, Deus completou a semana descansando, abençoando e santificando o sábado como um memorial eterno da Sua criação perfeita.",
                bibleRefs = listOf(
                    KeyVerseRef("gen", 1, 31, "Gênesis 1:31", "Viu Deus tudo quanto fizera, e eis que era muito bom."),
                    KeyVerseRef("gen", 2, 2, "Gênesis 2:2-3", "E abençoou Deus o dia sétimo e o santificou.", endVerse = 3)
                ),
                question = QuizQuestion(
                    question = "O que Deus fez no sétimo dia após concluir a criação em seis dias?",
                    options = listOf("Continuou criando novos planetas", "Descansou, abençoou e santificou o sétimo dia (sábado)", "Esqueceu da Terra"),
                    correctIndex = 1,
                    explanation = "O sábado nasceu na Criação como monumento de amor e descanso com Deus.",
                    verseRef = "Gênesis 2:2-3"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 5,
                isReview = true,
                heading = "Revisão do Estudo 2 • Filhos do Criador",
                studyText = "Ser adventista significa olhar para a própria vida e para a natureza com gratidão e cuidado. Deus criou tudo em seis dias literais pela Sua palavra, formou você à Sua imagem e deixou o sábado no sétimo dia para que jamais esquecêssemos quem nos criou. Cuidar do planeta, dos animais e da nossa saúde é honrar o Artista do Universo!",
                bibleRefs = listOf(
                    KeyVerseRef("gen", 2, 1, "Gênesis 2:1-3", "Assim, pois, foram acabados os céus e a terra.", endVerse = 3)
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Qual afirmação resume o ensino bíblico sobre a Criação?",
                    options = listOf(
                        "A vida surgiu sem propósito",
                        "Deus criou tudo perfeitamente em seis dias pela Sua palavra e instituiu o sábado no sétimo",
                        "Apenas o ser humano foi planejado depois de milhões de anos"
                    ),
                    correctIndex = 1,
                    explanation = "A semana literal da Criação culmina no sábado santo e confirma nosso valor como filhos de Deus.",
                    verseRef = "Gênesis 1:31; 2:3"
                )
            )
        ),
        motivationalMessage = "O mesmo Deus que pintou as galáxias conhece o seu nome e desenhou seus dons com propósito!",
        youtubePlaylistIndex = 2,
        youtubeVideoTitle = "Estudo 2 • A Beleza da Criação Divina"
    ),

    StudyLesson(
        number = 3,
        title = "A Origem do Mal",
        subtitle = "Entendendo o grande conflito e por que existe sofrimento",
        category = StudyCategory.FOUNDATIONS,
        headerArt = StudyHeaderArt.BIBLE_NIGHT,
        estimatedMinutes = 8,
        xpReward = 115,
        blogIntro = "Se Deus é tão bom e criou um mundo perfeito, por que existem doenças, guerras, injustiças e lágrimas hoje em dia? Essa é uma das perguntas mais honestas de qualquer adolescente ou adulto! A visão adventista do 'Grande Conflito' abre a cortina invisível da história e mostra como o mal começou no Céu — não criado por Deus, mas pela escolha orgulhosa de uma criatura livre — e como essa batalha entre Cristo e Satanás chegará ao fim para sempre.",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Deus criou o mal ou deu liberdade às criaturas?",
                studyText = "Amor de verdade nunca pode ser forçado. Se Deus tivesse programado anjos e seres humanos como robôs incapazes de dizer 'não', nunca saberíamos o que é amar espontaneamente! Por isso, Deus concedeu livre-arbítrio a todas as Suas criaturas inteligentes, convidando cada uma a escolher segui-Lo por confiança.",
                bibleRefs = listOf(
                    KeyVerseRef("jos", 24, 15, "Josué 24:15", "Escolhei, hoje, a quem sirvais... Eu e a minha casa serviremos ao Senhor.")
                ),
                question = QuizQuestion(
                    question = "Por que Deus concedeu livre-arbítrio aos anjos e aos seres humanos?",
                    options = listOf("Porque amor verdadeiro só existe onde há liberdade de escolha", "Por descuido na criação", "Para forçar obediência"),
                    correctIndex = 0,
                    explanation = "Sem liberdade não há amor genuíno; Deus deseja filhos livres que confiem nEle.",
                    verseRef = "Josué 24:15"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. Onde e como começou a rebelião?",
                studyText = "Surpreendentemente, o pecado não começou na Terra — começou no próprio Céu! Lúcifer era um querubim brilhante e honrado perto do trono de Deus. Mas, pouco a pouco, ele alimentou o orgulho e a inveja no coração, desejando exaltar seu próprio trono acima de Deus. Assim, transformou-se em Satanás (o adversário) e enganou um terço dos anjos.",
                bibleRefs = listOf(
                    KeyVerseRef("isa", 14, 12, "Isaías 14:12-14", "Tu dizias no teu coração: Eu subirei ao céu... serei semelhante ao Altíssimo.", endVerse = 14)
                ),
                question = QuizQuestion(
                    question = "Que sentimento corrompeu o coração de Lúcifer segundo Isaías 14:12-14?",
                    options = listOf("Cansaço do trabalho", "Orgulho e desejo egoísta de ocupar o lugar de Deus", "Falta de sabedoria"),
                    correctIndex = 1,
                    explanation = "O orgulho levou Lúcifer a questionar o caráter amoroso de Deus e querer ser igual ao Altíssimo.",
                    verseRef = "Isaías 14:13-14"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. O conflito espiritual no Céu",
                studyText = "Quando a rebelião se espalhou pelo Céu, houve uma guerra espiritual liderada por Miguel (Cristo) e Seus anjos contra o dragão e seus anjos rebeldes. Satanás perdeu seu lugar no Céu e foi lançado para a Terra, onde passou a tentar desviar os habitantes recém-criados do amor de Deus.",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 12, 7, "Apocalipse 12:7", "Houve peleja no céu. Miguel e os seus anjos pelejaram contra o dragão.")
                ),
                question = QuizQuestion(
                    question = "Qual foi o resultado da batalha descrita em Apocalipse 12:7?",
                    options = listOf("Miguel e Seus anjos venceram o dragão e o expulsaram do Céu", "O dragão assumiu o trono celestial", "Não houve vencedores"),
                    correctIndex = 0,
                    explanation = "Cristo e os anjos leais derrotaram a rebelião no Céu.",
                    verseRef = "Apocalipse 12:7"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                heading = "4. Como o pecado entrou no Jardim do Éden?",
                studyText = "Deus colocou a árvore do conhecimento do bem e do mal no Éden como um teste simples de confiança. Usando uma serpente como disfarce, Satanás sussurrou a primeira grande mentira contra Deus: 'É certo que não morrereis!' Ao duvidar da bondade divina e comer do fruto, Eva e Adão abriram a porta para a dor e a morte entrarem em nosso planeta.",
                bibleRefs = listOf(
                    KeyVerseRef("gen", 3, 4, "Gênesis 3:4", "Então, a serpente disse à mulher: É certo que não morrereis."),
                    KeyVerseRef("gen", 3, 6, "Gênesis 3:6", "Vendo a mulher que a árvore era boa... tomou-lhe do fruto e comeu.")
                ),
                question = QuizQuestion(
                    question = "Qual foi a estratégia de Satanás para enganar Eva em Gênesis 3:4?",
                    options = listOf("Contrariar diretamente a Palavra de Deus dizendo 'É certo que não morrereis'", "Mostrar um milagre no céu", "Usar força física"),
                    correctIndex = 0,
                    explanation = "A dúvida na Palavra de Deus continua sendo a principal armadilha do inimigo até hoje.",
                    verseRef = "Gênesis 3:4"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 5,
                isReview = true,
                heading = "Revisão do Estudo 3 • O Grande Conflito e Sua Vitória",
                studyText = "Saber como o mal começou nos ajuda a nunca culpar Deus pelas tragédias do pecado! Deus não criou o sofrimento — Ele respeitou a liberdade e, ao mesmo tempo, preparou o resgate para derrotar definitivamente o mal sem destruir o amor. Hoje vivemos no meio desse Grande Conflito, mas ao lado de Jesus estamos sempre no time vencedor!",
                bibleRefs = listOf(
                    KeyVerseRef("gen", 3, 15, "Gênesis 3:15", "Este te ferirá a cabeça, e tu lhe ferirás o calcanhar.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Deus foi o autor do pecado e do sofrimento?",
                    options = listOf(
                        "Sim, porque planejou assim",
                        "Não — o mal surgiu do mau uso do livre-arbítrio por Lúcifer e depois pela humanidade",
                        "O pecado sempre existiu antes de Deus"
                    ),
                    correctIndex = 1,
                    explanation = "Deus é 100% bom e justo; o pecado é uma intrusão causada pela rebelião contra Seu amor.",
                    verseRef = "Gênesis 3:15; Apocalipse 12:7"
                )
            )
        ),
        motivationalMessage = "Mesmo quando o mundo parece difícil, confie: Cristo já garantiu a vitória final sobre todo mal!",
        youtubePlaylistIndex = 3,
        youtubeVideoTitle = "Estudo 3 • A Origem do Mal"
    ),

    StudyLesson(
        number = 4,
        title = "O Plano da Salvação",
        subtitle = "O resgate mais corajoso e amoroso de todo o universo",
        category = StudyCategory.FOUNDATIONS,
        headerArt = StudyHeaderArt.HERO_STUDY,
        estimatedMinutes = 8,
        xpReward = 115,
        blogIntro = "Imagine cair em um poço fundo de onde ninguém consegue sair por conta própria. É exatamente isso que o pecado fez conosco! Mas antes mesmo de o mundo ser criado, a Trindade (Pai, Filho e Espírito Santo) já tinha um plano de emergência caso a humanidade caísse. A cruz do Calvário é a maior prova do universo de que Deus ama você mais do que a Sua própria vida!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. A primeira promessa de esperança ainda no Éden",
                studyText = "Mal Adão e Eva haviam pecado, Deus foi procurá-los no jardim — não com raios de vingança, mas com uma promessa! Em Gênesis 3:15, Deus anunciou que um Descendente da mulher esmagaria a cabeça da serpente. Séculos depois, Jesus nasceu em Belém para cumprir essa promessa e vencer Satanás na cruz.",
                bibleRefs = listOf(
                    KeyVerseRef("gen", 3, 15, "Gênesis 3:15", "Porei inimizade entre ti e a mulher... Este te ferirá a cabeça, e tu lhe ferirás o calcanhar.")
                ),
                question = QuizQuestion(
                    question = "Quem é o Descendente prometido em Gênesis 3:15 que esmagaria a cabeça da serpente?",
                    options = listOf("Um rei guerreiro comum", "Jesus Cristo, o Salvador", "Um anjo desconhecido"),
                    correctIndex = 1,
                    explanation = "Gênesis 3:15 é o primeiro anúncio do evangelho apontando para a vitória de Jesus na cruz.",
                    verseRef = "Gênesis 3:15"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. Por que o pecado exigia um preço tão alto?",
                studyText = "A Bíblia afirma que todos pecaram e que o salário justo do pecado é a morte eterna — o desligamento total da fonte da vida. Nenhuma boa ação humana conseguiria pagar essa dívida. Por isso Jesus, o Filho perfeito de Deus, assumiu nossa natureza, viveu sem pecar e morreu em nosso lugar para nos oferecer o dom gratuito da vida eterna.",
                bibleRefs = listOf(
                    KeyVerseRef("rom", 6, 23, "Romanos 6:23", "Porque o salário do pecado é a morte, mas o dom gratuito de Deus é a vida eterna em Cristo Jesus, nosso Senhor.")
                ),
                question = QuizQuestion(
                    question = "O que Romanos 6:23 contrasta entre o pecado e a oferta de Cristo?",
                    options = listOf(
                        "O pecado traz tristeza leve, e a vida eterna custa dinheiro",
                        "O salário do pecado é a morte, mas a vida eterna é dom gratuito em Cristo",
                        "Ambos dependem de sorte"
                    ),
                    correctIndex = 1,
                    explanation = "Nós merecíamos a morte, mas Jesus paga nossa dívida e nos dá a vida eterna de graça!",
                    verseRef = "Romanos 6:23"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. O coração de todo o Evangelho em um versículo",
                studyText = "João 3:16 é chamado de 'a Bíblia em miniatura'. Ele mostra que a salvação não nasceu da ira do Pai acalmada pelo Filho — foi o próprio Pai quem tanto amou o mundo que deu o Seu Filho unigênito! A cruz revela que Deus Pai e Jesus estão unidos em um amor infinito para que todo o que crer nEle tenha vida eterna.",
                bibleRefs = listOf(
                    KeyVerseRef("jhn", 3, 16, "João 3:16", "Porque Deus amou ao mundo de tal maneira que deu o seu Filho unigênito, para que todo o que nele crê não pereça, mas tenha a vida eterna.")
                ),
                question = QuizQuestion(
                    question = "O que motivou Deus a enviar Seu Filho Jesus segundo João 3:16?",
                    options = listOf("O Seu imenso amor pelo mundo", "A perfeição moral dos humanos", "Uma obrigação jurídica"),
                    correctIndex = 0,
                    explanation = "'Porque Deus amou ao mundo de tal maneira...' — o amor é a fonte de todo o Plano da Salvação.",
                    verseRef = "João 3:16"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                heading = "4. A ressurreição que garante a nossa vitória",
                studyText = "A história não terminou na sexta-feira da cruz! No domingo de manhã, Jesus ressuscitou vitorioso sobre a morte e o túmulo. Como Paulo resume em 1 Coríntios 15, Ele morreu pelos nossos pecados e ressuscitou ao terceiro dia segundo as Escrituras — garantindo que todo aquele que pertence a Cristo também vencerá a morte!",
                bibleRefs = listOf(
                    KeyVerseRef("1co", 15, 3, "1 Coríntios 15:3-4", "Cristo morreu pelos nossos pecados... foi sepultado e ressuscitou ao terceiro dia, segundo as Escrituras.", endVerse = 4)
                ),
                question = QuizQuestion(
                    question = "Por que a ressurreição de Jesus ao terceiro dia é essencial para o Plano da Salvação?",
                    options = listOf(
                        "Prova que Ele venceu a morte e garante vida eterna a quem nEle crê",
                        "Foi apenas um símbolo poético",
                        "Serve só para lembrar o passado"
                    ),
                    correctIndex = 0,
                    explanation = "Um Salvador vivo intercede por nós hoje e voltará para ressuscitar Seus filhos!",
                    verseRef = "1 Coríntios 15:3-4"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 5,
                isReview = true,
                heading = "Revisão do Estudo 4 • Um Presente Pago na Cruz",
                studyText = "Nunca tente comprar o amor de Deus — você já é amado antes mesmo de nascer! Jesus pagou o preço completo do pecado com Seu sangue e oferece o perdão e a vida eterna gratuitamente a você hoje. Aceitar esse resgate é o passo mais feliz da vida!",
                bibleRefs = listOf(
                    KeyVerseRef("jhn", 3, 16, "João 3:16", "Todo o que nele crê não pereça, mas tenha a vida eterna.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Como podemos receber a salvação conquistada por Jesus?",
                    options = listOf(
                        "Tentando acumular méritos sozinhos",
                        "Crendo em Jesus e aceitando pela fé esse presente gratuito de amor",
                        "Esperando ficar mais velho"
                    ),
                    correctIndex = 1,
                    explanation = "A salvação é um dom gratuito recebido pela fé em Cristo Jesus.",
                    verseRef = "João 3:16; Romanos 6:23"
                )
            )
        ),
        motivationalMessage = "Você vale o sangue do Filho de Deus — nunca permita que ninguém diminua o seu valor!",
        youtubePlaylistIndex = 4,
        youtubeVideoTitle = "Estudo 4 • O Plano da Salvação"
    ),

    StudyLesson(
        number = 5,
        title = "Fé, Arrependimento e Confissão",
        subtitle = "Os três passos para recomeçar com o coração leve",
        category = StudyCategory.CHRISTIAN_LIFE,
        headerArt = StudyHeaderArt.BIBLE_NIGHT,
        estimatedMinutes = 8,
        xpReward = 110,
        blogIntro = "Todo mundo erra em algum momento — às vezes respondemos mal em casa, mentimos por medo ou magoamos um amigo. Quando isso acontece, o inimigo tenta nos convencer de que Deus desistiu de nós. Mas a Bíblia ensina um caminho lindo para limpar o coração e recomeçar imediatamente: Fé, Arrependimento e Confissão diretamente a Jesus!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. O que é ter fé verdadeira em Deus?",
                studyText = "Muita gente acha que fé é apenas acreditar em algo sem provas. Na Bíblia, fé é confiança ativa em quem já provou ser fiel! Hebreus 11:1 diz que a fé é a certeza das promessas que esperamos e a convicção da realidade invisível de Deus. Ter fé é segurar a mão de Jesus mesmo quando não vemos toda a estrada.",
                bibleRefs = listOf(
                    KeyVerseRef("heb", 11, 1, "Hebreus 11:1", "Ora, a fé é a certeza de coisas que se esperam, a convicção de fatos que se não veem.")
                ),
                question = QuizQuestion(
                    question = "Como Hebreus 11:1 define a fé cristã?",
                    options = listOf(
                        "Apenas desejar boa sorte",
                        "Certeza de coisas que se esperam e convicção de fatos que se não veem",
                        "Repetir frases decoradas"
                    ),
                    correctIndex = 1,
                    explanation = "A fé bíblica é confiança firme no caráter e nas promessas de Deus.",
                    verseRef = "Hebreus 11:1"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. Qual é a diferença entre remorso e arrependimento?",
                studyText = "Sentir remorso é apenas ficar chateado porque fomos descobertos ou levamos bronca. Arrependimento bíblico é muito mais profundo: é uma mudança de mente e de direção operada pelo Espírito Santo! Em Atos 3:19, Pedro convida ao arrependimento e conversão para que os pecados sejam apagados.",
                bibleRefs = listOf(
                    KeyVerseRef("act", 3, 19, "Atos 3:19", "Arrependei-vos, pois, e convertei-vos para serem cancelados os vossos pecados.")
                ),
                question = QuizQuestion(
                    question = "O que significa arrepender-se e converter-se segundo Atos 3:19?",
                    options = listOf(
                        "Esconder o erro para ninguém saber",
                        "Mudar de atitude e voltar-se para Deus para ter os pecados cancelados",
                        "Ficar triste para sempre"
                    ),
                    correctIndex = 1,
                    explanation = "Arrependimento verdadeiro é tristeza pelo pecado acompanhada do desejo de mudar com a força de Cristo.",
                    verseRef = "Atos 3:19"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. A quem devemos confessar nossos pecados?",
                studyText = "Você não precisa esperar intermediários humanos para falar com o Pai! Como adventistas, cremos no sacerdócio direto de Jesus Cristo. Quando abrimos o coração em oração sincera e confessamos nossos pecados a Deus, 1 João 1:9 garante que Ele é fiel e justo para nos perdoar na mesma hora e purificar de toda injustiça.",
                bibleRefs = listOf(
                    KeyVerseRef("1jn", 1, 9, "1 João 1:9", "Se confessarmos os nossos pecados, ele é fiel e justo para nos perdoar os pecados e nos purificar de toda injustiça.")
                ),
                question = QuizQuestion(
                    question = "O que Deus promete em 1 João 1:9 quando confessamos nossos pecados a Ele?",
                    options = listOf(
                        "Apenas observar por alguns meses",
                        "Perdoar nossos pecados e purificar-nos de toda injustiça",
                        "Contar para toda a escola"
                    ),
                    correctIndex = 1,
                    explanation = "O perdão divino é imediato e completo porque Jesus já pagou por nossos pecados na cruz.",
                    verseRef = "1 João 1:9"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 5 • Coração Limpo e em Paz",
                studyText = "Fé é confiar em Jesus; arrependimento é querer mudar de rumo; confissão é abrir o coração diretamente a Deus. Se você errou hoje, não fuja de Deus — corra para Ele! Quanto mais rápido falamos com Jesus, mais leve e forte fica a nossa caminhada espiritual.",
                bibleRefs = listOf(
                    KeyVerseRef("1jn", 1, 9, "1 João 1:9", "Ele é fiel e justo para nos perdoar os pecados.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Qual é a sequência saudável quando percebemos que erramos?",
                    options = listOf(
                        "Fugir da igreja por vergonha",
                        "Crer no amor de Jesus, arrepender-se de coração e confessar diretamente a Deus",
                        "Fingir que nada aconteceu"
                    ),
                    correctIndex = 1,
                    explanation = "Jesus nos recebe de braços abertos sempre que O procuramos com sinceridade.",
                    verseRef = "1 João 1:9; Atos 3:19"
                )
            )
        ),
        motivationalMessage = "Com Jesus, cada oração sincera de confissão abre uma página nova e brilhante na sua vida!",
        youtubePlaylistIndex = 5,
        youtubeVideoTitle = "Estudo 5 • Fé, Arrependimento e Confissão"
    ),

    StudyLesson(
        number = 6,
        title = "Sinais da Volta de Cristo",
        subtitle = "O relógio profético anuncia que Jesus está chegando",
        category = StudyCategory.PROPHECY,
        headerArt = StudyHeaderArt.PROPHECY,
        estimatedMinutes = 8,
        xpReward = 120,
        blogIntro = "Quando viajamos de carro para visitar quem amamos, as placas na estrada mostram quantos quilômetros faltam até a chegada. Em Mateus 24, os discípulos perguntaram a Jesus quais seriam os sinais da Sua volta e do fim do mundo. Como um amigo cuidadoso, Jesus deixou placas claras na natureza, na sociedade e na missão da igreja — não para nos assustar, mas para despertar nossa esperança!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Sinais no mundo e na natureza",
                studyText = "Em Mateus 24:6-7, Jesus avisou que antes da Sua volta ouviríamos falar de guerras, rumores de guerras, crises de fome e terremotos em vários lugares. Ele também disse: 'Vede, não vos assusteis!' Essas crises mostram que este velho mundo está chegando ao fim e precisa urgentemente do retorno do seu Criador.",
                bibleRefs = listOf(
                    KeyVerseRef("mat", 24, 6, "Mateus 24:6-7", "Ouvireis falar de guerras... haverá fomes e terremotos em vários lugares.", endVerse = 7)
                ),
                question = QuizQuestion(
                    question = "Qual orientação Jesus deu em Mateus 24:6 ao falar sobre guerras e crises?",
                    options = listOf("Entrar em pânico", "'Vede, não vos assusteis'", "Desistir da fé"),
                    correctIndex = 1,
                    explanation = "Jesus pediu calma e confiança porque Ele está no controle da história.",
                    verseRef = "Mateus 24:6"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. Sinais no comportamento da sociedade",
                studyText = "Na segunda carta a Timóteo, Paulo descreveu como estariam as atitudes humanas nos últimos dias: egoísmo, amor ao dinheiro, desobediência aos pais, ingratidão e frieza espiritual. Tudo isso soa muito parecido com o que vemos nas notícias hoje! Em meio a isso, Deus chama jovens para serem diferentes e cheios de amor.",
                bibleRefs = listOf(
                    KeyVerseRef("2tm", 3, 1, "2 Timóteo 3:1", "Sabe, porém, isto: nos últimos dias, sobrevirão tempos difíceis.")
                ),
                question = QuizQuestion(
                    question = "O que Paulo destacou em 2 Timóteo 3 sobre a sociedade dos últimos dias?",
                    options = listOf("Tempos difíceis marcados pelo egoísmo e esfriamento moral", "Paz mundial absoluta sem problemas", "Fim das comunicações"),
                    correctIndex = 0,
                    explanation = "O crescimento do egoísmo confirma que estamos vivendo perto da volta de Jesus.",
                    verseRef = "2 Timóteo 3:1"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. O maior sinal missionário de todos",
                studyText = "Entre todos os sinais dados por Jesus, há um em que nós mesmos podemos participar hoje! Em Mateus 24:14, Ele declarou que o evangelho do reino seria pregado em todo o mundo para testemunho a todas as nações — e então viria o fim. Pela internet, rádio, TV, livros e pela vida de jovens missionários, a Voz de Deus está alcançando cada canto da Terra!",
                bibleRefs = listOf(
                    KeyVerseRef("mat", 24, 14, "Mateus 24:14", "E será pregado este evangelho do reino por todo o mundo, para testemunho a todas as nações. Então, virá o fim.")
                ),
                question = QuizQuestion(
                    question = "Qual sinal em Mateus 24:14 precede diretamente o fim?",
                    options = listOf("A pregação do evangelho do reino a todas as nações", "A construção de arranha-céus", "A descoberta de novos oceanos"),
                    correctIndex = 0,
                    explanation = "Deus deseja que todas as pessoas tenham oportunidade de conhecer Sua graça salvadora.",
                    verseRef = "Mateus 24:14"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 6 • Olhos Para o Alto!",
                studyText = "Em Lucas 21:28, Jesus resume qual deve ser a nossa reação ao vermos todos esses sinais acontecendo ao mesmo tempo: 'Exultai e erguei a vossa cabeça; porque a vossa redenção se aproxima!' Os sinais da volta de Jesus são o despertador de Deus avisando que a manhã eterna está quase raiando.",
                bibleRefs = listOf(
                    KeyVerseRef("luk", 21, 28, "Lucas 21:28", "Exultai e erguei a vossa cabeça; porque a vossa redenção se aproxima.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Como o cristão reage diante dos sinais do tempo do fim (Lucas 21:28)?",
                    options = listOf(
                        "Com alegria e esperança, sabendo que a redenção se aproxima",
                        "Com medo constante",
                        "Ignorando as profecias"
                    ),
                    correctIndex = 0,
                    explanation = "Quem ama a Jesus vê os sinais como prova de que falta pouco para vê-Lo face a face.",
                    verseRef = "Lucas 21:28"
                )
            )
        ),
        motivationalMessage = "Quando o mundo parecer agitado, levante os olhos: Jesus está mais perto do que nunca!",
        youtubePlaylistIndex = 6,
        youtubeVideoTitle = "Estudo 6 • Sinais da Volta de Cristo"
    ),

    StudyLesson(
        number = 7,
        title = "A Volta de Cristo",
        subtitle = "O reencontro literal, glorioso e visível do universo",
        category = StudyCategory.PROPHECY,
        headerArt = StudyHeaderArt.PROPHECY,
        estimatedMinutes = 8,
        xpReward = 125,
        blogIntro = "Existem muitas teorias confusas por aí — filmes dizendo que Jesus voltará em segredo ou que pessoas simplesmente desaparecerão sem ninguém ver nada. Mas o que a Bíblia realmente ensina? Como adventistas do sétimo dia (nosso próprio nome 'Adventista' vem da palavra 'advento', que significa vinda!), cremos na promessa literal de Jesus: Sua volta será um evento real, visível, audível e glorioso para toda a Terra!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. A promessa pessoal do próprio Jesus",
                studyText = "Na noite antes de morrer na cruz, Jesus viu o coração triste dos discípulos e fez uma das promessas mais doces da Bíblia em João 14:1-3: Ele foi preparar moradas na casa do Pai e garantiu que voltará pessoalmente para nos buscar, para que onde Ele estiver estejamos nós também!",
                bibleRefs = listOf(
                    KeyVerseRef("jhn", 14, 1, "João 14:1-3", "Voltarei e vos receberei para mim mesmo, para que, onde eu estou, estejais vós também.", endVerse = 3)
                ),
                question = QuizQuestion(
                    question = "O que Jesus prometeu em João 14:2-3 que está fazendo e fará por nós?",
                    options = listOf(
                        "Mandar cartas de longe",
                        "Preparar lugar na casa do Pai e voltar para nos buscar",
                        "Deixar a Terra como está para sempre"
                    ),
                    correctIndex = 1,
                    explanation = "Jesus garantiu pessoalmente: 'Voltarei e vos receberei para mim mesmo!'",
                    verseRef = "João 14:1-3"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. A volta de Jesus será secreta ou visível a todos?",
                studyText = "Não haverá nenhum rapto secreto ou invisível! Apocalipse 1:7 declara com todas as letras: 'Eis que vem com as nuvens, e todo olho o verá.' E em Mateus 24:27, Jesus comparou Sua vinda a um relâmpago que cruza o céu do oriente até o ocidente — impossível de falsificar ou esconder.",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 1, 7, "Apocalipse 1:7", "Eis que vem com as nuvens, e todo olho o verá."),
                    KeyVerseRef("mat", 24, 27, "Mateus 24:27", "Assim como o relâmpago sai do oriente e se mostra até no ocidente, assim há de ser a vinda do Filho do Homem.")
                ),
                question = QuizQuestion(
                    question = "Quantas pessoas verão a volta de Jesus segundo Apocalipse 1:7?",
                    options = listOf("Apenas um pequeno grupo em segredo", "Todo olho O verá vindo nas nuvens", "Somente quem assistir à TV"),
                    correctIndex = 1,
                    explanation = "Será um espetáculo cósmico visível e inconfundível para toda a humanidade.",
                    verseRef = "Apocalipse 1:7"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. O grande encontro nos ares com som de trombeta",
                studyText = "Além de visível, será audível e transformadora! Em 1 Tessalonicenses 4:16-17, Paulo descreve a voz do arcanjo e a trombeta de Deus ecoando pelo planeta. Primeiro, os salvos que dormiam na morte ressuscitarão com corpos gloriosos; depois, os salvos vivos serão transformados e todos subirão juntos nas nuvens para encontrar o Senhor nos ares!",
                bibleRefs = listOf(
                    KeyVerseRef("1th", 4, 16, "1 Tessalonicenses 4:16-17", "O Senhor mesmo... descerá dos céus, e os mortos em Cristo ressuscitarão primeiro.", endVerse = 17)
                ),
                question = QuizQuestion(
                    question = "Quem ressuscitará primeiro ao soar da trombeta na volta de Jesus (1 Tessalonicenses 4:16)?",
                    options = listOf("Os mortos em Cristo", "Ninguém ressuscitará", "Os ímpios"),
                    correctIndex = 0,
                    explanation = "Os amigos de Jesus que já morreram despertarão primeiro, juntando-se aos salvos vivos nos ares.",
                    verseRef = "1 Tessalonicenses 4:16-17"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                heading = "4. Alguém sabe a data marcada da volta de Jesus?",
                studyText = "De tempos em tempos surgem boatos marcando dia ou ano para o fim do mundo. Fuja disso! Jesus foi claríssimo em Mateus 24:36: 'Mas a respeito daquele dia e hora ninguém sabe, nem os anjos dos céus, nem o Filho, senão o Pai.' Nossa missão não é marcar datas, mas viver todos os dias em amizade com Cristo.",
                bibleRefs = listOf(
                    KeyVerseRef("mat", 24, 36, "Mateus 24:36", "A respeito daquele dia e hora ninguém sabe... senão o Pai.")
                ),
                question = QuizQuestion(
                    question = "O que devemos responder se alguém marcar uma data exata para a volta de Jesus?",
                    options = listOf(
                        "Acreditar imediatamente",
                        "Rejeitar, pois Jesus afirmou em Mateus 24:36 que ninguém sabe o dia e a hora",
                        "Fazer apostas"
                    ),
                    correctIndex = 1,
                    explanation = "Nenhuma pessoa na Terra conhece a data; devemos estar prontos a cada dia.",
                    verseRef = "Mateus 24:36"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 5,
                isReview = true,
                heading = "Revisão do Estudo 7 • Maranata: Ora, Vem Senhor Jesus!",
                studyText = "A volta de Cristo é a bendita esperança da Igreja Adventista! Ela será literal, pessoal, visível a todo olho, audível ao som da trombeta e marcará o reencontro emocionante com Jesus e com quem amamos. Enquanto esperamos, caminhamos com Ele todos os dias!",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 22, 20, "Apocalipse 22:20", "Certamente, venho sem demora. Amém! Vem, Senhor Jesus!")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Quais palavras descrevem corretamente a Segunda Vinda de Cristo?",
                    options = listOf(
                        "Literal, visível a todos, gloriosa e acompanhada da ressurreição dos justos",
                        "Secreta, invisível e silenciosa",
                        "Apenas simbólica dentro do coração"
                    ),
                    correctIndex = 0,
                    explanation = "A Bíblia ensina uma volta real, visível e gloriosa do próprio Senhor Jesus.",
                    verseRef = "Apocalipse 1:7; 1 Tessalonicenses 4:16"
                )
            )
        ),
        motivationalMessage = "Jesus disse 'Certamente venho sem demora' — e Ele nunca quebra uma promessa!",
        youtubePlaylistIndex = 7,
        youtubeVideoTitle = "Estudo 7 • A Volta de Cristo"
    ),

    StudyLesson(
        number = 8,
        title = "O Milênio",
        subtitle = "Mil anos de paz no Céu e a justiça transparente de Deus",
        category = StudyCategory.PROPHECY,
        headerArt = StudyHeaderArt.PROPHECY,
        estimatedMinutes = 8,
        xpReward = 115,
        blogIntro = "Você já ouviu falar nos 'mil anos' de Apocalipse 20? Muita gente imagina um reino milenar aqui na Terra cheia de problemas, mas quando lemos a Bíblia passo a passo descobrimos uma cena muito mais lógica e emocionante! Durante o milênio, os salvos estarão no Céu com Cristo enquanto a Terra permanece desolada — e Deus responde a todas as nossas dúvidas sobre justiça e amor!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Onde estarão os salvos durante os mil anos?",
                studyText = "Na volta de Jesus, todos os salvos sobem com Ele para as moradas celestiais (João 14:2-3). Em Apocalipse 20:4, João vê os salvos sentados em tronos no Céu, vivendo e reinando com Cristo durante mil anos — participando de uma revisão transparente dos registros celestiais!",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 20, 4, "Apocalipse 20:4", "Viveram e reinaram com Cristo durante mil anos.")
                ),
                question = QuizQuestion(
                    question = "Onde os salvos passarão os mil anos descritos em Apocalipse 20:4?",
                    options = listOf("Na Terra destruída", "No Céu, reinando com Cristo", "Em uma ilha isolada"),
                    correctIndex = 1,
                    explanation = "Os redimidos vão para o Céu com Jesus na Segunda Vinda e lá passam o milênio.",
                    verseRef = "Apocalipse 20:4"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. O que acontece com a Terra e com Satanás no milênio?",
                studyText = "Com os salvos no Céu e os ímpios mortos pelo resplendor da vinda de Cristo, não sobra nenhum ser humano vivo na Terra durante os mil anos. Apocalipse 20:1-3 diz que Satanás é 'preso' no abismo por mil anos — uma prisão de circunstâncias, pois sem ninguém vivo para enganar ou tentar, o inimigo fica totalmente sem trabalho no planeta desolado.",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 20, 1, "Apocalipse 20:1", "Vi descer do céu um anjo trazendo na mão a chave do abismo e uma grande corrente.")
                ),
                question = QuizQuestion(
                    question = "Em que sentido Satanás fica 'preso' durante o milênio?",
                    options = listOf(
                        "Preso às circunstâncias na Terra vazia, sem ninguém para tentar",
                        "Transformado em anjo bom",
                        "Preso com correntes de aço reais"
                    ),
                    correctIndex = 0,
                    explanation = "Sem habitantes vivos na Terra, Satanás fica impedido de enganar as nações durante os mil anos.",
                    verseRef = "Apocalipse 20:1-4"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Por que os santos examinam os registros no Céu?",
                studyText = "Você já se perguntou por que certa pessoa não está no Céu, ou por que Deus permitiu algo difícil na história? Em 1 Coríntios 6:2, Paulo revela que os santos participarão do julgamento! Durante o milênio, Deus abrirá os livros diante de nós para que cada dúvida seja esclarecida e todo o universo reconheça que Deus sempre agiu com justiça perfeita e amor.",
                bibleRefs = listOf(
                    KeyVerseRef("1co", 6, 2, "1 Coríntios 6:2", "Ou não sabeis que os santos hão de julgar o mundo?")
                ),
                question = QuizQuestion(
                    question = "Qual é o propósito de os salvos participarem do exame dos livros durante o milênio?",
                    options = listOf(
                        "Satisfazer curiosidade sem importância",
                        "Tirar todas as dúvidas e confirmar que as decisões de Deus foram sempre justas e amorosas",
                        "Mudar as sentenças por conta própria"
                    ),
                    correctIndex = 1,
                    explanation = "Deus é 100% transparente e quer que todos compreendam Sua justiça e misericórdia.",
                    verseRef = "1 Coríntios 6:2"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 8 • O Fim Definitivo do Mal",
                studyText = "Ao final dos mil anos, a Nova Jerusalém desce do Céu para a Terra, os ímpios ressuscitam para a sentença final, Satanás é solto brevemente de sua inatividade, e então o fogo purificador de Deus elimina para sempre o pecado, a morte e o mal! Depois disso, Deus recria a Terra perfeitamente para ser nosso lar eterno.",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 20, 7, "Apocalipse 20:7", "Quando, porém, se completarem os mil anos, Satanás será solto da sua prisão.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: O que marca o início e o fim dos mil anos?",
                    options = listOf(
                        "Iniciam com a volta de Jesus (salvos vão ao Céu) e terminam com a descida da Cidade Santa e destruição final do mal",
                        "São mil anos de paz na Terra atual antes de Jesus voltar",
                        "Começam depois que a Nova Terra já foi criada"
                    ),
                    correctIndex = 0,
                    explanation = "A cronologia bíblica de Apocalipse 20 coloca o milênio entre a Segunda Vinda e a criação da Nova Terra.",
                    verseRef = "Apocalipse 20:4-7"
                )
            )
        ),
        motivationalMessage = "Deus ama tanto você que no Céu Ele terá prazer em responder cada pergunta do seu coração!",
        youtubePlaylistIndex = 8,
        youtubeVideoTitle = "Estudo 8 • O Milênio"
    ),

    StudyLesson(
        number = 9,
        title = "A Verdade sobre a Morte",
        subtitle = "Um sono tranquilo e seguro até o chamado de Jesus",
        category = StudyCategory.FOUNDATIONS,
        headerArt = StudyHeaderArt.BIBLE_NIGHT,
        estimatedMinutes = 8,
        xpReward = 115,
        blogIntro = "Filmes, jogos e histórias populares frequentemente retratam pessoas mortas vagando como fantasmas, sofrendo imediatamente ou conversando com os vivos. Mas o que a Bíblia ensina de verdade? Os adventistas mantêm o ensino claro e consolador das Escrituras: a morte é um sono inconsciente e pacífico — ninguém sofre nem assombra ninguém, e a grande esperança está na ressurreição quando Jesus voltar!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. O que acontece com nossos pensamentos na morte?",
                studyText = "Quando uma lâmpada é desligada da tomada, a luz não vai voando para outro lugar — ela simplesmente se apaga até ser religada! Da mesma forma, quando o corpo e o fôlego de vida se separam na morte, Salmos 146:4 e Eclesiastes 9:5 explicam claramente que os pensamentos perecem e os mortos não sabem coisa nenhuma.",
                bibleRefs = listOf(
                    KeyVerseRef("ecc", 9, 5, "Eclesiastes 9:5-6", "Porque os vivos sabem que hão de morrer, mas os mortos não sabem coisa nenhuma.", endVerse = 6),
                    KeyVerseRef("psa", 146, 4, "Salmos 146:4", "Sai-lhes o espírito, e eles tornam ao pó; nesse mesmo dia, perecem todos os seus desígnios.")
                ),
                question = QuizQuestion(
                    question = "O que Eclesiastes 9:5 afirma sobre o estado de consciência de quem morreu?",
                    options = listOf(
                        "Eles observam tudo o que fazemos",
                        "Os mortos não sabem coisa nenhuma (estão inconscientes)",
                        "Eles enviam mensagens em sonhos"
                    ),
                    correctIndex = 1,
                    explanation = "A Bíblia afirma diretamente que na morte não há atividade mental, dor nem participação no que ocorre na Terra.",
                    verseRef = "Eclesiastes 9:5"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. Como o próprio Jesus chamou a morte?",
                studyText = "Quando Seu grande amigo Lázaro morreu em Betânia, Jesus usou uma comparação cheia de ternura em João 11:11: 'Nosso amigo Lázaro adormeceu, mas vou para despertá-lo.' Para quem dorme profundamente, oito horas passam em um piscar de olhos. Na morte, o tempo não dói nem demora — o próximo instante consciente do salvo será ver o rosto sorridente de Jesus na ressurreição!",
                bibleRefs = listOf(
                    KeyVerseRef("jhn", 11, 11, "João 11:11", "Nosso amigo Lázaro adormeceu, mas vou para despertá-lo."),
                    KeyVerseRef("jhn", 11, 25, "João 11:25", "Eu sou a ressurreição e a vida. Quem crê em mim, ainda que morra, viverá.")
                ),
                question = QuizQuestion(
                    question = "Com o que Jesus comparou a morte de Lázaro em João 11:11?",
                    options = listOf("Uma longa viagem sem volta", "Um sono do qual Ele iria despertá-lo", "Um castigo imediato"),
                    correctIndex = 1,
                    explanation = "Em mais de 50 passagens bíblicas, a morte é chamada de sono porque há um despertar garantido!",
                    verseRef = "João 11:11"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Quando receberemos a imortalidade?",
                studyText = "Só Deus possui imortalidade naturalmente (1 Timóteo 6:16). Nós somos seres mortais, mas a Bíblia revela exatamente quando os salvos se tornarão imortais! Em 1 Coríntios 15:52-53, Paulo declara que isso acontecerá 'ao ressoar da última trombeta', na Segunda Vinda de Cristo, quando este corpo mortal se revestirá da imortalidade.",
                bibleRefs = listOf(
                    KeyVerseRef("1co", 15, 52, "1 Coríntios 15:52-53", "Ao ressoar da última trombeta... é necessário que este corpo mortal se revista da imortalidade.", endVerse = 53)
                ),
                question = QuizQuestion(
                    question = "Quando o crente recebe o dom da imortalidade segundo 1 Coríntios 15:52-53?",
                    options = listOf(
                        "Na última trombeta, quando Jesus voltar",
                        "No dia do seu nascimento",
                        "Imediatamente ao fechar os olhos na morte"
                    ),
                    correctIndex = 0,
                    explanation = "A imortalidade é dada na volta de Cristo, não possuímos uma alma naturalmente imortal.",
                    verseRef = "1 Coríntios 15:52-53"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 9 • Paz Sem Medo de Fantasmas",
                studyText = "Saber a verdade bíblica sobre a morte nos traz duplo alívio: primeiro, temos paz sabendo que entes queridos que morreram não estão sofrendo nem sentindo saudade; segundo, ficamos protegidos contra superstições e enganos espirituais, pois sabemos que espíritos que imitam os mortos não vêm de Deus. Nossa esperança firme está em Jesus, a Ressurreição e a Vida!",
                bibleRefs = listOf(
                    KeyVerseRef("jhn", 11, 25, "João 11:25", "Eu sou a ressurreição e a vida.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Por que a doutrina bíblica da morte como um sono protege o cristão?",
                    options = listOf(
                        "Ensina que ninguém vaga como espírito e aponta toda esperança para a ressurreição na volta de Jesus",
                        "Incentiva conversar com espíritos",
                        "Diz que a morte é o fim definitivo sem esperança"
                    ),
                    correctIndex = 0,
                    explanation = "Quem conhece a Palavra descansa na promessa da ressurreição em Cristo e rejeita enganos.",
                    verseRef = "Eclesiastes 9:5; João 11:25"
                )
            )
        ),
        motivationalMessage = "Você nunca precisa ter medo do escuro: Jesus segura as chaves da vida e promete despertar os Seus!",
        youtubePlaylistIndex = 9,
        youtubeVideoTitle = "Estudo 9 • A Verdade sobre a Morte"
    ),

    StudyLesson(
        number = 10,
        title = "A Nova Terra",
        subtitle = "Nosso lar eterno sem lágrimas, doenças ou despedidas",
        category = StudyCategory.PROPHECY,
        headerArt = StudyHeaderArt.HERO_STUDY,
        estimatedMinutes = 8,
        xpReward = 115,
        blogIntro = "Muita gente pensa que passar a eternidade com Deus deve ser entediante — ficar sentado numa nuvem branca tocando harpa para sempre! Que alívio descobrir na Bíblia que isso é totalmente falso! Deus planejou recriar este nosso planeta em perfeição absoluta: uma Nova Terra vibrante, cheia de natureza exuberante, casas reais, amizades profundas, ciência, música e comunhão direta com Jesus!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Um novo céu e uma nova terra reais",
                studyText = "No penúltimo capítulo da Bíblia, João contempla o fim definitivo do velho mundo marcado pelo pecado e vê surgir 'novo céu e nova terra' (Apocalipse 21:1). E a promessa mais emocionante vem logo no verso 4: Deus mesmo enxugará dos nossos olhos toda lágrima, e nunca mais haverá morte, luto, choro nem dor!",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 21, 1, "Apocalipse 21:1", "Vi novo céu e nova terra, pois o primeiro céu e a primeira terra passaram."),
                    KeyVerseRef("rev", 21, 4, "Apocalipse 21:4", "E lhes enxugará dos olhos toda lágrima, e a morte já não existirá.")
                ),
                question = QuizQuestion(
                    question = "O que deixará de existir para sempre na Nova Terra segundo Apocalipse 21:4?",
                    options = listOf(
                        "Árvores, rios e casas",
                        "Morte, luto, pranto e dor",
                        "Alegria e música"
                    ),
                    correctIndex = 1,
                    explanation = "Toda marca de sofrimento desaparecerá eternamente na presença de Deus.",
                    verseRef = "Apocalipse 21:4"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. O que faremos no lar eterno?",
                studyText = "Isaías 65 dá um gostinho maravilhoso da rotina alegre dos salvos na Nova Terra: construiremos nossas próprias casas, plantaremos jardins e pomares, trabalharemos com criatividade sem cansaço e conviveremos em total paz com todos os animais — até o lobo e o cordeiro pastarão juntos sem nenhum perigo!",
                bibleRefs = listOf(
                    KeyVerseRef("isa", 65, 21, "Isaías 65:21", "Eles edificarão casas e nelas habitarão; plantarão vinhas e comerão o seu fruto."),
                    KeyVerseRef("isa", 65, 25, "Isaías 65:25", "O lobo e o cordeiro pastarão juntos... não se fará mal nem dano algum em todo o meu santo monte.")
                ),
                question = QuizQuestion(
                    question = "Segundo Isaías 65:21-25, como será a vida diária na Nova Terra?",
                    options = listOf(
                        "Inativa e silenciosa em nuvens",
                        "Cheia de atividades reais: construir casas, cuidar da natureza e conviver em paz com os animais",
                        "Cheia de competição"
                    ),
                    correctIndex = 1,
                    explanation = "Teremos corpos reais e uma vida rica, criativa e feliz para sempre.",
                    verseRef = "Isaías 65:21-25"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. O Rio da Vida e a Árvore da Vida",
                studyText = "No centro da Nova Jerusalém desce o Rio da Água da Vida, brilhante como cristal, saindo do trono de Deus e do Cordeiro. Em suas margens floresce a Árvore da Vida, produzindo doze frutos diferentes a cada mês! E de um sábado ao outro (Isaías 66:23), todo o universo se reunirá com alegria para adorar o Criador.",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 22, 1, "Apocalipse 22:1-2", "Mostrou-me o rio da água da vida... e de um e de outro lado do rio, está a árvore da vida.", endVerse = 2),
                    KeyVerseRef("isa", 66, 23, "Isaías 66:23", "De um sábado a outro, virá toda a carne a adorar perante mim, diz o Senhor.")
                ),
                question = QuizQuestion(
                    question = "Qual árvore especial volta a estar acessível aos salvos em Apocalipse 22:2?",
                    options = listOf("A árvore do conhecimento do mal", "A árvore da vida", "Um pinheiro comum"),
                    correctIndex = 1,
                    explanation = "A Árvore da Vida simboliza a comunhão eterna e a vitalidade que vêm de Deus.",
                    verseRef = "Apocalipse 22:1-2"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 10 • Vale a Pena Ser Fiel!",
                studyText = "Nenhum sacrifício que fazemos hoje por amor a Jesus se compara à alegria de entrar na Nova Terra! Lá reencontraremos amigos e familiares salvos, abraçaremos animais sem medo, exploraremos as maravilhas da criação e viveremos face a face com Jesus por toda a eternidade.",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 21, 4, "Apocalipse 21:4", "As primeiras coisas passaram.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Onde será o lar eterno definitivo dos salvos após o milênio?",
                    options = listOf(
                        "Na Nova Terra recriada e livre de todo pecado",
                        "Apenas flutuando no espaço vazio",
                        "Neste mesmo mundo com sofrimento"
                    ),
                    correctIndex = 0,
                    explanation = "Deus restaurará a Terra ao seu esplendor original do Éden para ser nosso lar eterno.",
                    verseRef = "Apocalipse 21:1-4; Isaías 65:17"
                )
            )
        ),
        motivationalMessage = "O melhor capítulo da sua vida nunca vai terminar — ele começa na Nova Terra ao lado de Jesus!",
        youtubePlaylistIndex = 10,
        youtubeVideoTitle = "Estudo 10 • A Nova Terra"
    ),

    StudyLesson(
        number = 11,
        title = "Salvação pela Graça",
        subtitle = "Amados gratuitamente, transformados por gratidão",
        category = StudyCategory.SANCTUARY,
        headerArt = StudyHeaderArt.HERO_STUDY,
        estimatedMinutes = 8,
        xpReward = 115,
        blogIntro = "Algumas pessoas pensam que entrar no Céu funciona como passar de ano na escola: você junta pontos suficientes fazendo boas ações e, se atingir a média, Deus aprova você. Mas se fosse assim, quem conseguiria nota 10 perfeita? Ninguém! A mensagem adventista da justificação pela fé exalta a graça maravilhosa de Jesus: somos salvos 100% pelo mérito dEle — e obedecemos por puro amor e gratidão!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Todos precisam de socorro",
                studyText = "Antes de entender o remédio, precisamos reconhecer o diagnóstico. Romanos 3:23-24 explica que todos pecaram e ficaram longe da glória de Deus. Ninguém é bom o suficiente por si mesmo! A boa notícia vem logo em seguida: somos justificados gratuitamente pela Sua graça, por meio da redenção que há em Cristo Jesus.",
                bibleRefs = listOf(
                    KeyVerseRef("rom", 3, 23, "Romanos 3:23-24", "Pois todos pecaram... sendo justificados gratuitamente, por sua graça, mediante a redenção que há em Cristo Jesus.", endVerse = 24)
                ),
                question = QuizQuestion(
                    question = "Como somos justificados (declarados justos diante de Deus) segundo Romanos 3:24?",
                    options = listOf(
                        "Pelos nossos próprios esforços perfeitos",
                        "Gratuitamente, pela graça de Deus em Cristo Jesus",
                        "Por descendência familiar"
                    ),
                    correctIndex = 1,
                    explanation = "Justificação significa que Jesus nos veste com a Sua justiça perfeita de graça!",
                    verseRef = "Romanos 3:23-24"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. O significado da Graça e da Fé",
                studyText = "Graça significa favor imerecido — receber um presente incrível que jamais poderíamos comprar. Efésios 2:8-9 afirma claramente: 'Porque pela graça sois salvos, mediante a fé; e isto não vem de vós; é dom de Deus; não de obras, para que ninguém se glorie.' Jesus oferece o presente; a fé é a nossa mão estendida para recebê-lo!",
                bibleRefs = listOf(
                    KeyVerseRef("eph", 2, 8, "Efésios 2:8-9", "Pela graça sois salvos, mediante a fé; e isto não vem de vós; é dom de Deus; não de obras.", endVerse = 9)
                ),
                question = QuizQuestion(
                    question = "Por que a salvação não vem das nossas próprias obras segundo Efésios 2:8-9?",
                    options = listOf(
                        "Para que ninguém se gabe e toda glória pertença à graça de Deus",
                        "Porque Deus não se importa com atitudes",
                        "Porque é impossível fazer o bem"
                    ),
                    correctIndex = 0,
                    explanation = "Não somos salvos pelas boas obras; somos salvos pela graça para que Cristo receba toda honra.",
                    verseRef = "Efésios 2:8-9"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Então qual é o lugar das boas obras?",
                studyText = "Logo após dizer que não somos salvos pelas obras, o verso 10 completa a ideia: 'Pois somos feitura dele, criados em Cristo Jesus para boas obras!' Pense em uma macieira: ela não dá maçãs para virar macieira — ela dá maçãs porque já é uma macieira viva! Quando Jesus vive em nós pela graça, amar, obedecer e ajudar o próximo brotam naturalmente como fruto.",
                bibleRefs = listOf(
                    KeyVerseRef("eph", 2, 10, "Efésios 2:10", "Pois somos feitura dele, criados em Cristo Jesus para boas obras.")
                ),
                question = QuizQuestion(
                    question = "Segundo Efésios 2:10, qual é o verdadeiro papel das boas obras na vida cristã?",
                    options = listOf(
                        "Pagar a dívida do pecado",
                        "Ser o fruto natural e alegre de quem já foi salvo e recriado em Cristo",
                        "Substituir a fé"
                    ),
                    correctIndex = 1,
                    explanation = "A graça salva e também transforma nosso caráter para praticarmos o bem com alegria.",
                    verseRef = "Efésios 2:10"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 11 • Salvos por Jesus, Transformados por Amor",
                studyText = "Se alguém perguntar: 'Você tem certeza da salvação?', você não precisa olhar para suas falhas e ter medo — olhe para Jesus! Pela graça mediante a fé você já tem perdão e paz hoje, e o Espírito Santo trabalha dentro de você para gerar frutos lindos de obediência e amor.",
                bibleRefs = listOf(
                    KeyVerseRef("eph", 2, 8, "Efésios 2:8-10", "Pela graça sois salvos, mediante a fé... criados em Cristo Jesus para boas obras.", endVerse = 10)
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Qual equação bíblica representa a verdadeira salvação?",
                    options = listOf(
                        "Fé + Boas Obras = Mérito próprio",
                        "Graça de Jesus (mediante a fé) = Salvação, que produz Boas Obras como fruto",
                        "Boas Obras sozinhas = Salvação"
                    ),
                    correctIndex = 1,
                    explanation = "Cristo faz 100% pela nossa salvação; nossa obediência é resposta de amor.",
                    verseRef = "Efésios 2:8-10"
                )
            )
        ),
        motivationalMessage = "Você não precisa ser perfeito para correr para Jesus — venha como está e deixe a graça transformar você!",
        youtubePlaylistIndex = 11,
        youtubeVideoTitle = "Estudo 11 • Salvação pela Graça"
    ),

    StudyLesson(
        number = 12,
        title = "O Santuário de Deus",
        subtitle = "A maquete celestial que revela cada passo da obra de Jesus",
        category = StudyCategory.SANCTUARY,
        headerArt = StudyHeaderArt.BIBLE_NIGHT,
        estimatedMinutes = 9,
        xpReward = 125,
        blogIntro = "Você já viu uma maquete de prédio antes de a construção ficar pronta? No Antigo Testamento, Deus pediu a Moisés para construir um Santuário portátil que era uma maquete perfeita de algo muito maior que existe no Céu! A doutrina do Santuário é uma das joias mais belas da fé adventista porque mostra, em imagens vívidas, o sacrifício de Jesus, Sua intercessão diária por nós hoje e a purificação final do universo.",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. O desejo de Deus de morar bem perto de nós",
                studyText = "Em Êxodo 25:8-9, Deus revelou o motivo do Santuário: 'E me farão um santuário, para que eu possa habitar no meio deles.' Ele mostrou a Moisés o modelo exato do Santuário celestial! Ali havia três espaços principais: o Pátio (onde ficava o altar de sacrifícios e a bacia de água), o Lugar Santo (candelabro, mesa dos pães e altar de incenso) e o Lugar Santíssimo (onde ficava a Arca da Aliança com os Dez Mandamentos).",
                bibleRefs = listOf(
                    KeyVerseRef("exo", 25, 8, "Êxodo 25:8-9", "E me farão um santuário, para que eu possa habitar no meio deles.", endVerse = 9)
                ),
                question = QuizQuestion(
                    question = "Qual era o principal propósito de Deus ao mandar construir o Santuário em Êxodo 25:8?",
                    options = listOf(
                        "Guardar ouro dos reis",
                        "Habitar no meio do Seu povo e ilustrar o plano da salvação",
                        "Apenas servir de museu"
                    ),
                    correctIndex = 1,
                    explanation = "Deus sempre quis estar próximo dos Seus filhos e ensinar visualmente como o pecado é perdoado.",
                    verseRef = "Êxodo 25:8"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. O Cordeiro que apontava para a Cruz",
                studyText = "No Pátio do santuário, o pecador arrependido levava um cordeirinho sem defeito, colocava as mãos sobre sua cabeça confessando os pecados e o sacrificava. Isso nunca salvou ninguém por magia — era uma aula visual apontando para o futuro! Quando João Batista viu Jesus se aproximando, apontou e disse: 'Eis o Cordeiro de Deus, que tira o pecado do mundo!'",
                bibleRefs = listOf(
                    KeyVerseRef("jhn", 1, 29, "João 1:29", "Eis o Cordeiro de Deus, que tira o pecado do mundo!")
                ),
                question = QuizQuestion(
                    question = "Quem era representado pelos cordeiros sacrificados no Pátio do Santuário?",
                    options = listOf("Moisés", "Jesus Cristo, o Cordeiro de Deus que morreu na cruz por nós", "Os sacerdotes humanos"),
                    correctIndex = 1,
                    explanation = "Todo sacrifício no Antigo Testamento apontava pela fé para a morte de Jesus no Calvário.",
                    verseRef = "João 1:29"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Jesus, nosso Sumo Sacerdote no Céu hoje",
                studyText = "Depois de ressuscitar, o trabalho de Jesus não acabou! A carta aos Hebreus explica que o santuário terrestre era apenas 'figura do verdadeiro'. Jesus subiu ao verdadeiro Santuário no próprio Céu e hoje atua lá como nosso Sumo Sacerdote! O candelabro lembra que Ele é nossa Luz; os pães lembram que Ele é o Pão da Vida; e o incenso sobe com nossas orações diante do Pai.",
                bibleRefs = listOf(
                    KeyVerseRef("heb", 8, 1, "Hebreus 8:1-2", "Possuímos tal sumo sacerdote... ministro do santuário e do verdadeiro tabernáculo que o Senhor erigiu.", endVerse = 2),
                    KeyVerseRef("heb", 9, 24, "Hebreus 9:24", "Cristo não entrou em santuário feito por mãos... porém no mesmo céu, para comparecer, agora, por nós, diante de Deus.")
                ),
                question = QuizQuestion(
                    question = "Onde Jesus está ministrando agora como nosso Sumo Sacerdote segundo Hebreus 9:24?",
                    options = listOf(
                        "No verdadeiro Santuário celestial diante de Deus",
                        "Em uma tenda no deserto",
                        "Em Jerusalém terrestre"
                    ),
                    correctIndex = 0,
                    explanation = "Jesus comparece hoje no próprio Céu diante do Pai em nosso favor!",
                    verseRef = "Hebreus 9:24"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 12 • Cada Móvel Fala de Jesus",
                studyText = "No Santuário, tudo tem significado espiritual prático para a sua vida: o Altar de Sacrifício é a Cruz onde você recebe perdão; a Bacia de Água é o Batismo; os Pães são a Bíblia; o Candelabro é o testemunho pelo Espírito Santo; o Incenso é a Oração; e a Arca guarda a Lei de amor de Deus. Nunca deixe de falar com seu Sumo Sacerdote no Céu!",
                bibleRefs = listOf(
                    KeyVerseRef("heb", 8, 1, "Hebreus 8:1-2", "Ministro do santuário e do verdadeiro tabernáculo.", endVerse = 2)
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Qual relação existe entre o Santuário de Moisés e o Santuário do Céu?",
                    options = listOf(
                        "Não têm relação nenhuma",
                        "O santuário terrestre era uma cópia/modelo que ensinava sobre o ministério real de Jesus no Céu",
                        "O santuário do Céu só existirá no futuro distante"
                    ),
                    correctIndex = 1,
                    explanation = "Hebreus 8 e 9 confirmam que o santuário de Moisés apontava para o ministério celestial de Cristo.",
                    verseRef = "Êxodo 25:8-9; Hebreus 9:24"
                )
            )
        ),
        motivationalMessage = "Você tem um Melhor Amigo e Sumo Sacerdote no trono do Céu ouvindo cada oração sua agora mesmo!",
        youtubePlaylistIndex = 12,
        youtubeVideoTitle = "Estudo 12 • O Santuário de Deus"
    ),

    StudyLesson(
        number = 13,
        title = "O Juízo",
        subtitle = "Por que o juízo divino é uma excelente notícia para você",
        category = StudyCategory.SANCTUARY,
        headerArt = StudyHeaderArt.PROPHECY,
        estimatedMinutes = 9,
        xpReward = 125,
        blogIntro = "Para muita gente, ouvir falar em 'Juízo Final' dá frio na barriga e medo. Mas na Bíblia, o juízo é anunciado pelos anjos como parte do 'evangelho eterno' — ou seja, BOAS NOTÍCIAS! Sabe por quê? Porque um juiz justo acaba com a impunidade, defende os inocentes e liberta quem confia no Advogado certo. E quando o nosso Advogado é Jesus Cristo, Ele nunca perdeu uma única causa!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. Uma cena solene no tribunal do Céu",
                studyText = "Em Daniel 7:9-10, o profeta teve uma visão impressionante antes da vinda de Jesus nas nuvens: tronos foram colocados, o Ancião de Dias (Deus Pai) se assentou, milhões de anjos assistiam e 'assentou-se o tribunal, e se abriram os livros'. Esse juízo investigativo celestial acontece antes da volta de Cristo para que todo o universo veja quem escolheu a graça de Jesus.",
                bibleRefs = listOf(
                    KeyVerseRef("dan", 7, 9, "Daniel 7:9-10", "Assentou-se o tribunal, e se abriram os livros.", endVerse = 10)
                ),
                question = QuizQuestion(
                    question = "O que Daniel 7:10 diz que foi aberto quando o tribunal celestial se assentou?",
                    options = listOf("Portas de bronze", "Os livros de registro", "Caixas de tesouro"),
                    correctIndex = 1,
                    explanation = "Os livros celestiais registram nossa história e nossas decisões em relação a Cristo.",
                    verseRef = "Daniel 7:9-10"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. O primeiro anjo anuncia que chegou a hora",
                studyText = "Em Apocalipse 14:6-7, um anjo voa pelo meio do céu proclamando o evangelho eterno em alta voz: 'Temei a Deus e dai-lhe glória, pois é chegada a hora do seu juízo; e adorai aquele que fez o céu, e a terra, e o mar!' Essa mensagem profética desperta o mundo para voltar à adoração pura ao Criador nos últimos dias.",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 14, 6, "Apocalipse 14:6-7", "Temei a Deus e dai-lhe glória, pois é chegada a hora do seu juízo.", endVerse = 7)
                ),
                question = QuizQuestion(
                    question = "O que o primeiro anjo de Apocalipse 14:7 convida todos a fazerem diante da hora do juízo?",
                    options = listOf(
                        "Esconder-se com medo",
                        "Temer (respeitar) a Deus, dar-Lhe glória e adorar o Criador",
                        "Ignorar a mensagem"
                    ),
                    correctIndex = 1,
                    explanation = "O juízo e a adoração ao Criador caminham juntos no chamado do evangelho eterno.",
                    verseRef = "Apocalipse 14:6-7"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Quem defende você no tribunal do Céu?",
                studyText = "Se fôssemos julgados apenas pelos nossos erros, ninguém passaria! Mas leia 1 João 2:1 com alegria: 'Se, todavia, alguém pecar, temos Advogado junto ao Pai, Jesus Cristo, o Justo.' Jesus não apenas é nosso Advogado — Ele mesmo já pagou a nossa fiança na cruz! Quem entrega a vida a Ele não entra em condenação.",
                bibleRefs = listOf(
                    KeyVerseRef("1jn", 2, 1, "1 João 2:1", "Temos Advogado junto ao Pai, Jesus Cristo, o Justo.")
                ),
                question = QuizQuestion(
                    question = "Quem é o nosso Advogado junto ao Pai segundo 1 João 2:1?",
                    options = listOf("Nós mesmos com nossas desculpas", "Jesus Cristo, o Justo", "Um anjo guardião"),
                    correctIndex = 1,
                    explanation = "Jesus defende todo aquele que confia nEle e aceita Seu perdão.",
                    verseRef = "1 João 2:1"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 13 • As Três Etapas do Juízo",
                studyText = "Na visão adventista completa da Bíblia, o juízo tem três etapas cheias de sabedoria: 1) Antes da volta de Jesus (Investigativo, Daniel 7), decidindo quem sobe na primeira ressurreição; 2) Durante o milênio (De Revisão, 1 Coríntios 6:2), quando os salvos tiram todas as dúvidas no Céu; 3) Depois do milênio (Executivo, Apocalipse 20), encerrando o mal para sempre. Com Jesus ao seu lado, o juízo é motivo de paz!",
                bibleRefs = listOf(
                    KeyVerseRef("rev", 14, 7, "Apocalipse 14:7", "É chegada a hora do seu juízo."),
                    KeyVerseRef("1jn", 2, 1, "1 João 2:1", "Temos Advogado junto ao Pai, Jesus Cristo, o Justo.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Por que o juízo divino é uma boa notícia para quem ama a Jesus?",
                    options = listOf(
                        "Porque Jesus é nosso Advogado, defende os Seus filhos e acabará com toda injustiça",
                        "Porque não existem regras",
                        "Porque ninguém será julgado"
                    ),
                    correctIndex = 0,
                    explanation = "O juízo vindica os filhos de Deus e traz justiça eterna ao universo.",
                    verseRef = "Daniel 7:9-10; 1 João 2:1"
                )
            )
        ),
        motivationalMessage = "Quando você caminha com Jesus, o seu Advogado já garantiu a sua vitória eterna!",
        youtubePlaylistIndex = 13,
        youtubeVideoTitle = "Estudo 13 • O Juízo"
    ),

    StudyLesson(
        number = 14,
        title = "As Leis na Bíblia",
        subtitle = "Diferenciando o que era sombra temporária do que é eterno",
        category = StudyCategory.CHRISTIAN_LIFE,
        headerArt = StudyHeaderArt.BIBLE_NIGHT,
        estimatedMinutes = 8,
        xpReward = 115,
        blogIntro = "Você já ouviu alguém dizer que 'a lei acabou na cruz'? Essa confusão acontece quando as pessoas misturam leis diferentes que existem na Bíblia! Deus deu ao antigo Israel leis civis para o governo da nação, leis de saúde, leis cerimoniais (sacrifícios e festas anuais que apontavam para a vinda de Jesus) e a Lei Moral eterna — os Dez Mandamentos. Entender essa diferença torna a leitura bíblica cristalina!",
        thoughtBlocks = listOf(
            StudyThoughtBlock(
                stepNumber = 1,
                heading = "1. As leis cerimoniais que apontavam para Cristo",
                studyText = "Todos os sacrifícios de cordeiros, rituais de purificação e festas cerimoniais descritos por Moisés em um livro eram como 'sombras' projetadas para frente! Em Colossenses 2:14-17, Paulo explica que Jesus encravou na cruz o escrito de dívida dessas ordenanças cerimoniais. Quando o Jesus real morreu na cruz, o véu do templo se rasgou e não precisamos mais sacrificar animais!",
                bibleRefs = listOf(
                    KeyVerseRef("col", 2, 14, "Colossenses 2:14, 17", "Removeu-o inteiramente, encravando-o na cruz... tudo isso tem sido sombra das coisas que haviam de vir; porém o corpo é de Cristo.", endVerse = 17)
                ),
                question = QuizQuestion(
                    question = "Qual conjunto de leis era uma 'sombra' de Cristo e terminou quando Ele morreu na cruz?",
                    options = listOf(
                        "A Lei Moral dos Dez Mandamentos",
                        "As leis cerimoniais de sacrifícios e ofertas",
                        "As leis de amar ao próximo"
                    ),
                    correctIndex = 1,
                    explanation = "Os sacrifícios cerimoniais apontavam para a cruz; cumpridos em Jesus, cessaram para sempre.",
                    verseRef = "Colossenses 2:14-17"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 2,
                heading = "2. O que Jesus disse sobre a Lei eterna?",
                studyText = "Para que ninguém pensasse que Ele veio apagar os Dez Mandamentos, Jesus declarou solenemente no Sermão do Monte: 'Não penseis que vim revogar a Lei ou os Profetas; não vim para revogar, vim para cumprir.' Enquanto céu e terra existirem, os princípios eternos do caráter de Deus permanecem intactos!",
                bibleRefs = listOf(
                    KeyVerseRef("mat", 5, 17, "Mateus 5:17-18", "Não penseis que vim revogar a Lei... nem um i ou um til jamais passará da Lei.", endVerse = 18)
                ),
                question = QuizQuestion(
                    question = "O que Jesus afirmou em Mateus 5:17 sobre a sua relação com a Lei de Deus?",
                    options = listOf(
                        "Que veio revogar e apagar tudo",
                        "Que não veio revogar, mas cumprir e honrar plenamente",
                        "Que a Lei não tem mais utilidade"
                    ),
                    correctIndex = 1,
                    explanation = "Jesus viveu e ensinou o verdadeiro significado espiritual e amoroso da Lei de Deus.",
                    verseRef = "Mateus 5:17-18"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 3,
                heading = "3. Pedra pelo dedo de Deus vs. Livro de Moisés",
                studyText = "A própria Bíblia mostra a diferença entre as duas leis: as leis cerimoniais foram escritas por Moisés em um livro e guardadas AO LADO da Arca da Aliança. Já a Lei Moral dos Dez Mandamentos foi falada em voz audível por Deus, escrita pelo próprio dedo divino em TÁBUAS DE PEDRA (Êxodo 31:18) e guardada DENTRO da Arca! Salmos 19:7 exalta: 'A lei do Senhor é perfeita e restaura a alma.'",
                bibleRefs = listOf(
                    KeyVerseRef("exo", 31, 18, "Êxodo 31:18", "Tábuas de pedra, escritas pelo dedo de Deus."),
                    KeyVerseRef("psa", 19, 7, "Salmos 19:7", "A lei do Senhor é perfeita e restaura a alma.")
                ),
                question = QuizQuestion(
                    question = "Onde e por quem foram escritos os Dez Mandamentos em contraste com a lei cerimonial?",
                    options = listOf(
                        "Em tábuas de pedra pelo próprio dedo de Deus",
                        "Em papiro por escribas romanos",
                        "Na areia do deserto"
                    ),
                    correctIndex = 0,
                    explanation = "A pedra simboliza o caráter permanente e eterno da Lei Moral de Deus.",
                    verseRef = "Êxodo 31:18"
                )
            ),
            StudyThoughtBlock(
                stepNumber = 4,
                isReview = true,
                heading = "Revisão do Estudo 14 • Sombra x Realidade Eterna",
                studyText = "Sempre que ler o Novo Testamento sobre 'lei', observe pelo contexto de qual lei o autor está falando! A lei cerimonial apontava para a cruz e acabou lá; já a Lei Moral dos Dez Mandamentos revela o caráter eterno de amor de Deus e continua válida para nos proteger e guiar em Cristo.",
                bibleRefs = listOf(
                    KeyVerseRef("mat", 5, 17, "Mateus 5:17", "Não vim para revogar, vim para cumprir.")
                ),
                question = QuizQuestion(
                    question = "Revisão Final: Qual afirmação diferencia corretamente as leis na Bíblia?",
                    options = listOf(
                        "Todas as leis terminaram juntas na cruz",
                        "A lei cerimonial (sacrifícios) acabou na cruz; a Lei Moral (Dez Mandamentos) é eterna",
                        "Ainda precisamos sacrificar cordeiros hoje"
                    ),
                    correctIndex = 1,
                    explanation = "Cristo encerrou os sacrifícios cerimoniais sendo o Cordeiro perfeito, mas Sua Lei Moral continua eterna.",
                    verseRef = "Colossenses 2:14-17; Mateus 5:17"
                )
            )
        ),
        motivationalMessage = "As leis de Deus são cercas de proteção colocadas por um Pai que ama você demais para deixá-lo se machucar!",
        youtubePlaylistIndex = 14,
        youtubeVideoTitle = "Estudo 14 • As Leis na Bíblia"
    )
)
