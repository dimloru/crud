USE test; 

DROP TABLE IF EXISTS book; 

CREATE TABLE `test`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NULL,
  `description` VARCHAR(255) NULL,
  `author` VARCHAR(255) NULL,
  `isbn` VARCHAR(20) NULL,
  `printYear` INT NULL,
  `readAlready` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO `book` (`title`, `description`, `author`, `isbn`, `printYear`, `readalready`) 
	VALUES ("Geroy nashego vremeni", "Novel", "Lermontov", "978-3-16-148410-0", 1840, 0), 
		("Kod Da Vinchi", "Detective", "Dan Drown", "978-3-16-148410-0", 2002, 0),
		("Spring in Action", "Manual", "Craig Walls", "978-3-16-148410-0", 2014, 0),
		("Spring 4 for pros", "Manual", "Kris Sheffer", "978-3-16-148410-0", 2015, 0),
		("Spring persistence with Hibernate", "Manual", "Paul Fisher", "978-3-16-148410-0", 2010, 0),
		("Using Thymeleaf", "Tutorial",  "Thymeleaf.org", "978-3-16-148410-0", 2018, 0),
		("Garry Potter and The Philosopher's Stone", "Fantasy", "J. K. Rowling", "978-3-16-148410-0", 1997, 0),
		("Garry Potter and The Chamber of Secrets", "Fantasy", "J. K. Rowling", "978-3-16-148410-0", 1998, 0),
		("Garry Potter and The Prisoner of Azkaban", "Fantasy", "J. K. Rowling", "978-3-16-148410-0", 1999, 0),
		("Garry Potter and The Goblet of Fire", "Fantasy", "J. K. Rowling", "978-3-16-148410-0", 2000, 0),
		("Garry Potter and The Order of the Phoenix", "Fantasy", "J. K. Rowling", "978-3-16-148410-0", 2003, 0),
		("Garry Potter and The Half-Blood Prince", "Fantasy", "J. K. Rowling", "978-3-16-148410-0", 2005, 0),
		("Garry Potter and The Deathly Hallows", "Fantasy", "J. K. Rowling", "978-3-16-148410-0", 2007, 0),
		("The Lord of the Rings", "Fantasy", "J.R.R.Tolkien", "978-3-16-148410-0", 1954, 0),
        ("The Ousider", "Horror", "Stephen King", "978-3-16-148410-0", 2018, 0),
		("Salems Lot", "Horror", "Stephen King", "978-3-16-148410-0", 2011, 0),
        ("112263", "Horror", "Stephen King", "978-3-16-148410-0", 2012, 0),
        ("Dr Sleep", "Horror", "Stephen King", "978-3-16-148410-0", 2016, 0),
        ("The Body", "Horror", "Stephen King", "978-3-16-148410-0", 2018, 0),
        ("Effective Java", "Tutorial", "Joshua Bloch", "978-3-16-148410-0", 2017, 0),
        ("Java: Beginners guide", "Tutorial", "Herbert Schildt", "978-3-16-148410-0", 2017, 0),
        ("Head First Java", "Tutorial", "Kathy Sierra", "978-3-16-148410-0", 2005, 0),
        ("Head First Design Patterns", "Tutorial", "Eric Freeman", "978-0596007126", 2007, 0),
        ("Thinking in Java", "Tutorial", "Bruce Eckel", "978-0131872486", 2014, 0),
        ("MySQL", "Tutorial", "Paul DuBois", "978-9332523852", 2013, 0),
        ("SQL in 10 minutes", "Tutorial", "Ben Forta", "978-0672336072", 2012, 0),
        ("Web design with HTML, CSS and JavaScript", "Tutorial", "Jon Duckett", "978-1118907443", 2014, 0),
        ("JavaScript: The Definitive Guide", "Tutorial", "David Flanagan", "978-3-16-148410-0", 2011, 0),
        ("Hibernate Tips", "Tutorial", "Thorben Janssen", "978-3-16-148410-0", 2017, 0),
        ("Angular 5: Ftom Theory to Practice", "Tutorial", "Stephen King", "978-3-16-148410-0", 2017, 0);