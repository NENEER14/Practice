import java.util.HashMap;
import java.util.Map;

public class MaxOccurrenceWords {
    public static void main(String[] args) {
        String str = "neeraj kumar neeraj kumar abcdef";
		String[] stringArray = str.split("\\s");
		Map<String, Integer> newMap = new HashMap<String, Integer>();
        int maxOccr = 0;
		for(String strTemp : stringArray) {
            int count = newMap.getOrDefault(strTemp, 0) + 1;
			newMap.put(strTemp, count);
            if(count > maxOccr){
                maxOccr = count;
            }
		}
        System.out.println(" maxOccr " + maxOccr);

        for (Map.Entry<String,Integer> entry : newMap.entrySet()){
            if(entry.getValue() == maxOccr){
                System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue());
            }
        }
    }
}
