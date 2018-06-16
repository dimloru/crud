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
		("The Lord of the Rings", "Fantasy", "J.R.R.Tolkien", "978-3-16-148410-0", 1954, 0);
		