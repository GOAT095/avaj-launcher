package com.goat.avaj.WeatherProvider;

import com.goat.avaj.aircraft.Coordinates;
import com.goat.avaj.tower.Tower;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates){

        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }
    public void changeWeather(){
        this.conditionsChanged();
    }
}
