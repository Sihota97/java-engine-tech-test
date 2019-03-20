package com.cg.Server.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Harjot Sihota
 *
 *
 */
public class WeightedRandomNumber<T extends Object> {
	private class Entry {
		double totalWeight;
		T object;
	}

	private List<Entry> entries = new ArrayList<>();
	private double totalWeight;
	private Random rand = new Random();

	/**
	 * This method is used to add an entry to the class object it adds a object e.g.
	 * 0 and a weight e.g. 40. every time a new object is added the weight is of the
	 * previous object is added to totalweight a new entry is created the object and
	 * current total weight is added to the entry the entry is athen added to an
	 * array list
	 * 
	 * @return void
	 * @param object e.g. 1, weight e.g. 30
	 */
	public void addEntry(T object, double weight) {
		totalWeight += weight;
		Entry e = new Entry();
		e.object = object;
		e.totalWeight = totalWeight;
		entries.add(e);
	}

	/**
	 * This method is used to generate a random number between 1 and 100 and for
	 * every entry E check if the random number is less or equal than the total
	 * weight of entry E if so return that entry
	 *
	 * @return entry : returns object of entry or null
	 *
	 */
	public T getRandom() {
		double r = rand.nextDouble() * totalWeight;

		for (Entry entry : entries) {
			if (entry.totalWeight >= r) {
				return entry.object;
			}
		}
		return null; // should only happen when there are no entries
	}
}
