class Member():  

    def __init__(self, fellowship, person):
        self.__member = person
        self.__member.setFellowship(fellowship)

    def person(self):
        return self.__member

    def getBreed(self):
        return self.__member.getBreed()
