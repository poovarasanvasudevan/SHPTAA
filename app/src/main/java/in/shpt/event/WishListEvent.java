package in.shpt.event;

/**
 * Created by poovarasanv on 16/9/16.
 */

public class WishListEvent {
    String message;
    String count;

    public WishListEvent() {
    }

    public WishListEvent(String message, String count) {
        this.message = message.replace("(", "").replace(")", "");
        this.count = count;
    }

    public String getMessage() {
        return message.replace("(", "").replace(")", "");
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
