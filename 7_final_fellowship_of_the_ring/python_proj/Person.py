class Person():
    
    def __init__(self, name):
        self.__name = name
        self.__fellowship = None
        self.__isAlive = True

    def name(self):
        return self.__name

    def toString(self):
        return self.name()
    
    def person(self):
        return self

    def setFellowship(self, fellowship):
        self.__fellowship = fellowship
    
    def fellowship(self):
        return self.__fellowship

    def isMemberOfAFellowship(self):
        return self.__fellowship != None
    
    def isMemberOfTheFellowship(self, fellowship):
        return self.__fellowship == fellowship
    
    def join(self, fellowship):
        if(self.fellowship() == None):
            fellowship.signUp(self) 
    
    def getBreed(self, breed = 'Person'):
        return breed
    
    def leaveFellowship(self):
        self.__fellowship = None

    def left(self):
        if(self.isMemberOfAFellowship):
            self.fellowship().cancel(self)
    
    def isAlive(self):
        return self.__isAlive

    def die(self):
        if(self.isAlive() == True):
            self.left()
            self.__isAlive = False
    
    def isFellowOf(self, person):
        return self.fellowship() == person.fellowship()

    def fellow(self, person):
        self.join(person.fellowship()) 


class Dwarf(Person):
    
    def __init__(self, name):
        super().__init__(name)

    def getBreed(self, breed = 'Person'):
        super('Dwarf')

class Elf(Person):
    
    def __init__(self, name):
        super().__init__(name)

    def getBreed(self, breed = 'Person'):
        super('Elf')

class Hobbit(Person):
    
    def __init__(self, name):
        super().__init__(name)

    def getBreed(self, breed = 'Person'):
        super('Hobbit')

class Human(Person):
    
    def __init__(self, name):
        super().__init__(name)

    def getBreed(self, breed = 'Person'):
        super('Human')

class Wizard(Person):
    
    def __init__(self, name):
        super().__init__(name)

    def getBreed(self, breed = 'Person'):
        super('Wizard')