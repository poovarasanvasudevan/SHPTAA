
package in.shpt.models.language;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Limit implements Parcelable
{

    @SerializedName("text")
    @Expose
    private int text;
    @SerializedName("value")
    @Expose
    private int value;
    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Limit> CREATOR = new Creator<Limit>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Limit createFromParcel(Parcel in) {
            Limit instance = new Limit();
            instance.text = ((int) in.readValue((int.class.getClassLoader())));
            instance.value = ((int) in.readValue((int.class.getClassLoader())));
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Limit[] newArray(int size) {
            return (new Limit[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The text
     */
    public int getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(int text) {
        this.text = text;
    }

    /**
     * 
     * @return
     *     The value
     */
    public int getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 
     * @return
     *     The href
     */
    public String getHref() {
        return href;
    }

    /**
     * 
     * @param href
     *     The href
     */
    public void setHref(String href) {
        this.href = href;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(text);
        dest.writeValue(value);
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}
