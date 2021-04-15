class Text{

//rotate
static String rotate(String e){
  String saida = "";
  if (e.length()>0){
  saida = saida + e.charAt(e.length()-1);
  for(int i=0; i< e.length()-1; i++){
    saida = saida + e.charAt(i);
  }
}
return saida;
}

//chop
static String chop(String e){
  String saida = "";
  if (e.length()>0){
  for(int i=0; i< e.length()-1; i++){
    saida = saida + e.charAt(i);
  }
}
return saida;
}

}
