import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
You and your friend have decided to start an international trading business. You want to earn a profit through some ol'
fashioned arbitrage: You'll buy widgets in one country and sell them in another at a higher price.
Your friend has already found the current market prices for widgets in cities around the world, and you'd like to use
this data to pick which cities to buy and sell widgets in.

Write a function max_profit(prices) that efficiently finds the two cities that maximize your profit (i.e. largest difference in prices).

Input: A dictionary with cities as keys and prices as values Output: An array (or tuple) containing the names of the cities (min, max)

prices = {'London': 72, 'New York': 70, 'Tokyo': 67, 'Miami': 62}

max_profit(prices) # => ('Miami', 'London')
 */
public class MaximumProfit {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("London", 72);
        map.put("New York", 70);
        map.put("Tokyo", 67);
        map.put("Miami", 62);
        String[] strings = max_profit(map);
        System.out.println(strings[0] + ">>>" + strings[1]);
    }

    private static String[] max_profit(Map<String, Integer> prices) {
        String result[] = new String[2];
        String min_city = null, max_city = null;
        int min_val = Integer.MAX_VALUE;
        int max_val = Integer.MIN_VALUE;

        Iterator<Map.Entry<String, Integer>> iterator = prices.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            int price = entry.getValue();
            String city = entry.getKey();
            if (price < min_val) {
                min_val = price;
                min_city = city;
            }
            if (price > max_val) {
                max_val = price;
                max_city = city;
            }
        }

        result[0] = min_city;
        result[1] = max_city;
        return result;
    }
}
