package com.goat.avaj.flayable;

import com.goat.avaj.tower.WeatherTower;

public interface Flayable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
    default void something()
    {
        System.out.println("something");
    }

}
