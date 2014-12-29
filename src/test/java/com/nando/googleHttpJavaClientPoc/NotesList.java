package com.nando.googleHttpJavaClientPoc;

import java.util.ArrayList;

@Deprecated
public class NotesList {
    /** We have to do it this way due to the service using an anonymous list */
		@SuppressWarnings("serial")
		public static class List extends ArrayList<Note>
        {
		}
	}
