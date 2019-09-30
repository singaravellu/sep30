
package collectionFrwrk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class CollectionFramework {

	int a;
	
	int j = 0;

	public CollectionFramework() {
	}

	public CollectionFramework(int a) {
		super();
		this.a = a;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
	@Override
	public int hashCode() {
		return a;
	}

	@Override
	public String toString() {
		return "CollectionFramework [a=" + a + "]  and hash code :" + hashCode();
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public static void main(String[] args) {

		// hashmap
		System.out.println("------------------------------------------");

		HashMap<CollectionFramework, Integer> hm = new HashMap<CollectionFramework, Integer>(10);
		CollectionFramework ob = new CollectionFramework(2);
		CollectionFramework ob1 = new CollectionFramework(3);
		hm.put(ob, 2);
		hm.put(new CollectionFramework(3),4);
		hm.put(ob1, 6);

		/*
		 * hm.put( new CollectionFramework(4),5);
		 * 
		 * hm.put( new CollectionFramework(5),8);
		 */

		for (Integer obj : hm.values()) {
			System.out.println(obj);
		}
		System.out.println("##################3");
		System.out.println(hm.get(new CollectionFramework(2)));
		System.out.println(hm.get(new CollectionFramework(3)));

		/*
		 * System.out.println("---------------------------------------------");
		 * 
		 * HashSet<CollectionFramework> hs= new HashSet<CollectionFramework>();
		 * hs.add(ob); hs.add(ob);
		 * 
		 * hs.add(new CollectionFramework(4));
		 * 
		 * hs.add(new CollectionFramework(5));
		 * 
		 * 
		 * hs.stream().forEach(System.out::println);
		 * 
		 * 
		 * 
		 * System.out.println("------------------------------------------");
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * // Lists // ArrayList List<String> arrayList = new ArrayList<String>();
		 * arrayList.add("deva"); arrayList.add(1, "jagga"); arrayList.add(0, "dev");
		 * arrayList.contains("deva"); arrayList.addAll(3, Arrays.asList("1", "2", "3",
		 * "4"));
		 * 
		 * // arrayList.removeAll(Arrays.asList("1","2","3","4"));
		 * System.out.println(arrayList.toString());
		 * 
		 * arrayList.stream().filter(obj ->
		 * obj.contains("dev")).forEach(System.out::println);
		 * System.out.println("----------"); for (String str : arrayList) {
		 * System.out.println(str + " "); } System.out.println(
		 * "////////////////////////////////////////////////////////////////////");
		 * arrayList.stream().filter((String name) ->
		 * name.contains("dev")).forEach(System.out::println);
		 * System.out.println("String to int"); arrayList.stream().skip(3).map(n ->
		 * Integer.valueOf(n)).forEach(System.out::println);
		 * 
		 * arrayList.stream().map(n -> n.replace("de",
		 * "di")).forEach(System.out::println);
		 * 
		 * 
		 * arrayList.stream().sorted().forEach(System.out::println);
		 * 
		 * arrayList.replaceAll(n->n.concat("---"));
		 * 
		 * 
		 * System.out.println(arrayList.toString());
		 * 
		 * Iterator<String> itr = arrayList.iterator(); while (itr.hasNext()) {
		 * System.out.println(itr.next()); itr.remove();
		 * 
		 * } System.out.println(arrayList.toString());
		 * 
		 * // linked list System.out.println("ll----------");
		 * 
		 * List<String> linkedList = new LinkedList<>();
		 * 
		 * linkedList.add("deva"); linkedList.add("dev"); linkedList.add("de");
		 * linkedList.remove(1);
		 * 
		 * System.out.println(linkedList.get(1));
		 * System.out.println(linkedList.toString()); Iterator<String> it1r =
		 * linkedList.iterator(); while (it1r.hasNext()) {
		 * System.out.println(it1r.next());
		 * 
		 * }
		 * 
		 * // set
		 * 
		 * Set<String> set = new TreeSet<String>();
		 * 
		 * set.addAll(linkedList); System.out.println(set.toString());
		 * System.out.println("------------------------------------------");
		 * 
		 * Set<CollectionFramework> set1 = new TreeSet<CollectionFramework>(new
		 * CollectionFramework()); CollectionFramework obj1 = new
		 * CollectionFramework(1); set1.add(obj1); set1.add(obj1);
		 * 
		 * set1.add(new CollectionFramework(13)); set1.add(new CollectionFramework(14));
		 * set1.stream().forEach(System.out::print);
		 * 
		 * System.out.println(set1.toString());
		 */

	}

	/*
	 * @Override public int compare(CollectionFramework o1, CollectionFramework o2)
	 * { // TODO Auto-generated method stub if ((o1.a > o2.a)) { return 1; } else
	 * return 0; }
	 */

}
