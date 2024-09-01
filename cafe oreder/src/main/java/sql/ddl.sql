-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema CafeOrder
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CafeOrder
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CafeOrder` DEFAULT CHARACTER SET utf8 ;
USE `CafeOrder` ;

-- -----------------------------------------------------
-- Table `CafeOrder`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CafeOrder`.`User` (
  `id` varchar(30) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `mobile` VARCHAR(45) NULL,
  PRIMARY KEY (`id`)
  
  
  )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CafeOrder`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CafeOrder`.`Product` (
  `pNum` VARCHAR(30) NOT NULL,
  `pName` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`pNum`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CafeOrder`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CafeOrder`.`OrderList` (
  `orderId` INT NOT NULL AUTO_INCREMENT,
  `User_id` VARCHAR(30) NOT NULL,
  `orderTime` DATETIME NULL,
  `totalPrice` INT NULL,
  PRIMARY KEY (`orderId`),
  INDEX `fk_OrderList_User_idx` (`User_id` ASC),
  CONSTRAINT `fk_OrderList_User`
    FOREIGN KEY (`User_id`)
    REFERENCES `CafeOrder`.`User` (`id`)
    ON DELETE cascade
    ON UPDATE cascade)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CafeOrder`.`Order_Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CafeOrder`.`Order_Product` (
  `quantity` INT NULL,
  `Product_pNum` VARCHAR(30) NOT NULL,
  `Orderlist_orderId` INT NOT NULL,
  INDEX `fk_Order_Product_Product1_idx` (`Product_pNum` ASC),
  INDEX `fk_Order_Product_Orderlist1_idx` (`Orderlist_orderId` ASC) ,
  CONSTRAINT `fk_Order_Product_Product1`
    FOREIGN KEY (`Product_pNum`)
    REFERENCES `CafeOrder`.`Product` (`pNum`)
    ON DELETE cascade
    ON UPDATE cascade,
  CONSTRAINT `fk_Order_Product_Order1`
    FOREIGN KEY (`Orderlist_orderId`)
    REFERENCES `CafeOrder`.`Orderlist` (`orderId`)
    ON DELETE cascade
    ON UPDATE cascade)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
