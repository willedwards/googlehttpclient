package com.nando.googleHttpJavaClientPoc;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;

import java.io.IOException;
import java.util.List;

@Deprecated
public class NotesAPI
{


    public List<Note> getAllNotes() throws IOException {
		HttpRequest request = HttpRequestHelper.buildGETRequest(NotesUrl.listAllNotes());
        HttpResponse response = request.execute();
        List<Note> notes =  response.parseAs(NotesList.List.class);
		return notes;
	}
	
	public Note getNote(Integer id) throws IOException {
		HttpRequest request = HttpRequestHelper.buildGETRequest(NotesUrl.getNote(id));
		return parseOneResponse(request.execute());
	}
	
	public Note createNote(Note note) throws IOException {
		HttpRequest request =  HttpRequestHelper.buildPOSTRequest(NotesUrl.createNote(), note);
		return parseOneResponse(request.execute());
	}

	public void updateNote(Note note) throws IOException {
		HttpRequestHelper.buildPUTRequest(NotesUrl.updateNote(), note);
	}
	
	public void deleteNote(Note note) throws IOException {
		HttpRequestHelper.buildDeleteRequest(NotesUrl.deleteNote(note.getId()));
	}

    private static <T> T   parseOneResponse(HttpResponse response) throws IOException {
		return (T)response.parseAs(Note.class);
	}
}
