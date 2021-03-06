package at.tuwien.sentimentanalyzer.beans;

import java.util.HashMap;

import at.tuwien.sentimentanalyzer.entities.Message;

/*
 * Author: Serafima
 */

public class WordCounter {

	public Message CountWords(Message message) {

		HashMap<String, Integer> countableWords = new HashMap<String, Integer>();
		
		
			for(String word : message.getMessage().toLowerCase().split(" ")){
				if (word.contains("_NN") || word.contains("_VB") || word.contains("_JJ") || word.contains("_RB")) {
					if(countableWords.containsKey(word)){
						countableWords.put(word, countableWords.get(word) + 1);
					}else{
						countableWords.put(word,1);
					}
				}
			}
		message.setWordcounts(countableWords);
		return message;
	}

}
