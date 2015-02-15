package com.nando.googleHttpJavaClientPoc;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class NotesRequesterAPITest
{
    static final RemoteRequester remoteRequester = new RemoteRequester(new NoteUrlConverter());


	@Test
	public void testCreate()
    {
        try {
            Note newNote = new Note(15, "Title created");
            Note expectedCreated = new Note(3, "Buy cheese and bread for breakfast.");
            Note createdNote = remoteRequester.create(newNote);
            assertEquals(expectedCreated, createdNote);
        }
        catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void find()
    {
        try{
            Note found = remoteRequester.findById(2);
            Note expectedFound = new Note(2,"Pick-up posters from post-office");
            assertEquals(expectedFound,found);
 		}
        catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

    @Test
    public void update()
    {
        try {
            //updated
            Note tobeUpdatedNote = new Note(15, "Title updated");

            remoteRequester.update(tobeUpdatedNote);
        }
        catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void getAll()
    {
        try{

        List<Note> notesList = (List<Note>)remoteRequester.getAll();

         assertEquals(2,notesList.size());

         Note expectedFirst = new Note(1,"Jogging in park");
         Note expectedNext = new Note(2,"Pick-up posters from post-office");

         assertTrue(notesList.contains(expectedFirst));
         assertTrue(notesList.contains(expectedNext));
        }
        catch (Exception e) {
    			Assert.fail(e.getMessage());
    		}
    }

    @Test
    public void delete()
    {
        try{

         //delete
        remoteRequester.delete(15);

        }
            catch (Exception e) {
    			e.printStackTrace();
    			Assert.fail(e.getMessage());
    		}
    }
}
