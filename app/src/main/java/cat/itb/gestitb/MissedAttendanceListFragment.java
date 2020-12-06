package cat.itb.gestitb;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MissedAttendanceListFragment extends Fragment {
    private MissedAttendanceViewModel missAttViewModel = null;
    private RecyclerView recyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        missAttViewModel = new ViewModelProvider(requireActivity()).get(MissedAttendanceViewModel.class);
        Log.d("MissedAttenListFragment", "Total Missed Attendances: " + missAttViewModel.missedAttendances.size());
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.missed_attendance_list_fragment, container, false);

        recyclerView = v.findViewById(R.id.missed_attendance_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager((getContext())));
        MissedAttendanceAdapter adapter = new MissedAttendanceAdapter(missAttViewModel.missedAttendances);
        recyclerView.setAdapter(adapter);

        return v;
    }


}