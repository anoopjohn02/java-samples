package anoop.test.sample.algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * This is showing how the Activity Problem Solved using Greedy Algorithm.
 * Supporting classes: Activity, ActivitySelection
 */
public class ActivityMain {
    public static void main(String[] args) {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("A1", 0, 6));
        activities.add(new Activity("A2", 3, 4));
        activities.add(new Activity("A3", 1, 2));
        activities.add(new Activity("A4", 5, 8));
        activities.add(new Activity("A5", 5, 7));
        activities.add(new Activity("A6", 8, 9));
        List<Activity> result = ActivitySelection.activitySelection(activities);
        result.forEach(activity -> System.out.println(activity.getName()));
    }
}
