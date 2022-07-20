package sec01.ex01;

import java.util.HashMap;
import java.util.Map;

/*
	java.util.Map
	1. 기존 배열은 index번호가 0부터 1씩 증가
	2. Map객체는 index부분을 개발자가 직접 생성하는 것/ put했을 때 비 순차적으로 삽입이 된다
	3. Map에 속해있는 HashMap은 K(Key), V(Value) 한쌍으로 값을 저장하는 방식
	4. HashMap<K, V> : <E> Generics Type
*/

public class HashMapTest {

	public HashMapTest() {
		
	}
	
	public static void main(String args[]) {
		Map<String, Integer> map = new HashMap<String, Integer>(); //capacity 조절가능
		//put(key, value) Method : key이름으로 value값을 저장함
		map.put("apple", 15000); // map.put("apple", 75000) 를 한번 더 부르면 덮어써짐
		map.put("banana", 5000);
		map.put("orange", 1350);
		map.put("watermelon", 17900);
		
		System.out.println("map.get(\"apple\")의 값은:" + map.get("apple") + "\t 이 객체의 길이는 "+map.size() + "-->" + map);
		// 모든 Key정보를 얻는 메서드 : keySet()
		System.out.println(map.keySet());
		int count = 1, total = 0;
		for(String key: map.keySet()) {
			System.out.println(count++ + "번째 Key의 Value: " + key);
			total += map.get(key);
		}
		System.out.println("총 합계: " + total);
		
		map.remove("orange");
		System.out.println("map.remove(\"orange\")의 결과" + map);
		
		map.clear();
		System.out.println("map.clear(): " + map);
	}
}
