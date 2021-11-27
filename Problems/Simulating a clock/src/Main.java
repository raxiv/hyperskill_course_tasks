class Clock {

    int hours = 12;
    int minutes = 0;

    public void next() {
        // implement me
        if (this.minutes >= 0 && this.minutes <= 58) {
            this.minutes++;
        } else if (this.hours >= 1 && this.hours <= 11) {
            this.hours++;
            this.minutes = 0;
        } else {
            this.hours = 1;
            this.minutes = 0;
        }
    }
}