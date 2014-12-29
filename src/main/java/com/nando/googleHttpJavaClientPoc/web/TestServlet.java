package com.nando.googleHttpJavaClientPoc.web;

import com.nando.googleHttpJavaClientPoc.API;
import com.nando.googleHttpJavaClientPoc.Note;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
public class TestServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		resp.getWriter().println("<table border=\"1\">");
		resp.getWriter().println("<tr><th>Function</th><th>Result</th></tr>");
		
		API api = new API();
		
		
		resp.getWriter().println("<tr><td>Get all notes</td><td>");
		try {
			List<Note> notesList = api.getAllNotes();
			for (Note note : notesList) {
				resp.getWriter().println(note.toString()+"</br>");
			}
		} catch (Exception e) {
			resp.getWriter().println("Error: "+e.getMessage());
		}
		resp.getWriter().println("</td></tr>");
		
		
		resp.getWriter().println("<tr><td>Get one note</td><td>");
		try {
			Note note = api.getNote(1);
			resp.getWriter().println(note.toString());
		} catch (Exception e) {
			resp.getWriter().println("Error: "+e.getMessage());
		}
		resp.getWriter().println("</td></tr>");		

				
		resp.getWriter().println("<tr><td>Create note</td><td>");
		try {
			Note newNote = new Note(15, "Title 15");
			Note createdNote = api.createNote(newNote);
			resp.getWriter().println(createdNote.toString());
		} catch (Exception e) {
			resp.getWriter().println("Error: "+e.getMessage());
		}
		resp.getWriter().println("</td></tr>");		

		
		resp.getWriter().println("<tr><td>Update note</td><td>");
		try {
			Note tobeUpdatedNote = new Note(15, "Title 11235");
			api.updateNote(tobeUpdatedNote);
			resp.getWriter().println("OK");
		} catch (Exception e) {
			resp.getWriter().println("Error: "+e.getMessage());
		}
		resp.getWriter().println("</td></tr>");		
		
		
		resp.getWriter().println("<tr><td>Delete note</td><td>");
		try {
			Note toBeDeletedNote = new Note(15, "Title 15");
			api.deleteNote(toBeDeletedNote);
			resp.getWriter().println("OK");
		} catch (Exception e) {
			resp.getWriter().println("Error: "+e.getMessage());
		}
		resp.getWriter().println("</td></tr>");	
		
		
		resp.getWriter().println("</table>");
	}
}
