package at.tuwien.sentimentanalyzer.beans;

import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;

import at.tuwien.sentimentanalyzer.entities.Message;
import at.tuwien.sentimentanalyzer.entities.reddit.Children;
import at.tuwien.sentimentanalyzer.entities.reddit.Data;
import at.tuwien.sentimentanalyzer.entities.reddit.RedditMessage;

public class RedditConvertor {
	public static Logger log = Logger.getLogger(RedditConvertor.class);
	/**
	 * @author LG
	 */
	public Message getMessage(RedditMessage redditMessage){
		
		Message msg = new Message();
		
		List<Children> children = redditMessage.getData().getChildren();
		for(Children child: children){
			if(child==null){
				System.out.println("Child is null..");
			} else{
				Data secondData = child.getData();
				System.out.println("Title: " + secondData.getTitle());
				System.out.println("Created: " + secondData.getCreated());
				String created = secondData.getCreated();
				
				created = created.substring(0, created.indexOf('.'));
				long epoch = Long.parseLong(created);
				Date date = new Date(epoch*1000);
				
				if(secondData.getTitle()!=null){
					msg.setMessage(secondData.getTitle());
				}
				
				if(date!=null){
					msg.setTimePosted(date);
				}
				msg.setSource("Reddit");

				if(secondData.getAuthor()!=null){
					msg.setAuthor(secondData.getAuthor());
				}
				
				
			}
			
		}
	
		log.info("Reddit message: " + msg);
		return msg;
	}
	

	
	

}