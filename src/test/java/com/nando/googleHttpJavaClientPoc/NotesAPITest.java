package com.nando.googleHttpJavaClientPoc;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

@Deprecated
public class NotesAPITest
{

	@Test
	public void testGetAllNotes() {
		try {

			NotesAPI notesApi = new NotesAPI();

			List<Note> notesList = notesApi.getAllNotes();

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

			NotesAPI notesApi = new NotesAPI();
			
			Note note = notesApi.getNote(1);

			System.out.println(note.toString());

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());			
		}
	}
	
	@Test
	public void testCreateNote() {
		try {

			NotesAPI notesApi = new NotesAPI();
			
			Note newNote = new Note(15, "Title 15");

			Note createdNote = notesApi.createNote(newNote);

			System.out.println(createdNote);	

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());			
		}
	}
	
	@Test
	public void testUpdateNote() {
		try {

			NotesAPI notesApi = new NotesAPI();
			
			Note tobeUpdatedNote = new Note(15, "Title 15");

			notesApi.updateNote(tobeUpdatedNote);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());			
		}
	}
	
	@Test
	public void testDeleteNote() {
		try {

			NotesAPI notesApi = new NotesAPI();
			
			Note toBeDeletedNote = new Note(15, "Title 15");

			notesApi.deleteNote(toBeDeletedNote);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());			
		}
	}
}
