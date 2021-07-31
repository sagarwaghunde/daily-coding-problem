package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//https://leetcode.com/problems/reconstruct-itinerary/
public class ReconstructItinerary_322 {
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
    
    public List<String> findItinerary(List<List<String>> tickets) {
        boolean[] edgeAddded = new boolean[tickets.size()];
        Map<String, Set<String>> adjList = getAdjList(tickets);
        List<String> result = new ArrayList<>();
        result.add("JFK");
        dfs("JFK", result, new HashSet<>(), adjList);
        return result; 
    }
    
    void dfs(String currentCity, List<String> result, Set<String> visitedEdges, Map<String, Set<String>> adjList) {
        Set<String> cities = adjList.getOrDefault(currentCity, new TreeSet<>());
        
        Iterator<String> cityIterator = cities.iterator();
        while(cityIterator.hasNext()) {
            String nextCity = cityIterator.next();
            String travel = currentCity + "-" + nextCity;
            if(visitedEdges.contains(travel)) {
                continue;
            }
            visitedEdges.add(travel);
            result.add(nextCity);
            dfs(nextCity, result, visitedEdges, adjList);
        }
    }
    Map<String, Set<String>> getAdjList(List<List<String>> tickets) {
        Map<String, Set<String>> adjList = new HashMap<>();
        for(List<String> edge : tickets) {
            Set<String> cities = adjList.getOrDefault(edge.get(0), new TreeSet<>());
            cities.add(edge.get(1));
            adjList.put(edge.get(0), cities);
        }
        return adjList;
    }
}
