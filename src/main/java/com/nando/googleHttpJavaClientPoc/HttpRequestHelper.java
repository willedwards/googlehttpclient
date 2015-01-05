package com.nando.googleHttpJavaClientPoc;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;
import java.util.Map;

/**
 * Author: wge
 * Date: 20/12/2014
 * Time: 22:19
 */

public class HttpRequestHelper
{
        private static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
        private static JsonFactory JSON_FACTORY = new JacksonFactory();


        private static HttpRequestFactory createRequestFactory() {
            return HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer()
               {
                   @Override
                   public void initialize(HttpRequest request)
                   {
                       request.setParser(new JsonObjectParser(JSON_FACTORY));
                   }
               });
        }

       public static HttpRequest buildRequestWithParams(GenericUrl url, Map<String,? extends Object> paramsMap) throws IOException
       {
           HttpRequestFactory requestFactory = createRequestFactory();
           return requestFactory.buildPostRequest(url, new UrlEncodedContent(paramsMap));
       }

    public static HttpRequest buildGETRequest(GenericUrl url) throws IOException
    {
        HttpRequestFactory requestFactory = createRequestFactory();
        return requestFactory.buildGetRequest(url);
    }


        public static HttpRequest buildPOSTRequest(GenericUrl url,GenericJson json) throws IOException
       {
           HttpRequestFactory requestFactory = createRequestFactory();
           JsonHttpContent httpContent = new JsonHttpContent(JSON_FACTORY, json);
           return requestFactory.buildPostRequest(url, httpContent);
       }

        public static HttpRequest buildPUTRequest(GenericUrl url,GenericJson json) throws IOException
       {
           HttpRequestFactory requestFactory = createRequestFactory();
           JsonHttpContent httpContent = new JsonHttpContent(JSON_FACTORY, json);
           return requestFactory.buildPutRequest(url, httpContent);
       }

        public static HttpRequest buildDeleteRequest(GenericUrl url) throws IOException
       {
           HttpRequestFactory requestFactory = createRequestFactory();
         	return requestFactory.buildDeleteRequest(url);
       }
}
