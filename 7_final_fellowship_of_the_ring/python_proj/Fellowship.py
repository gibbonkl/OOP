from Member import Member

class Fellowship():

    def __init__(self, name):
        self.__name = name
        self.__members = []

    def toString(self):
        return "Fellowship " + self.__name
    
    def count(self):
        return len(self.__members)

    def hasNoMembers(self):
        return len(self.__members) == 0
    
    def hasMembers(self):
        return len(self.__members) != 0

    def member(self, index):
        if( not index > 0): raise Exception("OutOfRangeException")
        return self.__members[index-1]  if(self.count() >= index) else None

    def lastMember(self):
        return self.__members[-1]  if(self.count() > 0) else None

    def signUp(self, *people):
        for person in people:
            if (person.isAlive() and person.isMemberOfAFellowship() == False):
                member = Member(self,person)
                self.__members.append(member)
    
    def cancel(self, person):
        for member in self.__members:
            if(member.person() == person):
                person.leaveFellowship()
                self.__members.remove(member)
    
    def dissolve(self):
        print(self.count())
        for member in self.__members:
            member.person().leaveFellowship()
            self.__members.remove(member)
            print(self.count())
