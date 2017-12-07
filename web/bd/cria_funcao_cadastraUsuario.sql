DELIMITER $$
CREATE FUNCTION `function_cadastraUsuarios`(
    fnome VARCHAR(100),
    fcpf VARCHAR(45),
    fendereco VARCHAR(100),
    ftelefone VARCHAR(45),
    femail VARCHAR(45),
    fsenha VARCHAR(45),
    ftipo INT) RETURNS int(11)
BEGIN
	INSERT INTO `usuarios`(`nome`, `cpf`, `endereco`, `telefone`, `email`, `senha`, `tipo`)
        values
        (fnome,fcpf,fendereco,ftelefone,femail,fsenha,ftipo);
       return LAST_INSERT_ID();
END$$
DELIMITER ;
