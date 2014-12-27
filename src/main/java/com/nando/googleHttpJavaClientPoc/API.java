package com.nando.googleHttpJavaClientPoc;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;

import java.io.IOException;
import java.util.List;

public class API
{
    private static GoogleUrlHelper<Note> helper = new GoogleUrlHelper();


	public List<Note> getAllNotes() throws IOException {
		HttpRequest request = HttpRequestHelper.buildGETRequest(NotesUrl.listAllNotes());
        HttpResponse response = request.execute();
        //ends up with ArrayMap.
        List<Note> notes =  (List<Note>)response.parseAs(GoogleUrlHelper.NotesList2.List.class);
		return notes;
	}

    public List<Note> getAllNotesWorks() throws IOException {
		HttpRequest request = HttpRequestHelper.buildGETRequest(NotesUrl.listAllNotes());
        HttpResponse response = request.execute();
        List<Note> notes =  (List<Note>)response.parseAs(GoogleUrlHelper.NotesList.class);
		return notes;
	}
	
	public Note getNote(Integer id) throws IOException {
		HttpRequest request = HttpRequestHelper.buildGETRequest(NotesUrl.getNote(id));
		return GoogleUrlHelper.parseOneResponse(request.execute(), Note.class);
	}
	
	public Note createNote(Note note) throws IOException {
		HttpRequest request =  HttpRequestHelper.buildPOSTRequest(NotesUrl.createNote(), note);
		return GoogleUrlHelper.parseOneResponse(request.execute(), Note.class);
	}

	public void updateNote(Note note) throws IOException {
		HttpRequestHelper.buildPUTRequest(NotesUrl.updateNote(), note);
	}
	
	public void deleteNote(Note note) throws IOException {
		HttpRequestHelper.buildDeleteRequest(NotesUrl.deleteNote(note.getId()));
	}


}
