package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.OurHashMap;
import model.OurMap;

class OurHashMapTest {

	@Test
	void testConstructorAndToString() {
		OurMap<String, ArrayList<Character>> map = new OurHashMap<>();
		ArrayList<Character> followers = new ArrayList<>();
		followers.add('U');
		followers.add('A');
		map.put("Alice", followers);
		System.out.println(map.get("Alice").toString());
	}

	@Test
	void testGetandPut () {
		OurMap<String, Integer> map = new OurHashMap<>();
		map.put("Taco", 4);
		assertEquals(4, map.get("Taco"));
		assertEquals(null, map.get("acoT"));
		map.put("acoT", 24);
		assertEquals(24, map.get("acoT"));
	}
	
	@Test
	void testSize() {
		OurMap<String, Integer> map = new OurHashMap<>();
		map.put("Taco", 4);
		assertEquals(4, map.get("Taco"));
		assertEquals(null, map.get("acoT"));
		map.put("acoT", 24);
		assertEquals(24, map.get("acoT"));
		assertEquals(2, map.size());
		map.put("acoT", 42);
		assertEquals(2, map.size());
		assertEquals(42, map.get("acoT"));
		
	}
	
	@Test
	void testContains () {
		OurMap<String, Integer> map = new OurHashMap<>();
		assertFalse(map.containsKey("Taco"));
		map.put("Taco", 4);
		assertTrue(map.containsKey("Taco"));
		assertEquals(4, map.get("Taco"));
		assertEquals(null, map.get("acoT"));
		assertFalse(map.containsKey("acoT"));
		map.put("acoT", 24);
		assertEquals(24, map.get("acoT"));
		assertTrue(map.containsKey("acoT"));
		
	}
}