CREATE TABLE COURSE
( 
    COURSE_ID integer AUTO_INCREMENT PRIMARY KEY,
    COURSE_NAME char(30)  NOT NULL ,
    DESCRIPTION BLOB ,
    TOTAL_HOURS integer NOT NULL,
    PUBLISH_DATE DATE,
    INSTRUCTOR_NAME char(30) NOT NULL,
    COURSE_RATING integer
);

insert into COURSE values("1", "C++", "This course introduces the student to object-oriented programming through a study of the concepts of program specification and design, algorithm development, and coding and testing using a modern software development environment. Students learn how to write programs in an object-oriented high level programming language. Topics covered include fundamentals of algorithms, flowcharts, problem solving, programming concepts, classes and methods, control structures, arrays, and strings. Throughout the semester, problem solving skills will be stressed and applied to solving computing problems. Weekly laboratory experiments will provide hands-on experience in topics covered in this course.", "32", "2008-01-22", "Sumita Arora", "4");

insert into COURSE values("2", "Core Java", "Core Java is just a part of Java which stands for J2SE containing all the basics of Java including some principles and package details. It’s a stand-alone Java application which covers everything from OOP concepts to special operators, from data types to wrapper classes, from Linked list to Array list, and queue to exception handling. There are three computing platforms based on the Java programming language, including the Java SE. It still is the most widely used platform based on the concept of OOP and is commonly used for development of portable desktop applications. In addition to the general purpose API’s, it consists of development tools, a virtual machine, and other class libraries. It also includes the Java Virtual Machine Specification.", "72", "2012-09-13", "James Gosling", "5");

insert into COURSE values("3", "HTML and CSS", "HTML, HyperText Markup Language, gives content structure and meaning by defining that content as, for example, headings, paragraphs, or images. CSS, or Cascading Style Sheets, is a presentation language created to style the appearance of content—using, for example, fonts or colors", "12", "2010-04-21", "Tim Berners-Lee", "4");

insert into COURSE values("4", "Javascript", "JavaScript is a dynamic computer programming language. It is lightweight and most commonly used as a part of web pages, whose implementations allow client-side script to interact with the user and make dynamic pages. It is an interpreted programming language with object-oriented capabilities.", "15", "2014-07-30", "Brendan Eich", "4");
