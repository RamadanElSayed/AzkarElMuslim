package com.azkar.azkarelmuslim.azkartypespackage.models;

public class AzkarTypeModel {

    private String azkarSbahText;

    private String periodAzkarSbah;

    private float azkarSbahFont = 23f;
    private String IncreaseOrDecrease="";
    private int indexOfAzkarNow;

    public String getIncreaseOrDecrease() {
        return IncreaseOrDecrease;
    }

    public void setIncreaseOrDecrease(String increaseOrDecrease) {
        IncreaseOrDecrease = increaseOrDecrease;
    }

    public AzkarTypeModel() {
    }

    public AzkarTypeModel(String azkarSbahText, String periodAzkarSbah) {
        this.azkarSbahText = azkarSbahText;
        this.periodAzkarSbah = periodAzkarSbah;
    }

    public int getIndexOfAzkarNow() {
        return indexOfAzkarNow;
    }

    public void setIndexOfAzkarNow(int indexOfAzkarNow) {
        this.indexOfAzkarNow = indexOfAzkarNow;
    }

    public String getAzkarSbahText() {
        return azkarSbahText;
    }

    public void setAzkarSbahText(String azkarSbahText) {
        this.azkarSbahText = azkarSbahText;
    }

    public String getPeriodAzkarSbah() {
        return periodAzkarSbah;
    }

    public void setPeriodAzkarSbah(String periodAzkarSbah) {
        this.periodAzkarSbah = periodAzkarSbah;
    }

    public float getAzkarSbahFont() {
        return azkarSbahFont;
    }

    public void setAzkarSbahFont(float azkarSbahFont) {
        this.azkarSbahFont = azkarSbahFont;
    }
}
