this is the assignment: CSCI 363 / CSCI 540 – Assignment 6: IntegerSet JUnit Testing Due: April 14, 2026 by 6PM Overview In Assignment 5, you implemented a Java class called IntegerSet. In this assignment, you will copy your Assignment 5 implementation into a new package and write JUnit 5 test cases to verify correctness. This assignment focuses on testing completeness and correctness. Important Requirements • Copy your Assignment 5 IntegerSet.java into the Assignment 6 package • Write JUnit 5 test cases for every method • Do NOT use Driver.java • Your code and tests must compile and run • If your code does not compile or tests do not run, the assignment grade is 0 Required Package Structure (STRICT) src/org/howard/edu/lsp/assignment6/IntegerSet.java src/org/howard/edu/lsp/assignment6/IntegerSetTest.java package org.howard.edu.lsp.assignment6; Test Coverage Requirement (STRICT) Each method must include BOTH: 1. 1. Normal case 2. 2. Edge case(s) Required Edge Cases • add(): duplicate values • remove(): value not present • equals(): same elements different order • union(): with empty set • intersect(): no common elements • diff(): identical sets • complement(): disjoint sets • contains(): value not present • isEmpty(): empty vs non-empty • toString(): empty set • largest(): single element + empty (exception) • smallest(): single element + empty (exception) JUnit Requirements Use JUnit 5 and include assertions such as (but not limited to): • assertEquals • assertTrue • assertFalse • assertThrows toString() Requirement Format must be exactly: [1, 2, 3] AI Usage and External References Submit AI_Usage_Report.md in org/howard/edu/lsp/assignment6/doc/ If nothing used: "nothing used" Grading Rubric Category Points clear() (normal + edge) 5 length() (normal + edge) 5 equals() (order + mismatch) 10 contains() (present + absent) 5 largest() (normal + exception) 5 smallest() (normal + exception) 5 add() (normal + duplicate) 5 remove() (normal + missing) 5 union() (normal + empty) 10 intersect() (normal + no overlap) 10 diff() (normal + identical) 10 complement() (normal + disjoint) 5 isEmpty() (empty + non-empty) 5 toString() (normal + empty) 5 Exception tests 5 AI_Usage_Report.md 10 Total: 100 points
Thought for 5s
Got it. This assignment is basically saying:
You are not rewriting the whole project from scratch. You are:
taking your Assignment 5 IntegerSet.java
copying it into a new package
writing JUnit 5 tests for every method
making sure the package/file structure is exactly right
What your folder structure should look like
src/
└── org/
   └── howard/
       └── edu/
           └── lsp/
               └── assignment6/
                   ├── IntegerSet.java
                   ├── IntegerSetTest.java
                   └── doc/
                       └── AI_Usage_Report.md
And both Java files should begin with:
package org.howard.edu.lsp.assignment6;

What you need to submit
You need these 3 things:
IntegerSet.java
IntegerSetTest.java
AI_Usage_Report.md

What the professor is testing
Your IntegerSetTest.java needs to test every method in IntegerSet.
That means you need tests for:
clear()
length()
equals()
contains()
largest()
smallest()
add()
remove()
union()
intersect()
diff()
complement()
isEmpty()
toString()
And for each method, you need:
a normal case
an edge case

Edge cases they explicitly require
These are not optional:
add() → duplicate values
remove() → value not present
equals() → same elements, different order
union() → with empty set
intersect() → no common elements
diff() → identical sets
complement() → disjoint sets
contains() → value not present
isEmpty() → empty vs non-empty
toString() → empty set
largest() → single element + empty set exception
smallest() → single element + empty set exception

Important thing about exceptions
If your largest() and smallest() throw IntegerSetException, then your tests should use:
assertThrows(IntegerSetException.class, () -> set.largest());
If your code throws a different exception, use that instead.

