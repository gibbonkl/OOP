class Randomizer{

    long seed = System.currentTimeMillis();
    double sqrd;

    double next(){
        if (seed < 100000) seed += 675248;
        sqrd = (((seed*seed)/1000.0)%1000000.0);
        if (sqrd < 0.0) sqrd = -1 * sqrd;
        seed = (long)(sqrd);
    return (sqrd/1000000.0);
    }

    int nextInt(int n){
      //System.out.println(nextInt(0,n));
    return nextInt(0,n);
    }

    int nextInt(int i, int f){
      int aux;
      do{
        aux = (int)(next()*100);
      //  System.out.println(aux);
      } while (aux<=i || aux>f);
    return aux;
    }

}
