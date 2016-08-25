package in.shpt.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import carbon.widget.LinearLayout;
import in.shpt.R;

/**
 * Created by poovarasanv on 24/8/16.
 */
public class LanguageContextMenu extends LinearLayout {

    private int feedItem = -1;

    private OnFeedContextMenuItemClickListener onItemClickListener;

    public LanguageContextMenu(Context context) {
        super(context);
        init();
    }

    public LanguageContextMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LanguageContextMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void bindToItem(int feedItem) {
        this.feedItem = feedItem;
    }

    public void dismiss() {
        ((ViewGroup) getParent()).removeView(LanguageContextMenu.this);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.language_content_menu, this, true);
        setBackgroundResource(R.drawable.shadow_172145);
        setOrientation(VERTICAL);
        setLayoutParams(new LayoutParams(500, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    public void setOnFeedMenuItemClickListener(OnFeedContextMenuItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnFeedContextMenuItemClickListener {
        public void onReportClick(int feedItem);

        public void onSharePhotoClick(int feedItem);

        public void onCopyShareUrlClick(int feedItem);

        public void onCancelClick(int feedItem);
    }
}
