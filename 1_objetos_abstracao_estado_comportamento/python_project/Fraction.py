class Fraction():
    
    def __init__ (self, numerador = 0, denominador = 1):
        if (numerador < 0 or denominador < 0): raise Exception("UnsupportedOperationException")
        if (denominador == 0): raise Exception("IllegalArgumentException")
         
        self.numerador = numerador
        self.denominador = denominador

    def mais(self, param1, param2):
        mmc = self.mmc(param2)
        self.numerador = (self.numerador*mmc/self.denominador) + (param1*mmc/param2)
        self.denominador = mmc    

    def mmc(self, param):
        r1 = param
        r2 = self.denominador
        resp = 1
    
        if(r1 > r2): max = r1 
        else: max = r2
        
        if (r1 == 1 or r2 == 1 or r1 == r2): resp = max
        else:
            for i in range (2, max+1, 1):
                while (r1%i == 0 or r2%i == 0):
                    resp = resp*i
                    if (r1%i == 0): r1 = r1/i
                    if (r2%i == 0): r2 = r2/i
        return resp

    '''
    def __init__ (self, *args):
        if (len(args) > 0): 
            self.numerador = int(args[0])
            if (int(args[0]) < 0): raise Exception("UnsupportedOperationException") 
            if (len(args) > 1): 
                if (int(args[1]) == 0): raise Exception("IllegalArgumentException") 
                if (int(args[1]) < 0): raise Exception("UnsupportedOperationException") 
                self.denominador = int(args[1])
            else: self.denominador = 1
        else: 
            self.numerador = 0
            self.denominador = 1
    '''    