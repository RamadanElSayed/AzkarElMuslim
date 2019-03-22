package com.azkar.azkarelmuslim.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity
public class AzkarModelDB implements Serializable {

    @PrimaryKey
    private  Long azkarId;

    @SerializedName("content")
    @ColumnInfo(name = "content")
    private String  azkarContent;

    public AzkarModelDB() {
    }

    public Long getAzkarId() {
        return azkarId;
    }

    public void setAzkarId(Long azkarId) {
        this.azkarId = azkarId;
    }

    public String getAzkarContent() {
        return azkarContent;
    }

    public void setAzkarContent(String azkarContent) {
        this.azkarContent = azkarContent;
    }
}
