import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    private static class CheckInRecord {
        String stationName;
        int time;
        
        public CheckInRecord(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private static class RouteStats {
        long totalTime;
        int tripCount;
        
        public RouteStats(long totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    private Map<Integer, CheckInRecord> checkIns;
    private Map<String, RouteStats> routes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routes = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInRecord(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInRecord record = checkIns.get(id);
        String startStation = record.stationName;
        int travelTime = t - record.time;
        
        String routeKey = startStation + "->" + stationName;
        
        RouteStats stats = routes.get(routeKey);
        if (stats == null) {
            routes.put(routeKey, new RouteStats(travelTime, 1));
        } else {
            stats.totalTime += travelTime;
            stats.tripCount++;
        }
        
        checkIns.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteStats stats = routes.get(routeKey);
        return (double) stats.totalTime / stats.tripCount;
    }
}