A strong IntegerSetTest.java template
You can use this and adjust names if your method behavior is slightly different.
package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {

   // ------------------------------------------------------------------ //
   // clear()
   // ------------------------------------------------------------------ //
   @Test
   public void testClearNormal() {
       IntegerSet set = new IntegerSet();
       set.add(1);
       set.add(2);
       set.clear();
       assertTrue(set.isEmpty());
   }

   @Test
   public void testClearEdgeAlreadyEmpty() {
       IntegerSet set = new IntegerSet();
       set.clear();
       assertTrue(set.isEmpty());
   }

   // ------------------------------------------------------------------ //
   // length()
   // ------------------------------------------------------------------ //
   @Test
   public void testLengthNormal() {
       IntegerSet set = new IntegerSet();
       set.add(1);
       set.add(2);
       assertEquals(2, set.length());
   }

   @Test
   public void testLengthEdgeEmptySet() {
       IntegerSet set = new IntegerSet();
       assertEquals(0, set.length());
   }

   // ------------------------------------------------------------------ //
   // equals()
   // ------------------------------------------------------------------ //
   @Test
   public void testEqualsNormalSameElementsDifferentOrder() {
       IntegerSet set1 = new IntegerSet();
       IntegerSet set2 = new IntegerSet();

       set1.add(1);
       set1.add(2);
       set1.add(3);

       set2.add(3);
       set2.add(1);
       set2.add(2);

       assertTrue(set1.equals(set2));
   }

   @Test
   public void testEqualsEdgeMismatch() {
       IntegerSet set1 = new IntegerSet();
       IntegerSet set2 = new IntegerSet();

       set1.add(1);
       set1.add(2);

       set2.add(1);
       set2.add(3);

       assertFalse(set1.equals(set2));
   }

   // ------------------------------------------------------------------ //
   // contains()
   // ------------------------------------------------------------------ //
   @Test
   public void testContainsNormal() {
       IntegerSet set = new IntegerSet();
       set.add(5);
       assertTrue(set.contains(5));
   }

   @Test
   public void testContainsEdgeValueNotPresent() {
       IntegerSet set = new IntegerSet();
       set.add(5);
       assertFalse(set.contains(10));
   }

   // ------------------------------------------------------------------ //
   // largest()
   // ------------------------------------------------------------------ //
   @Test
   public void testLargestNormal() throws IntegerSetException {
       IntegerSet set = new IntegerSet();
       set.add(1);
       set.add(7);
       set.add(3);
       assertEquals(7, set.largest());
   }

   @Test
   public void testLargestEdgeSingleElement() throws IntegerSetException {
       IntegerSet set = new IntegerSet();
       set.add(42);
       assertEquals(42, set.largest());
   }

   @Test
   public void testLargestEdgeEmptySetException() {
       IntegerSet set = new IntegerSet();
       assertThrows(IntegerSetException.class, () -> set.largest());
   }

   // ------------------------------------------------------------------ //
   // smallest()
   // ------------------------------------------------------------------ //
   @Test
   public void testSmallestNormal() throws IntegerSetException {
       IntegerSet set = new IntegerSet();
       set.add(9);
       set.add(2);
       set.add(5);
       assertEquals(2, set.smallest());
   }

   @Test
   public void testSmallestEdgeSingleElement() throws IntegerSetException {
       IntegerSet set = new IntegerSet();
       set.add(42);
       assertEquals(42, set.smallest());
 
how to set up testing on vscode
Here’s the easiest way to set up JUnit 5 testing in VS Code for your Java assignment.
1. Install the needed VS Code extensions
Open Extensions in VS Code and install:
Extension Pack for Java
Test Runner for Java
Usually the Java pack includes what you need.

2. Make sure your project folder is opened correctly
Open the root folder of your assignment in VS Code, not just one file.
Your project should look something like:
your-project-folder/
└── src/
   └── org/
       └── howard/
           └── edu/
               └── lsp/
                   └── assignment6/
                       ├── IntegerSet.java
                       ├── IntegerSetTest.java
                       └── doc/
                           └── AI_Usage_Report.md

3. Add JUnit 5 to the project
There are two common ways.
Option A: easiest way in VS Code Java projects
If VS Code recognizes your Java project, it often lets you add testing support automatically.
Try this:
Open IntegerSetTest.java
Hover over the import errors if JUnit is missing
Look for something like:
Add JUnit 5 to classpath
Resolve dependency
Configure Java Test Framework
If that appears, click it.

Option B: use Maven
This is the cleaner long-term way.
If you are okay using Maven, create a pom.xml in the root folder.
Use this:
<project xmlns="http://maven.apache.org/POM/4.0.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
   <modelVersion>4.0.0</modelVersion>

   <groupId>org.howard.edu.lsp</groupId>
   <artifactId>assignment6</artifactId>
   <version>1.0-SNAPSHOT</version>

   <properties>
       <maven.compiler.source>17</maven.compiler.source>
       <maven.compiler.target>17</maven.compiler.target>
       <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
       <junit.version>5.10.2</junit.version>
   </properties>

   <dependencies>
       <dependency>
           <groupId>org.junit.jupiter</groupId>
           <artifactId>junit-jupiter</artifactId>
           <version>${junit.version}</version>
           <scope>test</scope>
       </dependency>
   </dependencies>

   <build>
       <sourceDirectory>src</sourceDirectory>
       <testSourceDirectory>src</testSourceDirectory>

       <plugins>
           <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-surefire-plugin</artifactId>
               <version>3.2.5</version>
           </plugin>
       </plugins>
   </build>
</project>
Because your professor wants both files in src/.../assignment6/, this pom.xml makes Maven treat src as both source and test source.

4. Add the JUnit imports in your test file
Your IntegerSetTest.java should start like this:
package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {
   @Test
   public void testExample() {
       assertEquals(2, 1 + 1);
   }
}

5. Make sure your test class name and methods are correct
Class name should usually be IntegerSetTest
Test methods need @Test
Test methods should usually be public void
Example:
@Test
public void testAddNormal() {
   IntegerSet set = new IntegerSet();
   set.add(5);
   assertTrue(set.contains(5));
}

6. Run the tests in VS Code
Once JUnit is recognized, you should see:
a Run Test link above each test method
a Run Tests option near the class
a Testing flask icon on the left sidebar
You can click any of those to run tests.

7. If VS Code is not detecting tests
Try these fixes:
Make sure Java is installed
In the terminal, run:
java -version
javac -version
Make sure Maven is installed
If using Maven:
mvn -version
Reload VS Code
Press:
Cmd/Ctrl + Shift + P
Then run:
Java: Clean Java Language Server Workspace
Then reload.

8. Very important for your assignment
Your professor said:
do not use Driver.java
tests must compile and run
if tests do not run, grade can be 0
So before submitting, make sure:
IntegerSet.java compiles
IntegerSetTest.java compiles
all imports resolve
tests actually execute in VS Code

9. If your IntegerSetException is in another file
If your old Assignment 5 code used IntegerSetException, make sure that class is also available.
If your professor only wants these two files, then check whether:
your IntegerSet.java defines it internally, or
you need to copy IntegerSetException.java too
That part matters because otherwise your tests will not compile.

10. Fastest simple route
The simplest workflow is:
Open project folder in VS Code
Install Java extensions
Add pom.xml
Put IntegerSet.java and IntegerSetTest.java in the correct package
Run tests from the Testing tab
If you want, I can also show you the exact folder layout and files you should create in VS Code for this assignment.
IntegerSetTest.java
File
IntegerSet.java
File
I am going to send you the IntegerSet java and test I want you to grade it :
Thought for 21s
Yes — and based on the assignment rubric, I would not submit this as-is.
My honest grade: around 55/100 at best, and possibly much lower if your professor strictly enforces “must compile and run.”
The biggest issue is that your test file appears to have brace/structure problems, so it likely will not compile. There is also a mismatch between the exceptions your tests expect and the exceptions your IntegerSet class actually throws. Since the assignment says code/tests must compile and run or the grade is 0, that is the most serious problem.
Estimated rubric breakdown
Here is how I would score it assuming the professor reads intent generously, but also noting where it would fail in practice:
clear() — 5/5
length() — 5/5
equals() — 7/10
contains() — 5/5
largest() — 2/5
smallest() — 2/5
add() — 5/5
remove() — 5/5
union() — 10/10
intersect() — 10/10
diff() — 8/10
complement() — 4/5
isEmpty() — 5/5
toString() — 3/5
Exception tests — 0/5
AI_Usage_Report.md — 0/10 unless you have it separately
That gives about 76/100 on content, but because of the compile/run problems, the real practical grade could drop to 0 under the assignment policy.
What is good
You did a lot right.
Your IntegerSet.java itself is mostly solid:
duplicates are prevented in add
equals handles same elements by sorting copies
union, intersect, diff, and complement all return new sets
toString() sorts before printing, so nonempty output like [1, 2, 3] is correct.
Your test file also covers a lot of the assignment:
normal and edge cases for many methods
duplicate add
remove missing value
union with empty set
intersect with no overlap
diff with identical set
empty/nonempty isEmpty
empty and nonempty toString.
The biggest problems
1. Your test file likely does not compile
There is a missing closing brace after testSmallestEmptySet(), and there is also an extra closing brace after the intersect section, which appears to close the class too early. After that, more test methods continue outside the class. That is a compile error.
2. Your tests expect IntegerSetException, but your class throws RuntimeException
In IntegerSet.java, both largest() and smallest() throw RuntimeException("IntegerSet is empty").
But in IntegerSetTest.java, you catch IntegerSetException in the empty-set tests for largest() and smallest(). If IntegerSetException is not defined anywhere, this will not compile. Even if it is defined elsewhere, those tests would still fail because the wrong exception type is being thrown.
3. equals() does not clearly test the required “same elements different order” edge case
You do test equality, but your “identical sets” test inserts values in the same order. The assignment explicitly wants “same elements, different order.” You need something like:
set1: 1, 2, 3
set2: 3, 1, 2
4. toString() empty-set expectation may be wrong for your professor
Your test expects [] for the empty set. That may be fine, but the assignment says the format must be exactly [1, 2, 3]. Usually that implies [] is acceptable for empty, but some professors are picky. This one is probably okay, just not as airtight as the nonempty test.
5. Some tests are extra but not especially useful
Examples:
testContainsOnNullSet()
testUnionWithNullSet()
testIncorrectLargest()
These are not wrong in spirit, but they do not help much with the rubric. The assignment is about testing the class methods, not intentionally dereferencing a null object reference. Since set = null is not an IntegerSet edge case but a Java reference error, that test probably would not earn you anything.
What you need to fix before submitting
Fix the braces in IntegerSetTest.java first.
Right now that is the number one problem.
Make exceptions match.
Either:
change largest() and smallest() to throw IntegerSetException, or
change the tests to use RuntimeException
Use assertThrows for exception tests since the assignment specifically mentions it.
Example:
assertThrows(RuntimeException.class, () -> set.largest());
Add a true different-order equals test.
Make sure AI_Usage_Report.md exists in the required doc/ folder. Right now I cannot give credit for that because it was not included.
Bottom line
Content-wise, this is a good start and shows you understand how to test the class.
Submission-wise, it is not ready yet because:
the test file structure is broken
the exception type does not match
one required equals edge case is not directly tested.
Send me the fixed version and I’ll re-grade it like a professor would.
IntegerSetTest(1).java
File
check it now
Thought for a couple of seconds
Much better. This version looks submittable from a testing-structure standpoint, and the major exception mismatch is fixed in the test file.
My updated grade would be about 88/100, assuming:
it compiles in your VS Code setup,
JUnit 5 is configured correctly,
and you also submit AI_Usage_Report.md.
Without AI_Usage_Report.md, it drops to about 78/100. The assignment explicitly requires that file.
Updated rubric estimate
clear() — 5/5
length() — 5/5
equals() — 10/10
contains() — 5/5
largest() — 5/5
smallest() — 5/5
add() — 5/5
remove() — 5/5
union() — 10/10
intersect() — 10/10
diff() — 8/10
complement() — 5/5
isEmpty() — 5/5
toString() — 5/5
Exception tests — 5/5
AI_Usage_Report.md — 0/10 unless included
What improved
You fixed the biggest problems:
The test file now looks structurally complete as a single class.
You changed the empty-set exception tests for largest() and smallest() to assertThrows(RuntimeException.class, ...), which matches your actual IntegerSet.java.
You added the required equals() edge case for same elements in different order.
What is still keeping it from a 100
1. diff() is a little light
You do test the normal case and the identical-set case, which covers the rubric well. But one of your local variables is unused:
IntegerSet setB = new IntegerSet();
inside testIdnentityDiff(). That is not a grading disaster, just unnecessary.
2. A few tests are extra but not very meaningful
These are not wrong, but they are not especially useful for the rubric:
testContainsOnNullSet()
testUnionWithNullSet()
testIncorrectLargest()
The null-reference one especially is more about Java reference behavior than your IntegerSet method behavior. A professor may ignore it.
3. Naming/cleanliness issues
Not a huge point deduction, but professors sometimes care:
testIdnentityDiff() is misspelled
some formatting is uneven
a few closing braces sit on the same line as assertions in earlier sections
This usually would not cost much, but it makes the file look a little less polished.
One thing I would still tighten before submission
I would remove testContainsOnNullSet() and possibly testUnionWithNullSet() unless your professor specifically talked about null handling. They are not required by the prompt, and sometimes extra tests against behavior not mentioned in the assignment can cause confusion.
Final verdict
Right now:
With AI_Usage_Report.md: about 88/100
Without it: about 78/100
This is now a solid assignment, not a broken one. The main thing left is polishing and making sure that required markdown file is present.
If you want, send me your AI_Usage_Report.md text and I’ll make sure it matches the assignment exactly.
Well why is it 2 points off on the diff test even though I did it properly according to the rubric
Thought for a couple of seconds
You’re right to push on that — according to the rubric alone, your diff() section should get full credit.
You did include:
a normal case for diff()
an edge case for diff(): identical sets
That is exactly what the assignment asks for.
So I would revise that part to:
diff() — 10/10
Why I originally held back 2 points
I was grading a little more like a picky instructor looking at overall polish, not strictly the rubric line by line. The things I noticed were:
testIdnentityDiff() has a typo in the name
setB is created but never used in that test
But those are cleanliness issues, not failures of the required diff() coverage. They should not reduce the actual rubric score for that category.
Corrected score
That would change the estimate to:
With AI_Usage_Report.md: about 90/100
Without AI_Usage_Report.md: about 80/100
Bottom line
For diff() specifically, you met the rubric and should get full points. My earlier deduction there was too strict.
IntegerSetTest(2).java
File
ok leys lookk at it now
Thought for a couple of seconds
This version got worse, because it now has a compile error in the diff() section. So I would not submit this one yet.
The problem
In testIdenticalDiff(), you declare setB twice in the same method:
IntegerSet setB = new IntegerSet();
...
IntegerSet setB = setA.diff(setA);
That is a Java compile error because the variable name is already defined in that scope.
The exact fix
Change that method to this:
@Test
public void testIdenticalDiff() {
   IntegerSet setA = new IntegerSet();
   setA.add(1);
   setA.add(2);

   IntegerSet diffSet = setA.diff(setA);
   assertEquals(0, diffSet.length(), "Diff of a set with itself should result in an empty set");
}
That removes:
the unused first setB
the duplicate declaration
the naming confusion.
Grade right now
Because the assignment says if the code/tests do not compile and run, the grade can be 0, I would treat this current version as not submission-ready.
Aside from that compile error
Everything else still looks mostly solid:
equals() has the required same-elements-different-order case
largest() and smallest() now use assertThrows
diff() coverage itself is fine once that compile error is fixed.
One more small note
testIncorrectDiff() is not wrong, but it is a little redundant because testDiffWithNonEmptySets() already checks the main behavior. It will not hurt much, but it is not necessary for the rubric.
So the main answer is: the new issue is a duplicate variable declaration in testIdenticalDiff(). Once you fix that, this version goes back to being strong.
IntegerSetTest(3).java
File
grade it now
Thought for a couple of seconds
This version is strong. I’d grade the test file at about 92/100, and 102/110-style coverage quality if I were just judging thoroughness. For the actual assignment rubric, that means:
About 92/100 if AI_Usage_Report.md is included and everything runs
About 82/100 if AI_Usage_Report.md is missing
The file now looks compile-ready, and your coverage clearly matches the required methods and edge cases much better.
Rubric-style breakdown
clear() — 5/5
length() — 5/5
equals() — 10/10
contains() — 5/5
largest() — 5/5
smallest() — 5/5
add() — 5/5
remove() — 5/5
union() — 10/10
intersect() — 10/10
diff() — 10/10
complement() — 5/5
isEmpty() — 5/5
toString() — 5/5
Exception tests — 5/5
AI_Usage_Report.md — 0/10 unless submitted
That is 90/90 on the Java testing portion, plus the separate 10 points for the AI report.
Why this is much better
You now cover the required edge cases cleanly:
equals() has same elements, different order via testSameElementsDifferentOrder()
add() has the duplicate value case
remove() has value not present
union() has with empty set
intersect() has no common elements
diff() has identical sets and also an empty-set case
complement() has disjoint sets explicitly now
contains() has value not present
isEmpty() has empty vs non-empty
toString() has empty set and correct formatted non-empty output [1, 2, 3]
largest() and smallest() each have single-element and empty-set exception tests using assertThrows, which matches your implementation’s RuntimeException.
What is keeping it from a perfect score
There are only a few things now:
1. Some extra tests are unnecessary
These do not hurt much, but they are not really rubric-driven:
testContainsOnNullSet()
testIncorrectLargest()
testIncorrectDiff()
testUnionWithNullSet()
They are not wrong, but they are more “extra behavior checks” than assignment requirements. A professor usually will not deduct much for that, but sometimes extra tests can distract from the required ones.
2. Minor polish issues
A few formatting spots are still uneven, like braces on the same line in some methods and slightly inconsistent spacing/indentation. That is not a major grading issue, but it affects presentation a little.
3. Your IntegerSet.java still uses RuntimeException
That is okay because your tests now match it. But if your professor expected a custom IntegerSetException from Assignment 5, they might comment on that depending on how strict they are. Your current implementation explicitly throws RuntimeException in largest() and smallest(), and your tests are aligned with that.
My honest final judgment
This is now a good submission.
If I were the professor, I’d likely give:
90/100 or 92/100 if the AI report is present and the project runs cleanly
80/100 to 82/100 if the AI report is missing
So from a “can I turn this in?” perspective: yes, this version looks solid. The biggest remaining practical thing is making sure AI_Usage_Report.md is in the required folder.
If you want the safest final polish, I’d remove testContainsOnNullSet() and leave the rest.
should I add display names
Short answer: you don’t have to—but yes, you should.
Why?
Your assignment does not require @DisplayName, so you won’t lose points for not having it.
But adding it gives you:
✅ Cleaner test output in VS Code
✅ Easier debugging (you instantly know what failed)
✅ Looks more professional / polished (this matters)

What it looks like
Instead of just:
@Test
public void testAddDuplicateElement() {
Do this:
@Test
@DisplayName("add(): duplicate values should not increase size")
public void testAddDuplicateElement() {

Example (based on your file)
@Test
@DisplayName("equals(): same elements in different order should be equal")
public void testSameElementsDifferentOrder() {
   IntegerSet set1 = new IntegerSet();
   IntegerSet set2 = new IntegerSet();
   set1.add(1);
   set1.add(2);
   set2.add(2);
   set2.add(1);
   assertTrue(set1.equals(set2));
}

When it’s MOST useful (focus here if short on time)
If you don’t want to add it everywhere, prioritize:
edge cases
exception tests
confusing logic
Examples:
"largest(): throws exception on empty set"
"diff(): identical sets returns empty set"
"union(): with empty set returns original elements"

One important thing
Don’t forget to import it:
import org.junit.jupiter.api.DisplayName;

My recommendation (for your assignment)
If you have 5–10 minutes → add them to key tests only
If you want to maximize polish → add them to all tests
If you’re rushing → you’re already fine without them

Final verdict
Not required → won’t affect grade
Nice polish → could help perception
If you want, I can auto-add clean display names to your whole file so it looks like a perfect submission.
can you add them to my tests
Thought for 4s
Yes — here’s your test file with @DisplayName added cleanly.
Add this import near the top:
import org.junit.jupiter.api.DisplayName;
And here is the updated file:
package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {
   // ------------------------------------------------------------------ //
   // clear()
   // ------------------------------------------------------------------ //

   @Test
   @DisplayName("clear(): removes all elements from a non-empty set")
   public void testClear() {
       IntegerSet set = new IntegerSet();
       set.add(1);
       set.add(2);
       set.clear();
       assertEquals(0, set.length(), "Clear should result in an empty set");
   }

   @Test
   @DisplayName("clear(): empty set remains empty")
   public void testClearOnEmptySet() {
       IntegerSet set = new IntegerSet();
       set.clear();
       assertEquals(0, set.length(), "Clearing an already empty set should still result in an empty set");
   }

   // ------------------------------------------------------------------ //
   // length()
   // ------------------------------------------------------------------ //

   @Test
   @DisplayName("length(): empty set has length 0")
   public void testLengthEmptySet() {
       IntegerSet set = new IntegerSet();
       assertEquals(0, set.length(), "Length of an empty set should be 0");
   }

   @Test
   @DisplayName("length(): non-empty set returns correct size")
   public void testLengthNonEmptySet() {
       IntegerSet set = new IntegerSet();
       set.add(1);
       set.add(2);
       set.add(3);
       assertEquals(3, set.length(), "Length should reflect the number of unique elements in the set");
   }

   // ------------------------------------------------------------------ //
   // equals()
   // ------------------------------------------------------------------ //

   @Test
   @DisplayName("equals(): identical sets are equal")
   public void testEqualsIdenticalSets() {
       IntegerSet set1 = new IntegerSet();
       IntegerSet set2 = new IntegerSet();
       set1.add(1);
       set1.add(2);
       set2.add(1);
       set2.add(2);
       assertTrue(set1.equals(set2), "Identical sets should be equal");
   }

   @Test
   @DisplayName("equals(): different sets are not equal")
   public void testEqualsDifferentSets() {
       IntegerSet set1 = new IntegerSet();
       IntegerSet set2 = new IntegerSet();
       set1.add(1);
       set1.add(2);
       set2.add(2);
       set2.add(3);
       assertFalse(set1.equals(set2), "Different sets should not be equal");
   }

   @Test
   @DisplayName("equals(): two empty sets are equal")
   public void testEqualsEmptySets() {
       IntegerSet set1 = new IntegerSet();
       IntegerSet set2 = new IntegerSet();
       assertTrue(set1.equals(set2), "Two empty sets should be equal");
   }

   @Test
   @DisplayName("equals(): sets with different lengths are not equal")
   public void testDifferentLengthSets() {
       IntegerSet set1 = new IntegerSet();
       IntegerSet set2 = new IntegerSet();
       set1.add(1);
       set1.add(2);
       set2.add(1);
       assertFalse(set1.equals(set2), "Sets of different lengths should not be equal");
   }

   @Test
   @DisplayName("equals(): same elements in different order are equal")
   public void testSameElementsDifferentOrder() {
       IntegerSet set1 = new IntegerSet();
       IntegerSet set2 = new IntegerSet();
       set1.add(1);
       set1.add(2);
       set2.add(2);
       set2.add(1);
       assertTrue(set1.equals(set2), "Sets with the same elements in different order should be equal");
   }

   // ------------------------------------------------------------------ //
   // contains()
   // ------------------------------------------------------------------ //

   @Test
   @DisplayName("contains(): returns true for existing element")
   public void testContainsExistingElement() {
       IntegerSet set = new IntegerSet();
       set.add(1);
       assertTrue(set.contains(1), "Set should contain the added element");
   }

   @Test
   @DisplayName("contains(): returns false for non-existing element")
   public void testContainsNonExistingElement() {
       IntegerSet set = new IntegerSet();
       set.add(1);
       assertFalse(set.contains(2), "Set should not contain an element that was not added");
   }

   @Test
   @DisplayName("contains(): empty set does not contain any value")
   public void testContainsEmptySet() {
       IntegerSet set = new IntegerSet();
       assertFalse(set.contains(1), "Empty set should not contain any elements");
   }

   @Test
   @DisplayName("contains(): calling method on null reference throws NullPointerException")
   public void testContainsOnNullSet() {
       IntegerSet set = null;
       try {
           set.contains(1);
           fail("Calling contains on a null set should throw NullPointerException");
       } catch (NullPointerException e) {
           // Expected exception
       }
   }

   // ------------------------------------------------------------------ //
   // largest()
   // ------------------------------------------------------------------ //

   @Test
   @DisplayName("largest(): returns maximum value in non-empty set")
   public void testLargestNonEmptySet() {
       IntegerSet set = new IntegerSet();
       set.add(1);
       set.add(3);
       set.add(2);
       assertEquals(3, set.largest(), "Largest should return the maximum element in the set");
   }

   @Test
   @DisplayName("largest(): single-element set returns that element")
   public void testLargestSingleElementSet() {
       IntegerSet set = new IntegerSet();
       set.add(5);
       assertEquals(5, set.largest(), "Largest should return the only element in the set");
   }

   @Test
   @DisplayName("largest(): empty set throws RuntimeException")
   public void testLargestEmptySet() {
       IntegerSet set = new IntegerSet();
       assertThrows(RuntimeException.class, () -> set.largest());
   }

   @Test
   @DisplayName("largest(): does not return a non-maximum value")
   public void testIncorrectLargest() {
       IntegerSet set = new IntegerSet();
       set.add(1);
       set.add(2);
       set.add(3);
       assertNotEquals(2, set.largest(), "Largest should not return a non-maximum element");
   }

   // ------------------------------------------------------------------ //
   // smallest()
   // ------------------------------------------------------------------ //

   @Test
   @DisplayName("smallest(): returns minimum value in non-empty set")
   public void testSmallestNonEmptySet() {
       IntegerSet set = new IntegerSet();
       set.add(3);
       set.add(1);
       set.add(2);
       assertEquals(1, set.smallest(), "Smallest should return the minimum element in the set");
   }

   @Test
   @DisplayName("smallest(): single-element set returns that element")
   public void testSmallestSingleElementSet() {
       IntegerSet set = new IntegerSet();
       set.add(5);
       assertEquals(5, set.smallest(), "Smallest should return the only element in the set");
   }

   @Test
   @DisplayName("smallest(): empty set throws RuntimeException")
   public void testSmallestEmptySet() {
       IntegerSet set = new IntegerSet();
       assertThrows(RuntimeException.class, () -> set.smallest());
   }

   // ------------------------------------------------------------------ //
   // add()
   // ------------------------------------------------------------------ //

   @Test
   @DisplayName("add(): inserts a new element into the set")
   public void testAddNewElement() {
       IntegerSet set = new IntegerSet();
       set.add(1);
       assertTrue(set.contains(1), "Adding a new element should result in it being contained in the set");
   }

   @Test
   @DisplayName("add(): duplicate element does not increase set size")
   public void testAddDuplicateElement() {
       IntegerSet set = new IntegerSet();
       set.add(1);
       set.add(1);
       assertEquals(1, set.length(), "Adding a duplicate element should not increase the length of the set");
   }

   @Test
   @DisplayName("add(): multiple unique elements increase set size")
   public void testAddMultipleElements() {
       IntegerSet set = new IntegerSet();
       set.add(1);
       set.add(2);
       set.add(3);
       assertEquals(3, set.length(), "Adding multiple unique elements should increase the length accordingly");
   }

   // ------------------------------------------------------------------ //
   // remove()
   // ------------------------------------------------------------------ //

   @Test
   @DisplayName("remove(): deletes an existing element")
   public void testRemoveExistingElement() {
       IntegerSet set = new IntegerSet();
       set.add(1);
       set.remove(1);
       assertFalse(set.contains(1), "Removing an existing element should result in it no longer being contained in the set");
   }

   @Test
   @DisplayName("remove(): removing non-existing element does not change set")
   public void testRemoveNonExistingElement() {
       IntegerSet set = new IntegerSet();
       set.add(1);
       set.remove(2);
       assertTrue(set.contains(1), "Removing a non-existing element should not affect the existing elements in the set");
   }

   @Test
   @DisplayName("remove(): removing from empty set leaves it unchanged")
   public void testRemoveFromEmptySet() {
       IntegerSet set = new IntegerSet();
       set.remove(1);
       assertEquals(0, set.length(), "Removing from an empty set should not change the length of the set");
   }

   // ------------------------------------------------------------------ //
   // union()
   // ------------------------------------------------------------------ //

   @Test
   @DisplayName("union(): combines unique elements from two non-empty sets")
   public void testUnionWithNonEmptySets() {
       IntegerSet setA = new IntegerSet();
       IntegerSet setB = new IntegerSet();
       setA.add(1);
       setA.add(2);
       setB.add(2);
       setB.add(3);
       IntegerSet unionSet = setA.union(setB);
       assertTrue(unionSet.contains(1), "Union should contain elements from the first set");
       assertTrue(unionSet.contains(2), "Union should contain common elements from both sets");
       assertTrue(unionSet.contains(3), "Union should contain elements from the second set");
       assertEquals(3, unionSet.length(), "Union should have the correct number of unique elements");
   }

   @Test
   @DisplayName("union(): union with empty set returns original elements")
   public void testUnionWithEmptySet() {
       IntegerSet setA = new IntegerSet();
       IntegerSet setB = new IntegerSet();
       setA.add(1);
       IntegerSet unionSet = setA.union(setB);
       assertTrue(unionSet.contains(1), "Union with an empty set should contain all elements from the non-empty set");
       assertEquals(1, unionSet.length(), "Union with an empty set should have the same number of elements as the non-empty set");
   }

   @Test
   @DisplayName("union(): union with null set returns original elements")
   public void testUnionWithNullSet() {
       IntegerSet setA = new IntegerSet();
       setA.add(1);
       IntegerSet unionSet = setA.union(null);
       assertTrue(unionSet.contains(1), "Union with a null set should contain all elements from the original set");
       assertEquals(1, unionSet.length(), "Union with a null set should have the same number of elements as the original set");
   }

   @Test
   @DisplayName("union(): does not modify the original sets")
   public void testUnionDoesNotModifyOriginals() {
       IntegerSet setA = new IntegerSet();
       IntegerSet setB = new IntegerSet();
       setA.add(1);
       setB.add(2);
       setA.union(setB);
       assertTrue(setA.contains(1), "Original set A should not be modified by union");
       assertFalse(setA.contains(2), "Original set A should not contain elements from set B");
       assertTrue(setB.contains(2), "Original set B should not be modified by union");
       assertFalse(setB.contains(1), "Original set B should not contain elements from set A");
   }

   // ------------------------------------------------------------------ //
   // intersect()
   // ------------------------------------------------------------------ //

   @Test
   @DisplayName("intersect(): returns common elements from two non-empty sets")
   public void testIntersectWithNonEmptySets() {
       IntegerSet setA = new IntegerSet();
       IntegerSet setB = new IntegerSet();
       setA.add(1);
       setA.add(2);
       setB.add(2);
       setB.add(3);
       IntegerSet intersectSet = setA.intersect(setB);
       assertTrue(intersectSet.contains(2), "Intersect should contain common elements from both sets");
       assertFalse(intersectSet.contains(1), "Intersect should not contain elements that are only in the first set");
       assertFalse(intersectSet.contains(3), "Intersect should not contain elements that are only in the second set");
       assertEquals(1, intersectSet.length(), "Intersect should have the correct number of common elements");
   }

   @Test
   @DisplayName("intersect(): intersecting with empty set returns empty set")
   public void testIntersectWithEmptySet() {
       IntegerSet setA = new IntegerSet();
       IntegerSet setB = new IntegerSet();
       setA.add(1);
       IntegerSet intersectSet = setA.intersect(setB);
       assertEquals(0, intersectSet.length(), "Intersect with an empty set should result in an empty set");
   }

   @Test
   @DisplayName("intersect(): no overlap returns empty set")
   public void testNoOverlapIntersect() {
       IntegerSet setA = new IntegerSet();
       IntegerSet setB = new IntegerSet();
       setA.add(1);
       setA.add(2);
       setB.add(3);
       setB.add(4);
       IntegerSet intersectSet = setA.intersect(setB);
       assertEquals(0, intersectSet.length(), "Intersect of two sets with no common elements should result in an empty set");
   }

   // ------------------------------------------------------------------ //
   // diff()
   // ------------------------------------------------------------------ //

   @Test
   @DisplayName("diff(): returns elements only in the first set")
   public void testDiffWithNonEmptySets() {
       IntegerSet setA = new IntegerSet();
       IntegerSet setB = new IntegerSet();
       setA.add(1);
       setA.add(2);
       setB.add(2);
       setB.add(3);
       IntegerSet diffSet = setA.diff(setB);
       assertTrue(diffSet.contains(1), "Diff should contain elements that are only in the first set");
       assertFalse(diffSet.contains(2), "Diff should not contain common elements from both sets");
       assertFalse(diffSet.contains(3), "Diff should not contain elements that are only in the second set");
       assertEquals(1, diffSet.length(), "Diff should have the correct number of unique elements from the first set");
   }

   @Test
   @DisplayName("diff(): identical sets return empty set")
   public void testIdenticalDiff() {
       IntegerSet setA = new IntegerSet();
       setA.add(1);
       setA.add(2);
       IntegerSet diffSet = setA.diff(setA);
       assertEquals(0, diffSet.length(), "Diff of a set with itself should result in an empty set");
   }

   @Test
   @DisplayName("diff(): does not include common or second-set-only elements")
   public void testIncorrectDiff() {
       IntegerSet setA = new IntegerSet();
       IntegerSet setB = new IntegerSet();
       setA.add(1);
       setA.add(2);
       setB.add(2);
       setB.add(3);
       IntegerSet diffSet = setA.diff(setB);
       assertFalse(diffSet.contains(2), "Diff should not contain common elements from both sets");
       assertFalse(diffSet.contains(3), "Diff should not contain elements that are only in the second set");
       assertEquals(1, diffSet.length(), "Diff should have the correct number of unique elements from the first set");
   }

   @Test
   @DisplayName("diff(): diff with empty set returns original elements")
   public void testDiffWithEmptySet() {
       IntegerSet setA = new IntegerSet();
       IntegerSet setB = new IntegerSet();
       setA.add(1);
       IntegerSet diffSet = setA.diff(setB);
       assertTrue(diffSet.contains(1), "Diff with an empty set should contain all elements from the non-empty set");
       assertEquals(1, diffSet.length(), "Diff with an empty set should have the same number of elements as the non-empty set");
   }

   // ------------------------------------------------------------------ //
   // complement()
   // ------------------------------------------------------------------ //

   @Test
   @DisplayName("complement(): returns elements only in the second set")
   public void testComplementWithNonEmptySets() {
       IntegerSet setA = new IntegerSet();
       IntegerSet setB = new IntegerSet();
       setA.add(1);
       setA.add(2);
       setB.add(2);
       setB.add(3);
       IntegerSet complementSet = setA.complement(setB);
       assertFalse(complementSet.contains(1), "Complement should not contain elements that are only in the first set");
       assertFalse(complementSet.contains(2), "Complement should not contain common elements from both sets");
       assertTrue(complementSet.contains(3), "Complement should contain elements that are only in the second set");
       assertEquals(1, complementSet.length(), "Complement should have the correct number of unique elements from the second set");
   }

   @Test
   @DisplayName("complement(): complement with empty set returns empty set")
   public void testComplementWithEmptySet() {
       IntegerSet setA = new IntegerSet();
       IntegerSet setB = new IntegerSet();
       setA.add(1);
       IntegerSet complementSet = setA.complement(setB);
       assertEquals(0, complementSet.length(), "Complement with an empty set should result in an empty set");
   }

   @Test
   @DisplayName("complement(): disjoint sets return all elements from second set")
   public void testComplementDisjointSets() {
       IntegerSet setA = new IntegerSet();
       IntegerSet setB = new IntegerSet();
       setA.add(1);
       setA.add(2);
       setB.add(3);
       setB.add(4);
       IntegerSet complementSet = setA.complement(setB);
       assertTrue(complementSet.contains(3), "Complement should contain elements that are only in the second set");
       assertTrue(complementSet.contains(4), "Complement should contain elements that are only in the second set");
       assertFalse(complementSet.contains(1), "Complement should not contain elements that are only in the first set");
       assertFalse(complementSet.contains(2), "Complement should not contain elements that are only in the first set");
       assertEquals(2, complementSet.length(), "Complement should have the correct number of unique elements from the second set");
   }

   // ------------------------------------------------------------------ //
   // isEmpty()
   // ------------------------------------------------------------------ //

   @Test
   @DisplayName("isEmpty(): returns true for empty set")
   public void testIsEmptyOnEmptySet() {
       IntegerSet set = new IntegerSet();
       assertTrue(set.isEmpty(), "isEmpty should return true for an empty set");
   }

   @Test
   @DisplayName("isEmpty(): returns false for non-empty set")
   public void testIsEmptyOnNonEmptySet() {
       IntegerSet set = new IntegerSet();
       set.add(1);
       assertFalse(set.isEmpty(), "isEmpty should return false for a non-empty set");
   }

   // ------------------------------------------------------------------ //
   // toString()
   // ------------------------------------------------------------------ //

   @Test
   @DisplayName("toString(): empty set formats as []")
   public void testToStringEmptySet() {
       IntegerSet set = new IntegerSet();
       assertEquals("[]", set.toString(), "toString of an empty set should be []");
   }

   @Test
   @DisplayName("toString(): non-empty set formats in ascending order")
   public void testToStringNonEmptySet() {
       IntegerSet set = new IntegerSet();
       set.add(3);
       set.add(1);
       set.add(2);
       assertEquals("[1, 2, 3]", set.toString(), "toString should return a sorted list of elements in the set");
   }
}
If you want, I can also trim out the few extra tests that are not really needed so the file looks cleaner for submission.

