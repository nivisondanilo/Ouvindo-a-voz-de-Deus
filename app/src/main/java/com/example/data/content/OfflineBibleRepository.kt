package com.example.data.content

import com.example.i18n.AppLanguage
import com.example.model.BibleBook
import com.example.model.BibleChapter
import com.example.model.BibleVerse
import com.example.model.KeyVerseRef

object OfflineBibleRepository {
    val books: List<BibleBook> = listOf(
        BibleBook(
            id = "gen",
            namePt = "Gênesis",
            nameEn = "Genesis",
            nameEs = "Génesis",
            testament = "AT",
            chapters = listOf(
                BibleChapter(
                    1, "A Criação do Mundo", listOf(
                        BibleVerse("gen", 1, 1, "No princípio, criou Deus os céus e a terra."),
                        BibleVerse("gen", 1, 2, "A terra, porém, estava sem forma e vazia; havia trevas sobre a face do abismo, e o Espírito de Deus pairava por sobre as águas."),
                        BibleVerse("gen", 1, 3, "Disse Deus: Haja luz; e houve luz."),
                        BibleVerse("gen", 1, 26, "Também disse Deus: Façamos o homem à nossa imagem, conforme a nossa semelhança; tenha ele domínio sobre os peixes do mar, sobre as aves dos céus e sobre toda a terra."),
                        BibleVerse("gen", 1, 27, "Criou Deus, pois, o homem à sua imagem, à imagem de Deus o criou; homem e mulher os criou."),
                        BibleVerse("gen", 1, 31, "Viu Deus tudo quanto fizera, e eis que era muito bom. Houve tarde e manhã, o sexto dia.")
                    )
                ),
                BibleChapter(
                    2, "O Sábado da Criação", listOf(
                        BibleVerse("gen", 2, 1, "Assim, pois, foram acabados os céus e a terra e todo o seu exército."),
                        BibleVerse("gen", 2, 2, "E, havendo Deus terminado no dia sétimo a sua obra, que fizera, descansou nesse dia de toda a sua obra que tinha feito."),
                        BibleVerse("gen", 2, 3, "E abençoou Deus o dia sétimo e o santificou; porque nele descansou de toda a obra que, como Criador, fizera.")
                    )
                ),
                BibleChapter(
                    3, "A Queda e a Promessa do Resgate", listOf(
                        BibleVerse("gen", 3, 4, "Então, a serpente disse à mulher: É certo que não morrereis."),
                        BibleVerse("gen", 3, 6, "Vendo a mulher que a árvore era boa para se comer, agradável aos olhos e árvore desejável para dar entendimento, tomou-lhe do fruto e comeu."),
                        BibleVerse("gen", 3, 15, "Porei inimizade entre ti e a mulher, entre a tua descendência e o seu descendente. Este te ferirá a cabeça, e tu lhe ferirás o calcanhar.")
                    )
                )
            )
        ),
        BibleBook(
            id = "exo",
            namePt = "Êxodo",
            nameEn = "Exodus",
            nameEs = "Éxodo",
            testament = "AT",
            chapters = listOf(
                BibleChapter(
                    20, "Os Dez Mandamentos", listOf(
                        BibleVerse("exo", 20, 1, "Então, falou Deus todas estas palavras:"),
                        BibleVerse("exo", 20, 2, "Eu sou o Senhor, teu Deus, que te tirei da terra do Egito, da casa da servidão."),
                        BibleVerse("exo", 20, 3, "Não terás outros deuses diante de mim."),
                        BibleVerse("exo", 20, 4, "Não farás para ti imagem de escultura, nem semelhança alguma do que há em cima nos céus, nem embaixo na terra."),
                        BibleVerse("exo", 20, 7, "Não tomarás o nome do Senhor, teu Deus, em vão."),
                        BibleVerse("exo", 20, 8, "Lembra-te do dia de sábado, para o santificar."),
                        BibleVerse("exo", 20, 9, "Seis dias trabalharás e farás toda a tua obra."),
                        BibleVerse("exo", 20, 10, "Mas o sétimo dia é o sábado do Senhor, teu Deus; não farás nenhum trabalho."),
                        BibleVerse("exo", 20, 11, "Porque, em seis dias, fez o Senhor os céus e a terra, o mar e tudo o que neles há e, ao sétimo dia, descansou; por isso, o Senhor abençoou o dia de sábado e o santificou."),
                        BibleVerse("exo", 20, 12, "Honra teu pai e tua mãe, para que se prolonguem os teus dias na terra que o Senhor, teu Deus, te dá."),
                        BibleVerse("exo", 20, 13, "Não matarás."),
                        BibleVerse("exo", 20, 14, "Não adulterarás."),
                        BibleVerse("exo", 20, 15, "Não furtarás."),
                        BibleVerse("exo", 20, 16, "Não dirás falso testemunho contra o teu próximo."),
                        BibleVerse("exo", 20, 17, "Não cobiçarás a casa do teu próximo... nem coisa alguma que pertença ao teu próximo.")
                    )
                ),
                BibleChapter(
                    25, "O Santuário de Deus", listOf(
                        BibleVerse("exo", 25, 8, "E me farão um santuário, para que eu possa habitar no meio deles."),
                        BibleVerse("exo", 25, 9, "Segundo tudo o que eu te mostrar para modelo do tabernáculo e para modelo de todos os seus móveis, assim mesmo o fareis.")
                    )
                ),
                BibleChapter(
                    31, "As Tábuas Escritas por Deus", listOf(
                        BibleVerse("exo", 31, 18, "E, tendo acabado de falar com ele no monte Sinai, deu a Moisés as duas tábuas do Testemunho, tábuas de pedra, escritas pelo dedo de Deus.")
                    )
                )
            )
        ),
        BibleBook(
            id = "lev",
            namePt = "Levítico",
            nameEn = "Leviticus",
            nameEs = "Levítico",
            testament = "AT",
            chapters = listOf(
                BibleChapter(
                    27, "Fidelidade ao Senhor", listOf(
                        BibleVerse("lev", 27, 30, "Também todas as dízimas da terra, tanto dos cereais do campo como dos frutos das árvores, são do Senhor; santas são ao Senhor.")
                    )
                )
            )
        ),
        BibleBook(
            id = "jos",
            namePt = "Josué",
            nameEn = "Joshua",
            nameEs = "Josué",
            testament = "AT",
            chapters = listOf(
                BibleChapter(
                    1, "Coragem na Palavra", listOf(
                        BibleVerse("jos", 1, 8, "Não cesses de falar deste Livro da Lei; antes, medita nele dia e noite, para que tenhas cuidado de fazer segundo tudo quanto nele está escrito."),
                        BibleVerse("jos", 1, 9, "Não to mandei eu? Sê forte e corajoso; não temas, nem te espantes, porque o Senhor, teu Deus, é contigo por onde quer que andares.")
                    )
                ),
                BibleChapter(
                    24, "Escolha Livre", listOf(
                        BibleVerse("jos", 24, 15, "Porém, se vos parece mal servir ao Senhor, escolhei, hoje, a quem sirvais... Eu e a minha casa serviremos ao Senhor.")
                    )
                )
            )
        ),
        BibleBook(
            id = "psa",
            namePt = "Salmos",
            nameEn = "Psalms",
            nameEs = "Salmos",
            testament = "AT",
            chapters = listOf(
                BibleChapter(
                    19, "A Glória de Deus na Natureza e na Lei", listOf(
                        BibleVerse("psa", 19, 1, "Os céus proclamam a glória de Deus, e o firmamento anuncia as obras das suas mãos."),
                        BibleVerse("psa", 19, 7, "A lei do Senhor é perfeita e restaura a alma; o testemunho do Senhor é fiel e dá sabedoria aos símplices.")
                    )
                ),
                BibleChapter(
                    23, "O Bom Pastor", listOf(
                        BibleVerse("psa", 23, 1, "O Senhor é o meu pastor; nada me faltará."),
                        BibleVerse("psa", 23, 2, "Ele me faz repousar em pastos verdejantes. Leva-me para junto das águas de descanso;"),
                        BibleVerse("psa", 23, 3, "refrigera-me a alma. Guia-me pelas veredas da justiça por amor do seu nome."),
                        BibleVerse("psa", 23, 4, "Ainda que eu ande pelo vale da sombra da morte, não temerei mal nenhum, porque tu estás comigo.")
                    )
                ),
                BibleChapter(
                    33, "O Poder da Palavra Criadora", listOf(
                        BibleVerse("psa", 33, 6, "Os céus por sua palavra se fizeram, e, pelo sopro de sua boca, o exército deles."),
                        BibleVerse("psa", 33, 9, "Pois ele falou, e tudo se fez; ele ordenou, e tudo passou a existir.")
                    )
                ),
                BibleChapter(
                    119, "Amor pela Palavra", listOf(
                        BibleVerse("psa", 119, 9, "De que maneira poderá o jovem guardar puro o seu caminho? Observando-o segundo a tua palavra."),
                        BibleVerse("psa", 119, 11, "Guardo no coração as tuas palavras, para não pecar contra ti."),
                        BibleVerse("psa", 119, 105, "Lâmpada para os meus pés é a tua palavra e luz, para os meus caminhos.")
                    )
                ),
                BibleChapter(
                    146, "Confiança no Criador", listOf(
                        BibleVerse("psa", 146, 4, "Sai-lhes o espírito, e eles tornam ao pó; nesse mesmo dia, perecem todos os seus desígnios.")
                    )
                )
            )
        ),
        BibleBook(
            id = "pro",
            namePt = "Provérbios",
            nameEn = "Proverbs",
            nameEs = "Proverbios",
            testament = "AT",
            chapters = listOf(
                BibleChapter(
                    9, "Princípio da Sabedoria", listOf(
                        BibleVerse("pro", 9, 10, "O temor do Senhor é o princípio da sabedoria, e o conhecimento do Santo é prudência.")
                    )
                ),
                BibleChapter(
                    22, "Caminho de Sabedoria", listOf(
                        BibleVerse("pro", 22, 6, "Ensina a criança no caminho em que deve andar, e, ainda quando for velho, não se desviará dele.")
                    )
                ),
                BibleChapter(
                    30, "Pureza da Palavra de Deus", listOf(
                        BibleVerse("pro", 30, 5, "Toda palavra de Deus é pura; ele é escudo para os que nele confiam."),
                        BibleVerse("pro", 30, 6, "Nada acrescentes às suas palavras, para que não te repreenda, e sejas achado mentiroso.")
                    )
                )
            )
        ),
        BibleBook(
            id = "ecc",
            namePt = "Eclesiastes",
            nameEn = "Ecclesiastes",
            nameEs = "Eclesiastés",
            testament = "AT",
            chapters = listOf(
                BibleChapter(
                    9, "O Estado dos Mortos", listOf(
                        BibleVerse("ecc", 9, 5, "Porque os vivos sabem que hão de morrer, mas os mortos não sabem coisa nenhuma, nem tampouco terão eles recompensa, porque a sua memória jaz no esquecimento."),
                        BibleVerse("ecc", 9, 6, "Amor, ódio e inveja para eles já pereceram; para sempre não têm eles parte em coisa alguma do que se faz debaixo do sol.")
                    )
                )
            )
        ),
        BibleBook(
            id = "isa",
            namePt = "Isaías",
            nameEn = "Isaiah",
            nameEs = "Isaías",
            testament = "AT",
            chapters = listOf(
                BibleChapter(
                    8, "À Lei e ao Testemunho", listOf(
                        BibleVerse("isa", 8, 20, "À lei e ao testemunho! Se eles não falarem desta maneira, jamais verão a alva.")
                    )
                ),
                BibleChapter(
                    14, "A Queda de Lúcifer", listOf(
                        BibleVerse("isa", 14, 12, "Como caíste do céu, ó estrela da manhã, filho da alva! Como foste lançado por terra, tu que debilitavas as nações!"),
                        BibleVerse("isa", 14, 13, "Tu dizias no teu coração: Eu subirei ao céu; acima das estrelas de Deus exaltarei o meu trono."),
                        BibleVerse("isa", 14, 14, "Subirei acima das mais altas nuvens e serei semelhante ao Altíssimo.")
                    )
                ),
                BibleChapter(
                    28, "Como Estudar as Escrituras", listOf(
                        BibleVerse("isa", 28, 10, "Porque é preceito sobre preceito, preceito e mais preceito; regra sobre regra, regra e mais regra; um pouco aqui, um pouco ali.")
                    )
                ),
                BibleChapter(
                    65, "A Alegria da Nova Terra", listOf(
                        BibleVerse("isa", 65, 17, "Pois eis que eu crio novos céus e nova terra; e não haverá lembrança das coisas passadas."),
                        BibleVerse("isa", 65, 21, "Eles edificarão casas e nelas habitarão; plantarão vinhas e comerão o seu fruto."),
                        BibleVerse("isa", 65, 25, "O lobo e o cordeiro pastarão juntos... não se fará mal nem dano algum em todo o meu santo monte, diz o Senhor.")
                    )
                ),
                BibleChapter(
                    66, "Adoração Eterna", listOf(
                        BibleVerse("isa", 66, 22, "Porque, como os novos céus e a nova terra, que hei de fazer, estarão diante de mim, diz o Senhor, assim há de estar a vossa posteridade e o vosso nome."),
                        BibleVerse("isa", 66, 23, "E será que, de uma Festa da Lua Nova à outra e de um sábado a outro, virá toda a carne a adorar perante mim, diz o Senhor.")
                    )
                )
            )
        ),
        BibleBook(
            id = "dan",
            namePt = "Daniel",
            nameEn = "Daniel",
            nameEs = "Daniel",
            testament = "AT",
            chapters = listOf(
                BibleChapter(
                    1, "Fidelidade na Saúde", listOf(
                        BibleVerse("dan", 1, 8, "Resolveu Daniel, firmemente, não contaminar-se com as finas iguarias do rei, nem com o vinho que ele bebia."),
                        BibleVerse("dan", 1, 12, "Experimenta, peço-te, os teus servos dez dias; e que se nos dêem legumes a comer e água a beber."),
                        BibleVerse("dan", 1, 17, "Ora, a estes quatro jovens Deus deu o conhecimento e a inteligência em toda cultura e sabedoria.")
                    )
                ),
                BibleChapter(
                    7, "O Juízo e a Profecia", listOf(
                        BibleVerse("dan", 7, 9, "Continuei olhando, até que foram postos uns tronos, e o Ancião de Dias se assentou."),
                        BibleVerse("dan", 7, 10, "Assentou-se o tribunal, e se abriram os livros."),
                        BibleVerse("dan", 7, 25, "Proferirá palavras contra o Altíssimo, magoará os santos do Altíssimo e cuidará em mudar os tempos e a lei.")
                    )
                )
            )
        ),
        BibleBook(
            id = "amo",
            namePt = "Amós",
            nameEn = "Amos",
            nameEs = "Amós",
            testament = "AT",
            chapters = listOf(
                BibleChapter(
                    3, "Revelação Profética", listOf(
                        BibleVerse("amo", 3, 7, "Certamente, o Senhor Deus não fará coisa alguma, sem primeiro revelar o seu segredo aos seus servos, os profetas.")
                    )
                )
            )
        ),
        BibleBook(
            id = "mal",
            namePt = "Malaquias",
            nameEn = "Malachi",
            nameEs = "Malaquías",
            testament = "AT",
            chapters = listOf(
                BibleChapter(
                    3, "Fidelidade e Imutabilidade de Deus", listOf(
                        BibleVerse("mal", 3, 6, "Porque eu, o Senhor, não mudo; por isso, vós, ó filhos de Jacó, não sois consumidos."),
                        BibleVerse("mal", 3, 10, "Trazei todos os dízimos à casa do Tesouro, para que haja mantimento na minha casa; e provai-me nisto, diz o Senhor dos Exércitos, se eu não vos abrir as janelas do céu e não derramar sobre vós bênção sem medida.")
                    )
                )
            )
        ),
        BibleBook(
            id = "mat",
            namePt = "Mateus",
            nameEn = "Matthew",
            nameEs = "Mateo",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    3, "O Batismo de Jesus", listOf(
                        BibleVerse("mat", 3, 16, "Batizado Jesus, saiu logo da água, e eis que se lhe abriram os céus, e viu o Espírito de Deus descendo como pomba, vindo sobre ele."),
                        BibleVerse("mat", 3, 17, "E eis uma voz dos céus, que dizia: Este é o meu Filho amado, em quem me comprazo.")
                    )
                ),
                BibleChapter(
                    5, "O Sermão do Monte", listOf(
                        BibleVerse("mat", 5, 17, "Não penseis que vim revogar a Lei ou os Profetas; não vim para revogar, vim para cumprir."),
                        BibleVerse("mat", 5, 18, "Porque em verdade vos digo: até que o céu e a terra passem, nem um i ou um til jamais passará da Lei, até que tudo se cumpra.")
                    )
                ),
                BibleChapter(
                    22, "O Maior Mandamento", listOf(
                        BibleVerse("mat", 22, 37, "Respondeu-lhe Jesus: Amarás o Senhor, teu Deus, de todo o teu coração, de toda a tua alma e de todo o teu entendimento."),
                        BibleVerse("mat", 22, 39, "O segundo, semelhante a este, é: Amarás o teu próximo como a ti mesmo."),
                        BibleVerse("mat", 22, 40, "Destes dois mandamentos dependem toda a Lei e os Profetas.")
                    )
                ),
                BibleChapter(
                    23, "Fidelidade Integral", listOf(
                        BibleVerse("mat", 23, 23, "Ai de vós, escribas e fariseus... porque dais o dízimo da hortelã, do endro e do cominho e tendes negligenciado os preceitos mais importantes da Lei: a justiça, a misericórdia e a fé; devíeis, porém, fazer estas coisas, sem omitir aquelas.")
                    )
                ),
                BibleChapter(
                    24, "Os Sinais da Volta de Jesus", listOf(
                        BibleVerse("mat", 24, 6, "E, certamente, ouvireis falar de guerras e rumores de guerras; vede, não vos assusteis."),
                        BibleVerse("mat", 24, 7, "Porquanto se levantará nação contra nação, reino contra reino, e haverá fomes e terremotos em vários lugares."),
                        BibleVerse("mat", 24, 14, "E será pregado este evangelho do reino por todo o mundo, para testemunho a todas as nações. Então, virá o fim."),
                        BibleVerse("mat", 24, 27, "Porque, assim como o relâmpago sai do oriente e se mostra até no ocidente, assim há de ser a vinda do Filho do Homem."),
                        BibleVerse("mat", 24, 36, "Mas a respeito daquele dia e hora ninguém sabe, nem os anjos dos céus, nem o Filho, senão o Pai.")
                    )
                ),
                BibleChapter(
                    28, "A Grande Comissão", listOf(
                        BibleVerse("mat", 28, 19, "Ide, portanto, fazei discípulos de todas as nações, batizando-os em nome do Pai, e do Filho, e do Espírito Santo;"),
                        BibleVerse("mat", 28, 20, "ensinando-os a guardar todas as coisas que vos tenho ordenado. E eis que estou convosco todos os dias até à consumação do século.")
                    )
                )
            )
        ),
        BibleBook(
            id = "mrk",
            namePt = "Marcos",
            nameEn = "Mark",
            nameEs = "Marcos",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    2, "Senhor do Sábado", listOf(
                        BibleVerse("mrk", 2, 27, "E acrescentou: O sábado foi estabelecido por causa do homem, e não o homem por causa do sábado;"),
                        BibleVerse("mrk", 2, 28, "de sorte que o Filho do Homem é senhor também do sábado.")
                    )
                ),
                BibleChapter(
                    16, "Crer e Ser Batizado", listOf(
                        BibleVerse("mrk", 16, 16, "Quem crer e for batizado será salvo; quem, porém, não crer será condenado.")
                    )
                )
            )
        ),
        BibleBook(
            id = "luk",
            namePt = "Lucas",
            nameEn = "Luke",
            nameEs = "Lucas",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    2, "A Infância de Jesus", listOf(
                        BibleVerse("luk", 2, 52, "E crescia Jesus em sabedoria, estatura e graça, diante de Deus e dos homens.")
                    )
                ),
                BibleChapter(
                    4, "O Costume de Jesus no Sábado", listOf(
                        BibleVerse("luk", 4, 16, "Indo para Nazaré, onde fora criado, entrou, num sábado, na sinagoga, segundo o seu costume, e levantou-se para ler.")
                    )
                ),
                BibleChapter(
                    21, "Ergam a Cabeça", listOf(
                        BibleVerse("luk", 21, 28, "Ora, ao começarem estas coisas a suceder, exultai e erguei a vossa cabeça; porque a vossa redenção se aproxima.")
                    )
                ),
                BibleChapter(
                    23, "Descanso Sabático Após a Cruz", listOf(
                        BibleVerse("luk", 23, 56, "Então, se retiraram para preparar aromas e bálsamos. E, no sábado, descansaram, segundo o mandamento.")
                    )
                )
            )
        ),
        BibleBook(
            id = "jhn",
            namePt = "João",
            nameEn = "John",
            nameEs = "Juan",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    1, "O Cordeiro de Deus", listOf(
                        BibleVerse("jhn", 1, 29, "No dia seguinte, viu João a Jesus, que vinha para ele, e disse: Eis o Cordeiro de Deus, que tira o pecado do mundo!")
                    )
                ),
                BibleChapter(
                    3, "O Amor de Deus", listOf(
                        BibleVerse("jhn", 3, 16, "Porque Deus amou ao mundo de tal maneira que deu o seu Filho unigênito, para que todo o que nele crê não pereça, mas tenha a vida eterna.")
                    )
                ),
                BibleChapter(
                    5, "As Escrituras Testificam de Jesus", listOf(
                        BibleVerse("jhn", 5, 39, "Examinais as Escrituras, porque julgais ter nelas a vida eterna, e são elas mesmas que testificam de mim.")
                    )
                ),
                BibleChapter(
                    8, "A Verdade que Liberta", listOf(
                        BibleVerse("jhn", 8, 32, "E conhecereis a verdade, e a verdade vos libertará.")
                    )
                ),
                BibleChapter(
                    10, "Um Só Rebanho", listOf(
                        BibleVerse("jhn", 10, 16, "Ainda tenho outras ovelhas, não deste aprisco; a mim me convém conduzi-las; elas ouvirão a minha voz; então, haverá um rebanho e um pastor.")
                    )
                ),
                BibleChapter(
                    11, "Jesus Desperta Lázaro", listOf(
                        BibleVerse("jhn", 11, 11, "Isto dizia e depois lhes acrescentou: Nosso amigo Lázaro adormeceu, mas vou para despertá-lo."),
                        BibleVerse("jhn", 11, 25, "Disse-lhe Jesus: Eu sou a ressurreição e a vida. Quem crê em mim, ainda que morra, viverá.")
                    )
                ),
                BibleChapter(
                    14, "Promessa de Volta e Amor", listOf(
                        BibleVerse("jhn", 14, 1, "Não se turbe o vosso coração; credes em Deus, crede também em mim."),
                        BibleVerse("jhn", 14, 2, "Na casa de meu Pai há muitas moradas. Se assim não fora, eu vo-lo teria dito. Pois vou preparar-vos lugar."),
                        BibleVerse("jhn", 14, 3, "E, quando eu for e vos preparar lugar, voltarei e vos receberei para mim mesmo, para que, onde eu estou, estejais vós também."),
                        BibleVerse("jhn", 14, 15, "Se me amais, guardareis os meus mandamentos.")
                    )
                ),
                BibleChapter(
                    16, "O Espírito da Verdade", listOf(
                        BibleVerse("jhn", 16, 13, "Quando vier, porém, o Espírito da verdade, ele vos guiará a toda a verdade; porque não falará por si mesmo, mas dirá tudo o que tiver ouvido e vos anunciará as coisas que hão de vir.")
                    )
                ),
                BibleChapter(
                    17, "A Palavra é a Verdade", listOf(
                        BibleVerse("jhn", 17, 17, "Santifica-os na verdade; a tua palavra é a verdade.")
                    )
                )
            )
        ),
        BibleBook(
            id = "act",
            namePt = "Atos",
            nameEn = "Acts",
            nameEs = "Hechos",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    1, "O Poder do Espírito", listOf(
                        BibleVerse("act", 1, 8, "Mas recebereis poder, ao descer sobre vós o Espírito Santo, e sereis minhas testemunhas.")
                    )
                ),
                BibleChapter(
                    2, "Arrependimento e Batismo", listOf(
                        BibleVerse("act", 2, 38, "Respondeu-lhes Pedro: Arrependei-vos, e cada um de vós seja batizado em nome de Jesus Cristo para remissão dos vossos pecados, e recebereis o dom do Espírito Santo.")
                    )
                ),
                BibleChapter(
                    3, "Arrependimento", listOf(
                        BibleVerse("act", 3, 19, "Arrependei-vos, pois, e convertei-vos para serem cancelados os vossos pecados.")
                    )
                ),
                BibleChapter(
                    5, "Obedecer a Deus", listOf(
                        BibleVerse("act", 5, 29, "Então, Pedro e os demais apóstolos afirmaram: Antes, importa obedecer a Deus do que aos homens.")
                    )
                ),
                BibleChapter(
                    8, "Filipe e o Eunuco Etíope", listOf(
                        BibleVerse("act", 8, 26, "Um anjo do Senhor falou a Filipe, dizendo: Dispõe-te e vai para o lado do Sul, no caminho que desce de Jerusalém para Gaza; este se acha deserto."),
                        BibleVerse("act", 8, 30, "Correndo Filipe, ouviu-o ler o profeta Isaías e perguntou: Compreendes o que vens lendo?"),
                        BibleVerse("act", 8, 31, "Ele respondeu: Como poderei entender, se alguém não me explicar? E convidou Filipe a subir e a sentar-se junto a ele.")
                    )
                ),
                BibleChapter(
                    20, "Alegria em Dar", listOf(
                        BibleVerse("act", 20, 35, "Recordando as palavras do próprio Senhor Jesus: Mais bem-aventurado é dar que receber.")
                    )
                )
            )
        ),
        BibleBook(
            id = "rom",
            namePt = "Romanos",
            nameEn = "Romans",
            nameEs = "Romanos",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    3, "Justificados pela Graça", listOf(
                        BibleVerse("rom", 3, 23, "Pois todos pecaram e carecem da glória de Deus,"),
                        BibleVerse("rom", 3, 24, "sendo justificados gratuitamente, por sua graça, mediante a redenção que há em Cristo Jesus.")
                    )
                ),
                BibleChapter(
                    6, "Novidade de Vida", listOf(
                        BibleVerse("rom", 6, 4, "Fomos, pois, sepultados com ele na morte pelo batismo; para que, como Cristo foi ressuscitado dentre os mortos pela glória do Pai, assim também andemos nós em novidade de vida."),
                        BibleVerse("rom", 6, 23, "Porque o salário do pecado é a morte, mas o dom gratuito de Deus é a vida eterna em Cristo Jesus, nosso Senhor.")
                    )
                ),
                BibleChapter(
                    12, "Mente Renovada", listOf(
                        BibleVerse("rom", 12, 2, "E não vos conformeis com este século, mas transformai-vos pela renovação da vossa mente.")
                    )
                )
            )
        ),
        BibleBook(
            id = "1co",
            namePt = "1 Coríntios",
            nameEn = "1 Corinthians",
            nameEs = "1 Corintios",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    6, "Templo do Espírito Santo", listOf(
                        BibleVerse("1co", 6, 2, "Ou não sabeis que os santos hão de julgar o mundo?"),
                        BibleVerse("1co", 6, 19, "Acaso, não sabeis que o vosso corpo é santuário do Espírito Santo, que está em vós?"),
                        BibleVerse("1co", 6, 20, "Agora, pois, glorificai a Deus no vosso corpo.")
                    )
                ),
                BibleChapter(
                    9, "Sustento e Domínio Próprio", listOf(
                        BibleVerse("1co", 9, 14, "Assim ordenou também o Senhor aos que pregam o evangelho que vivam do evangelho."),
                        BibleVerse("1co", 9, 25, "Todo atleta em tudo se domina; aqueles, para alcançar uma coroa corruptível; nós, porém, a incorruptível.")
                    )
                ),
                BibleChapter(
                    10, "Tudo para Glória de Deus", listOf(
                        BibleVerse("1co", 10, 31, "Portanto, quer comais, quer bebais ou façais outra coisa qualquer, fazei tudo para a glória de Deus.")
                    )
                ),
                BibleChapter(
                    15, "A Vitória da Ressurreição", listOf(
                        BibleVerse("1co", 15, 3, "Antes de tudo, vos entreguei o que também recebi: que Cristo morreu pelos nossos pecados, segundo as Escrituras,"),
                        BibleVerse("1co", 15, 4, "e que foi sepultado e ressuscitou ao terceiro dia, segundo as Escrituras."),
                        BibleVerse("1co", 15, 52, "Num momento, num abrir e fechar de olhos, ao ressoar da última trombeta. A trombeta soará, os mortos ressuscitarão incorruptíveis, e nós seremos transformados."),
                        BibleVerse("1co", 15, 53, "Porque é necessário que este corpo corruptível se revista da incorruptibilidade, e que o corpo mortal se revista da imortalidade.")
                    )
                )
            )
        ),
        BibleBook(
            id = "2co",
            namePt = "2 Coríntios",
            nameEn = "2 Corinthians",
            nameEs = "2 Corintios",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    9, "Oferta Alegre", listOf(
                        BibleVerse("2co", 9, 7, "Cada um contribua segundo tiver proposto no coração, não com tristeza ou por necessidade; porque Deus ama a quem dá com alegria.")
                    )
                )
            )
        ),
        BibleBook(
            id = "gal",
            namePt = "Gálatas",
            nameEn = "Galatians",
            nameEs = "Gálatas",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    5, "O Fruto do Espírito", listOf(
                        BibleVerse("gal", 5, 22, "Mas o fruto do Espírito é: amor, alegria, paz, longanimidade, benignidade, bondade, fidelidade,"),
                        BibleVerse("gal", 5, 23, "mansidão, domínio próprio. Contra estas coisas não há lei.")
                    )
                )
            )
        ),
        BibleBook(
            id = "eph",
            namePt = "Efésios",
            nameEn = "Ephesians",
            nameEs = "Efesios",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    2, "Salvos pela Graça", listOf(
                        BibleVerse("eph", 2, 8, "Porque pela graça sois salvos, mediante a fé; e isto não vem de vós; é dom de Deus;"),
                        BibleVerse("eph", 2, 9, "não de obras, para que ninguém se glorie."),
                        BibleVerse("eph", 2, 10, "Pois somos feitura dele, criados em Cristo Jesus para boas obras.")
                    )
                ),
                BibleChapter(
                    5, "Cristo, Cabeça da Igreja", listOf(
                        BibleVerse("eph", 5, 23, "Porque o marido é o cabeça da mulher, como também Cristo é o cabeça da igreja, sendo este mesmo o salvador do corpo.")
                    )
                )
            )
        ),
        BibleBook(
            id = "php",
            namePt = "Filipenses",
            nameEn = "Philippians",
            nameEs = "Filipenses",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    4, "Pensamentos Nobres", listOf(
                        BibleVerse("php", 4, 8, "Finalmente, irmãos, tudo o que é verdadeiro, tudo o que é respeitável, tudo o que é justo, tudo o que é puro, tudo o que é amável, tudo o que é de boa fama, seja isso o que ocupe o vosso pensamento."),
                        BibleVerse("php", 4, 13, "Tudo posso naquele que me fortalece.")
                    )
                )
            )
        ),
        BibleBook(
            id = "col",
            namePt = "Colossenses",
            nameEn = "Colossians",
            nameEs = "Colosenses",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    2, "Sombras e Realidade em Cristo", listOf(
                        BibleVerse("col", 2, 14, "Tendo cancelado o escrito de dívida, que era contra nós e que constava de ordenanças, o qual nos era prejudicial, removeu-o inteiramente, encravando-o na cruz."),
                        BibleVerse("col", 2, 17, "Porque tudo isso tem sido sombra das coisas que haviam de vir; porém o corpo é de Cristo.")
                    )
                )
            )
        ),
        BibleBook(
            id = "1th",
            namePt = "1 Tessalonicenses",
            nameEn = "1 Thessalonians",
            nameEs = "1 Tesalonicenses",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    4, "A Esperança da Ressurreição", listOf(
                        BibleVerse("1th", 4, 16, "Porquanto o Senhor mesmo, dada a sua palavra de ordem, ouvida a voz do arcanjo, e ressoada a trombeta de Deus, descerá dos céus, e os mortos em Cristo ressuscitarão primeiro;"),
                        BibleVerse("1th", 4, 17, "depois, nós, os vivos, os que ficarmos, seremos arrebatados juntamente com eles, entre nuvens, para o encontro do Senhor nos ares, e, assim, estaremos para sempre com o Senhor.")
                    )
                )
            )
        ),
        BibleBook(
            id = "1tm",
            namePt = "1 Timóteo",
            nameEn = "1 Timothy",
            nameEs = "1 Timoteo",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    4, "Exemplo na Juventude", listOf(
                        BibleVerse("1tm", 4, 12, "Ninguém despreze a tua mocidade; pelo contrário, torna-te padrão dos fiéis, na palavra, no procedimento, no amor, na fé, na pureza.")
                    )
                )
            )
        ),
        BibleBook(
            id = "2tm",
            namePt = "2 Timóteo",
            nameEn = "2 Timothy",
            nameEs = "2 Timoteo",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    3, "Inspiração das Escrituras", listOf(
                        BibleVerse("2tm", 3, 1, "Sabe, porém, isto: nos últimos dias, sobrevirão tempos difíceis,"),
                        BibleVerse("2tm", 3, 16, "Toda a Escritura é inspirada por Deus e útil para o ensino, para a repreensão, para a correção, para a educação na justiça,"),
                        BibleVerse("2tm", 3, 17, "a fim de que o homem de Deus seja perfeito e perfeitamente habilitado para toda boa obra.")
                    )
                )
            )
        ),
        BibleBook(
            id = "heb",
            namePt = "Hebreus",
            nameEn = "Hebrews",
            nameEs = "Hebreos",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    8, "Nosso Sumo Sacerdote", listOf(
                        BibleVerse("heb", 8, 1, "Ora, o essencial das coisas que temos dito é que possuímos tal sumo sacerdote, que se assentou à destra do trono da Majestade nos céus,"),
                        BibleVerse("heb", 8, 2, "como ministro do santuário e do verdadeiro tabernáculo que o Senhor erigiu, não o homem.")
                    )
                ),
                BibleChapter(
                    9, "Cristo no Santuário Celestial", listOf(
                        BibleVerse("heb", 9, 24, "Porque Cristo não entrou em santuário feito por mãos, figura do verdadeiro, porém no mesmo céu, para comparecer, agora, por nós, diante de Deus.")
                    )
                ),
                BibleChapter(
                    11, "A Certeza da Fé", listOf(
                        BibleVerse("heb", 11, 1, "Ora, a fé é a certeza de coisas que se esperam, a convicção de fatos que se não veem.")
                    )
                )
            )
        ),
        BibleBook(
            id = "1pe",
            namePt = "1 Pedro",
            nameEn = "1 Peter",
            nameEs = "1 Pedro",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    2, "Sacerdócio Real", listOf(
                        BibleVerse("1pe", 2, 9, "Vós, porém, sois raça eleita, sacerdócio real, nação santa, povo de propriedade exclusiva de Deus, a fim de proclamardes as virtudes daquele que vos chamou das trevas para a sua maravilhosa luz.")
                    )
                )
            )
        ),
        BibleBook(
            id = "2pe",
            namePt = "2 Pedro",
            nameEn = "2 Peter",
            nameEs = "2 Pedro",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    1, "Inspiração Profética", listOf(
                        BibleVerse("2pe", 1, 21, "Porque nunca jamais qualquer profecia foi dada por vontade humana; entretanto, homens santos falaram da parte de Deus, movidos pelo Espírito Santo.")
                    )
                )
            )
        ),
        BibleBook(
            id = "1jn",
            namePt = "1 João",
            nameEn = "1 John",
            nameEs = "1 Juan",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    1, "Perdão e Comunhão", listOf(
                        BibleVerse("1jn", 1, 9, "Se confessarmos os nossos pecados, ele é fiel e justo para nos perdoar os pecados e nos purificar de toda injustiça.")
                    )
                ),
                BibleChapter(
                    2, "Nosso Advogado", listOf(
                        BibleVerse("1jn", 2, 1, "Filhinhos meus, estas coisas vos escrevo para que não pequeis. Se, todavia, alguém pecar, temos Advogado junto ao Pai, Jesus Cristo, o Justo.")
                    )
                )
            )
        ),
        BibleBook(
            id = "rev",
            namePt = "Apocalipse",
            nameEn = "Revelation",
            nameEs = "Apocalipsis",
            testament = "NT",
            chapters = listOf(
                BibleChapter(
                    1, "Todo Olho o Verá", listOf(
                        BibleVerse("rev", 1, 7, "Eis que vem com as nuvens, e todo olho o verá, até quantos o traspassaram.")
                    )
                ),
                BibleChapter(
                    12, "O Grande Conflito", listOf(
                        BibleVerse("rev", 12, 7, "Houve peleja no céu. Miguel e os seus anjos pelejaram contra o dragão."),
                        BibleVerse("rev", 12, 17, "Irou-se o dragão contra a mulher e foi pelejar com os restantes da sua descendência, os que guardam os mandamentos de Deus e têm o testemunho de Jesus.")
                    )
                ),
                BibleChapter(
                    14, "A Mensagem dos Três Anjos", listOf(
                        BibleVerse("rev", 14, 6, "Vi outro anjo voando pelo meio do céu, tendo um evangelho eterno para pregar aos que se assentam sobre a terra."),
                        BibleVerse("rev", 14, 7, "Temei a Deus e dai-lhe glória, pois é chegada a hora do seu juízo; e adorai aquele que fez o céu, e a terra, e o mar, e as fontes das águas."),
                        BibleVerse("rev", 14, 12, "Aqui está a perseverança dos santos, os que guardam os mandamentos de Deus e a fé em Jesus.")
                    )
                ),
                BibleChapter(
                    19, "O Espírito da Profecia", listOf(
                        BibleVerse("rev", 19, 10, "Adora a Deus. Pois o testemunho de Jesus é o espírito da profecia.")
                    )
                ),
                BibleChapter(
                    20, "O Milênio", listOf(
                        BibleVerse("rev", 20, 1, "Então, vi descer do céu um anjo trazendo na mão a chave do abismo e uma grande corrente."),
                        BibleVerse("rev", 20, 4, "Vi também tronos, e nestes sentaram-se aqueles aos quais foi dada autoridade de julgar... e viveram e reinaram com Cristo durante mil anos."),
                        BibleVerse("rev", 20, 7, "Quando, porém, se completarem os mil anos, Satanás será solto da sua prisão.")
                    )
                ),
                BibleChapter(
                    21, "Novos Céus e Nova Terra", listOf(
                        BibleVerse("rev", 21, 1, "Vi novo céu e nova terra, pois o primeiro céu e a primeira terra passaram."),
                        BibleVerse("rev", 21, 4, "E lhes enxugará dos olhos toda lágrima, e a morte já não existirá, já não haverá luto, nem pranto, nem dor, porque as primeiras coisas passaram.")
                    )
                ),
                BibleChapter(
                    22, "O Rio da Vida e a Integridade da Palavra", listOf(
                        BibleVerse("rev", 22, 1, "Então, me mostrou o rio da água da vida, brilhante como cristal, que sai do trono de Deus e do Cordeiro."),
                        BibleVerse("rev", 22, 2, "De um e de outro lado do rio, está a árvore da vida, que produz doze frutos, dando o seu fruto de mês em mês."),
                        BibleVerse("rev", 22, 18, "Eu, a todo aquele que ouve as palavras da profecia deste livro, testifico: Se alguém lhes fizer qualquer acréscimo, Deus lhe acrescentará os flagelos escritos neste livro;"),
                        BibleVerse("rev", 22, 19, "e, se alguém tirar qualquer coisa das palavras do livro desta profecia, Deus tirará a sua parte da árvore da vida, da cidade santa e das coisas que se acham escritas neste livro."),
                        BibleVerse("rev", 22, 20, "Aquele que dá testemunho destas coisas diz: Certamente, venho sem demora. Amém! Vem, Senhor Jesus!")
                    )
                )
            )
        )
    )

    fun bookName(book: BibleBook, lang: AppLanguage): String = when (lang) {
        AppLanguage.PT -> book.namePt
        AppLanguage.EN -> book.nameEn
        AppLanguage.ES -> book.nameEs
    }

    fun getBook(bookId: String): BibleBook =
        books.firstOrNull { it.id == bookId } ?: books.first()

    fun findPassageText(ref: KeyVerseRef): String {
        val book = books.firstOrNull { it.id == ref.bookId } ?: return ref.excerpt
        val chapter = book.chapters.firstOrNull { it.chapterNumber == ref.chapter } ?: return ref.excerpt
        val end = ref.endVerse ?: ref.verse
        val matching = chapter.verses.filter { it.verse in ref.verse..end }
        return if (matching.isNotEmpty()) {
            matching.joinToString(" ") { "(${it.verse}) ${it.text}" }
        } else {
            ref.excerpt
        }
    }

    fun searchVerses(query: String, lang: AppLanguage): List<Pair<String, BibleVerse>> {
        val trimmed = query.trim()
        if (trimmed.isBlank()) return emptyList()
        val results = mutableListOf<Pair<String, BibleVerse>>()
        for (book in books) {
            val name = bookName(book, lang)
            val bookMatches = name.contains(trimmed, ignoreCase = true)
            for (chapter in book.chapters) {
                for (verse in chapter.verses) {
                    if (bookMatches || verse.text.contains(trimmed, ignoreCase = true)) {
                        results.add("$name ${chapter.chapterNumber}:${verse.verse}" to verse)
                    }
                }
            }
        }
        return results.take(40)
    }
}
