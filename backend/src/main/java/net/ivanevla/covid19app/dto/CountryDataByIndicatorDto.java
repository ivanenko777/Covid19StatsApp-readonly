package net.ivanevla.covid19app.dto;

import java.util.ArrayList;
import java.util.List;

public class CountryDataByIndicatorDto {
    private String label;
    private List<Integer> data;

    public CountryDataByIndicatorDto() {
        this.data = new ArrayList<>();
    }

    public CountryDataByIndicatorDto(String label, List<Integer> data) {
        this.label = label;
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public List<Integer> getData() {
        return data;
    }
}
