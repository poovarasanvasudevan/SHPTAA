
package in.shpt.models.language;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class CommonCategoryFormat implements Parcelable
{

    @SerializedName("breadcrumbs")
    @Expose

    private List<Breadcrumb> breadcrumbs = new ArrayList<Breadcrumb>();
    @SerializedName("heading_title")
    @Expose
    private String headingTitle;
    @SerializedName("text_refine")
    @Expose
    private String textRefine;
    @SerializedName("text_empty")
    @Expose
    private String textEmpty;
    @SerializedName("text_quantity")
    @Expose
    private String textQuantity;
    @SerializedName("text_manufacturer")
    @Expose
    private String textManufacturer;
    @SerializedName("text_model")
    @Expose
    private String textModel;
    @SerializedName("text_price")
    @Expose
    private String textPrice;
    @SerializedName("text_tax")
    @Expose
    private String textTax;
    @SerializedName("text_points")
    @Expose
    private String textPoints;
    @SerializedName("text_compare")
    @Expose
    private String textCompare;
    @SerializedName("text_display")
    @Expose
    private String textDisplay;
    @SerializedName("text_list")
    @Expose
    private String textList;
    @SerializedName("text_grid")
    @Expose
    private String textGrid;
    @SerializedName("text_sort")
    @Expose
    private String textSort;
    @SerializedName("text_limit")
    @Expose
    private String textLimit;
    @SerializedName("button_cart")
    @Expose
    private String buttonCart;
    @SerializedName("button_wishlist")
    @Expose
    private String buttonWishlist;
    @SerializedName("button_compare")
    @Expose
    private String buttonCompare;
    @SerializedName("button_continue")
    @Expose
    private String buttonContinue;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("compare")
    @Expose
    private String compare;
    @SerializedName("categories")
    @Expose

    private List<Category> categories = new ArrayList<Category>();
    @SerializedName("products")
    @Expose

    private List<Product> products = new ArrayList<Product>();
    @SerializedName("sorts")
    @Expose

    private List<Sort> sorts = new ArrayList<Sort>();
    @SerializedName("limits")
    @Expose

    private List<Limit> limits = new ArrayList<Limit>();
    @SerializedName("sort")
    @Expose
    private String sort;
    @SerializedName("order")
    @Expose
    private String order;
    @SerializedName("limit")
    @Expose
    private String limit;
    public final static Parcelable.Creator<CommonCategoryFormat> CREATOR = new Creator<CommonCategoryFormat>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CommonCategoryFormat createFromParcel(Parcel in) {
            CommonCategoryFormat instance = new CommonCategoryFormat();
            in.readList(instance.breadcrumbs, (in.shpt.models.language.Breadcrumb.class.getClassLoader()));
            instance.headingTitle = ((String) in.readValue((String.class.getClassLoader())));
            instance.textRefine = ((String) in.readValue((String.class.getClassLoader())));
            instance.textEmpty = ((String) in.readValue((String.class.getClassLoader())));
            instance.textQuantity = ((String) in.readValue((String.class.getClassLoader())));
            instance.textManufacturer = ((String) in.readValue((String.class.getClassLoader())));
            instance.textModel = ((String) in.readValue((String.class.getClassLoader())));
            instance.textPrice = ((String) in.readValue((String.class.getClassLoader())));
            instance.textTax = ((String) in.readValue((String.class.getClassLoader())));
            instance.textPoints = ((String) in.readValue((String.class.getClassLoader())));
            instance.textCompare = ((String) in.readValue((String.class.getClassLoader())));
            instance.textDisplay = ((String) in.readValue((String.class.getClassLoader())));
            instance.textList = ((String) in.readValue((String.class.getClassLoader())));
            instance.textGrid = ((String) in.readValue((String.class.getClassLoader())));
            instance.textSort = ((String) in.readValue((String.class.getClassLoader())));
            instance.textLimit = ((String) in.readValue((String.class.getClassLoader())));
            instance.buttonCart = ((String) in.readValue((String.class.getClassLoader())));
            instance.buttonWishlist = ((String) in.readValue((String.class.getClassLoader())));
            instance.buttonCompare = ((String) in.readValue((String.class.getClassLoader())));
            instance.buttonContinue = ((String) in.readValue((String.class.getClassLoader())));
            instance.thumb = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.compare = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.categories, (in.shpt.models.language.Category.class.getClassLoader()));
            in.readList(instance.products, (in.shpt.models.language.Product.class.getClassLoader()));
            in.readList(instance.sorts, (in.shpt.models.language.Sort.class.getClassLoader()));
            in.readList(instance.limits, (in.shpt.models.language.Limit.class.getClassLoader()));
            instance.sort = ((String) in.readValue((String.class.getClassLoader())));
            instance.order = ((String) in.readValue((String.class.getClassLoader())));
            instance.limit = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public CommonCategoryFormat[] newArray(int size) {
            return (new CommonCategoryFormat[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The breadcrumbs
     */
    public List<Breadcrumb> getBreadcrumbs() {
        return breadcrumbs;
    }

    /**
     * 
     * @param breadcrumbs
     *     The breadcrumbs
     */
    public void setBreadcrumbs(List<Breadcrumb> breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
    }

    /**
     * 
     * @return
     *     The headingTitle
     */
    public String getHeadingTitle() {
        return headingTitle;
    }

    /**
     * 
     * @param headingTitle
     *     The heading_title
     */
    public void setHeadingTitle(String headingTitle) {
        this.headingTitle = headingTitle;
    }

    /**
     * 
     * @return
     *     The textRefine
     */
    public String getTextRefine() {
        return textRefine;
    }

    /**
     * 
     * @param textRefine
     *     The text_refine
     */
    public void setTextRefine(String textRefine) {
        this.textRefine = textRefine;
    }

    /**
     * 
     * @return
     *     The textEmpty
     */
    public String getTextEmpty() {
        return textEmpty;
    }

    /**
     * 
     * @param textEmpty
     *     The text_empty
     */
    public void setTextEmpty(String textEmpty) {
        this.textEmpty = textEmpty;
    }

    /**
     * 
     * @return
     *     The textQuantity
     */
    public String getTextQuantity() {
        return textQuantity;
    }

    /**
     * 
     * @param textQuantity
     *     The text_quantity
     */
    public void setTextQuantity(String textQuantity) {
        this.textQuantity = textQuantity;
    }

    /**
     * 
     * @return
     *     The textManufacturer
     */
    public String getTextManufacturer() {
        return textManufacturer;
    }

    /**
     * 
     * @param textManufacturer
     *     The text_manufacturer
     */
    public void setTextManufacturer(String textManufacturer) {
        this.textManufacturer = textManufacturer;
    }

    /**
     * 
     * @return
     *     The textModel
     */
    public String getTextModel() {
        return textModel;
    }

    /**
     * 
     * @param textModel
     *     The text_model
     */
    public void setTextModel(String textModel) {
        this.textModel = textModel;
    }

    /**
     * 
     * @return
     *     The textPrice
     */
    public String getTextPrice() {
        return textPrice;
    }

    /**
     * 
     * @param textPrice
     *     The text_price
     */
    public void setTextPrice(String textPrice) {
        this.textPrice = textPrice;
    }

    /**
     * 
     * @return
     *     The textTax
     */
    public String getTextTax() {
        return textTax;
    }

    /**
     * 
     * @param textTax
     *     The text_tax
     */
    public void setTextTax(String textTax) {
        this.textTax = textTax;
    }

    /**
     * 
     * @return
     *     The textPoints
     */
    public String getTextPoints() {
        return textPoints;
    }

    /**
     * 
     * @param textPoints
     *     The text_points
     */
    public void setTextPoints(String textPoints) {
        this.textPoints = textPoints;
    }

    /**
     * 
     * @return
     *     The textCompare
     */
    public String getTextCompare() {
        return textCompare;
    }

    /**
     * 
     * @param textCompare
     *     The text_compare
     */
    public void setTextCompare(String textCompare) {
        this.textCompare = textCompare;
    }

    /**
     * 
     * @return
     *     The textDisplay
     */
    public String getTextDisplay() {
        return textDisplay;
    }

    /**
     * 
     * @param textDisplay
     *     The text_display
     */
    public void setTextDisplay(String textDisplay) {
        this.textDisplay = textDisplay;
    }

    /**
     * 
     * @return
     *     The textList
     */
    public String getTextList() {
        return textList;
    }

    /**
     * 
     * @param textList
     *     The text_list
     */
    public void setTextList(String textList) {
        this.textList = textList;
    }

    /**
     * 
     * @return
     *     The textGrid
     */
    public String getTextGrid() {
        return textGrid;
    }

    /**
     * 
     * @param textGrid
     *     The text_grid
     */
    public void setTextGrid(String textGrid) {
        this.textGrid = textGrid;
    }

    /**
     * 
     * @return
     *     The textSort
     */
    public String getTextSort() {
        return textSort;
    }

    /**
     * 
     * @param textSort
     *     The text_sort
     */
    public void setTextSort(String textSort) {
        this.textSort = textSort;
    }

    /**
     * 
     * @return
     *     The textLimit
     */
    public String getTextLimit() {
        return textLimit;
    }

    /**
     * 
     * @param textLimit
     *     The text_limit
     */
    public void setTextLimit(String textLimit) {
        this.textLimit = textLimit;
    }

    /**
     * 
     * @return
     *     The buttonCart
     */
    public String getButtonCart() {
        return buttonCart;
    }

    /**
     * 
     * @param buttonCart
     *     The button_cart
     */
    public void setButtonCart(String buttonCart) {
        this.buttonCart = buttonCart;
    }

    /**
     * 
     * @return
     *     The buttonWishlist
     */
    public String getButtonWishlist() {
        return buttonWishlist;
    }

    /**
     * 
     * @param buttonWishlist
     *     The button_wishlist
     */
    public void setButtonWishlist(String buttonWishlist) {
        this.buttonWishlist = buttonWishlist;
    }

    /**
     * 
     * @return
     *     The buttonCompare
     */
    public String getButtonCompare() {
        return buttonCompare;
    }

    /**
     * 
     * @param buttonCompare
     *     The button_compare
     */
    public void setButtonCompare(String buttonCompare) {
        this.buttonCompare = buttonCompare;
    }

    /**
     * 
     * @return
     *     The buttonContinue
     */
    public String getButtonContinue() {
        return buttonContinue;
    }

    /**
     * 
     * @param buttonContinue
     *     The button_continue
     */
    public void setButtonContinue(String buttonContinue) {
        this.buttonContinue = buttonContinue;
    }

    /**
     * 
     * @return
     *     The thumb
     */
    public String getThumb() {
        return thumb;
    }

    /**
     * 
     * @param thumb
     *     The thumb
     */
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The compare
     */
    public String getCompare() {
        return compare;
    }

    /**
     * 
     * @param compare
     *     The compare
     */
    public void setCompare(String compare) {
        this.compare = compare;
    }

    /**
     * 
     * @return
     *     The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * 
     * @return
     *     The products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * 
     * @param products
     *     The products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * 
     * @return
     *     The sorts
     */
    public List<Sort> getSorts() {
        return sorts;
    }

    /**
     * 
     * @param sorts
     *     The sorts
     */
    public void setSorts(List<Sort> sorts) {
        this.sorts = sorts;
    }

    /**
     * 
     * @return
     *     The limits
     */
    public List<Limit> getLimits() {
        return limits;
    }

    /**
     * 
     * @param limits
     *     The limits
     */
    public void setLimits(List<Limit> limits) {
        this.limits = limits;
    }

    /**
     * 
     * @return
     *     The sort
     */
    public String getSort() {
        return sort;
    }

    /**
     * 
     * @param sort
     *     The sort
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * 
     * @return
     *     The order
     */
    public String getOrder() {
        return order;
    }

    /**
     * 
     * @param order
     *     The order
     */
    public void setOrder(String order) {
        this.order = order;
    }

    /**
     * 
     * @return
     *     The limit
     */
    public String getLimit() {
        return limit;
    }

    /**
     * 
     * @param limit
     *     The limit
     */
    public void setLimit(String limit) {
        this.limit = limit;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(breadcrumbs);
        dest.writeValue(headingTitle);
        dest.writeValue(textRefine);
        dest.writeValue(textEmpty);
        dest.writeValue(textQuantity);
        dest.writeValue(textManufacturer);
        dest.writeValue(textModel);
        dest.writeValue(textPrice);
        dest.writeValue(textTax);
        dest.writeValue(textPoints);
        dest.writeValue(textCompare);
        dest.writeValue(textDisplay);
        dest.writeValue(textList);
        dest.writeValue(textGrid);
        dest.writeValue(textSort);
        dest.writeValue(textLimit);
        dest.writeValue(buttonCart);
        dest.writeValue(buttonWishlist);
        dest.writeValue(buttonCompare);
        dest.writeValue(buttonContinue);
        dest.writeValue(thumb);
        dest.writeValue(description);
        dest.writeValue(compare);
        dest.writeList(categories);
        dest.writeList(products);
        dest.writeList(sorts);
        dest.writeList(limits);
        dest.writeValue(sort);
        dest.writeValue(order);
        dest.writeValue(limit);
    }

    public int describeContents() {
        return  0;
    }

}
