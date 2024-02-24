package anoop.test.sample.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is showing how the Activity Problem Solved using Greedy Algorithm.
 * Supporting classes: Activity, ActivitySelection
 */
public class ActivitySelectionProblem {
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

 class ActivitySelection {

    public static List<Activity> activitySelection(List<Activity> activities) {
        //Sort activities based on finishing time
        Collections.sort(activities, Comparator.comparingInt(Activity::getFinishTime));

        List<Activity> result = new ArrayList<>();
        // Start with first activity
        Activity first = activities.get(0);
        result.add(first);

        // Identify next activities by comparing start time with finish time
        for (int index = 1; index < activities.size(); index++) {
            Activity activity = activities.get(index);
            if(activity.getStartTime() >= first.getFinishTime()) {
                result.add(activity);
                first = activity;
            }
        }
        return result;
    }
}

class Activity {
    private String name;
    private int startTime;
    private int finishTime;

    public Activity(String name, int startTime, int finishTime) {
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }
}
