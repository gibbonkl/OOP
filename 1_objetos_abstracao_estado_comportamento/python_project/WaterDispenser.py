class WaterDispenser():

    def __init__(self, volume = 0):
        self.__volume = volume
        self.__num_copos_200 = 0
        self.__num_copos_300 = 0
        
    def agua(self):
        return self.__volume
    
    def copos_200(self):
        return self.__num_copos_200

    def copos_300(self):
        return self.__num_copos_300

    def servir_copo_200(self):
        if (self.copos_200() > 0 and self.agua() >= 200):
            self.__num_copos_200 -= 1
            self.__volume -= 200

    def servir_copo_300(self):
        if (self.copos_300() > 0 and self.agua() >= 200):
            self.__num_copos_300 -= 1
            self.__volume -= 300
        
    def abastecerAgua(self, volume = 20000):
        self.__volume = volume

    def abastecer_copo_200(self):
        self.__num_copos_200 = 100

    def abastecer_copo_300(self):
        self.__num_copos_300 = 100