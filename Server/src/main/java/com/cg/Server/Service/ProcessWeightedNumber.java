package com.cg.Server.Service;

import java.util.ArrayList;

import org.json.JSONObject;

import com.cg.Server.Model.WeightedRandomNumber;

public class ProcessWeightedNumber {

	public static JSONObject getRandomValue() {
		WeightedRandomNumber<Integer> itemDrops = new WeightedRandomNumber<>();
		// Setup - a real game would read this information from a configuration file or
		// database
		ArrayList<Integer> result = new ArrayList<Integer>();

		itemDrops.addEntry(0, 40.0);
		itemDrops.addEntry(1, 30.0);
		itemDrops.addEntry(2, 20.0);
		itemDrops.addEntry(3, 10.0);

		// drawing random entries from it
		// for (int i = 0; i <= 100000; i++) {
		result.add(itemDrops.getRandom());
		JSONObject j = JsonConverter.toJson(result);
		return j;
	}

}
