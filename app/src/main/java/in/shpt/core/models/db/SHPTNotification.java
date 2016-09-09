package in.shpt.core.models.db;

import java.util.Date;

import ollie.Model;
import ollie.annotation.Column;
import ollie.annotation.Table;

/**
 * Created by poovarasanv on 7/9/16.
 */

@Table("shpt_notification")
public class SHPTNotification extends Model{



    @Column("id")
    public Long ID;

    @Column("not_name")
    public String name;

    @Column("not_type")
    public String type;

    @Column("logo")
    public String logo;

    @Column("created_date")
    public Date created_date;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }
}
