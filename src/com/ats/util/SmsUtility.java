package com.ats.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;


public class  SmsUtility {

	public  String sendEmail(HttpServletRequest request){
		String resp="";
		
		try{
			String phoneNumber=request.getParameter("mbno");
			String message=request.getParameter("smsmessage");
			String username="sanjeev";
			String password="1234";
			String address="http://192.168.0.4";
			String port="8094";
			URL url=new URL(address+":"+port+"/SendSMS?username="+username+"&password="+password+"&phone="+phoneNumber+"&message="+URLEncoder.encode(message,"UTF-8"));
			System.out.println(url);
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			BufferedReader br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputline;
			while((inputline=br.readLine())!=null){
				System.out.println(inputline);
			}
			if("ok".equalsIgnoreCase(connection.getResponseMessage())){
				resp="success";
			}
			/*resp=connection.getResponseMessage();*/
			System.out.println(resp);
			//}
		}catch(Exception e){
			e.printStackTrace();
			resp=e.getMessage();
		}
		return resp;
	}
}
