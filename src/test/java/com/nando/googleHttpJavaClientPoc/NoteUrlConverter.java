package com.nando.googleHttpJavaClientPoc;/**
 * Author: wge
 * Date: 29/12/2014
 * Time: 14:07
 */

import com.google.api.client.http.GenericUrl;

import java.util.ArrayList;

public class NoteUrlConverter extends GenericUrl implements UrlConverter
{
    private static final String NOTES_BASE_URL = "http://private-5f9ca-gaetest.apiary-mock.com/notes";//"http://private-anon-072adbda5-gaetest.apiary-mock.com/notes";
    /** GET ALL */
    private static final GenericUrl listAllNotes() {
        return new NoteUrlConverter(NOTES_BASE_URL);
    }

    /** GET ONE */
    private static final GenericUrl getNote(Integer id) {
        return new NoteUrlConverter(NOTES_BASE_URL+"/"+id);
    }

    /** POST ONE */
    private static final GenericUrl createNote() {
        return new NoteUrlConverter(NOTES_BASE_URL);
    }

    /** PUT ONE */
    private static final GenericUrl updateNote() {
        return new NoteUrlConverter(NOTES_BASE_URL);
    }

    /** DELETE ONE */
    private static final GenericUrl deleteNote(Integer id) {
        return new NoteUrlConverter(NOTES_BASE_URL+"/"+id);
    }

    /** We have to do it this way due to the service using an anonymous list */
    @SuppressWarnings("serial")
    public static class MyList extends ArrayList<Note>
    {
    }

    @Override
    public Class getClassList()
    {
        return MyList.class;
    }

    @Override
    public GenericUrl getUrlById(Integer id)
    {
        return getNote(id);
    }

    @Override
    public GenericUrl createUrl()
    {
        return createNote();
    }

    @Override
    public GenericUrl updateUrl()
    {
        return updateNote();
    }

    @Override
    public GenericUrl deleteById(Integer id)
    {
        return deleteNote(id);
    }

    @Override
    public Class getConcreteClass()
    {
        return Note.class;
    }

    @Override
    public GenericUrl listAll()
    {
        return listAllNotes();
    }

    public NoteUrlConverter( ) {
        super();
    }

    private NoteUrlConverter(String encodedUrl) {
        super(encodedUrl);
    }


}
