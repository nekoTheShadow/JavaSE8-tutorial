package chapter8.question15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class Question15 {
	public static void main(String[] args) throws IOException {
		var file = Paths.get("war-and-peace.txt");
		var pattern = Pattern.compile("^After");
		Files.lines(file).filter(pattern.asPredicate()).forEach(System.out::println);
	}
}

/*
After receiving her visitors, the countess was so tired that she gave
After Anna Mikhaylovna had driven off with her son to visit Count Cyril
After a few minutes' bustle beside the high bedstead, those who had
After inspecting the carriage himself and seeing the trunks put in, he
After washing and dressing, Prince Andrew came into the diplomat's
After his journey and the campaign during which he had been deprived of
After the fatigues and impressions of the journey, his reception, and
After a while the moving mass became agitated, someone rode past on a
After supper Pierre with his partner followed the others into the
After dinner, he went to see his daughter-in-law. The little princess
After tea, the company went into the sitting room and Princess Mary was
After his illness he looked rather thinner that day than on the field of
After passing some Austrian troops he noticed that the next part of the
After five o'clock it was only at the Augesd Dam that a hot cannonade
After looking at him Napoleon smiled.
After receiving this news late in the evening, when he was alone in his
After a while he re-entered it as if to snuff the candles, and, seeing
After Denisov's departure, Rostov spent another fortnight in Moscow,
After his interview with his wife Pierre left for Petersburg. At the
After these words, the Mason, as if tired by his long discourse, again
After that they took his right hand, placed it on something, and told
After that Anna Pavlovna led up to the courage and firmness of the King
After the Austerlitz campaign Prince Andrew had firmly resolved not
After his losses, he had determined to pay back his debt to his parents
After this Prince Andrew was conducted to the door and the officer on
After the first feeling of perplexity aroused in the parents by Berg's
After Prince Andrew, Boris came up to ask Natasha for a dance, and then
After dinner Speranski's daughter and her governess rose. He patted the
After dinner Natasha, at Prince Andrew's request, went to the clavichord
After six rubbers the general got up, saying that it was no use playing
After long hesitations, doubts, and prayers, Princess Mary gave the
After this outburst the prince did not speak any more about the matter.
After the rapture of meeting, and after that odd feeling of unsatisfied
After reaching home Nicholas was at first serious and even dull. He was
After listening a few moments in silence, the count and his attendant
After a while "Uncle" came in, in a Cossack coat, blue trousers, and
After supper, over their cherry brandy, Rostov and "Uncle" talked of
After nine o'clock two traps and three mounted men, who had been sent
After tea, Nicholas, Sonya, and Natasha went to the sitting room, to
After the condescending surprise, nonrecognition, and praise, from those
After Russian country dances and chorus dances, Pelageya Danilovna made
After Nicholas had gone things in the Rostov household were more
After Prince Andrews engagement to Natasha, Pierre without any apparent
After Metivier's departure the old prince called his daughter in, and
After the roast, champagne was served. The guests rose to congratulate
After her life in the country, and in her present serious mood, all this
After Mass, when they had finished their coffee in the dining room
After she had gone, a dressmaker from Madame Suppert-Roguet waited
After the first monologue the whole company rose and surrounded
After giving several recitations, Mademoiselle George left, and Countess
After reaching home Natasha did not sleep all night. She was tormented
After breakfast, which was her best time, Marya Dmitrievna sat down in
After reading the letter Natasha sat down at the writing table to answer
After dinner Natasha went to her room and again took up Princess Mary's
After tea Sonya noticed a housemaid at Natasha's door timidly waiting
After taking a turn along the Podnovinski Boulevard, Balaga began to
After a moment's silence Natasha answered: "Yes, ill."
After hearing the details of Anatole's marriage from Pierre, and giving
After a few words to Pierre about the awful roads from the Polish
After living at the seat of the highest authority and power, after
After four days of solitude, ennui, and consciousness of his impotence
After some minutes, the gentleman-in-waiting who was on duty came into
After saying all he had been instructed to say, Balashev added that
After all that Napoleon had said to him--those bursts of anger and the
After dinner they went to drink coffee in Napoleon's study, which four
After his interview with Pierre in Moscow, Prince Andrew went to
After Ostermann had gone, a command rang out to the Uhlans.
After those involuntary words--that if he were free he would have asked
After dinner the count settled himself comfortably in an easy chair and
After reading about the dangers that threatened Russia, the hopes the
After the definite refusal he had received, Petya went to his room
After that Princess Mary did not see her father for a whole week. He was
After giving the clerk orders about the work to be done, Alpatych, not
After Smolensk Napoleon sought a battle beyond Dorogobuzh at Vyazma, and
After the return of Alpatych from Smolensk the old prince suddenly
After her father's funeral Princess Mary shut herself up in her room and
After sunset the wind had dropped. The night was calm and fresh. Toward
After the hussars had come to the village and Rostov had gone to see the
After hearing the matter, Kutuzov smacked his lips together and shook
After the Emperor had left Moscow, life flowed on there in its usual
After the loss of the Shevardino Redoubt, we found ourselves on the
After Kaysarov, others whom Pierre knew came up to him, and he had not
After he had returned, voices were heard outside the shed. "Who's that?"
After breakfast Napoleon in de Beausset's presence dictated his order of
After giving these and other commands he returned to his tent, and the
After the advance has begun in this manner, orders will be given in
After hearing him, Kutuzov said in French:
After the sufferings he had been enduring, Prince Andrew enjoyed a
After that the generals began to disperse with the solemnity and
After the battle of Borodino the abandonment and burning of Moscow was
After that a long-frocked abbe was brought to her. She confessed to
Afterwards when he recalled those thoughts Pierre was convinced that
After Petya had joined Obolenski's regiment of Cossacks and left for
After dinner the whole Rostov household set to work with enthusiastic
After the last two days spent in solitude and unusual circumstances,
Afterwards when he had received a name and wealth he dared not think of
After a short silence the countess spoke again but this time no one
After growing confused from pain while being carried into the hut he
After arranging his clothes, he took the pistol and was about to go out.
After dining and taking rather too much of the Hungarian wine,
After a few words about Princess Mary and her late father, whom
After meeting Princess Mary, though the course of his life went on
After the execution Pierre was separated from the rest of the prisoners
After a short silence he rose.
After that he avoided Dessalles and the countess who caressed him and
After the French victory at Borodino there was no general engagement nor
After the burning of Smolensk a war began which did not follow any
After talking for some time with the esaul about next day's attack,
After that Petya remained silent for a long time, listening to the
After speaking to the senior French officer, who came out of the house
After the second day's march Pierre, having examined his feet by the
After the twenty-eighth of October when the frosts began, the flight of
After staggering into Smolensk which seemed to them a promised land, the
After Prince Andrew's death Natasha and Princess Mary alike felt this.
After she felt herself deserted by Princes Mary and alone in her grief,
After the encounter at Vyazma, where Kutuzov had been unable to hold
After the junction with the army of the brilliant admiral and Petersburg
After Pierre's departure that first evening, when Natasha had said to
After her visit to the Rostovs and her unexpectedly chilly reception by
After that, when in discussions with his village elders or stewards the
After seven years of marriage Pierre had the joyous and firm
After the deaths of her son and husband in such rapid succession, she
After supper Nicholas, having undressed in his study and given
Afterwards in the evening when I gave him his ticket, he again began
*/