# Dining Philosophers Problem

## To run:

`cd` into the directory and use make/gnumake.

To compile classes
```➜ make -f Makefile``` or ```➜ make all Makefile```

To run for default argument 4
```➜ make run Makefile```

To run for arguments 3,4,5
```➜ make -f Makefile regression```

To remove .class files
```➜ make Makefile clean```

## Sample runs:
You could also just compile and run it on your own

### Compile
```
➜ javac DiningPhilosophers.java
```

### Format
```
➜ java DiningPhilosophers [OPTIONAL X]
```
where X is a positive integer with default value 4

For non decimal input
```
➜ java DiningPhilosophers -7.a
"-7.a" is not a positive decimal integer

Usage: java DiningPhilosophers [NUMBER_OF_PHILOSOPHERS]
```
Run with your own arguments
```
➜ java DiningPhilosophers 1
1 philosopher(s) came in for a dinner.
Philosopher (ID: 1) has started eating.
Philosopher (ID: 1) is done eating.
Philosopher (ID: 1) has started thinking.
Philosopher (ID: 1) is done thinking.
Philosopher (ID: 1) has started talking.
Philosopher 1 says: If thee cannot speak, thee must be silent
Philosopher (ID: 1) is done talking.
Philosopher (ID: 1) has started eating.
Philosopher (ID: 1) is done eating.
Philosopher (ID: 1) has started thinking.
Philosopher (ID: 1) is done thinking.
Philosopher (ID: 1) has started talking.
Philosopher 1 says: If thee cannot speak, thee must be silent
Philosopher (ID: 1) is done talking.
Philosopher (ID: 1) has started eating.
Philosopher (ID: 1) is done eating.
Philosopher (ID: 1) has started thinking.
Philosopher (ID: 1) is done thinking.
Philosopher (ID: 1) has started talking.
Philosopher 1 says: You know, true is false and false is true if you think of it
Philosopher (ID: 1) is done talking.
Philosopher (ID: 1) has started eating.
Philosopher (ID: 1) is done eating.
Philosopher (ID: 1) has started thinking.
Philosopher (ID: 1) is done thinking.
Philosopher (ID: 1) has started talking.
Philosopher 1 says: My number is 1
Philosopher (ID: 1) is done talking.
Philosopher (ID: 1) has started eating.
Philosopher (ID: 1) is done eating.
Philosopher (ID: 1) has started thinking.
Philosopher (ID: 1) is done thinking.
Philosopher (ID: 1) has started talking.
Philosopher 1 says: Eh, it's not easy to be a philosopher: eat, think, talk, eat...
Philosopher (ID: 1) is done talking.
Philosopher (ID: 1) has started eating.
Philosopher (ID: 1) is done eating.
Philosopher (ID: 1) has started thinking.
Philosopher (ID: 1) is done thinking.
Philosopher (ID: 1) has started eating.
Philosopher (ID: 1) is done eating.
Philosopher (ID: 1) has started thinking.
Philosopher (ID: 1) is done thinking.
Philosopher (ID: 1) has started eating.
Philosopher (ID: 1) is done eating.
Philosopher (ID: 1) has started thinking.
Philosopher (ID: 1) is done thinking.
Philosopher (ID: 1) has started eating.
Philosopher (ID: 1) is done eating.
Philosopher (ID: 1) has started thinking.
Philosopher (ID: 1) is done thinking.
Philosopher (ID: 1) has started eating.
Philosopher (ID: 1) is done eating.
Philosopher (ID: 1) has started thinking.
Philosopher (ID: 1) is done thinking.
Philosopher (ID: 1) has started talking.
Philosopher 1 says: 2 + 2 = 5 for extremely large values of 2...
Philosopher (ID: 1) is done talking.
All philosophers have left. System terminates normally.
```
