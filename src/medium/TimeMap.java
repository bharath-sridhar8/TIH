package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class TimeValue {
	private int time;
	private String value;

	public int getTime() {
		return time;
	}

	public String getValue() {
		return value;
	}

	public TimeValue(int time, String value) {
		this.time = time;
		this.value = value;
	}
}

public class TimeMap {
	
	HashMap<String, List<TimeValue>> map;
	
	public TimeMap() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<>());
		}
		TimeValue timeValue = new TimeValue(timestamp, value);
		map.get(key).add(timeValue);
	}

	public String get(String key, int timestamp) {
		if (!map.containsKey(key))
			return "";
		List<TimeValue> timeValues = map.get(key);
		int i = Collections.binarySearch(timeValues, new TimeValue(timestamp, ""),
				Comparator.comparingInt(TimeValue::getTime));
		if (i >= 0) {
			return timeValues.get(i).getValue();
		} else {
			int idxToInsert = -(i + 1);
			if (idxToInsert == 0)
				return "";
			else
				return timeValues.get(idxToInsert - 1).getValue();
		}
	}

	public static void main(String[] args) {
		TimeMap timeKVStore = new TimeMap();
		timeKVStore.set("foo", "bar", 2);
		System.out.println(timeKVStore.get("bar", 1));
		System.out.println(timeKVStore.get("foo", 1));
		System.out.println(timeKVStore.get("foo", 2));
		System.out.println(timeKVStore.get("foo", 3));
		timeKVStore.set("foo", "bar2", 4);
		System.out.println(timeKVStore.get("foo", 4));
		System.out.println(timeKVStore.get("foo", 5));
	}

}
