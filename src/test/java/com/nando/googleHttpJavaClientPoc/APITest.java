package com.nando.googleHttpJavaClientPoc;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class APITest
{

	@Test
	public void testGetAllNotes() {
		try {

			API api = new API();

			List<Note> notesList = api.getAllNotes();

			for (Note note : notesList) {
				System.out.println(note.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());			
		}
	}
	
	@Test
	public void testGetNote() {
		try {

			API api = new API();
			
			Note note = api.getNote(1);

			System.out.println(note.toString());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());			
		}
	}
	
	@Test
	public void testCreateNote() {
		try {

			API api = new API();
			
			Note newNote = new Note(15, "Title 15");

			Note createdNote = api.createNote(newNote);

			System.out.println(createdNote);	

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());			
		}
	}
	
	@Test
	public void testUpdateNote() {
		try {

			API api = new API();
			
			Note tobeUpdatedNote = new Note(15, "Title 15");

			api.updateNote(tobeUpdatedNote);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());			
		}
	}
	
	@Test
	public void testDeleteNote() {
		try {

			API api = new API();
			
			Note toBeDeletedNote = new Note(15, "Title 15");

			api.deleteNote(toBeDeletedNote);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());			
		}
	}
}
