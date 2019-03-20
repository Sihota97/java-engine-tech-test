package com.cg.Client;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class CommunicationTest {

	@Test
	public void multipleTable() throws Exception {
		HashMap<Integer, Integer> s = new HashMap<Integer, Integer>();
		for (int i = 1; i <= 100000; i++) {
			JSONObject a = Client.postRequest("Table");
			if (!s.containsKey(a.getInt("Value"))) {
				s.put(a.getInt("Value"), 1);
			} else {
				s.put(a.getInt("Value"), s.get(a.getInt("Value")) + 1);
			}

		}
		Boolean zero, one, two, three;
		float zero_val, one_val, two_val, three_val;

		zero_val = (float) s.get(0) / 1000;
		one_val = (float) s.get(1) / 1000;
		two_val = (float) s.get(2) / 1000;
		three_val = (float) s.get(3) / 1000;

		zero = zero_val < 40.3997 && zero_val > 39.6003;
		one = one_val < 30.3739 && one_val > 29.6003;
		two = two_val < 20.3263 && two_val > 19.6003;
		three = three_val < 10.2248 && three_val > 9.6003;

		assertTrue(zero && one && two && three);

	}

	@Test // testing if string is not empty
	public void testSpin() throws Exception {
		int aceCount = 0;
		int kingCount = 0;
		int queenCount = 0;
		int jackCount = 0;
		HashMap<String, Integer> s = new HashMap<String, Integer>();

		for (int i = 1; i <= 100000; i++) {
			JSONObject res = Client.postRequest("Spin");
			JSONArray jsonArray = res.getJSONArray("Array");
			JSONArray jsonArray2 = jsonArray.getJSONArray(1);
			for (int j = 0; j < jsonArray2.length(); j++) {
				String a = jsonArray2.getString(j);

				if (a.equalsIgnoreCase("ACE")) {
					aceCount++;
				} else if (a.equalsIgnoreCase("KING")) {
					kingCount++;
				} else if (a.equalsIgnoreCase("QUEEN")) {
					queenCount++;
				} else if (a.equalsIgnoreCase("JACK")) {
					jackCount++;
				}

				if (aceCount == 2) {
					// totalAce2++;
					if (!s.containsKey("aceCount2")) {
						s.put("aceCount2", 1);
					} else {
						s.put("aceCount2", s.get("aceCount2") + 1);
					}

				} else if (aceCount == 3) {
					// totalAce3++;
					if (!s.containsKey("aceCount3")) {
						s.put("aceCount3", 1);
					} else {
						s.put("aceCount3", s.get("aceCount3") + 1);
					}
				} else if (kingCount == 3) {
					// totalKing++;
					if (!s.containsKey("kingCount")) {
						s.put("kingCount", 1);
					} else {
						s.put("kingCount", s.get("kingCount") + 1);
					}
				} else if (queenCount == 3) {
					// totalQueen++;
					if (!s.containsKey("queenCount")) {
						s.put("queenCount", 1);
					} else {
						s.put("queenCount", s.get("queenCount") + 1);
					}
				} else if (jackCount == 3) {
					// totalJack++;
					if (!s.containsKey("jackCount")) {
						s.put("jackCount", 1);
					} else {
						s.put("jackCount", s.get("jackCount") + 1);
					}
				}
			}
			aceCount = 0;
			kingCount = 0;
			queenCount = 0;
			jackCount = 0;
		}

		Boolean zero, one, two, three, four;
		float zero_val, one_val, two_val, three_val, four_val;

		zero_val = (float) s.get("aceCount3") / 1000;
		one_val = (float) s.get("kingCount") / 1000;
		two_val = (float) s.get("queenCount") / 1000;
		three_val = (float) s.get("jackCount") / 1000;
		four_val = (float) s.get("aceCount2") / 1000;

		zero = zero_val < 0.5184 && zero_val > 0.4076;
		one = one_val < 1.1824 && one_val > 1.0124;
		two = two_val < 2.2625 && two_val > 2.0251;
		three = three_val < 3.8578 && three_val > 3.5496;
		four = four_val < 9.8514 && four_val > 9.4366;

		assertTrue(zero && one && two && three && four);

	}

	@Test // testing if string is not empty
	public void testTable() throws Exception {
		JSONObject res = Client.postRequest("Table");
		assertTrue(!res.isEmpty());
	}

}
