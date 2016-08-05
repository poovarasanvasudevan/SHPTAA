package in.shpt.core.models;

import java.util.List;

/**
 * Created by poovarasanv on 4/8/16.
 */
public class SHPTNavMenu {

    /**
     * title : Accounts
     * child : [{"name":"My Accounts","action":"in.shpt.activity.HomeActivity","icon":"gmi_home"},{"name":"Address Book","action":"in.shpt.activity.HomeActivity","icon":"gmi_book"},{"name":"My Orders","action":"in.shpt.activity.HomeActivity","icon":"gmi_shopping_cart_plus"},{"name":"Credits","action":"in.shpt.activity.HomeActivity","icon":"gmi_money"}]
     */

    private String title;
    /**
     * name : My Accounts
     * action : in.shpt.activity.HomeActivity
     * icon : gmi_home
     */

    private List<ChildBean> child;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ChildBean> getChild() {
        return child;
    }

    public void setChild(List<ChildBean> child) {
        this.child = child;
    }

    public static class ChildBean {
        private String name;
        private String action;
        private String icon;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
