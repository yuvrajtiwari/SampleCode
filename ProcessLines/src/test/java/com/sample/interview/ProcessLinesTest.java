package com.sample.interview;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sample.interview.BlankInputException;
import com.sample.interview.NoValidCategoryFoundException;
import com.sample.interview.ProcessLines;

import static org.junit.Assert.assertEquals;

public class ProcessLinesTest {

	@Test(expected = BlankInputException.class)
	public void testProcessLines_InputNull() throws BlankInputException,
			NoValidCategoryFoundException {

		List<String> inputList = null;

		new ProcessLines().process(inputList);

	}

	@Test(expected = BlankInputException.class)
	public void testProcessLines_EmptyList() throws BlankInputException,
			NoValidCategoryFoundException {

		List<String> inputList = new ArrayList<String>();

		new ProcessLines().process(inputList);

	}

	@Test(expected = NoValidCategoryFoundException.class)
	public void testProcessLines_NoValidCategory() throws BlankInputException,
			NoValidCategoryFoundException {

		List<String> inputList = setUpListWithNoValidCategory(new ArrayList<String>());

		new ProcessLines().process(inputList);

	}

	@Test
	public void testProcessLines_TestValidCategoriesAndCount()
			throws BlankInputException, NoValidCategoryFoundException {

		List<String> input = setUpValidTestList(new ArrayList<String>());
		String expectedOutput = setUpOutput(new StringBuilder());

		ByteArrayOutputStream outContentFromProcessLines = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContentFromProcessLines));

		new ProcessLines().process(input);
		// comparing the contents of output stream with expected output
		assertEquals(expectedOutput.toString(),
				outContentFromProcessLines.toString());

	}

	@Test(timeout = 3)
	public void testProcessLines_Timeout() throws BlankInputException,
			NoValidCategoryFoundException {

		List<String> input = setUpValidTestList(new ArrayList<String>());
		String expectedOutput = setUpOutput(new StringBuilder());

		ByteArrayOutputStream outContentFromProcessLines = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContentFromProcessLines));
		
		new ProcessLines().process(input);
		
		//comparing the contents of output stream with expected output
		assertEquals(expectedOutput.toString(),
				outContentFromProcessLines.toString());

	}

	private String setUpOutput(StringBuilder stringBuilder) {
		String newLine = System.getProperty("line.separator");
		if (newLine == null)
			newLine = "\n";

		stringBuilder.append("PERSON Bob Jones" + newLine);

		stringBuilder.append("PERSON Spielberg" + newLine);
		stringBuilder.append("PERSON Fred Smith" + newLine);
		stringBuilder.append("FOOD Pizza" + newLine);
		stringBuilder.append("FOOD Ice Cream" + newLine);
		stringBuilder.append("PLACE New York" + newLine);
		stringBuilder.append("PERSON George Washington" + newLine);
		stringBuilder.append("PERSON Henry" + newLine);
		stringBuilder.append("PLACE Omaha" + newLine);
		stringBuilder.append("PERSON Bob Jones Davis" + newLine);
		stringBuilder.append("PERSON Bob Ela Davis" + newLine);
		stringBuilder.append("FOOD 2" + newLine);
		stringBuilder.append("PERSON 7" + newLine);
		stringBuilder.append("PLACE 2" + newLine);
		return stringBuilder.toString();
	}

	private List<String> setUpValidTestList(ArrayList<String> list) {
		list.add("PERSONIFICATION Henry");
		list.add("FOODER PizzaEater");
		list.add("PET Fido");
		list.add("PET Jaguar");
		list.add("PET Cat");
		list.add("STORE Seven Eleven");
		list.add("WORKPLACE New York");
		list.add("TREE Maple");
		list.add("COUCH POTATO NBD");
		list.add("PET ABC CBD");
		list.add("HOME London");
		list.add("PERSON Bob Jones");
		list.add("PERSON Bob Jones");
		list.add("PERSON Bob Jones");
		list.add("PERSON Bob Jones");
		list.add("PERSON Bob Jones");
		list.add("PERSON Spielberg");
		list.add("PERSONIFICATION Henry");
		list.add("PERSON Fred Smith");
		list.add("FOOD Pizza");
		list.add("PET Fido");
		list.add("PET ABC");
		list.add("PET DBD");
		list.add("FOOD Ice Cream");
		list.add("PLACE New York");
		list.add("FOOD Pizza");
		list.add("FOOD Pizza");
		list.add("FOOD Pizza");
		list.add("TREE Maple");
		list.add("PERSON George Washington");
		list.add("PERSON Henry");
		list.add("PLACE Omaha");
		list.add("COUCH POTATO NBD");
		list.add("PET ABC CBD");
		list.add("PET DBD");
		list.add("PERSON Bob Jones Davis");
		list.add("PERSON Bob Ela Davis");
		return list;
	}

	private List<String> setUpListWithNoValidCategory(ArrayList<String> list) {

		list.add("PERSONIFICATION Henry");
		list.add("FOODER PizzaEater");
		list.add("PET Fido");
		list.add("PET Jaguar");
		list.add("PET Cat");
		list.add("STORE Seven Eleven");
		list.add("WORKPLACE New York");
		list.add("TREE Maple");
		list.add("COUCH POTATO NBD");
		list.add("PET ABC CBD");
		list.add("HOME London");
		return list;
	}

}
