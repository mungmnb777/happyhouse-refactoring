package com.ssafy.happyhouse.dto;

import com.ssafy.happyhouse.dto.address.City;

import java.time.LocalDateTime;

public class HouseDto {
    private int id;
    private String name;
    private String price;
    private String buildYear;
    private String dealYear;
    private String dealMonth;
    private String dealDay;
    private String roadName;
    private String mainRoadNo;
    private String subRoadNo;
    private String area;
    private City city;

    public HouseDto() {
        super();
    }

    public HouseDto(int id, String name, String price, String buildYear, String dealYear, String dealMonth,
                    String dealDay, String roadName, String mainRoadNo, String subRoadNo, String area, City city) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.buildYear = buildYear;
        this.dealYear = dealYear;
        this.dealMonth = dealMonth;
        this.dealDay = dealDay;
        this.roadName = roadName;
        this.mainRoadNo = mainRoadNo;
        this.subRoadNo = subRoadNo;
        this.area = area;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBuildYear() {
        return buildYear;
    }

    public void setBuildYear(String buildYear) {
        this.buildYear = buildYear;
    }

    public String getDealYear() {
        return dealYear;
    }

    public void setDealYear(String dealYear) {
        this.dealYear = dealYear;
    }

    public String getDealMonth() {
        return dealMonth;
    }

    public void setDealMonth(String dealMonth) {
        this.dealMonth = dealMonth;
    }

    public String getDealDay() {
        return dealDay;
    }

    public void setDealDay(String dealDay) {
        this.dealDay = dealDay;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getMainRoadNo() {
        return mainRoadNo;
    }

    public void setMainRoadNo(String mainRoadNo) {
        this.mainRoadNo = mainRoadNo;
    }

    public String getSubRoadNo() {
        return subRoadNo;
    }

    public void setSubRoadNo(String subRoadNo) {
        this.subRoadNo = subRoadNo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "HouseDto [id=" + id + ", name=" + name + ", price=" + price + ", buildYear=" + buildYear + ", dealYear="
                + dealYear + ", dealMonth=" + dealMonth + ", dealDay=" + dealDay + ", roadName=" + roadName
                + ", mainRoadNo=" + mainRoadNo + ", subRoadNo=" + subRoadNo + ", area=" + area + ", city=" + city + "]";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int id;
        private String name;
        private String price;
        private String buildYear;
        private String dealYear;
        private String dealMonth;
        private String dealDay;
        private String roadName;
        private String mainRoadNo;
        private String subRoadNo;
        private String area;
        private City city;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(String price) {
            this.price = price;
            return this;
        }

        public Builder buildYear(String buildYear) {
            this.buildYear = buildYear;
            return this;
        }

        public Builder dealYear(String dealYear) {
            this.dealYear = dealYear;
            return this;
        }

        public Builder dealMonth(String dealMonth) {
            this.dealMonth = dealMonth;
            return this;
        }

        public Builder dealDay(String dealDay) {
            this.dealDay = dealDay;
            return this;
        }

        public Builder roadName(String roadName) {
            this.roadName = roadName;
            return this;
        }

        public Builder mainRoadNo(String mainRoadNo) {
            this.mainRoadNo = mainRoadNo;
            return this;
        }

        public Builder subRoadNo(String subRoadNo) {
            this.subRoadNo = subRoadNo;
            return this;
        }

        public Builder area(String area) {
            this.area = area;
            return this;
        }

        public Builder city(City city) {
            this.city = city;
            return this;
        }

        public HouseDto build() {
            return new HouseDto(id, name, price, buildYear, dealYear, dealMonth, dealDay, roadName, mainRoadNo, subRoadNo, area, city);
        }
    }
}
