package cat.itb.gestitb;

import android.os.Bundle;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;

import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class MissedAttendanceListFragmentDirections {
    private MissedAttendanceListFragmentDirections() {
    }

    @NonNull
    public static ActionListToFragment actionListToFragment(
            @NonNull MissedAttendance missedAttendance) {
        return new ActionListToFragment(missedAttendance);
    }

    public static class ActionListToFragment implements NavDirections {
        private final HashMap arguments = new HashMap();

        private ActionListToFragment(@NonNull MissedAttendance missedAttendance) {
            if (missedAttendance == null) {
                throw new IllegalArgumentException("Argument \"missedAttendance\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("missedAttendance", missedAttendance);
        }

        @NonNull
        public ActionListToFragment setMissedAttendance(@NonNull MissedAttendance missedAttendance) {
            if (missedAttendance == null) {
                throw new IllegalArgumentException("Argument \"missedAttendance\" is marked as non-null but was passed a null value.");
            }
            this.arguments.put("missedAttendance", missedAttendance);
            return this;
        }

        @Override
        @SuppressWarnings("unchecked")
        @NonNull
        public Bundle getArguments() {
            Bundle __result = new Bundle();
            if (arguments.containsKey("missedAttendance")) {
                MissedAttendance missedAttendance = (MissedAttendance) arguments.get("missedAttendance");
                if (Parcelable.class.isAssignableFrom(MissedAttendance.class) || missedAttendance == null) {
                    __result.putParcelable("missedAttendance", Parcelable.class.cast(missedAttendance));
                } else if (Serializable.class.isAssignableFrom(MissedAttendance.class)) {
                    __result.putSerializable("missedAttendance", Serializable.class.cast(missedAttendance));
                } else {
                    throw new UnsupportedOperationException(MissedAttendance.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
                }
            }
            return __result;
        }

        @Override
        public int getActionId() {
            return R.id.action_list_to_fragment;
        }

        @SuppressWarnings("unchecked")
        @NonNull
        public MissedAttendance getMissedAttendance() {
            return (MissedAttendance) arguments.get("missedAttendance");
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            ActionListToFragment that = (ActionListToFragment) object;
            if (arguments.containsKey("missedAttendance") != that.arguments.containsKey("missedAttendance")) {
                return false;
            }
            if (getMissedAttendance() != null ? !getMissedAttendance().equals(that.getMissedAttendance()) : that.getMissedAttendance() != null) {
                return false;
            }
            if (getActionId() != that.getActionId()) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 31 * result + (getMissedAttendance() != null ? getMissedAttendance().hashCode() : 0);
            result = 31 * result + getActionId();
            return result;
        }

        @Override
        public String toString() {
            return "ActionListToFragment(actionId=" + getActionId() + "){"
                    + "missedAttendance=" + getMissedAttendance()
                    + "}";
        }
    }
}
