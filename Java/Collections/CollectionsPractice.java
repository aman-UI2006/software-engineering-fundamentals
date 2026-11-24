import java.util.*;
public class CollectionsPractice {
 public static void main(String[]args){
  List<String> names=new ArrayList<>(List.of("Mira","Aarav","Mira"));
  Set<String> unique=new HashSet<>(names);
  Map<String,Integer> frequency=new HashMap<>();
  for(String name:names)frequency.merge(name,1,Integer::sum);
  PriorityQueue<Map.Entry<String,Integer>> minHeap=new PriorityQueue<>(Map.Entry.comparingByValue());
  minHeap.addAll(frequency.entrySet());
  System.out.println("List: "+names);
  System.out.println("Unique set (iteration order unspecified): "+unique);
  System.out.println("Frequency map: "+frequency);
  System.out.println("Least frequent: "+minHeap.peek());
  System.out.println("Sorted keys: "+new TreeMap<>(frequency));
 }
}
