package com.cg.Server.Service;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Harjot Sihota
 *
 *
 */
public class JsonConverter {

	/**
	 * This method is used to convert an array list into a jsonObject. It is used by
	 * the ProcessWeightedNumber class
	 *
	 * @return j : a JSONObject
	 * @param ArrayList type Integer.
	 */
	public static JSONObject toJson(ArrayList<Integer> result) {
		JSONObject j = new JSONObject();
		for (int i = 0; i < result.size(); i++) {
			j.put("Value", result.get(i));
		}

		return j;

	}

	/**
	 * This method is used to convert an array list into a jsonObject. It is used by
	 * the ProcessWeightedNumber class. puts the JSONArray into a JSONObject
	 *
	 *
	 * @return j : a JSONObject
	 * @param a 3x3 String Matrix
	 */
	public static JSONObject toJson(String[][] result) {
		JSONObject j = new JSONObject();
		JSONArray a = new JSONArray(result);
		j.put("Array", a);

		return j;

	}

}
