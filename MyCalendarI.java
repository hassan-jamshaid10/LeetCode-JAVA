class MyCalendar {
    private List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] booking : bookings) {
            int bookedStart = booking[0];
            int bookedEnd = booking[1];
         
            if (start < bookedEnd && bookedStart < end) {
                return false;  
            }
        }
   
        bookings.add(new int[]{start, end});
        return true;
    }
}