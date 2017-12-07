DELIMITER $$
CREATE FUNCTION `function_cadastraImagens`(
    
    furl VARCHAR(200),
	ftipo INT) RETURNS int(11),
    fimIdOs INT) RETURNS int(11)
BEGIN
	INSERT INTO `imagens`( `url`, `tipo`, `imIdOs`)
        values
        (furl,ftipo,fimIdOs);
       return LAST_INSERT_ID();
END$$
DELIMITER ;
