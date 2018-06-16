USE test; 

DROP TABLE IF EXISTS book; 

CREATE TABLE `test`.`bookshelf` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NULL,
  `description` VARCHAR(255) NULL,
  `author` VARCHAR(255) NULL,
  `isbn` VARCHAR(20) NULL,
  `printYear` INT NULL,
  `readAlready` TINYINT(0) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO `bookshelf` (`title`,` `description`, `author`, `isbn`, `printYear`) 
	VALUES ("Geroy nashego vremeni", "Novel", "Lermontov", "978-3-16-148410-0", 1840), 
		("Kod Da Vinchi", "Detective", "Dan Drown", "978-3-16-148410-0", 2002),
		("Spring in Action", "Manual", "Craig Walls", "978-3-16-148410-0", 2014),
		("Spring 4 for pros", "Manual", "Kris Sheffer", "978-3-16-148410-0", 2015),
		("Spring persistence with Hibernate", "Manual", "Paul Fisher", "978-3-16-148410-0", 2010),
		("Using Thymeleaf", "Tutorial",  "Thymeleaf.org", "978-3-16-148410-0", 2018),
		("Garry Potter and The Philosopher's Stone", "Fantasy", "J. K. Rowling", "978-3-16-148410-0", 1997),
		("Garry Potter and The Chamber of Secrets", "Fantasy", "J. K. Rowling", "978-3-16-148410-0", 1998),
		("Garry Potter and The Prisoner of Azkaban", "Fantasy", "J. K. Rowling", "978-3-16-148410-0", 1999),
		("Garry Potter and The Goblet of Fire", "Fantasy", "J. K. Rowling", "978-3-16-148410-0", 2000),
		("Garry Potter and The Order of the Phoenix", "Fantasy", "J. K. Rowling", "978-3-16-148410-0", 2003),
		("Garry Potter and The Half-Blood Prince", "Fantasy", "J. K. Rowling", "978-3-16-148410-0", 2005),
		("Garry Potter and The Deathly Hallows", "Fantasy", "J. K. Rowling", "978-3-16-148410-0", 2007),
		("The Lord of the Rings", "Fantasy", "J.R.R.Tolkien", "978-3-16-148410-0", 1954);
		