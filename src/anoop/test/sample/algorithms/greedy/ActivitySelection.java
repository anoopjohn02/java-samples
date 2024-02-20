package anoop.test.sample.algorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivitySelection {

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
