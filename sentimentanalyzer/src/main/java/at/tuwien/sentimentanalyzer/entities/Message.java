package at.tuwien.sentimentanalyzer.entities;

import java.util.Date;

import org.apache.camel.Converter;
import org.apache.log4j.Logger;

/**
 * All messages, tweets, posts, whatever, will be aggregated to this format
 * @author CLF
 *
 */
@Converter
public class Message {
	public static Logger log = Logger.getLogger(Message.class);
	
	@Override
	public String toString() {
		return "Message [message=" + message + ", author=" + author
				+ ", timePosted=" + timePosted + ", source=" + source + "]";
	}
	/**
	 * The content of the message (e.g. a tweet, a fecebook post, ...)
	 */
	private String message;
	/**
	 * The author of the message
	 */
	private String author;
	/**
	 * When was the message posted
	 */
	private Date timePosted;
	/**
	 * From which source did the message come from? (twitter, facebook, reddit, ...)
	 * Since i do not know which sources we will have i leave this as String
	 */
	private String source;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getTimePosted() {
		return timePosted;
	}
	public void setTimePosted(Date timePosted) {
		this.timePosted = timePosted;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
}