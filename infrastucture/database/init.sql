CREATE DATABASE IF NOT EXISTS `service_c`;

USE service_c;
CREATE TABLE `message_c` (
  message_id INT(11) NOT NULL DEFAULT 0,
  message VARCHAR(50) NOT NULL,
  PRIMARY KEY (message_id)
);

INSERT INTO `message_c` VALUES (1, "abc");
INSERT INTO `message_c` VALUES (2, "def");