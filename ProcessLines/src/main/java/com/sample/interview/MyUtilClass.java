package com.sample.interview;

import java.util.List;

import com.google.common.collect.Multimap;

public class MyUtilClass {

	public static String getStringFromList(List<String> list) {
		StringBuilder sb = new StringBuilder();

		for (String s : list) {
			sb.append(s + " ");
		}

		return sb.toString();
	}

	public static void printMapValueCounts(
			Multimap<String, String> catalogMultimap) {

		for (String key : catalogMultimap.keySet()) {

			System.out.print(key + " ");

			System.out.println(catalogMultimap.get(key).size());

		}

	}

}
