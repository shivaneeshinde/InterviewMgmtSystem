CREATE SCHEMA `interview` ;


CREATE TABLE `interview`.`Details` (
  `EmailId` VARCHAR(45) NOT NULL,
  `Name` VARCHAR(45) NULL,
  `AppointmentDate` DATE NULL,
  `MoveForward` VARCHAR(45) NULL,
  `InterviewTranscription` VARCHAR(45) NULL,
  `ActionResult` VARCHAR(45) NULL,
  PRIMARY KEY (`EmailId`));


Insert into `interview`.`Details` values('shivaneeshinde1996@gmail.com','Shivanee', '2021-03-18','First Round', 'Still in process','InProcess');