package com.solutions.interview.impl;

import com.solutions.interview.IAnagramFinder;
import com.solutions.utils.AnagramDocumentation;
@AnagramDocumentation(
		name = "Dhanaraj", description = "Implementation for Anagram Finder", version = 1
		)
public class AnagramFinderImpl implements IAnagramFinder {


	@Override
	public boolean areAnagrams(String s1, String s2) {

		int[] bitArray = new int[256];
		if (s1 == null || s2 == null)
			return false;
		s1 = s1.replaceAll("\\s+", "");
		s2 = s2.replaceAll("\\s+", "");
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int len = c1.length;
		int len2 = c2.length;

		if (len != len2)
			return false;

		for (int i = 0; i < len; i++) {
			bitArray[c1[i]]++;
		}

		for (int i = 0; i < len; i++) {
			bitArray[c2[i]]--;
		}

		for (int i = 0; i < 256; i++) {
			if (bitArray[i] != 0)
				return false;
		}
		return true;

	}

}
