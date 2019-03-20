package com.cg.Client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.json.JSONObject;

public class Client {

	public static JSONObject postRequest(String body) throws MalformedURLException, IOException, ProtocolException {
		URL url = new URL("http://localhost:8008/serve");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		con.setRequestProperty("Accept", "application/json");
		byte[] outputInBytes = body.getBytes("UTF-8");

		OutputStream os = con.getOutputStream();
		os.write(outputInBytes);
		os.close();

		InputStream in = new BufferedInputStream(con.getInputStream());
		String result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
		JSONObject jsonObject = new JSONObject(result);

		in.close();
		con.disconnect();

		return jsonObject;
	}
}
