from WaterDispenser import WaterDispenser

def main():

  maq = WaterDispenser()

  print(maq.agua() == 0) # mL
  print(maq.copos_200() == 0)
  print(maq.copos_300() == 0)
  maq.servir_copo_200() # não efetua

  print(maq.agua() == 0) # mL
  print(maq.copos_200() == 0)
  print(maq.copos_300() == 0)

  maq.abastecerAgua() # inicializa 20000mL
  print(maq.agua() == 20000) # mL

  maq.abastecerAgua() # mantém consistente
  print(maq.agua() == 20000) # mL

  maq.servir_copo_200() # não efetua, sem copo
  print(maq.agua() == 20000) # mL


  maq.abastecer_copo_200() # agora a máquina possui 100 copos de 200
  print(maq.copos_200() == 100)

  # correção (A.K.A. PATCH!) =====================================
  maq.servir_copo_200()
  maq.servir_copo_200()
  maq.servir_copo_200()
  maq.servir_copo_200()
  maq.servir_copo_200() # -1000ml e 5 copos de 200

  print(maq.agua() == 19000)
  print(maq.copos_200() == 95)
  print(maq.copos_300() == 0)

  maq.abastecer_copo_200() # agora a máquina possui 100 copos de 200 novamente
  print(maq.copos_200() == 100)

  maq.servir_copo_200() # -200ml e 1 copo de 200
  # fim correção =====================================

  print(maq.agua() == 18800)
  print(maq.copos_200() == 99)
  print(maq.copos_300() == 0)

  maq.abastecer_copo_300() # agora a máquina possui 100 copos de 300
  print(maq.copos_300() == 100)

  maq.servir_copo_300()
  print(maq.agua() == 18500)
  print(maq.copos_200() == 99)
  print(maq.copos_300() == 99)

  # servir 50 copos de 300 = 15000ml
  for i in range (0, 50, 1):
    maq.servir_copo_300()

  print(maq.agua() == 3500)
  print(maq.copos_200() == 99)
  print(maq.copos_300() == 49)

  # servir 17 copos de 200 = 3400ml
  for i in range (0, 17, 1):
    maq.servir_copo_200()

  print(maq.agua() == 100)
  print(maq.copos_200() == 82)
  print(maq.copos_300() == 49)

  # não há água para atender o pedido
  maq.servir_copo_300()

  print(maq.agua() == 100)
  print(maq.copos_200() == 82)
  print(maq.copos_300() == 49)

  # não há água para atender o pedido
  maq.servir_copo_200()

  print(maq.agua() == 100)
  print(maq.copos_200() == 82)
  print(maq.copos_300() == 49)

  maq.abastecerAgua() # inicializa 20000mL

  print(maq.agua() == 20000)
  print(maq.copos_200() == 82)
  print(maq.copos_300() == 49)

  # servir os 49 copos de 300 restantes = 14700ml
  while (maq.copos_300() > 0):
    maq.servir_copo_300()

  print(maq.agua() == 5300)
  print(maq.copos_200() == 82)
  print(maq.copos_300() == 0)

  # não há copo para atender o pedido
  maq.servir_copo_300()

  print(maq.agua() == 5300)
  print(maq.copos_200() == 82)
  print(maq.copos_300() == 0)

  maq.servir_copo_200() # de 200 ok
  maq.servir_copo_200() # de 200 ok

  print(maq.agua() == 4900)
  print(maq.copos_200() == 80)
  print(maq.copos_300() == 0)

  maq.abastecer_copo_300() # 100 copos de 300

  print(maq.agua() == 4900)
  print(maq.copos_200() == 80)
  print(maq.copos_300() == 100)

  # 3 copos de 300
  maq.servir_copo_300() 
  maq.servir_copo_300() 
  maq.servir_copo_300()

  print(maq.agua() == 4000)
  print(maq.copos_200() == 80)
  print(maq.copos_300() == 97)

  input('Press ENTER to exit')

if __name__ == "__main__":
    print('Terminal execution!')
    main()
else:
  print('Module execution!')
  main()
