# 1. 데이터 모델링

## 1) ERD
![image](https://github.com/user-attachments/assets/128a19c0-298f-4ca9-a90d-39ac233ea456)

## 2) DML 스크립트
```
-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user` (
  `id` VARCHAR(10) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `nickname` VARCHAR(10) NULL,
  `address` VARCHAR(50) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `product` (
  `prod_num` INT NOT NULL AUTO_INCREMENT,
  `prod_name` VARCHAR(50) NOT NULL,
  `prod_price` INT NOT NULL,
  PRIMARY KEY (`prod_num`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orderlist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `orderlist` (
  `order_num` INT NOT NULL,
  `user_id` VARCHAR(10) NOT NULL,
  `product_prod_num` INT NOT NULL,
  `prod_count` VARCHAR(45) NOT NULL,
  `count` INT NULL,
  `totalprice` INT NULL,
  INDEX `fk_user_has_product_product1_idx` (`product_prod_num` ASC) VISIBLE,
  INDEX `fk_user_has_product_user_idx` (`user_id` ASC) VISIBLE,
  PRIMARY KEY (`order_num`),
  CONSTRAINT `fk_user_has_product_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_product_product1`
    FOREIGN KEY (`product_prod_num`)
    REFERENCES `product` (`prod_num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
```

## 3) user 테이블에 더미데이터 추가
```
INSERT INTO `user` VALUES("jinam", "1234", "곰사모", "서울시");
```

# 2. vo

## User
- private String id;
- private String password;
- private String nickname;
- private String address;

## Product
- private int prodNum;
- private String prodName;
- private String prodPrice;

# 3. flow
1. main.jsp 출력
2. '로그인' 메뉴 클릭
3. login.jsp 출력
4. 아이디와 비밀번호 입력 후 '로그인' 버튼 클릭
5. FrontController 서블릿에 입력값이 전송됨
6. DAOImpl 반환받고, login() 메소드 호출하여 User 객체를 반환받음
   - User != null 인 경우> User를 "user"로 Session에 바인딩 & path = "main.jsp"
   - User != null 가 아닌 경우> "아이디와 비밀번호를 다시 확인해주세요."를 "msg"로 Request에 바인딩 & path = "login.jsp"
7. forward(path) 방식으로 네비게이션
8. 바인딩한 데이터를 출력






