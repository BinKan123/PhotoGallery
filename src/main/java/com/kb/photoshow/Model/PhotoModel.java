package com.kb.photoshow.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import static com.kb.photoshow.Model.PhotoModel.TABLE_NAME;

/**
 * Created by kanbi on 20/05/2018.
 */
@Entity(tableName = TABLE_NAME)
public class PhotoModel {
    public static final String TABLE_NAME = "Photos";

    @PrimaryKey
    @ColumnInfo(name="id")
    @NonNull
    @SerializedName("id")
    private String id;

    @ColumnInfo(name="owner")
    @SerializedName("owner")
    private String owner;

    @ColumnInfo(name="secret")
    @SerializedName("secret")
    private String secret;

    @ColumnInfo(name="server")
    @SerializedName("server")
    private String server;

    @ColumnInfo(name="farm")
    @SerializedName("farm")
    private Integer farm;

    @ColumnInfo(name="title")
    @SerializedName("title")
    private String title;

    @ColumnInfo(name="ispublic")
    @SerializedName("ispublic")
    private Integer ispublic;

    @ColumnInfo(name="isfriend")
    @SerializedName("isfriend")
    private Integer isfriend;

    @ColumnInfo(name="isfamily")
    @SerializedName("isfamily")
    private Integer isfamily;

    @ColumnInfo(name="is_primary")
    @SerializedName("is_primary")
    private Integer is_primary;

    @ColumnInfo(name="has_comment")
    @SerializedName("has_comment")
    private Integer has_comment;

    public PhotoModel() {

    }

    public PhotoModel(String id, String owner, String secret, String server, Integer farm, String title, Integer ispublic, Integer isfriend, Integer isfamily, Integer is_primary, Integer has_comment) {
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.title = title;
        this.ispublic = ispublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
        this.is_primary = is_primary;
        this.has_comment = has_comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Integer getFarm() {
        return farm;
    }

    public void setFarm(Integer farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIspublic() {
        return ispublic;
    }

    public void setIspublic(Integer ispublic) {
        this.ispublic = ispublic;
    }

    public Integer getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(Integer isfriend) {
        this.isfriend = isfriend;
    }

    public Integer getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(Integer isfamily) {
        this.isfamily = isfamily;
    }

    public Integer getIs_primary() {
        return is_primary;
    }

    public void setIs_primary(Integer is_primary) {
        this.is_primary = is_primary;
    }

    public Integer getHas_comment() {
        return has_comment;
    }

    public void setHas_comment(Integer has_comment) {
        this.has_comment = has_comment;
    }
}
