package net.ivanevla.covid19app.dto;

import java.util.List;

public class CountryDataDto {
    private String country;
    private List<String> labels;
    private List<CountryDataByIndicatorDto> datasets;

    public CountryDataDto(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<CountryDataByIndicatorDto> getDatasets() {
        return datasets;
    }

    public void setDatasets(List<CountryDataByIndicatorDto> datasets) {
        this.datasets = datasets;
    }
}
