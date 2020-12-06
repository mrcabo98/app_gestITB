package cat.itb.gestitb;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MissedAttendanceViewModel extends ViewModel {
    List<MissedAttendance> missedAttendances = new ArrayList<MissedAttendance>();

    String[] modules = {
            "M6 - Data access",
            "M7 - Interface development",
            "M8 - Mobile app development",
            "M9 - Process and service programming",
            "M15 - Complex environment",
            "M16 - AI"
    };

    public MissedAttendanceViewModel() {
        for (int i = 0; i < 100; i++) {
            MissedAttendance missedAttendance = new MissedAttendance();
            missedAttendance.setNameStudent("Student #" + i);
            missedAttendance.setModuleName(modules[(int) (Math.random() * 6)]);
            missedAttendance.setJustified(i % 2 == 0);
            missedAttendances.add(missedAttendance);
        }
    }

}