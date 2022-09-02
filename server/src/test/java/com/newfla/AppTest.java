package com.newfla;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.newfla.App;

import io.javalin.Javalin;
import io.javalin.core.util.JavalinLogger;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws IOException
     * @throws ClientProtocolException
     */
    @Test
    public void shouldAnswerWithTrue() throws ClientProtocolException, IOException
    {
        Javalin app = App.initServerJavalin();

        HttpUriRequest request = new HttpGet( "http://localhost:7070");
        CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
        assertEquals(200, httpResponse.getStatusLine().getStatusCode());
        assertEquals("Hello World HTTP\n",  EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8));
    }
}
