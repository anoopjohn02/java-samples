package anoop.test.sample;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestApp {
    public static void main(String[] args) {
        TestApp app = new TestApp();
        app.testStringMethods("Anoop John");
        //app.testStringMethods("Anoop John ");
        //app.testStringMethods(null);
    }

    public void testStringMethods(String text) {
        //System.out.println(text.(2));
    }

    public void testLocal() {
        Locale locale = Locale.GERMANY;
        System.out.println("Local:"+locale.getDisplayName());
        System.out.println("Local:"+locale.getDisplayCountry());
        ZoneId zoneid1 = ZoneId.of("Asia/Kolkata");
        LocalDateTime id1 = LocalDateTime.now(zoneid1);
        System.out.println(id1);

        Calendar calendar = Calendar.getInstance(locale);
        calendar.setTime(new Date());
        System.out.println(calendar.getTime());
    }
}
