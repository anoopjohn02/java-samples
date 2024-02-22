package anoop.test.sample.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KnapsackItemProblem {

    public static void main(String[] args) {
        List<KnapsackItem> items = new ArrayList<>();
        items.add(new KnapsackItem(1, 100, 20));
        items.add(new KnapsackItem(2, 120, 30));
        items.add(new KnapsackItem(1, 60, 10));
        knapSack(items, 50);
    }

    private static void knapSack(List<KnapsackItem> items, int capacity) {
        Collections.sort(items, (o1, o2) -> {
            if (o2.getRatio()>o1.getRatio()) return 1;
            else return -1;
        });
        int usedCapacity = 0;
        double totalValue = 0;

        for (KnapsackItem item : items) {
            if (usedCapacity + item.getWeight()<=capacity) {
                usedCapacity+=item.getWeight();
                System.out.println("Taken: "+item);
                totalValue+=item.getValue();
            } else {
                int usedWeight = capacity - usedCapacity;
                double value = item.getRatio()*usedWeight;
                System.out.println("Taken: item index = "+ item.getIndex()+ ", obtained value= "+ value+ ", used weight =" +usedWeight+ ", ratio = "+ item.getRatio());
                usedCapacity += usedWeight;
                totalValue += value;

            }
            if (usedCapacity == capacity) break;
        }
        System.out.println("\nTotal value obtained: "+ totalValue);
    }
}
