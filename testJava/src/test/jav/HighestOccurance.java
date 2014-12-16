package test.jav;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HighestOccurance {
	public static void main(String[] args) {
		System.out.println(highestOccu("aagwjhgjhsdghfytty"));

	}

	public static int highestOccu(String sampleText) {
		char[] charArray = sampleText.toCharArray();
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for (char c : charArray) {
			if (hashMap.containsKey(c)) {
				int temp = hashMap.get(c);
				System.out.println(temp);
				hashMap.put(c, temp + 1);
			} else {
				hashMap.put(c, 1);
			}
			System.out.println(hashMap);
		}
		System.out.println(hashMap);
		return getMaxValue(hashMap);
	}

	static int getMaxValue(HashMap<Character, Integer> map) {
		Set set = map.keySet();
		int max = 0;
		Iterator<Character> it = set.iterator();
		while (it.hasNext()) {
			Character c = (Character) it.next();
			int value = map.get(c);
			if (value >= max)
				max = value;
		}
		return max;
	}

}
