        package AdventOfCode;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;
        import java.util.stream.Collectors;

        public class ProcessLines {
            public Almanac almanac = new Almanac();
            
            private Map<String, List<List<Long>>> mapData = new HashMap<>();
            private String currentMap = null;

            
            private void mapLine(String line) {
                
                
                String[] parts = line.split("seeds:");
                Pattern spaceNumberRegex = Pattern.compile("\\s*((?:\\d+\\s*)+)");
                Pattern mapPattern = Pattern.compile("(.*map:)$");


                if (parts.length > 1) {
                    String seedsString = parts[1];
                    Matcher spaceMatcher = spaceNumberRegex.matcher(seedsString);
                    if (spaceMatcher.find()) {
                        List<Long> seeds = Arrays.stream(spaceMatcher.group(1)
                                                    .split("\\s+"))
                                                    .map(Long::parseLong)
                                                    .collect(Collectors.toList());
                        almanac.setSeeds(seeds);
                    }
                }

                Matcher mapMatcher = mapPattern.matcher(line);
                if (mapMatcher.find()) {
                    currentMap = mapMatcher.group(1);
                    mapData.putIfAbsent(currentMap, new ArrayList<>());

                } else {
                    Matcher matchNumbers = spaceNumberRegex.matcher(line);
                    if (currentMap != null && matchNumbers.find()) {
                        
                        List<Long> numbers = Arrays.stream(matchNumbers.group(1).split("\\s+"))
                                                    .map(Long::parseLong)
                                                    .collect(Collectors.toList());
                        mapData.get(currentMap).add(numbers);
                    }
                }

            }

            public long run(List<String> lines) {
                ProcessMap processor = new ProcessMap();
                for (String line : lines) {
                    mapLine(line);
                }                
                processor.processAllMappings(mapData);
            
                List<Long> seeds = almanac.getSeeds();
                List<Long> finalLocations = new ArrayList<>();
            
                for (long seed : seeds) {
                    long soil = processor.calculateDestination("seed-to-soil map:", seed);
                    long fertilizer = processor.calculateDestination("soil-to-fertilizer map:", soil);
                    long water = processor.calculateDestination("fertilizer-to-water map:", fertilizer);
                    long light = processor.calculateDestination("water-to-light map:", water);
                    long temperature = processor.calculateDestination("light-to-temperature map:", light);
                    long humidity = processor.calculateDestination("temperature-to-humidity map:", temperature);
                    long location = processor.calculateDestination("humidity-to-location map:", humidity);
                    
                    finalLocations.add(location);
                }

                long result = almanac.findMinimum(finalLocations);

                return result;
            }
        }
