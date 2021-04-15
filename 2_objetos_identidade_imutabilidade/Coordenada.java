class Coordenada{

    final double longitude;
    final double latitude;

      Coordenada(){
        this.longitude = 0.0;
        this.latitude = 0.0;
      }

      Coordenada (double lat, double lg){
        if(lg<-180 || lg>180 || lat<-90 || lat >90) throw new AssertionError();
        this.longitude = lg;
        this.latitude = lat;
      }

      Coordenada norte(double lt){
      return new Coordenada(this.latitude+lt, this.longitude);
      }

      Coordenada sul(double lt){
      return new Coordenada(this.latitude-lt, this.longitude);
      }

      Coordenada leste(double lg){
      return new Coordenada(this.latitude, this.longitude+lg);
      }

      Coordenada oeste(double lg){
      return new Coordenada(this.latitude, this.longitude-lg);
      }

      boolean noEquador(){
        if(this.latitude == 0) return true;
      return false;
      }

      boolean noMeridiano(){
        if(this.longitude == 0 || this.longitude == 180
                || this.longitude == -180) return true;
      return false;
      }

      boolean noNorte(){
        if(this.latitude>0) return true;
      return false;
      }

      boolean noSul(){
        if(this.latitude<0) return true;
      return false;
      }

      boolean noOriente(){
        if(this.longitude>0) return true;
      return false;
      }

      boolean noOcidente(){
        if(this.longitude<0) return true;
      return false;
      }

      @Override
      public String toString(){
        String latitudeString = "" + latitude;
        String longitudeString = "" + longitude;
        int LatCount = 7;
        int LongCount = 7;

        for(int i=latitudeString.length()-1; i>=0; i--){
          if(latitudeString.charAt(i) == '.'){
            i=0;
          } else LatCount--;
        }

        for(int i=longitudeString.length()-1; i>=0; i--){
          if(longitudeString.charAt(i) == '.'){
            i=0;
          } else LongCount--;
        }

        String printable = "" + latitude;
        while (LatCount > 0) {
          printable = printable + "0";
          LatCount--;
        }
        printable = printable + "°" + ", " + longitude;
        while (LongCount > 0) {
          printable = printable + "0";
          LongCount--;
        }
        printable = printable + "°";
      return printable;

      }

      @Override
      public boolean equals(Object o){
        Coordenada outraCoordenada = (Coordenada) o;
      return (this.latitude == outraCoordenada.latitude)
              && (this.longitude == outraCoordenada.longitude);
      }

      public String googleMaps(){
        String printable = "" + "https://www.google.com.br/maps/@"
                              + latitude;
        printable = printable + "," + longitude;
        printable = printable + ",10z?hl=pt-BR";
      return printable;

      }
}
