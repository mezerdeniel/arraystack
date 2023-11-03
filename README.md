# Stack

_Note: This exercise belongs to "Block 3: Algorithmen - Aufgabe"
of the module "Project and Training 2". For administrative details, see on Moodle._

You have to implement a generic Stack as an introductory exercise. This exercise should allow you to afterwards successfully work on the second part (in a different gitlab repository), 
where you will then have to implement a priority queue.

Consider the documentations of the provided interfaces for further specifications. Additionally, there are a lot of test cases (cf. also below) which may help you.

Important: You are not allowed to use standard collection classes from the libraries (for example `java.util.ArrayList` etc.), 
but you must implement yourself the data structure based on the idea of a array based stack. 

Note that all updates, error corrections etc. (if any) for this task will be available in the corresponding Moodle course.

The points for evaluation are specified below. Fulfilling just the test classes does not necessarily imply that you get all points (cf. below)!

## ArrayBasedStack

Write a class `ch.bfh.stack.ArrayBasedStack` that implements the interface `ch.bfh.stack.Stack`. Your class must use the idea of an array based stack. 

The underlying array must be _expendable_, hence when full replaced by an array of double length. Optionally, if the array is filled less than 25%, replace the array by one of half its length (use a minimum of - say - 10 elements of the array for efficiency purposes).



## Usage

The class `ch.bfh.stack.StackUseExample` shows how such a stack can be used. This file is just for you to help understand the datastructure.


## Requirements

All methods must have amortized complexity O(1), hence constant amortized time with the exception of `contains`, `equals` and `hashCode` which must be O(size()).


## Hints

_Hints for Java:_
* (none)


## Evaluation

**Overall, you can get max. 8 points for this implementation of a stack. Look at all points and penalties detailed below!**

Your code must be contained in the master branch of your gitlab repository.

For your implementation, there are some test classes available:
* `ArrayBasedStackTest` Functional tests for your implementation of the stack 
    * _100% of all tests ok: 3 points_
    * _75-99% of all tests ok: 2 points_
    * _0-74% of all test ok: 0 points_
* `EncapsulationTest` Test if all methods and variables implement correct visibility
    * _100% of all tests ok: 1 points_
    * _otherwise: 0 points_
* `TimeTest` Time tests for some aspects of your implementation
  * _100% of all tests ok: 1 points_
  * _0-99% of all test ok: 0 points_
  * Note that passing the tests in test file `TimeTests` is not necessarily sufficient to fulfill all complexity requirements (cf. above).
* `PrintlnTest` Tests for detecting unnecessary output on sysout and syserr
  * _100% of all tests ok: 1 points_
  * _0-99% of all test ok: 0 points_

A test is one method in the test class. Note that for a good implementation, all tests take **only seconds not minutes** to finish!

In addition, you get the following points if the respective criterion is fulfilled. Note that fulfilling the test classes above does not imply that you get automatically the points below!
* Complexity requirements: 
    * _all fulfilled: 1 point_
    * _otherwise: 0 points_
* Code comments:
    * _comments ok: 1 point_ 
    * _not clean: 0 points (for example "To Do"'s, unused code, uncommented inner classes or uncommented private/protected methods)_
    * Note: the test class `TestTime` from above is not sufficient for testing all complexity requirements!

In addition, the following penalties apply:
* _If no array is used for the data: -6 points_
* _If the array is not expendable: -2 points_
* _If the final version is not in the main branch: -2 points_
* _If insecure and unmotivated (!) `@SuppressWarnings("unchecked")` statements are used: -2 points_ 
* _If unnecessary and unmotivated (!) try-catch blocks are used: -2 points_
* _If the compiler emits warnings: -2 points_

Compiler warnings look typically like that:
``[INFO] .../ArrayBasedStack.java uses unchecked or unsafe operations.``

The term "unmotivated" above means that no explanation was given in the source code why the respective `@SuppressWarnings("unchecked")` resp. try-catch block was necessary in this situation and could not be avoided.


## Maven

It must be possible to test your implementation at
any time with [Maven](http://maven.apache.org/) by following the steps
given below. It is assumed that you have installed Maven on your
computer.


### Testing

To compile and test, open a terminal window and
go to the root directory of this project. Then type:

```shell
$ mvn clean test
[a lot of output]
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
...
[INFO] Results:
[INFO] 
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  <....>
[INFO] Finished at: <....>
[INFO] ------------------------------------------------------------------------
```


### Code Quality 

To check the quality of your code, you can execute [Checkstyle](). A
Checkstyle configuration file is given in your project under
`src/etc`. Type:

```shell
$ mvn checkstyle:check
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------------< ch.bfh:stack >----------------------
[INFO] Building stack 1.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-checkstyle-plugin:3.1.1:checkstyle (default-cli) @ stack ---
[INFO] Beginne Prüfung... (the same in English of French...)
Prüfung beendet. (the same in English of French...)
[INFO] You have 0 Checkstyle violations.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  (sec) s
[INFO] Finished at: (date)
[INFO] ------------------------------------------------------------------------
```

Watch if there are Checkstyle error/warnings. If so, correct them.


### Javadoc for Java

You can generate Javadoc documentation. Type (don't forget to add `compile`):

```shell
$ mvn clean compile javadoc:javadoc
[INFO] Scanning for projects...
[INFO] 
[INFO] ---------------------< ch.bfh:priorityqueue >----------------------
[INFO] Building stack 1.0
[INFO] --------------------------------[ jar ]---------------------------------
[a lot of output]
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  (sec) s
[INFO] Finished at: (date)
[INFO] ------------------------------------------------------------------------
```

Watch if there are Javadoc error/warnings. If so, correct them.



