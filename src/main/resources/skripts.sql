DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS master;
DROP TABLE IF EXISTS record;
DROP TABLE IF EXISTS service_price;
DROP TABLE IF EXISTS user;

CREATE TABLE `beauty_saloon`.`service_price` (
                                                 `idservice_price` SERIAL,
                                                 `service_name` VARCHAR(45) NULL,

                                                 `service_price` VARCHAR(20) NULL,
                                                 PRIMARY KEY (`idservice_price`));
INSERT INTO service_price (service_name,  service_price)
VALUE ('Advance Hair Cut - Volume Minimize Cut', 200);

INSERT INTO service_price (service_name, service_price)
    VALUE ('Advance Hair Cut-Full Layer', 180 );
INSERT INTO service_price (service_name, service_price)
    VALUE ('Advance Hair Cut-Split-end-cutr', 210 );
INSERT INTO service_price (service_name, service_price)
    VALUE ('Advance Hair Cut-Steps Layer', 160 );

INSERT INTO service_price (service_name, service_price)
    VALUE ('Advanced Hair Servicest-Rebonding', 4000 );
INSERT INTO service_price (service_name, service_price)
    VALUE ('Advanced Hair Servicest-Smoothing', 3000 );
INSERT INTO service_price (service_name, service_price)
    VALUE ('Advanced Hair Services-Straightening', 3500 );
INSERT INTO service_price (service_name, service_price)
    VALUE ('Bleach-Face',250 );
INSERT INTO service_price (service_name, service_price)
    VALUE ('Bridal Make-up-Mac', 8000 );
INSERT INTO service_price (service_name, service_price)
    VALUE ('Face Massage-Herbal', 200);
INSERT INTO service_price (service_name, service_price)
    VALUE ('Face Massage-Herbal', 200 );
INSERT INTO service_price (service_name, service_price)
    VALUE ('Facial-Herbal', 230);




CREATE TABLE `beauty_saloon`.`user` (
                                        `iduser` INT NOT NULL AUTO_INCREMENT,
                                        `first_name` VARCHAR(45) NULL,
                                        `last_name` VARCHAR(45) NULL,
                                        `e_mail` VARCHAR(45) NULL,
                                        `password` VARCHAR(45) NULL,
                                        `role` VARCHAR(45) NULL,
                                        PRIMARY KEY (`iduser`),
                                        UNIQUE INDEX `e_mail_UNIQUE` (`e_mail` ASC) VISIBLE,
                                        UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8
    COLLATE = utf8_unicode_ci;


CREATE TABLE `beauty_saloon`.`record` (
                                          `idrecord` INT NOT NULL AUTO_INCREMENT,
                                          `user_id` INT NULL,
                                          `master_id` INT NULL,
                                          `time_from` INT NULL,
                                          `date` INT NULL,
                                          UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) VISIBLE,
                                          PRIMARY KEY (`idrecord`));


CREATE TABLE `beauty_saloon`.`master` (
                                          `idmaster` INT NOT NULL AUTO_INCREMENT,
                                          `level` VARCHAR(45) NULL,
                                          `phone_number` INT NULL,
                                          `description` VARCHAR(45) NULL,
                                          `iduser` INT NULL,
                                          PRIMARY KEY (`idmaster`),
                                          UNIQUE INDEX `iduser_UNIQUE` (`iduser` ASC) VISIBLE);

CREATE TABLE `beauty_saloon`.`comment` (
                                           `idcomment` INT NOT NULL AUTO_INCREMENT,
                                           `comment_text` VARCHAR(150) NULL,
                                           `user_id` INT NULL,
                                           `master_id` INT NULL,
                                           `record_id` INT NULL,
                                           UNIQUE INDEX `record_id_UNIQUE` (`record_id` ASC) VISIBLE,
                                           PRIMARY KEY (`idcomment`));




