package cat.itb.gestitb;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class MissedAttendance implements Parcelable {
    String nameStudent;
    String moduleName;
    Date date;
    boolean isJustified;

    public MissedAttendance() {
        this.nameStudent = "";
        this.moduleName = "";
        this.date = new Date();
        this.isJustified = false;
    }

    protected MissedAttendance(Parcel in) {
        nameStudent = in.readString();
        moduleName = in.readString();
        isJustified = in.readByte() != 0;
    }

    public static final Creator<MissedAttendance> CREATOR = new Creator<MissedAttendance>() {
        @Override
        public MissedAttendance createFromParcel(Parcel in) {
            return new MissedAttendance(in);
        }

        @Override
        public MissedAttendance[] newArray(int size) {
            return new MissedAttendance[size];
        }
    };

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isJustified() {
        return isJustified;
    }

    public void setJustified(boolean justified) {
        isJustified = justified;
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameStudent);
        dest.writeString(moduleName);
        dest.writeByte((byte) (isJustified ? 1 : 0));
    }
}