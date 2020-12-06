package cat.itb.gestitb;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import java.util.Date;

public class MissedAttendanceFragment extends Fragment {
    private EditText nameText;
    private CheckBox isJustified;
    private Spinner moduleSpinner;
    private Button dateButton;
    private Button addButton;
    private MissedAttendance missedAttendance;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.missed_attendance_fragment, container, false);

        nameText = v.findViewById(R.id.name_text);
        moduleSpinner = v.findViewById(R.id.spinner);
        isJustified = v.findViewById(R.id.is_justified);
        dateButton = v.findViewById(R.id.date_button);
        addButton = v.findViewById(R.id.add_button);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.modules, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        moduleSpinner.setAdapter(adapter);
        dateButton.setEnabled(false);
        dateButton.setText((new Date()).toString());

        if (getArguments() != null)
            missedAttendance = getArguments().getParcelable("missedAttendance");
        if (missedAttendance != null) {
            nameText.setText(missedAttendance.getNameStudent());
            moduleSpinner.setSelection(0);
            isJustified.setChecked(missedAttendance.isJustified());
            dateButton.setText(missedAttendance.getDate().toString());
            addButton.setVisibility(View.INVISIBLE);
        } else missedAttendance = new MissedAttendance();

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (nameText != null) {
            nameText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    missedAttendance.nameStudent = nameText.getText().toString();
                    return false;
                }
            });
        }


        if (moduleSpinner != null) {
            moduleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    missedAttendance.moduleName = parent.getItemAtPosition(position).toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    missedAttendance.moduleName = "";
                }
            });
        }

        if (isJustified != null) {
            isJustified.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    missedAttendance.isJustified = isChecked;
                }
            });
        }

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                String moduleSelection = moduleSpinner.getSelectedItem().toString();
                String date = dateButton.getText().toString();
                if (!name.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Missed attendance create");

                    if (isJustified.isChecked()) {
                        builder.setMessage("The student " + name + " has missed " + moduleSelection + " on " + date + " with justification");
                    } else {
                        builder.setMessage("The student " + name + " has missed " + moduleSelection + " on " + date + " without justification");
                    }

                    builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            nameText.setText("");
                            moduleSpinner.setSelection(0);
                            dateButton.setText((new Date()).toString());
                            isJustified.setChecked(false);
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                } else {
                    Toast.makeText(getContext(), "Put the student/'s name", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
