package com.goat.avaj.aircraft;

import com.goat.avaj.flayable.Flayable;
import com.goat.avaj.WeatherProvider.WeatherTower;

public class Baloon extends Aircraft implements Flayable {
    private WeatherTower weatherTower;

//    @Override
//    void fuckOff() {
//
//    }

    public Baloon(String name, Coordinates coordinates){
        super(name, coordinates);

    }

    @Override
    public void registerTower(WeatherTower weatherTower){

        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
//    • Baloon:
//            ◦ SUN - Longitude increases with 2, Height increases with 4
//            ◦ RAIN - Height decreases with 5
//            ◦ FOG - Height decreases with 3
//            ◦ SNOW - Height decreases with 15
    @Override
    public void updateConditions(){
        String WeatherNow = weatherTower.getWeather(this.coordinates);
        Randomizer rand = new Randomizer();
        switch (WeatherNow) {
            case "SUN" -> {
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, coordinates.getLatitude(), this.coordinates.getHeight() + 4);
                System.out.println(this.toString() + " " + this.Sun[(rand.generate(0,2))]);
            }
            case "RAIN" -> {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), coordinates.getLatitude(), this.coordinates.getHeight() - 5);
                System.out.println(toString() + " " + this.Rain[(rand.generate(0,2))]);
            }
            case "FOG" -> {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), coordinates.getLatitude(), this.coordinates.getHeight() - 3);
                System.out.println(toString() + " " + this.Fog[(rand.generate(0,2))]);
            }
            case "SNOW" -> {
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), coordinates.getLatitude(), this.coordinates.getHeight() - 15);
                System.out.println(toString() + " " + this.Snow[(rand.generate(0,2))]);
            }
            default -> {
            }
        }
        if(this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        if(coordinates.getHeight() <= 0){
            System.out.println(this.toString() + " is landing right now.");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: " + this.toString() + " unregistered from weather tower.");
        }
    }

    @Override
    public String toString() {
        return "Baloon#" + this.name + "(" +  this.id + ")";
    }
}
