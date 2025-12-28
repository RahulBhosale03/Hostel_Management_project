package com.hostel.hostel_management.dashboard.dto;

public class ChartDataResponse {

    private String label;
    private long value;

    public ChartDataResponse() {}

    public ChartDataResponse(String label, long value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
