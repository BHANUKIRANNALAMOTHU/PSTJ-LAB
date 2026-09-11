import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    // Maps customer id -> (startStation, checkInTime)
    private Map<Integer, CheckInInfo> checkInMap;
    // Maps "startStation->endStation" -> (totalTime, count)
    private Map<String, RouteInfo> routeMap;

    private static class CheckInInfo {
        String stationName;
        int time;

        CheckInInfo(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

    private static class RouteInfo {
        double totalTime;
        int count;

        RouteInfo(double totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkInMap.remove(id);
        String routeKey = info.stationName + "->" + stationName;
        int duration = t - info.time;
        
        RouteInfo route = routeMap.getOrDefault(routeKey, new RouteInfo(0, 0));
        route.totalTime += duration;
        route.count += 1;
        routeMap.put(routeKey, route);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteInfo route = routeMap.get(routeKey);
        return route.totalTime / route.count;
    }
}
