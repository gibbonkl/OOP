class Time{

    private final int seconds;

    //`h:m:s`, `h:m` e somente `h`
    Time (int h, int m, int s){
      this.seconds = s+ m*60 + h*3600;
    }

    Time (int h, int m){
      this.seconds = m*60 + h*3600;
    }

    Time (int h){
      this.seconds = h*3600;
    }

    Time () {
      this.seconds = 0;
    }

    Time plus(Time t){
      int newSec = (this.seconds + t.seconds);
    return new Time(hourConverter(newSec),
                minuteConverter(newSec), secondConverter(newSec));
    }

    int hours(){
    return hourConverter(this.seconds);
    }

    int minutes(){
    return minuteConverter(this.seconds);
    }

    int seconds(){
    return secondConverter(this.seconds);
    }

    Time plusHours(int h){
    int newSec = (this.seconds + h*3600);
    return new Time(hourConverter(newSec),
              minuteConverter(newSec), secondConverter(newSec));
    }

    Time plusMinutes(int m){
      int newSec = (this.seconds + m*60);
    return new Time(hourConverter(newSec),
                minuteConverter(newSec), secondConverter(newSec));
    }

    Time plusSeconds(int s){
      int newSec = (this.seconds + s);
    return new Time(hourConverter(newSec),
                minuteConverter(newSec), secondConverter(newSec));
    }

    Time minus(Time t){
      int newSec = (this.seconds - t.seconds);
    return new Time(hourConverter(newSec),
                minuteConverter(newSec), secondConverter(newSec));
    }

    Time minusHours(int h){
      int newSec = (this.seconds - h*3600);
    return new Time(hourConverter(newSec),
                minuteConverter(newSec), secondConverter(newSec));
    }

    Time minusMinutes(int m){
      int newSec = (this.seconds - m*60);
    return new Time(hourConverter(newSec),
                minuteConverter(newSec), secondConverter(newSec));
    }

    Time minusSeconds(int s){
      int newSec = (this.seconds - s);
    return new Time(hourConverter(newSec),
                minuteConverter(newSec), secondConverter(newSec));
    }

    Time tick(){
    return plusSeconds(1);
    } //(adiciona um segundo)

    Time shift(){
      if(hours()<=12) return plusHours(12);
    return minusHours(12);
    } //(inverte o turno)

    boolean isMidDay(){
      if(toString().equals("12:00:00")) return true;
    return false;
    } //(questiona se é meio-dia)

    boolean isMidNight(){
      if(toString().equals("00:00:00")) return true;
    return false;
    } //(questiona se é meia-noite)

    @Override // annotation
    public String toString() {

      String printable = "";

      if (hours() < 10){
        printable = printable + "0" + hours();
      } else printable = printable + hours();

      printable = printable + ":";

      if (minutes() < 10){
        printable = printable + "0" + minutes();
      } else printable = printable + minutes();

      printable = printable + ":";

      if (seconds() < 10){
        printable = printable + "0" + seconds();
      } else printable = printable + seconds();

    return printable;
    }

    @Override
    public boolean equals(Object o) {
      Time outroTime = (Time) o;
    return this.seconds == outroTime.seconds;
    }

    //Support Methods
    int hourConverter(int sec){
      if (sec/3600 > 23) return (sec/3600)-24;
      if (sec/3600 < 0) return (sec/3600)+24;
    return sec/3600;
    }

    int minuteConverter(int sec){
    return (sec%3600)/60;
    }

    int secondConverter(int sec){
    return (sec%3600)%60;
    }

}
