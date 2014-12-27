package com.nando.googleHttpJavaClientPoc;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public class Note extends GenericJson {
	
	@Key
	private Integer id;
	
	@Key
	private String title;

	public Note() {
	}
	
	public Note(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + "]";
	}
	
}
