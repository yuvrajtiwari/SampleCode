Process-Lines Version 1.0 30/03/2016


General Information
-------------------
This maven project auto downloads 3rd party dependencies compiles business logic 
and tests and then runs automated tests.

After successful completion of the tests maven creates a executable jar file in the target folder.(ProcessLines-1.0.jar)
The project contains the implementation of the class ProcessLines and method process.

The method process receives a list of Strings containing any number of lines.
Each line has two parts, Category and Subcategory.

The valid categories are:
FOOD
PERSON
PLACE


Outputs:
1. The input lines, with invalid categories and duplicates removed
2. A chart that lists the categories and the number of unique lines with those categories


The method processLines is also tested by Junit tests for corner cases 
namely (empty-null) input list, no valid category provided in input list,
assert expected output for dummy data and check performance with a timeout test.

P.S-There is no main method or program flow in class ProcessLines. 
Maven handles all automated tests.


------------------------------------------------------------------------------------------

How to run
-----------

1) Prerequisites: Maven 3.3 requires JDK 1.7 or above to execute - 
   it still allows you to build against 1.3 and other JDK versions
   Once Maven,Junit and JDK are all set up and added to PATH, We can test the application.
   
2) We can use mvn followed by any of the below commands for testing this application :

	validate: validate the project is correct and all necessary information is available
	compile: compile the source code of the project
	test: test the compiled source code using a suitable unit testing framework. 
	package: take the compiled code and package it in its distributable format, such as a JAR. 
	install: install the package into the local repository, for use as a dependency in other projects locally
	
	example: $rootDir~ProcessLines/ mvn install 
	
-------------------------------------------------------------------------------------------
List of Files 						
-------------

Source Files: Location-src/main/java	
-----------------------------------						    						
BlankInputException.java				 	
MyUtilClass.java						 
NoValidCategoryFoundException.java		  	
ProcessLines.java						  
																
Test File: Location-src/test/java																
----------------------------------
ProcessLinesTest.java
	
Build Configuration File				 
------------------------
pom.xml	   

Executable Jar
--------------
ProcessLines-1.0.jar

General Information	
-------------------							 
README.txt								

-------------------------------------------------------------------------------------------
Contact and other Information:
-----------------------------
Author:Yuvraj Tiwari
Created:03/30/2016
e-mail:yuvraj.tiwari@ymail.com

-------------------------------------------------------------------------------------------