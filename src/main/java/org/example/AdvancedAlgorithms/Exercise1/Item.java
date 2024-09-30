package org.example.AdvancedAlgorithms.Exercise1;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class FractionalKnapsack {

    static double getMaxValue(int W, Item[] arr) {
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                double r1 = (double) o1.value / o1.weight;
                double r2 = (double) o2.value / o2.weight;
                return Double.compare(r2, r1);
            }
        });

        double totalValue = 0.0;

        for (Item i : arr) {
            int curWt = i.weight;
            int curVal = i.value;

            if (W - curWt >= 0) {
                W -= curWt;
                totalValue += curVal;
            } else {
                double fraction = ((double) W / curWt);
                totalValue += (curVal * fraction);
                W = (int) (W - (curWt * fraction));
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] arr = {new Item(60, 10), new Item(100, 20), new Item(120, 30)};

        int W = 50;
        System.out.println("Maximum value we can obtain = " + getMaxValue(W, arr));
    }
}

