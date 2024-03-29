package com.cg.Server.Service;

import java.util.LinkedHashMap;

import org.json.JSONObject;

import com.cg.Server.Model.SpinFeature;

/**
 * @author FMNPTeam - RGHM
 *
 *
 */
public class ProcessSpin {

	/**
	 * This method is used to set the symbol and reel values. and then get the
	 * matrix and convert it into JSON *
	 *
	 * @return j : a JSONObject .
	 */
	public static JSONObject getSpinMatrix() {
		LinkedHashMap<Integer, String> symbols = new LinkedHashMap<Integer, String>();
		SpinFeature spin = new SpinFeature();
		symbols.put(1, "ACE");
		symbols.put(2, "KING");
		symbols.put(3, "QUEEN");
		symbols.put(4, "JACK");

		String[] reel1 = new String[] { symbols.get(4), symbols.get(4), symbols.get(2), symbols.get(2), symbols.get(1),
				symbols.get(3), symbols.get(3), symbols.get(2), symbols.get(1), symbols.get(4), symbols.get(1),
				symbols.get(4), symbols.get(3), symbols.get(3), symbols.get(4), symbols.get(3), symbols.get(2),
				symbols.get(4) };
		String[] reel2 = new String[] { symbols.get(2), symbols.get(3), symbols.get(4), symbols.get(4), symbols.get(4),
				symbols.get(1), symbols.get(2), symbols.get(3), symbols.get(4), symbols.get(4), symbols.get(4),
				symbols.get(1), symbols.get(3), symbols.get(3), symbols.get(3), symbols.get(2), symbols.get(2),
				symbols.get(1) };
		String[] reel3 = new String[] { symbols.get(4), symbols.get(4), symbols.get(2), symbols.get(2), symbols.get(1),
				symbols.get(3), symbols.get(3), symbols.get(2), symbols.get(1), symbols.get(4), symbols.get(1),
				symbols.get(4), symbols.get(3), symbols.get(3), symbols.get(4), symbols.get(3), symbols.get(2),
				symbols.get(4) };

		String[][] matrix = spin.createSpin(reel1, reel2, reel3);
		JSONObject j = JsonConverter.toJson(matrix);
		j.put("Score", spin.getValue());
		return j;

	}

}
