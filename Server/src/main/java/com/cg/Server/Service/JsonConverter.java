package com.cg.Server.Service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonConverter {

	public static JSONObject toJson(ArrayList<Integer> result) {
		JSONObject j = new JSONObject();
		for (int i = 0; i < result.size(); i++) {
			j.put("Value", result.get(i));
		}

		return j;

	}

	public static JSONObject toJson(String[][] result) {
		JSONObject j = new JSONObject();
		JSONArray a = new JSONArray(result);
		j.put("Array", a);

		return j;

	}

}
