package com.cg.Server.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeightedRandomNumber<T extends Object> {
	private class Entry {
		double totalWeight;
		T object;
	}

	private List<Entry> entries = new ArrayList<>();
	private double totalWeight;
	private Random rand = new Random();

	public void addEntry(T object, double weight) {
		totalWeight += weight;
		Entry e = new Entry();
		e.object = object;
		e.totalWeight = totalWeight;
		entries.add(e);
	}

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
