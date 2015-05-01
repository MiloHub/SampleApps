import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NumberToWord {

	public static void main(String[] args) {

		convert(77212002);

	}

	static String convert(long a) {

		if (a < 0) {
			return "negative";

		} else {

			String n = Long.toString(a);
			String str = String.format("%,d", a);
			Map<Integer, String> s = new HashMap<Integer, String>();
			String[] nums = str.split(",");
			for (int i = nums.length - 1, x = 0; i >= 0; i--) {
				s.put(x++, nums[i]);
			}
			Set<Integer> range = s.keySet();
			String result = "";
			for (int r : range) {

				switch (r) {

				case 0: {

					result = conver1000(s.get(r));
					continue;
				}
				case 1: {
					result = conver1000(s.get(r)) + " thousands " + result;
					continue;
				}
				case 2: {
					result = conver1000(s.get(r)) + " million " + result;
					continue;
				}
				case 3: {
					result = conver1000(s.get(r)) + " billion " + result;
					continue;
				}
				}
			}
			System.out.println("result-->" + result);
			return n;
		}

	}

	static String[] num = { "", "one", "two", "three", "four", "five", "six",
			"seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen",
			"fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen", "twenty" };
	static String[] tens = { "", "ten", "twenty", "thirty", "fourty", "fifty",
			"sixty", "seventy", "eighty", "ninety" };

	static String conver1000(String s) {
		String result = "";
		int i = Integer.parseInt(s);

		if (i % 100 < 20) {

			result = num[i % 100];

			i = i / 100;

		} else {

			result = num[i % 10];

			i = i / 10;

			result = tens[i % 10] + " " + result;
			i = i / 10;

		}
		if (i == 0)
			return result;
		return num[i] + " hundred " + result;
	}

}
