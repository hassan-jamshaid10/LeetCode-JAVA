class MyCalendarTwo {
    private List<int[]> events;
    private List<int[]> overlaps;

    public MyCalendarTwo() {
        events = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] overlap : overlaps) {
            if (Math.max(start, overlap[0]) < Math.min(end, overlap[1])) {
                return false; 
            }
        }

        for (int[] event : events) {
            int overlapStart = Math.max(start, event[0]);
            int overlapEnd = Math.min(end, event[1]);

            if (overlapStart < overlapEnd) {
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }

        events.add(new int[]{start, end});
        return true;
    }
}
