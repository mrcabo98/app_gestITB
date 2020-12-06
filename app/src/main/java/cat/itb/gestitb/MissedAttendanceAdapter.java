package cat.itb.gestitb;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MissedAttendanceAdapter extends RecyclerView.Adapter<MissedAttendanceAdapter.MissedAttendaveViewHolder> {
    List<MissedAttendance> missedAttendances;

    public MissedAttendanceAdapter(List<MissedAttendance> missedAttendances) {
        this.missedAttendances = missedAttendances;
    }

    public class MissedAttendaveViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private TextView moduleTextView;
        private TextView dateTextView;
        private ImageView justifiedImageView;

        public MissedAttendaveViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.student_name_text);
            moduleTextView = itemView.findViewById(R.id.module_name_text);
            dateTextView = itemView.findViewById(R.id.date_text);
            justifiedImageView = itemView.findViewById(R.id.is_justified);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NavDirections listToFragmentDirections = MissedAttendanceListFragmentDirections.actionListToFragment(missedAttendances.get(getAdapterPosition()));
                    Navigation.findNavController(v).navigate(listToFragmentDirections);
                }
            });
        }

        public void bind(MissedAttendance missedAttendance) {
            nameTextView.setText(missedAttendance.getNameStudent());
            moduleTextView.setText(missedAttendance.getModuleName());
            dateTextView.setText(missedAttendance.getDate().toString());
            justifiedImageView.setVisibility(missedAttendance.isJustified() ? View.VISIBLE : View.INVISIBLE);
        }
    }


    @Override
    public MissedAttendaveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.missed_attendance_list_item, parent, false);

        return new MissedAttendaveViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MissedAttendaveViewHolder holder, int position) {
        MissedAttendance missedAttendance = missedAttendances.get(position);
        holder.bind(missedAttendance);
    }

    @Override
    public int getItemCount() {
        return missedAttendances.size();
    }

}
