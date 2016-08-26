
package in.shpt.models.language;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Breadcrumb implements Parcelable
{

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("separator")
    @Expose
    private String separator;
    public final static Parcelable.Creator<Breadcrumb> CREATOR = new Creator<Breadcrumb>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Breadcrumb createFromParcel(Parcel in) {
            Breadcrumb instance = new Breadcrumb();
            instance.text = ((String) in.readValue((String.class.getClassLoader())));
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            instance.separator = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Breadcrumb[] newArray(int size) {
            return (new Breadcrumb[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
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

    /**
     * 
     * @return
     *     The separator
     */
    public String getSeparator() {
        return separator;
    }

    /**
     * 
     * @param separator
     *     The separator
     */
    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(text);
        dest.writeValue(href);
        dest.writeValue(separator);
    }

    public int describeContents() {
        return  0;
    }

}
