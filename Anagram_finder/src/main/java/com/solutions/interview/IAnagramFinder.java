package com.solutions.interview;

import com.solutions.utils.AnagramDocumentation;

@AnagramDocumentation(name="Dhanaraj" , description="Anagram Finder" , version=1) 
public interface IAnagramFinder {
	/**
	* Determines if two strings are anagrams. Whitespace is ignored, but all other characters
	* (including punctuation) count.
	* @param s1 first string to compare
	* @param s2 second string to compare
	* @return true if s1 and s2 are anagrams, false otherwise
	*/
	public boolean areAnagrams(String s1, String s2);
	
}
