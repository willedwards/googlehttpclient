package com.nando.googleHttpJavaClientPoc;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.json.GenericJson;
import com.nando.googleHttpJavaClientPoc.util.HttpRequestHelper;

import java.io.IOException;
import java.util.List;

/**
 * Author: wge
 * Date: 29/12/2014
 * Time: 13:47
 */

public class RemoteRequester
{

    private final UrlConverter urlConverter;

    public RemoteRequester(UrlConverter urlConverter){

        this.urlConverter = urlConverter;
    }

    public List<Note> getAll() throws IOException {
		HttpRequest request = HttpRequestHelper.buildGETRequest(urlConverter.listAll());
        HttpResponse response = request.execute();
        List<Note> notes=  (List<Note>)response.parseAs(urlConverter.getClassList());
		return notes;
	}

    public <T> T findById(Integer id) throws IOException
    {
   		HttpRequest request = HttpRequestHelper.buildGETRequest(urlConverter.getUrlById(id));
        HttpResponse response = request.execute();
        return parseOneResponse(response);
   	}

   	public <T> T create(GenericJson genericJson) throws IOException {
   		HttpRequest request =  HttpRequestHelper.buildPOSTRequest(urlConverter.createUrl(), genericJson);
        HttpResponse response = request.execute();
   		return parseOneResponse(response);
   	}

    public void update(GenericJson genericJson) throws IOException {
   		HttpRequestHelper.buildPUTRequest(urlConverter.updateUrl(), genericJson);
   	}

   	public void delete(Integer id) throws IOException {
   		HttpRequestHelper.buildDeleteRequest(urlConverter.deleteById(id));
   	}

    private  <T> T   parseOneResponse(HttpResponse response) throws IOException {
		return (T)response.parseAs(urlConverter.getConcreteClass());
	}
}
