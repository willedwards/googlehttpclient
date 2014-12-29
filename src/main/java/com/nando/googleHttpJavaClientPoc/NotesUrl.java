package com.nando.googleHttpJavaClientPoc;/**
 * Author: wge
 * Date: 20/12/2014
 * Time: 21:47
 */

import com.google.api.client.http.GenericUrl;

class NotesUrl extends GenericUrl
{

    private static final String NOTES_BASE_URL = "http://private-anon-072adbda5-gaetest.apiary-mock.com/notes";

    public NotesUrl(String encodedUrl) {
        super(encodedUrl);
    }

    /** GET ALL */
    public static NotesUrl listAllNotes() {
        return new NotesUrl(NOTES_BASE_URL);
    }

    /** GET ONE */
    public static NotesUrl getNote(Integer id) {
        return new NotesUrl(NOTES_BASE_URL+"/"+id);
    }

    /** POST ONE */
    public static NotesUrl createNote() {
        return new NotesUrl(NOTES_BASE_URL);
    }

    /** PUT ONE */
    public static NotesUrl updateNote() {
        return new NotesUrl(NOTES_BASE_URL);
    }

    /** DELETE ONE */
    public static NotesUrl deleteNote(Integer id) {
        return new NotesUrl(NOTES_BASE_URL+"/"+id);
    }

}
