package com.solutions.interview;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.solutions.interview.IAnagramFinder;
import com.solutions.interview.impl.AnagramFinderImpl;
/**
 * 
 * Test class for Anagram Finder
 * 
 *
 */
@RunWith(JUnit4.class)
public class AnagramFinderTest {

	IAnagramFinder anagramFinder = new AnagramFinderImpl();
	String inputString1 = null;
	String inputString2 = null;

	@Before
	public void setUp() {
		inputString1 = "test";
		inputString2 = "test";
	}

	@Test
	public void areAnagramSuccess() {
		boolean isAnagram = anagramFinder.areAnagrams(inputString1, inputString2);
		Assert.assertEquals(true, isAnagram);
		Assert.assertTrue("Not Anagram", isAnagram);
	}
	
	@Test
	public void areAnagramInValidString() {
		inputString1= "East";
		inputString2 ="West";
		boolean isAnagram = anagramFinder.areAnagrams(inputString1, inputString2);
		Assert.assertEquals(false, isAnagram);
		Assert.assertFalse("Not Anagram", isAnagram);
	}
	@Test
	public void areAnagramWithNonSenseString() {
		inputString1= "ZZ1ZX;";
		inputString2 ="X 1 ZZZ;";
		boolean isAnagram = anagramFinder.areAnagrams(inputString1, inputString2);
		Assert.assertEquals(true, isAnagram);
		Assert.assertTrue("Not Anagram", isAnagram);
	}
	

	@After
	public void cleanUp() {
		inputString1 = null;
		inputString2 = null;
	}

}
