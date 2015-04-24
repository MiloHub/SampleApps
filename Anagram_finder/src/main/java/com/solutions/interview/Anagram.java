package com.solutions.interview;

import com.solutions.interview.impl.AnagramFinderImpl;
import com.solutions.utils.AnagramDocumentation;


@AnagramDocumentation(
name = "Dhanaraj", description = "Main Class for Anagram Finder", version = 1
)
public class Anagram {

	public static void main(String[] args) {

		IAnagramFinder iAnagramFinder = new AnagramFinderImpl();

		if (args != null && args.length > 1) {
			String string1 = args[0];
			String string2 = args[1];
			System.out.println("  Input  String 1: " + string1);
			System.out.println("  Input  String 2: " + string2);
			if (iAnagramFinder.areAnagrams(string1, string2)) {
				System.out.println("word provided are anagrams!");
			} else {
				System.out.println("word provided are not anagrams!");
			}
		}

	}

}
