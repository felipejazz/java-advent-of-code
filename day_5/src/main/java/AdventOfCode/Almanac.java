package AdventOfCode;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;


class Almanac {
    private List<Long> seeds;
    private Map<Long, Long> seedToSoilMap = new HashMap<>();
    private Map<Long, Long> soilToFertilizerMap = new HashMap<>();
    private Map<Long, Long> fertilizerToWaterMap = new HashMap<>();
    private Map<Long, Long> waterToLightMap = new HashMap<>();
    private Map<Long, Long> lightToTemperatureMap = new HashMap<>();
    private Map<Long, Long> temperatureToHumidityMap = new HashMap<>();
    private Map<Long, Long> humitidyToLocationMap = new HashMap<>();



    public List<Long> getSeeds() {
        return seeds;
    }

    public void setSeeds(List<Long> seeds) {
        this.seeds = seeds;
    }

    public Map<Long, Long> getSeedToSoilMap() {
        return seedToSoilMap;
    }

    public void setSeedToSoilMap(Map<Long, Long> seedToSoilMap) {
        this.seedToSoilMap = seedToSoilMap;
    }

    public Map<Long, Long> getSoilToFertilizerMap() {
        return soilToFertilizerMap;
    }

    public void setSoilToFertilizerMap(Map<Long, Long> soilToFertilizerMap) {
        this.soilToFertilizerMap = soilToFertilizerMap;
    }

    public Map<Long, Long> getFertilizerToWaterMap() {
        return fertilizerToWaterMap;
    }

    public void setFertilizerToWaterMap(Map<Long, Long> fertilizerToWaterMap) {
        this.fertilizerToWaterMap = fertilizerToWaterMap;
    }

    public Map<Long, Long> getWaterToLightMap() {
        return waterToLightMap;
    }

    public void setWaterToLightMap(Map<Long, Long> waterToLightMap) {
        this.waterToLightMap = waterToLightMap;
    }

    public Map<Long, Long> getLightToTemperatureMap() {
        return lightToTemperatureMap;
    }

    public void setLightToTemperatureMap(Map<Long, Long> lightToTemperatureMap) {
        this.lightToTemperatureMap = lightToTemperatureMap;
    }

    public Map<Long, Long> getTemperatureToHumidityMap() {
        return temperatureToHumidityMap;
    }

    public void setTemperatureToHumidityMap(Map<Long, Long> temperatureToHumidityMap) {
        this.temperatureToHumidityMap = temperatureToHumidityMap;
    }

    public Map<Long, Long> getHumitidyToLocationMap() {
        return humitidyToLocationMap;
    }

    public void setHumitidyToLocationMap(Map<Long, Long> humitidyToLocationMap) {
        this.humitidyToLocationMap = humitidyToLocationMap;
    }


    public long matchMinorLocation() {

        List<Long> seeds = getSeeds();
        Map<Long, Long> seedToSoilMap = getSeedToSoilMap();
        Map<Long, Long> soilToFertilizerMap = getSoilToFertilizerMap();
        Map<Long, Long> fertilizerToWaterMap = getFertilizerToWaterMap();
        Map<Long, Long> waterToLightMap = getWaterToLightMap();
        Map<Long, Long> lightToTemperatureMap = getLightToTemperatureMap();
        Map<Long, Long> temperatureToHumidityMap = getTemperatureToHumidityMap();
        Map<Long, Long> humitidyToLocationMap = getHumitidyToLocationMap();
        List<Long> locations = new ArrayList<>();

        for (long seed: seeds) {
            long soil = seedToSoilMap.get(seed);
            long fertilizer = soilToFertilizerMap.get(soil);
            long water = fertilizerToWaterMap.get(fertilizer);
            long light = waterToLightMap.get(water);
            long temperature = lightToTemperatureMap.get(light);
            long humidity = temperatureToHumidityMap.get(temperature);
            long location = humitidyToLocationMap.get(humidity);
            locations.add(location);
            
        }

        long result = findMinimum(locations);
        

        return result;

    }

    public long findMinimum(List<Long> array) {
        if (array == null || array.size() == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
    
        long min = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) < min) {
                min = array.get(i);
            }
        }
        return min;
    }
    

    
    // @Override
    // public String toString() {
    //     return "Almanac: " +
    //             "seeds=" + seeds;

    //             //  +
    //             // ", gameNumbers=" + gameNumbers +
    //             // ", winnnigGame=" + winningGame;
    // }
}