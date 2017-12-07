DELIMITER $$
CREATE FUNCTION `function_cadastraOrdemDeServico`(
    fproduto VARCHAR(45),
    fmarca VARCHAR(45),
    fmodelo VARCHAR(45),
    fprobInfor VARCHAR(500),
    fstatus VARCHAR(45),
    fprobConst VARCHAR(500),
	fdata DATE,
    fosIdUsu INT) RETURNS int(11)
BEGIN
	INSERT INTO `ordemdeservico`(`produto`, `marca`, `modelo`, `probInfor`, `status`, `probConst`, `data`, `osIdUsu`)
        values
        (fproduto,fmarca,fmodelo,fprobInfor,fstatus,fprobConst,fdata,fosIdUsu);
       return LAST_INSERT_ID();
END$$
DELIMITER ;
