package com.pharmaweb.admin;

/**
 * 
 * @author Anthony DENAUD
 *
 */
public class Message {
	private String title;
	private String Style;
	private String text;
	
	
	public Message() {
		super();
	}
	
	public Message(String title, String style, String text) {
		super();
		this.title = title;
		Style = style;
		this.text = text;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStyle() {
		return Style;
	}
	public void setStyle(String style) {
		Style = style;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
