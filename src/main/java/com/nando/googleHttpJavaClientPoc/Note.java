package com.nando.googleHttpJavaClientPoc;

import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

public class Note extends GenericJson {
	
	@Key
	private Integer id;
	
	@Key
	private String title;

	public Note() {
	}
	
	public Note(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + "]";
	}

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Note))
        {
            return false;
        }
        if (!super.equals(o))
        {
            return false;
        }

        Note note = (Note) o;

        if (id != null ? !id.equals(note.id) : note.id != null)
        {
            return false;
        }
        if (title != null ? !title.equals(note.title) : note.title != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

}
