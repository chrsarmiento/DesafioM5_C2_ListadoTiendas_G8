package com.desafiolatam.listadodetiendas.data

import com.desafiolatam.listadodetiendas.model.Store
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.withContext

class StoreRepository {

    private var listStore = listOf<Store>()

    suspend fun getStoreList(): Flow<List<Store>> {
        val response = withContext(Dispatchers.IO) {
            for (i in 0..9) {
                delay(100L)
            }

            listOf(
                Store(
                    id = 1,
                    name = "Cicero Store",
                    address = "Colosseum, Piazza del Colosseo, 1, 00184 Roma RM, Italy",
                    officeHours = "Lunes a Viernes desde las 9:00 a las 18:30, Sábados y Domingos abierto desde las 10:30 a las 15:30",
                    photo = "https://images.pexels.com/photos/2566085/pexels-photo-2566085.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                    history = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt."
                ),
                Store(
                    id = 2,
                    name = "Li Europan lingues",
                    address = "Panthéon, Pl. du Panthéon, 75005 Paris, France",
                    officeHours = "Lunes a Viernes desde las 9:00 a las 18:30, fines de semana cerrado",
                    photo = "https://images.pexels.com/photos/5611543/pexels-photo-5611543.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                    history = "Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser plu simplic e regulari quam li existent Europan lingues"
                ),
                Store(
                    id = 3,
                    name = "Relojeria Kafka",
                    address = "Prague Astronomical Clock, Staroměstské nám. 1, 110 00 Josefov, Czechia",
                    officeHours = "Lunes a Viernes desde las 9:00 a las 18:30, fines de semana cerrado",
                    photo = "https://images.pexels.com/photos/2260827/pexels-photo-2260827.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                    history = "One morning, when Gregor Samsa woke from troubled dreams, he found himself transformed in his bed into a horrible vermin. He lay on his armour-like back, and if he lifted his head a little he could see his brown belly, slightly domed and divided by arches into stiff sections. The bedding was hardly able to cover it and seemed ready to slide off any moment. His many legs, pitifully thin compared with the size of the rest of him, waved about helplessly as he looked"
                ),
                Store(
                    id = 4,
                    name = "Love Craft Arts",
                    address = "Lovecraft Arts & Sciences, 65 Weybosset St, Providence, RI 02903, United States",
                    officeHours = "Lunes a Viernes desde las 9:00 a las 18:30",
                    photo = "https://images.pexels.com/photos/2482128/pexels-photo-2482128.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                    history = "We saw, as I have said, certain obstructions on the polished floor ahead; and I may add that our nostrils were assailed almost simultaneously by a very curious intensification of the strange prevailing fetor, now quite plainly mixed with the nameless stench of those others which had gone before. The light of the second torch left no doubt of what the obstructions were, and we dared approach them only because we could see, even from a distance, that they were quite as past all harming power as had been the six similar specimens unearthed from the monstrous star-mounded graves at poor Lake's camp."
                ),
                Store(
                    id = 5,
                    name = "The Ancient Mariner",
                    address = "Public Art: The Ancient Mariner, 11 The Esplanade, Watchet TA23 0AH, United Kingdom",
                    officeHours = "Lunes a Viernes desde las 9:00 a las 18:30",
                    photo = "https://images.pexels.com/photos/2261199/pexels-photo-2261199.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                    history = "Day after day, day after day, We stuck, nor breath nor motion; As idle as a painted ship Upon a painted ocean. Water, water, every where, And all the boards did shrink; Water, water, every where, Nor any drop to drink. The very deep did rot: O Christ! That ever this should be! Yea, slimy things did crawl with legs Upon the slimy sea. About, about, in reel and rout The death-fires danced at night; The water, like a witch's oils, Burnt green, and blue and white. And some in dreams assurèd were Of the Spirit that plagued us so; Nine fathom deep he had followed us From the land of mist and snow."
                ),
                Store(
                    id = 6,
                    name = "Just Another Store",
                    address = "The Little Mermaid, Langelinie, 2100 København Ø, Denmark",
                    officeHours = "Lunes a Viernes desde las 9:00 a las 18:30",
                    photo = "https://images.pexels.com/photos/2484847/pexels-photo-2484847.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                    history = "Madame Duval, encouraged by this success, looked around her with an air of triumph, and continued her harangue. \"And so, Sir, I suppose you thought to have had it all your own way, and to have comed here as often as you pleased, and to have got me to Howard Grove again, on purpose to have served me as you did before; but you shall see I'm as cunning as you; so you may go and find somebody else to use in that manner, and to put your mask on, and to make a fool of; for as to me, if you go to tell me your stories about the Tower again, for a month together, I'll never believe 'm no more: and I'll promise you, Sir, if you think I like such jokes, you'll find I'm no such person.\""
                ),
                Store(
                    id = 7,
                    name = "The Night Watch",
                    address = "Big Ben, London SW1A 0AA, United Kingdom",
                    officeHours = "Lunes a Viernes desde las 9:00 a las 18:30",
                    photo = "https://images.pexels.com/photos/2563411/pexels-photo-2563411.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                    history = "It was curious to observe the effect which his embarrassment, added to the freedom with which Madame Duval addressed him, had upon the rest of the company. Every one, who before seemed at a loss how or if at all, to occupy a chair, how filled it with the most easy composure: and Mr. Smith, whose countenance had exhibited the most striking picture of mortified envy, now began to recover his usual expression of satisfied conceit. Young Branghton, too, who had been apparently awed by the presence of so fine a gentleman, was again himself, rude and familiar: while his mouth was wide distended into a broad grin, at hearing his aunt give the beau such a trimming."
                ),
                Store(
                    id = 8,
                    name = "The Ugly Comet",
                    address = "The Great Pyramid of Giza, Al Haram, Nazlet El-Semman, Al Giza Desert, Giza Governorate 3512201, Egypt",
                    officeHours = "Lunes a Viernes desde las 9:00 a las 18:30",
                    photo = "https://images.pexels.com/photos/1730839/pexels-photo-1730839.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                    history = "Every scrap of paper was gone, and with it all my notes, my memoranda, relating to railways and travel, my letter of credit, in fact all that might be useful to me were I once outside the castle. I sat and pondered awhile, and then some thought occurred to me, and I made search of my portmanteau and in the wardrobe where I had placed my clothes."
                ),
                Store(
                    id = 9,
                    name = "Ark Store",
                    address = "Great Wall of China, Huai Rou Qu, China, 101406",
                    officeHours = "Lunes a Viernes desde las 9:00 a las 18:30",
                    photo = "https://images.pexels.com/photos/2146993/pexels-photo-2146993.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                    history = "\"The letter to Hawkins--that I shall, of course, send on, since it is yours. Your letters are sacred to me. Your pardon, my friend, that unknowingly I did break the seal. Will you not cover it again?\" He held out the letter to me, and with a courteous bow handed me a clean envelope. I could only redirect it and hand it to him in silence. When he went out of the room I could hear the key turn softly. A minute later I went over and tried it, and the door was locked."
                ),
                Store(
                    id = 10,
                    name = "Lucy Antique Shop",
                    address = "Hallstättersee Schifffahrt GmbH, Am Hof 126, 4830 Hallstatt, Austria",
                    officeHours = "Lunes a Viernes desde las 9:00 a las 18:30",
                    photo = "https://images.pexels.com/photos/3894579/pexels-photo-3894579.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
                    history = "This was brought to the lawyer the next morning, before he was out of bed; and he had no sooner seen it and been told the circumstances, than he shot out a solemn lip. “I shall say nothing till I have seen the body,” said he; “this may be very serious. Have the kindness to wait while I dress.” And with the same grave countenance he hurried through his breakfast and drove to the police station, whither the body had been carried. As soon as he came into the cell, he nodded."
                ),
            )
        }
        listStore = response
        return flowOf(response)
    }

    suspend fun getStoreById(id: Int) : StateFlow<Store?> {
        val data: MutableStateFlow<Store?> = MutableStateFlow(null)
        getStoreList().collect() {
            list -> val store = list.find {
                it.id == id
            }
            data.value = store
        }
        return data
    }

}