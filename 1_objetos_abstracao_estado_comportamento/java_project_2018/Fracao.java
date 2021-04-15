class Fracao {

  int numerador;
  int denominador;

  Fracao (int n, int d) {
  if (d==0) throw new IllegalArgumentException();
  if (d<0 || n<0) throw new UnsupportedOperationException();
  this.numerador = n;
  this. denominador = d;
  }

  Fracao (int n) {
  this.numerador = n;
  this.denominador = 1;
  }

  Fracao () {
    this.numerador = 0;
    this.denominador = 1;
  }

  int numerador() {
    return this. numerador;
  }

  int denominador() {
    return this.denominador;
  }

  void mais (int a, int b) {
    if (b == this.denominador) {
      this.numerador = this.numerador + a;
    } else {
    this.denominador = this.denominador * b;
    this.numerador = a*10 + this.numerador;
  }
  }


}
