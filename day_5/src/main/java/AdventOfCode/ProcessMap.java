package AdventOfCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProcessMap {
    static class MapEntry {
        long destinationStart;
        long sourceStart;
        long rangeLength;

        public MapEntry(long destinationStart, long sourceStart, long rangeLength) {
            this.destinationStart = destinationStart;
            this.sourceStart = sourceStart;
            this.rangeLength = rangeLength;
        }
    }

    private Map<String, List<MapEntry>> mappings = new HashMap<>();

    public void addMapping(String mapName, long destinationStart, long sourceStart, long rangeLength) {
        mappings.computeIfAbsent(mapName, k -> new ArrayList<>()).add(new MapEntry(destinationStart, sourceStart, rangeLength));
    }

    public Map<Long, Long> processSeeds(String mapName) {
        Map<Long, Long> seedToSoil = new HashMap<>();
        
        for (long i = 0; i <= 99; i++) {
            seedToSoil.put(i, i);
        }
        
        
        List<MapEntry> mapEntries = mappings.getOrDefault(mapName, new ArrayList<>());
        

        for (MapEntry entry : mapEntries) {


            long sourceStart = entry.sourceStart;
            long destStart = entry.destinationStart;
            long rangeLength = entry.rangeLength;
            
            for (int i = 0; i < rangeLength; i++) {
                long source = sourceStart + i;
                long dest = destStart + i;
                seedToSoil.put(source, dest);
            }
        }
        
        return seedToSoil;
    }

    public void processAllMappings(Map<String, List<List<Long>>> mapData) {
        for (Map.Entry<String, List<List<Long>>> entry : mapData.entrySet()) {
            String mapName = entry.getKey();
            List<List<Long>> mapParams = entry.getValue();
            for (List<Long> params : mapParams) {
                if (params.size() == 3) { 
                    this.addMapping(mapName, params.get(0), params.get(1), params.get(2));
                }
            }
        }
    }

    public long calculateDestination(String mapName, long source) {
        List<MapEntry> mapEntries = mappings.getOrDefault(mapName, new ArrayList<>());
        for (MapEntry entry : mapEntries) {
            long sourceEnd = entry.sourceStart + entry.rangeLength - 1;
            if (source >= entry.sourceStart && source <= sourceEnd) {
                
                long offset = source - entry.sourceStart;
                
                return entry.destinationStart + offset;
            }
        }
        return source;
    }
}
