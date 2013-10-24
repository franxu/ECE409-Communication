package com.example.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.util.Base64;

public class GetMethod extends Activity{
	public String getInternetData(){
		String page = null;
		BufferedReader in = null;
		try{
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet("http://my.energy-aware.com/rest/meters/3/readings");
			//create header to http request to login to the neurio cloud
			String credentials = "ubc2013" + ":" + "temp013";
			String base64EncodeCredentials = Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
			request.addHeader("Authorization","Basic " + base64EncodeCredentials);
			HttpResponse response = client.execute(request);
			
			in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while((line = in.readLine()) != null){
				sb.append(line + NL);
			}
			in.close();
			page = sb.toString();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			if(in != null){
				try{
					in.close();
					return page;
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}
		return page;
	}

}
