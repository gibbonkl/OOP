from Person import Person, Dwarf, Elf, Hobbit, Human, Wizard
from Fellowship import Fellowship
from Member import Member

def main():
	# Initializing People
	Gandalf = Person("Gandalf")
	Aragorn = Human("Aragorn")
	Gimli = Dwarf("Gimli")
	Legolas = Elf("Legolas")
	Boromir = Human("Boromir")
	Frodo = Hobbit("Frodo")
	Sam = Hobbit("Sam")
	Meriadoc = Hobbit("Meriadoc")
	Peregrin = Hobbit("Peregrin")
	# Initializing Fellowships
	FellowshipOfTheRing = Fellowship("of The Ring")
	EvilFellowship = Fellowship("of Evil")

	# 0.3pts -> Every person has a name
	print(Gandalf.name() == ("Gandalf"))
	print(Gandalf.toString() == ("Gandalf"))

	# 0.3pts -> There is no members yet
	print(FellowshipOfTheRing.toString() == ("Fellowship of The Ring"))
	print(EvilFellowship.toString() == ("Fellowship of Evil"))
	print(EvilFellowship.count() == 0)
	print(FellowshipOfTheRing.count() == 0)
	print(FellowshipOfTheRing.hasNoMembers() == True)
	print(FellowshipOfTheRing.hasMembers() == False)

	# 0.3pts -> Members count from 1 (not 0)
	print(FellowshipOfTheRing.member(1) == None )
	print(FellowshipOfTheRing.lastMember() == None)

	# 0.3pts -> There is two members (order matters)
	FellowshipOfTheRing.signUp(Gandalf) # member 1
	FellowshipOfTheRing.signUp(Aragorn) # member 2
	print(FellowshipOfTheRing.count() == 2)
	print(FellowshipOfTheRing.hasNoMembers() == False)
	print(FellowshipOfTheRing.hasMembers() == True)

	# 0.4pts -> Member is a intermediary class between Fellowship and Person
	print(isinstance(FellowshipOfTheRing.member(1),Member))
	#VER-> print(isinstance(FellowshipOfTheRing.member(2),Person))

	# 0.4pts -> Through Member we can access the people
	print(FellowshipOfTheRing.member(1).person().name() == ("Gandalf"))
	print(FellowshipOfTheRing.member(1).person() == (Gandalf))
	#VER-> print(FellowshipOfTheRing.member(1).person() == (Wizard("Gandalf")))
	print(not (FellowshipOfTheRing.member(1).person() == (Aragorn)))
	print(FellowshipOfTheRing.member(2).person() == (Aragorn))

	# 0.4pts -> Out of Range should not throw an exception
	#ok-> print(FellowshipOfTheRing.member(-1) == None)
	print(FellowshipOfTheRing.member(3) == None)

	# 0.4pts -> The relationship is bidirectional
	print(Aragorn.fellowship() == FellowshipOfTheRing)
	print(Aragorn.fellowship() != EvilFellowship)
	print(Aragorn.fellowship() == Gandalf.fellowship())
	print(Gimli.fellowship() == None)

	print(Aragorn.isMemberOfAFellowship() == True)
	print(Aragorn.isMemberOfTheFellowship(FellowshipOfTheRing) == True)
	print(Aragorn.isMemberOfTheFellowship(EvilFellowship) == False)
	print(Gimli.isMemberOfAFellowship() == False)
	print(Gimli.isMemberOfTheFellowship(FellowshipOfTheRing) == False)
	print(Gimli.isMemberOfTheFellowship(EvilFellowship) == False)

	# 0.5pts -> However, a person can be member of only one fellowship
	EvilFellowship.signUp(Aragorn) # Aragorn has not been included
	print(EvilFellowship.count() == 0)
	print(EvilFellowship.hasNoMembers() == True)
	print(Aragorn.fellowship() == FellowshipOfTheRing)
	print(Aragorn.isMemberOfTheFellowship(FellowshipOfTheRing) == True)
	print(Aragorn.isMemberOfTheFellowship(EvilFellowship) == False)

	# 0.5pts -> There is another way to join the fellowships
	Gimli.join(FellowshipOfTheRing)
	Gimli.join(EvilFellowship) # has no effect (already in a fellowship)
	print(FellowshipOfTheRing.count() == 3)
	print(FellowshipOfTheRing.member(3).person() == (Gimli))

	# 0.5pts -> Even indirect way
	Legolas.join(Gimli.fellowship())
	print(FellowshipOfTheRing.count() == 4)
	print(FellowshipOfTheRing.lastMember().person() == (Legolas))

	# 0.5pts -> More queries
	###### print(FellowshipOfTheRing.count("Human") == 1)
	###### print(FellowshipOfTheRing.count("Elf") == 1)
	###### print(FellowshipOfTheRing.count("Hobbit") == 0)
	###### print(FellowshipOfTheRing.has("Human") == True)
	###### print(FellowshipOfTheRing.has("Hobbit") == False)

	# 0.6pts -> Get the fellowship complete (adding various members at one time)
	print(FellowshipOfTheRing.count() == 4)
	FellowshipOfTheRing.signUp(Boromir, Frodo)
	FellowshipOfTheRing.signUp(Sam, Meriadoc, Peregrin)
	print(FellowshipOfTheRing.count() == 9)
	###### print(FellowshipOfTheRing.count("Hobbit") == 4)

	# 0.6pts -> Left the FellowshipOfTheRing
	print(FellowshipOfTheRing.count() == 9)
	######print(FellowshipOfTheRing.count("Human") == 2)
	print(Boromir.fellowship() == FellowshipOfTheRing)
	print(FellowshipOfTheRing.member(5).person() == Boromir)
	FellowshipOfTheRing.cancel(Boromir)

	print(FellowshipOfTheRing.count() == 8)
	######print(FellowshipOfTheRing.count("Human") == 1)
	print(Boromir.fellowship() == None)
	print(FellowshipOfTheRing.member(5).person() == Frodo)
		
	# 0.6pts -> Other way to unsubscribe
	Frodo.left() # leave current fellowship if any
	print(FellowshipOfTheRing.count() == 7)
	print(Frodo.fellowship() == None)

	Gandalf.die()
	print(FellowshipOfTheRing.count() == 6)
	print(Gandalf.fellowship() == None)
		
	# 0.6pts -> People can't join fellowships after die
	print(FellowshipOfTheRing.count() == 6)
	Gandalf.join(FellowshipOfTheRing)
	print(Gandalf.fellowship() == None)
	print(FellowshipOfTheRing.count() == 6)
		
	# 0.7pts -> Asking if people are sharing a fellowship
	print(Meriadoc.isFellowOf(Peregrin) == True)
	print(Meriadoc.isFellowOf(Gandalf) == False)
	print(Meriadoc.isFellowOf(Boromir) == False)
	print(Meriadoc.isFellowOf(Meriadoc) == True)
	print(Gandalf.isFellowOf(Gandalf) == True)
		
	# 0.7pts -> Should be reflexive
	print(Meriadoc.isFellowOf(Peregrin) == Peregrin.isFellowOf(Meriadoc))
	print(Meriadoc.isFellowOf(Boromir) == Boromir.isFellowOf(Meriadoc))
		
	# 0.7pts -> Yet another way to join a fellowship
	print(Boromir.fellowship() == None)
	Boromir.fellow(Meriadoc)
	print(Boromir.fellowship() == Meriadoc.fellowship())
	print(Meriadoc.isFellowOf(Boromir) == True)
	Boromir.left()
	print(Boromir.fellowship() == None)
	Meriadoc.fellow(Boromir)
	'''	
	print(Boromir.fellowship() == Meriadoc.fellowship())
		
	# 0.7pts -> Dissolve the fellowship :(
	FellowshipOfTheRing.dissolve()
	print(FellowshipOfTheRing.count() == 0)
	print(FellowshipOfTheRing.hasNoMembers() == True)
	print(FellowshipOfTheRing.member(1) == None)
	print(FellowshipOfTheRing.lastMember() == None)
	'''
	input("Press enter to esc!")

if __name__ == "__main__":
	main()
