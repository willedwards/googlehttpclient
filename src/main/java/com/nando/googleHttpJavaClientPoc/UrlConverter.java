package com.nando.googleHttpJavaClientPoc;

import com.google.api.client.http.GenericUrl;

/**
 * Author: wge
 * Date: 29/12/2014
 * Time: 13:55
 */
public interface UrlConverter
{

    Class getClassList();

    GenericUrl getUrlById(Integer id);

    GenericUrl createUrl();

    GenericUrl updateUrl();

    GenericUrl deleteById(Integer id);

    Class getConcreteClass();

    GenericUrl listAll();
}
