import java.util.ArrayList;
import java.util.List;

class BrowserHistory {
    private List<String> history;
    private int curr;
    private int maxBoundary;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 0;
        maxBoundary = 0;
    }
    
    public void visit(String url) {
        curr++;
        if (curr < history.size()) {
            history.set(curr, url);
        } else {
            history.add(url);
        }
        // Visiting a new URL invalidates all forward history
        maxBoundary = curr;
    }
    
    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return history.get(curr);
    }
    
    public String forward(int steps) {
        curr = Math.min(maxBoundary, curr + steps);
        return history.get(curr);
    }
}
