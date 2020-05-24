package com.ats.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;

import com.ats.util.*;

import org.apache.http.client.fluent.Request;
import org.apache.http.HttpResponse;
/**
 * Servlet implementation class Token
 */
@WebServlet("/tkn")
public class Token extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static String categoryTTS = "tts";
	public static String categorySTT = "stt";

	
	public static String getToken(String category) throws Exception{
		String token = "";
		HttpEntity entity = getTokenEntity(category);
		InputStream inputStream;
		try {
			inputStream = entity.getContent();
			if(inputStream != null) {
				if(inputStream.available() > 0) {
					byte[] buffer = new byte[4096];
					int length = 0;
					StringBuilder sb = new StringBuilder();
					while((length = inputStream.read(buffer)) > 0) {
						sb.append(new String(buffer, 0, length));
					}
					token = sb.toString();
				}
				inputStream.close();
			}
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return token;
	}
	
	
	private static HttpEntity getTokenEntity(String category) throws Exception{
		String url = "";
		String username = "", password = "";
		if(category.equals(categorySTT)) {
			url = Configuration.TOKEN_API_URL + "?url=" + Configuration.getInstance().SPEECH_TO_TEXT_API_URL;
			username = Configuration.getInstance().SPEECH_TO_TEXT_USERNAME;
			password = Configuration.getInstance().SPEECH_TO_TEXT_PASSWORD;
		}
		else if(category.equals(categoryTTS)) {
			url = Configuration.TOKEN_API_URL + "?url=" + Configuration.getInstance().TEXT_TO_SPEECH_API_URL;
			username = Configuration.getInstance().TEXT_TO_SPEECH_USERNAME;
			password = Configuration.getInstance().TEXT_TO_SPEECH_PASSWORD;
		}

		System.out.println("url: "+url);

		if(url.length() > 0) {
			URI converseURI = new URI(url).normalize();
			Request request = Request.Get(converseURI);
			HttpResponse httpResponse = Utility.invokeRequest(request, username, password, url.startsWith("https"));
			if(httpResponse.getStatusLine().getStatusCode() == 200){
				HttpEntity entity = httpResponse.getEntity();
				return entity;
			}
		}
		throw new Exception("Invalid request URL");
	}


       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Token() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
