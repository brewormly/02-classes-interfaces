## Static and regular inner classes

1. [What is a static class?](http://lmgtfy.com/?q=java+static+inner+class)
	- Refresh your knowledge on UML (_e.g._ [here](http://plantuml.com/class-diagram))
	- What's the difference between a regular inner and static inner class?
	- Can you think of some use cases for both?
    ------
    - https://stackoverflow.com/questions/70324/java-inner-class-and-static-nested-class
    - Was spricht für eine statische inner Klasse: Statisch heißt ich kann ohne ein SimpleListImpl auf ein Element zugreifen. Ich kann dann nicht auf die Objekte der SimpleListImpl zugreifen.
2. Implement `Element` as static inner class of `SimpleListImpl`.
	- Why is this class static, and ideally `private`?
3. Implement the `Iterator` interface as inner class of `SimpleListImpl`.
	- Why is it helpful to make this class non-static?
    - Weil ich auf den Head zugreifen muss (current = head)
    - Wenn der Iterator static wäre dann könnte ich das nicht
4. Add the `Iterable` interface to your `SimpleListImpl`, and implement the required methods.
	- Why is implementing the `Iterable` interface essential for a (good) list implementation? (Hint: Check the test cases!)
    - weil ich dann foreach(Element el : list) schreiben kann
	- Are there any language definition constraints to this?


## Anonymous (inner) classes and lambda expressions

1. Implement the `filter` method for your `SimpleListImpl` class (see `SimpleFilter` interface).
2. Check the given test suite for an example on 
	- how to use an anonymous class with an interface.
	- how an anonymous class can be replaced by a lambda expression.
3. Add some test methods and implement another filter logic (_e.g._ every third number, or any number smaller than a certain value).
5. Review anonymous classes and lambdas.
	- Lambda expressions look very convenient; can you think of a scenario where they should not be used?
    - man kann nur auf ein element prüfen, immer dann wenn man einen anderen kontext braucht oder wenn man sich etwas merken muss geht es nicht mehr, immer dann wenn ich einen Zustand brauche; wenn es schlicht zu komplex wird, so dass man nicht mehr auf anhieb erkennt was der Ausdruck macht
	- Recall how scoping works for anonymous (inner or local) classes; can you think of a scenario where to avoid them? 
    - auf protected kann zugegriffen werden :/
