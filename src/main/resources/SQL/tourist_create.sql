DROP DATABASE IF EXISTS mydb;

CREATE DATABASE mydb;

USE mydb;

CREATE TABLE IF NOT EXISTS `mydb`.`TagsTable` (
  `tag_id` INT NOT NULL AUTO_INCREMENT,
  `tag_name` VARCHAR(45) NULL,
  PRIMARY KEY (`tag_id`),
  UNIQUE INDEX `tag_id_UNIQUE` (`tag_id` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`City` (
  `city_id` INT NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`city_id`),
  UNIQUE INDEX `city_id_UNIQUE` (`city_id` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`TouristAttraction` (
  `attraction_id` INT NOT NULL AUTO_INCREMENT,
  `attractionName` VARCHAR(45) NOT NULL,
  `description` TEXT NOT NULL,
  `description_long` TEXT NOT NULL,
  `City` INT NOT NULL,
  `picture_file` VARCHAR(255),
  PRIMARY KEY (`attraction_id`),
  UNIQUE INDEX `idTouristAttraction_UNIQUE` (`attraction_id` ASC) INVISIBLE,
  INDEX `city_id_idx` (`City` ASC) VISIBLE,
  CONSTRAINT `city_id`
    FOREIGN KEY (`City`)
    REFERENCES `mydb`.`City` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`CityAttractions` (
  `city_id` INT NOT NULL,
  `attraction_id` INT NOT NULL,
  PRIMARY KEY (`attraction_id`, `city_id`),
  INDEX `city_id_idx` (`city_id` ASC) VISIBLE,
  CONSTRAINT `fk_attraction_id` 
    FOREIGN KEY (`attraction_id`)
    REFERENCES `mydb`.`TouristAttraction` (`attraction_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_city_id`
    FOREIGN KEY (`city_id`)
    REFERENCES `mydb`.`City` (`city_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`AttractionTagsTable` (
  `attraction_id` INT NOT NULL,
  `tag_id` INT NOT NULL,
  PRIMARY KEY (`attraction_id`, `tag_id`),
  INDEX `tag_id_idx` (`tag_id` ASC) VISIBLE,
  CONSTRAINT `attraction_id`
    FOREIGN KEY (`attraction_id`)
    REFERENCES `mydb`.`TouristAttraction` (`attraction_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tag_id`
    FOREIGN KEY (`tag_id`)
    REFERENCES `mydb`.`TagsTable` (`tag_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


