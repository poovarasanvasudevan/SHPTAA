package in.shpt.models.common;

import in.shpt.shptenum.CategoryTypeEnum;

/**
 * Created by poovarasanv on 26/8/16.
 */
public class Categories {

    String name;
    String path;
    String href;
    CategoryTypeEnum categoryTypeEnum;

    public Categories(String name, String path, String href, CategoryTypeEnum categoryTypeEnum) {
        this.name = name;
        this.path = path;
        this.href = href;
        this.categoryTypeEnum = categoryTypeEnum;
    }

    public Categories() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public CategoryTypeEnum getCategoryTypeEnum() {
        return categoryTypeEnum;
    }

    public void setCategoryTypeEnum(CategoryTypeEnum categoryTypeEnum) {
        this.categoryTypeEnum = categoryTypeEnum;
    }
}
