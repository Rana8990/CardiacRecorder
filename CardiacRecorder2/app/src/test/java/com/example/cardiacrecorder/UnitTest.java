
package com.example.cardiacrecorder;

        import static org.junit.Assert.assertFalse;
        import static org.junit.Assert.assertTrue;

        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.robolectric.Robolectric;
        import org.robolectric.RobolectricTestRunner;
        import org.robolectric.RuntimeEnvironment;
        import org.robolectric.android.controller.ActivityController;
        import org.robolectric.annotation.Config;

        import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.Date;

/**
 * DatabaseUnitTest class for testing on Database insertion, update or delete
 */
@RunWith(RobolectricTestRunner.class)
public class UnitTest {

    /**
     * checks if a record is added successfully on database
     */
    @Test
    public void testAdd() {
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(RuntimeEnvironment.application);

        String systol = "95";
        String diastol = "75";
        String pulse = "68";
        String comments = "sdf";
        Calendar calendar = Calendar.getInstance();

        Date currentDate = calendar.getTime();
        String date_value = DateFormat.getDateInstance(DateFormat.FULL).format(currentDate);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
        String time_value = simpleDateFormat.format(calendar.getTime());


        myDatabaseHelper.addBook(time_value, date_value, systol, diastol, pulse, comments);

        assertTrue(myDatabaseHelper.checkIfDataExists(time_value));

        myDatabaseHelper.close();
    }

    /**
     * checks if a record is deleted successfully on database
     */
//    @Test
//    public void testdelete() {
//        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(RuntimeEnvironment.application);
//
//        String systol = "95";
//        String diastol = "75";
//        String pulse = "68";
//        String comments = "sdf";
//        String blood_pressure_status = "Regular";
//        String pulse_status = "Normal";
//        Calendar calendar = Calendar.getInstance();
//
//        Date currentDate = calendar.getTime();
//        String date_value = DateFormat.getDateInstance(DateFormat.FULL).format(currentDate);
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
//        String time_value = simpleDateFormat.format(calendar.getTime());
//
//
//        Long id = myDatabaseHelper.insertData(systol, diastol, blood_pressure_status, pulse, pulse_status, date_value, time_value, comments);
//
//        myDatabaseHelper.deleteList(Long.toString(id));
//
//        assertFalse(myDatabaseHelper.checkIfDataExists(id));
//
//        myDatabaseHelper.close();
//    }

    /**
     * checks if update on database is successful
     */
//    @Test
//    public void testUpdate() {
//        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(RuntimeEnvironment.application);
//
//        String systol = "95";
//        String diastol = "75";
//        String pulse = "68";
//        String comments = "sdf";
//        String blood_pressure_status = "Regular";
//        String pulse_status = "Normal";
//        Calendar calendar = Calendar.getInstance();
//
//        Date currentDate = calendar.getTime();
//        String date_value = DateFormat.getDateInstance(DateFormat.FULL).format(currentDate);
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm a");
//        String time_value = simpleDateFormat.format(calendar.getTime());
//
//
//        Long id = myDatabaseHelper.insertData(systol, diastol, blood_pressure_status, pulse, pulse_status, date_value, time_value, comments);
//
//        String systol1 = "85";
//        String diastol1 = "65";
//        String pulse1 = "58";
//        String comments1 = "sitting";
//        String blood_pressure_status1 = "Normal";
//        String pulse_status1 = "Regular";
//        Calendar calendar1 = Calendar.getInstance();
//
//        Date currentDate1 = calendar.getTime();
//        String date_value1 = DateFormat.getDateInstance(DateFormat.FULL).format(currentDate);
//
//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("hh:mm a");
//        String time_value1 = simpleDateFormat.format(calendar.getTime());
//
//        boolean flag = myDatabaseHelper.updateDataWithId(Long.toString(id), systol1, diastol1, blood_pressure_status1, pulse1, pulse_status1,date_value1, time_value1, comments1);
//
//        assertTrue(flag);
//
//        myDatabaseHelper.close();
//    }

}