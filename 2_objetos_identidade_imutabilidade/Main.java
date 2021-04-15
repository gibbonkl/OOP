class Main {

    public static void main(String[] args) {

      System.out.println("_______1_______");
      Time t1 = new Time();
      // representação string, padrão 00:00:00
      System.out.println(t1.toString().equals("00:00:00"));
      Time t2 = new Time(1, 40, 5);
      System.out.println(t2.toString().equals("01:40:05"));
      Time t3 = t1.plus(t2);
      System.out.println(t3.toString().equals("01:40:05"));
      System.out.println(t3.hours() == 1);
      System.out.println(t3.minutes() == 40);
      System.out.println(t3.seconds() == 5);
      // deve ser imutável
      System.out.println(t1.hours() == 0);
      System.out.println(t1.minutes() == 0);
      System.out.println(t1.seconds() == 0);
      // plus
      Time t4 = t3.plus(t2);
      System.out.println(t4.toString().equals("03:20:10"));
      // implementar equals
      System.out.println(t4.equals(new Time(3, 20, 10)));
      Time t5 = t2.plusHours(1);
      System.out.println(t5.toString().equals("02:40:05"));
      Time t6 = t4.plusHours(23);
      System.out.println(t6.toString().equals("02:20:10"));
      Time t7 = t6.plusMinutes(10);
      System.out.println(t7.toString().equals("02:30:10"));
      Time t8 = t7.plusSeconds(80);
      System.out.println(t8.toString().equals("02:31:30"));
      // até aqui 0.2
      Time t9 = new Time().plusHours(19).plusMinutes(23).plusSeconds(18);
      System.out.println(t9.toString().equals("19:23:18"));
      Time t10 = t9.plusHours(-1).plusMinutes(-1).plusSeconds(-1);
      System.out.println(t10.toString().equals("18:22:17"));
      Time t11 = t10.minusHours(2).minusMinutes(2).minusSeconds(2);
      System.out.println(t11.toString().equals("16:20:15"));
      Time t12 = t11.minusHours(-5);
      System.out.println(t12.toString().equals("21:20:15"));
      Time t13 = t11.minus(t12);
      System.out.println(t13.toString().equals("19:00:00"));
      System.out.println(t13.isMidDay() == false);
      Time t14 = t13.minus(t13);
      System.out.println(t14.toString().equals("00:00:00"));
      System.out.println(t14.isMidDay() == false);
      System.out.println(t14.isMidNight() == true);
      System.out.println(t14.plusHours(12).isMidDay() == true);
      Time t15 = new Time(3, 40);
      System.out.println(t15.toString().equals("03:40:00"));
      Time t16 = t15.shift();
      System.out.println(t16.toString().equals("15:40:00"));
      Time t17 = t16.shift();
      System.out.println(t17.toString().equals("03:40:00"));
      Time t18 = t17.tick();
      System.out.println(t18.toString().equals("03:40:01"));
      Time t19 = t18.tick().tick().tick();
      System.out.println(t19.toString().equals("03:40:04"));
      Time t20 = t19.plusHours(50).plusMinutes(50).minusSeconds(50).tick().shift();

      System.out.println(t20.toString().equals("18:29:15"));

      System.out.println("_______2_______");
      // construtores:
      Coordenada c1 = new Coordenada();
      System.out.println(c1.latitude == 0.0);
      System.out.println(c1.longitude == 0.0);

      Coordenada c2 = new Coordenada(50.0, 134.0);
      System.out.println(c2.latitude == 50.0);
      System.out.println(c2.longitude == 134.0);

      Coordenada c3 = new Coordenada(-90.0, -180.0);
      System.out.println(c3.latitude == -90.0);
      System.out.println(c3.longitude == -180.0);

      // estas coordenadas são inválidas e devem lançar exceção
      // faça serem rejeitadas e depois comente-as para não parar o programa

      //Coordenada e1 = new Coordenada(-91.0, 0.0);
      //Coordenada e2 = new Coordenada(100.0, 0.0);
      //Coordenada e3 = new Coordenada(10.0, -182.0);
      //Coordenada e4 = new Coordenada(10.0, 200.0);
      //Coordenada e5 = new Coordenada(-95.0, -200.0);

      // imutabilidade: as linhas a seguir devem causar erro de compilação
      // verifique se está de acordo e depois comente-as
      Coordenada c4 = new Coordenada();

      //c4.latitude = 30.0;  // não deve permitir reatribuição
      //c4.longitude = 80.0; // não deve permitir reatribuição

      // operações/comandos:
      Coordenada in = new Coordenada(30.0, 50.0);
      Coordenada out = in.norte(5.0);
      System.out.println(in.latitude == 30.0); // deve ser imutável
      System.out.println(out.latitude == 35.0);
      out.norte(5.0); // sem reatribuição sem alteração
      System.out.println(out.latitude == 35.0);
      out = out.norte(5.0); // reatribuindo
      System.out.println(out.latitude == 40.0);
      out = out.sul(60.0);
      System.out.println(out.latitude == -20.0);
      out = out.sul(30.0);
      System.out.println(out.latitude == -50.0);
      out = out.sul(-10.0);
      System.out.println(out.latitude == -40.0);
      out = out.norte(-10.0);
      System.out.println(out.latitude == -50.0);
      System.out.println(out.longitude == 50.0);
      out = out.leste(50.0);
      System.out.println(out.longitude == 100.0);
      out = out.oeste(180.0);
      System.out.println(out.longitude == -80.0);
      out = out.oeste(-10.0);
      System.out.println(out.longitude == -70.0);
      out = out.leste(-10.0);
      System.out.println(out.longitude == -80.0);
      // até aqui 0.2

      // consultas:
      Coordenada q = new Coordenada();
      System.out.println(q.latitude == 0);
      System.out.println(q.longitude == 0);
      System.out.println(q.noEquador() == true);
      System.out.println(q.noMeridiano() == true);
      q = q.norte(10.0);
      System.out.println(q.latitude == 10);
      System.out.println(q.noEquador() == false);
      q = q.leste(10.0);
      System.out.println(q.noMeridiano() == false);
      q = q.leste(170.0);
      System.out.println(q.longitude == 180.0);
      System.out.println(q.noMeridiano() == true);
      q = q.oeste(200.0);
      System.out.println(q.longitude == -20.0);
      System.out.println(q.noMeridiano() == false);
      q = q.oeste(160.0);
      System.out.println(q.longitude == -180.0);
      System.out.println(q.noMeridiano() == true);

      Coordenada r = new Coordenada(30.0, 70.0);
      System.out.println(r.latitude == 30.0);
      System.out.println(r.longitude == 70.0);
      System.out.println(r.noNorte() == true);
      System.out.println(r.noSul() == false);
      System.out.println(r.noOriente() == true);
      System.out.println(r.noOcidente() == false);
      r = r.oeste(140.0).sul(60.0);
      System.out.println(r.latitude == -30.0);
      System.out.println(r.longitude == -70.0);
      System.out.println(r.noNorte() == false);
      System.out.println(r.noSul() == true);
      System.out.println(r.noOriente() == false);
      System.out.println(r.noOcidente() == true);

      // toString:
      System.out.println(c1.toString().equals("0.0000000°, 0.0000000°"));
      System.out.println(c2.toString().equals("50.0000000°, 134.0000000°"));
      System.out.println(c3.toString().equals("-90.0000000°, -180.0000000°"));
      System.out.println(out.toString().equals("-50.0000000°, -80.0000000°"));
      System.out.println(q.toString().equals("10.0000000°, -180.0000000°"));
      System.out.println(r); // -30.0000000°, -70.0000000°
      System.out.println(r.toString().equals("-30.0000000°, -70.0000000°"));

      Coordenada t = new Coordenada(-32.0714021, -52.1425059);
      // https://www.google.com.br/maps/@-32.0714021,-52.1425059,13z?hl=pt-BR
      System.out.println(t);; // -32.0714021°, -52.1425059°
      System.out.println(t.toString().equals("-32.0714021°, -52.1425059°"));

      // equals:
      System.out.println(t.equals(r) == false);
      Coordenada y = new Coordenada(-32.0714021, -52.1425059);
      System.out.println(t.equals(y) == true);
      System.out.println(y.equals(t) == true);
      System.out.println(y.equals(y) == true);
      System.out.println(y.equals(r) == false);

      System.out.println("-desafio-");
      // desafio: escrever método que retorna link para Google Maps!
      Coordenada u = new Coordenada(37.402473, -122.3212843);
      String url = u.googleMaps();
      System.out.println(url.equals("https://www.google.com.br/maps/@37.402473,-122.3212843,10z?hl=pt-BR"));
      // descomente para ver se funciona (não testei)
      // Runtime.getRuntime().exec("google-chrome " + url);
      // tente outro navegador, no windows tente "start " + url

      System.out.println("_______3_______");

      System.out.println("Testando intervalo ...");
      Randomizer randomizer1 = new Randomizer();
      for (int i = 0; i < 1000000; i++) {
          double n = randomizer1.next();
          if (n < 0 || n >= 1.0) System.out.println("false: " + n);
      }
      System.out.println("Testando variação ...");
      Randomizer randomizer2 = new Randomizer();
      int[] variacao = new int[10];
      for (int i = 0; i < 1000000; i++) {
          variacao[((int) (randomizer2.next() * 10))]++;
      }
      // até aqui vale 0.1
      // deve ter +ou- 100000 em cada slot:
      System.out.println(java.util.Arrays.toString(variacao));
      System.out.println("Testando nextInt ...");
      Randomizer randomizer3 = new Randomizer();
      for (int i = 0; i < 1000000; i++) {
          int n = randomizer3.nextInt(17);
          if (n < 0 || n > 17) System.out.println("false: " + n);
      }
      for (int i = 0; i < 1000000; i++) {
          int n = randomizer3.nextInt(17, 51);
          if (n < 17 || n > 51) System.out.println("false: " + n);
      }

}
}
