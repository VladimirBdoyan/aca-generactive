package com.company.model;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir
 * Date: 20.07.2021.
 * Time: 16:06.
 */
public class Configuration {
    private Resolution resolution;

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public Configuration(Resolution resolution) {
        this.resolution = resolution;
    }

    public enum Resolution {

        HD(1, "HD"),
        FHD(2, "FHD "),
        FOUR_4K(4, "4K");

        private int coefficient;
        private String name;

        public int getCoefficient() {
            return coefficient;
        }

        public String getName() {
            return name;
        }

        Resolution(int coefficient, String name) {
            this.coefficient = coefficient;
            this.name = name;
        }
    }
}
