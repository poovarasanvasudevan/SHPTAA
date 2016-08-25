
package in.shpt.models.products.book;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product implements Parcelable
{

    @SerializedName("quantity")
    @Expose
    private String quantity;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("special")
    @Expose
    private boolean special;
    @SerializedName("free_shipping")
    @Expose
    private boolean freeShipping;
    @SerializedName("free_shipping_date")
    @Expose
    private String freeShippingDate;
    @SerializedName("stock_status")
    @Expose
    private String stockStatus;
    @SerializedName("tax")
    @Expose
    private boolean tax;
    @SerializedName("rating")
    @Expose
    private int rating;
    @SerializedName("item_language")
    @Expose
    private String itemLanguage;
    @SerializedName("reviews")
    @Expose
    private String reviews;
    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Product> CREATOR = new Creator<Product>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Product createFromParcel(Parcel in) {
            Product instance = new Product();
            instance.quantity = ((String) in.readValue((String.class.getClassLoader())));
            instance.productId = ((String) in.readValue((String.class.getClassLoader())));
            instance.thumb = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.price = ((String) in.readValue((String.class.getClassLoader())));
            instance.special = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.freeShipping = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.freeShippingDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.stockStatus = ((String) in.readValue((String.class.getClassLoader())));
            instance.tax = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.rating = ((int) in.readValue((int.class.getClassLoader())));
            instance.itemLanguage = ((String) in.readValue((String.class.getClassLoader())));
            instance.reviews = ((String) in.readValue((String.class.getClassLoader())));
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Product[] newArray(int size) {
            return (new Product[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * 
     * @param quantity
     *     The quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * 
     * @return
     *     The productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId
     *     The product_id
     */
    public void setProductId(String productId) {
        this.productId = productId;
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
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
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
     *     The price
     */
    public String getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 
     * @return
     *     The special
     */
    public boolean isSpecial() {
        return special;
    }

    /**
     * 
     * @param special
     *     The special
     */
    public void setSpecial(boolean special) {
        this.special = special;
    }

    /**
     * 
     * @return
     *     The freeShipping
     */
    public boolean isFreeShipping() {
        return freeShipping;
    }

    /**
     * 
     * @param freeShipping
     *     The free_shipping
     */
    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    /**
     * 
     * @return
     *     The freeShippingDate
     */
    public Object getFreeShippingDate() {
        return freeShippingDate;
    }

    /**
     * 
     * @param freeShippingDate
     *     The free_shipping_date
     */
    public void setFreeShippingDate(String freeShippingDate) {
        this.freeShippingDate = freeShippingDate;
    }

    /**
     * 
     * @return
     *     The stockStatus
     */
    public String getStockStatus() {
        return stockStatus;
    }

    /**
     * 
     * @param stockStatus
     *     The stock_status
     */
    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    /**
     * 
     * @return
     *     The tax
     */
    public boolean isTax() {
        return tax;
    }

    /**
     * 
     * @param tax
     *     The tax
     */
    public void setTax(boolean tax) {
        this.tax = tax;
    }

    /**
     * 
     * @return
     *     The rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * 
     * @param rating
     *     The rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * 
     * @return
     *     The itemLanguage
     */
    public String getItemLanguage() {
        return itemLanguage;
    }

    /**
     * 
     * @param itemLanguage
     *     The item_language
     */
    public void setItemLanguage(String itemLanguage) {
        this.itemLanguage = itemLanguage;
    }

    /**
     * 
     * @return
     *     The reviews
     */
    public String getReviews() {
        return reviews;
    }

    /**
     * 
     * @param reviews
     *     The reviews
     */
    public void setReviews(String reviews) {
        this.reviews = reviews;
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
        dest.writeValue(quantity);
        dest.writeValue(productId);
        dest.writeValue(thumb);
        dest.writeValue(name);
        dest.writeValue(description);
        dest.writeValue(price);
        dest.writeValue(special);
        dest.writeValue(freeShipping);
        dest.writeValue(freeShippingDate);
        dest.writeValue(stockStatus);
        dest.writeValue(tax);
        dest.writeValue(rating);
        dest.writeValue(itemLanguage);
        dest.writeValue(reviews);
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}
