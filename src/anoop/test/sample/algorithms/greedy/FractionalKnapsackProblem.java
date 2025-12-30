package anoop.test.sample.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FractionalKnapsackProblem {

    public static void main(String[] args) {
        List<KnapsackItem> items = new ArrayList<>();
        items.add(new KnapsackItem(1, 100, 20));
        items.add(new KnapsackItem(2, 120, 30));
        items.add(new KnapsackItem(1, 60, 10));
        knapSack(items, 50);
    }

    private static void knapSack(List<KnapsackItem> items, int capacity) {
        Collections.sort(items, (o1, o2) -> {
            if (o2.getRatio()>o1.getRatio())
                return 1;
            else
                return -1;
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

class KnapsackItem {
    private int index;
    private int value;
    private int weight;
    private double ratio;

    public KnapsackItem(int index, int value, int weight) {
        this.index = index;
        this.value = value;
        this.weight = weight;
        ratio = value * 1.0 / weight;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
