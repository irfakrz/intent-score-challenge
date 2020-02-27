package id.putraprima.skorbola.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String namaHome;
    private String namaAway;
    private int skorHome;
    private int skorAway;

    public User(String namaHome, String namaAway, int skorHome, int skorAway) {
        this.namaHome = namaHome;
        this.namaAway = namaAway;
        this.skorHome = skorHome;
        this.skorAway = skorAway;
    }

    public String getNamaHome() {
        return namaHome;
    }

    public void setNamaHome(String namaHome) {
        this.namaHome = namaHome;
    }

    public String getNamaAway() {
        return namaAway;
    }

    public void setNamaAway(String namaAway) {
        this.namaAway = namaAway;
    }

    public int getSkorHome() {
        return skorHome;
    }

    public void setSkorHome(int skorHome) {
        this.skorHome = skorHome;
    }

    public int getSkorAway() {
        return skorAway;
    }

    public void setSkorAway(int skorAway) {
        this.skorAway = skorAway;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.namaHome);
        dest.writeString(this.namaAway);
        dest.writeInt(this.skorHome);
        dest.writeInt(this.skorAway);
    }

    protected User(Parcel in) {
        this.namaHome = in.readString();
        this.namaAway = in.readString();
        this.skorHome = in.readInt();
        this.skorAway = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
