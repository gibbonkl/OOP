class MaquinaAgua {

  private int volume=0;
  private int copos200=0;
  private int copos300=0;

    MaquinaAgua() {

}

    int agua(){
     return this.volume;
   }

   int copos200(){
   return this.copos200;
 }

   int copos300() {
     return this.copos300;
   }

   void servirCopo200() {
     if (this.copos200 <=0 || this.volume < 200) return;
     this.copos200 = this.copos200 - 1;
     this.volume = this.volume - 200;
   }

    void abastecerAgua() {
      this.volume = 20000;
    }

    void abastecerCopo200() {
      this.copos200 = 100;
    }

    void servirCopo300() {
      if (this.copos300 <=0 || this.volume < 300) return;
      this.copos300 = this.copos300 -1;
      this.volume = this.volume - 300;
    }

    void abastecerCopo300() {
      this.copos300 = 100;
    }
}
