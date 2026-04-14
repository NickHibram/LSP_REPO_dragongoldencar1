this is the assignment: CSCI 363 / CSCI 540 – Assignment 6: IntegerSet JUnit Testing
Due: April 14, 2026 by 6PM

Overview
In Assignment 5, you implemented a Java class called IntegerSet.

In this assignment, you will copy your Assignment 5 implementation into a new package and write JUnit 5 test cases to verify correctness. This assignment focuses on testing completeness and correctness.
Important Requirements
•	Copy your Assignment 5 IntegerSet.java into the Assignment 6 package
•	Write JUnit 5 test cases for every method
•	Do NOT use Driver.java
•	Your code and tests must compile and run
•	If your code does not compile or tests do not run, the assignment grade is 0
Required Package Structure (STRICT)
src/org/howard/edu/lsp/assignment6/IntegerSet.java
src/org/howard/edu/lsp/assignment6/IntegerSetTest.java
package org.howard.edu.lsp.assignment6;
Test Coverage Requirement (STRICT)
Each method must include BOTH:
1.	1. Normal case
2.	2. Edge case(s)
Required Edge Cases
•	add(): duplicate values
•	remove(): value not present
•	equals(): same elements different order
•	union(): with empty set
•	intersect(): no common elements
•	diff(): identical sets
•	complement(): disjoint sets
•	contains(): value not present
•	isEmpty(): empty vs non-empty
•	toString(): empty set
•	largest(): single element + empty (exception)
•	smallest(): single element + empty (exception)
JUnit Requirements
Use JUnit 5 and include assertions such as (but not limited to):
•	assertEquals
•	assertTrue
•	assertFalse
•	assertThrows
toString() Requirement
Format must be exactly:
[1, 2, 3]
AI Usage and External References
Submit AI_Usage_Report.md in org/howard/edu/lsp/assignment6/doc/
If nothing used: "nothing used"
Grading Rubric
Category	Points
clear() (normal + edge)	5
length() (normal + edge)	5
equals() (order + mismatch)	10
contains() (present + absent)	5
largest() (normal + exception)	5
smallest() (normal + exception)	5
add() (normal + duplicate)	5
remove() (normal + missing)	5
union() (normal + empty)	10
intersect() (normal + no overlap)	10
diff() (normal + identical)	10
complement() (normal + disjoint)	5
isEmpty() (empty + non-empty)	5
toString() (normal + empty)	5
Exception tests	5
AI_Usage_Report.md	10

Total: 100 points
how to set up testing on vscode
IntegerSetTest.java
File
IntegerSet.java
File
I am going to send you the IntegerSet java and test I want you to grade it :
IntegerSetTest(1).java
File
check it now
Well why is it 2 points off on the diff test even though I did it properly according to the rubric 
IntegerSetTest(2).java
File
ok leys lookk at it now 
IntegerSetTest(3).java
File
grade it now 
should I add display names 
can you add them to my tests 