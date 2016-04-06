package com.sample.interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;

public class ProcessLines {

	// new Predicate to filter valid Categories
	static Predicate<String> isValidCategory = new Predicate<String>() {

		@Override
		public boolean apply(String currentString) {
			Iterable<String> inputLine = Splitter.on(" ").omitEmptyStrings()
					.trimResults().split(currentString);

			ArrayList<String> wordList = Lists.newArrayList(inputLine);

			if (wordList.get(0).equals("FOOD")) { // returns true if the
													// category matches
				return true;
			} else if (wordList.get(0).equals("PERSON")) {
				return true;
			} else if (wordList.get(0).equals("PLACE")) {
				return true;
			}
			return false;
		}
	};
	
	

	public void process(List<String> lines) throws BlankInputException,
			NoValidCategoryFoundException {

		if (lines == null || lines.size() == 0) {
			throw new BlankInputException();
		}
		// get a list of unique lines
		List<String> uniqueInputs = ImmutableSet.copyOf(lines).asList();

		// remove all lines containing invalid category
		Collection<String> filtered = FluentIterable.from(uniqueInputs)
				.filter(isValidCategory).toList();

		// throw NoValidCategoryFoundException if no valid category among unique
		// lines
		if (filtered.size() == 0) {
			throw new NoValidCategoryFoundException();
		}

		// construct a Multi-map to add all valid (categories-Subcategories)
		// TreeMultimap Ensures Keys are sorted
		Multimap<String, String> catalogMultimap = TreeMultimap.create();

		for (String s : filtered) {

			// print the output for all valid category-Subcategory pairs
			System.out.println(s);

			// get space sperated tokens from each line and add them as Key
			// Value pairs in the Multi-map
			Iterable<String> inputLine = Splitter.on(" ").omitEmptyStrings()
					.trimResults().split(s);
			ArrayList<String> entries = Lists.newArrayList(inputLine);
			// retrieving sublist of the current line excluding the first
			// element.
			String value = MyUtilClass.getStringFromList(entries.subList(1,
					entries.size()));

			// add first index of list(Category) as key and rest of sublist as
			// value in multimap
			catalogMultimap.put(entries.get(0), value);

		}

		// print each category and its count

		MyUtilClass.printMapValueCounts(catalogMultimap);

	}

}
