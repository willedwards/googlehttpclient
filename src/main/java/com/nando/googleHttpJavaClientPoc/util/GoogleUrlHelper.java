package com.nando.googleHttpJavaClientPoc.util;

import com.google.api.client.http.HttpResponse;
import com.nando.googleHttpJavaClientPoc.Note;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: wge
 * Date: 26/12/2014
 * Time: 14:19
 */

public class GoogleUrlHelper<T>
{
    static class NotesList {
		/** We have to do it this way due to the service using an anonymous list */
		@SuppressWarnings("serial")
		public static class List extends ArrayList<Note> {
		}
	}

    public static class NotesList2<T> {
		/** We have to do it this way due to the service using an anonymous list */
		@SuppressWarnings("serial")
		public static class List<T> extends ArrayList<T>
        {
		}
	}

	public static <T> List<T> parseManyResponse(HttpResponse response) throws IOException
    {
		return (List<T>)response.parseAs(NotesList.List.class);
	}

    public static <T> T   parseOneResponse(HttpResponse response, Class clazz) throws IOException {
		return (T)response.parseAs(clazz);
	}


}
