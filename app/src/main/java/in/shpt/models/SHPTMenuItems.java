package in.shpt.models;

import android.graphics.drawable.Drawable;

/**
 * Created by poovarasanv on 4/8/16.
 */
public class SHPTMenuItems {

    Drawable icon;
    String title;

    public SHPTMenuItems(Drawable icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
