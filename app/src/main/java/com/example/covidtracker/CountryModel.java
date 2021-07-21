package com.example.covidtracker;

public class CountryModel {

    private String flag,country,cases,today_cases,deaths,Today_deaths,recovered,activeCases,CriticalCases;

    public CountryModel(String flag, String country, String cases, String today_cases, String deaths, String today_deaths, String recovered, String activeCases, String criticalCases) {
        this.flag = flag;
        this.country = country;
        this.cases = cases;
        this.today_cases = today_cases;
        this.deaths = deaths;
        Today_deaths = today_deaths;
        this.recovered = recovered;
        this.activeCases = activeCases;
        CriticalCases = criticalCases;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCases() {
        return cases;
    }

    public void setCases(String cases) {
        this.cases = cases;
    }

    public String getToday_cases() {
        return today_cases;
    }

    public void setToday_cases(String today_cases) {
        this.today_cases = today_cases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getToday_deaths() {
        return Today_deaths;
    }

    public void setToday_deaths(String today_deaths) {
        Today_deaths = today_deaths;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public String getCriticalCases() {
        return CriticalCases;
    }

    public void setCriticalCases(String criticalCases) {
        CriticalCases = criticalCases;
    }
}

