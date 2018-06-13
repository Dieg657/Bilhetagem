-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema aviao
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema aviao
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `aviao` DEFAULT CHARACTER SET utf8 ;
USE `aviao` ;

-- -----------------------------------------------------
-- Table `aviao`.`tb_estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aviao`.`tb_estado` (
  `id_estado` INT NOT NULL AUTO_INCREMENT,
  `estado` VARCHAR(45) NULL,
  `uf` VARCHAR(45) NULL,
  PRIMARY KEY (`id_estado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aviao`.`tb_empresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aviao`.`tb_empresa` (
  `fantasia_emp` VARCHAR(45) NULL,
  `inest_emp` VARCHAR(45) NULL,
  `cnpj` VARCHAR(20) NOT NULL,
  `end_emp` VARCHAR(200) NULL,
  `num_emp` VARCHAR(45) NULL,
  `compl_emp` VARCHAR(45) NULL,
  `bairro_emp` VARCHAR(45) NULL,
  `cidade_emp` VARCHAR(45) NULL,
  `idest_emp` INT NOT NULL,
  `cep_emp` INT NULL,
  `email_emp` VARCHAR(45) NULL,
  `obs_emp` TEXT(999) NULL,
  PRIMARY KEY (`cnpj`),
  INDEX `fk_tb_empresa_tb_estado_idx` (`idest_emp` ASC),
  CONSTRAINT `fk_tb_empresa_tb_estado`
    FOREIGN KEY (`idest_emp`)
    REFERENCES `aviao`.`tb_estado` (`id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aviao`.`tb_funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aviao`.`tb_funcionario` (
  `nm_func` VARCHAR(255) NULL,
  `cpf_func` VARCHAR(20) NOT NULL,
  `tel_func` VARCHAR(20) NULL,
  `email_func` VARCHAR(150) NULL,
  `idsexo_func` INT NULL,
  `obs_func` TEXT(999) NULL,
  `cnpj_emp` VARCHAR(20) NOT NULL,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf_func` ASC),
  PRIMARY KEY (`cpf_func`),
  INDEX `fk_tb_funcionario_tb_empresa1_idx` (`cnpj_emp` ASC),
  CONSTRAINT `fk_tb_funcionario_tb_empresa1`
    FOREIGN KEY (`cnpj_emp`)
    REFERENCES `aviao`.`tb_empresa` (`cnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aviao`.`tb_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aviao`.`tb_cliente` (
  `nm_cli` VARCHAR(255) NULL,
  `doc_cli` VARCHAR(45) NULL,
  `org_cli` VARCHAR(45) NULL,
  `iduf_cli` INT NOT NULL,
  `dtnasc_cli` DATE NULL,
  `cpf_cli` VARCHAR(20) NOT NULL,
  `end_cli` VARCHAR(200) NULL,
  `num_cli` VARCHAR(45) NULL,
  `compl_cli` VARCHAR(45) NULL,
  `bairro_cli` VARCHAR(45) NULL,
  `cidade_cli` VARCHAR(45) NULL,
  `idest_cli` INT NOT NULL,
  `email_cli` VARCHAR(45) NULL,
  `obs_cli` TEXT(999) NULL,
  UNIQUE INDEX `cpf_cli_UNIQUE` (`cpf_cli` ASC),
  PRIMARY KEY (`cpf_cli`),
  INDEX `fk_tb_cliente_tb_estado1_idx` (`iduf_cli` ASC),
  INDEX `fk_tb_cliente_tb_estado2_idx` (`idest_cli` ASC),
  CONSTRAINT `fk_tb_cliente_tb_estado1`
    FOREIGN KEY (`iduf_cli`)
    REFERENCES `aviao`.`tb_estado` (`id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_cliente_tb_estado2`
    FOREIGN KEY (`idest_cli`)
    REFERENCES `aviao`.`tb_estado` (`id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aviao`.`tb_voo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aviao`.`tb_voo` (
  `voo_tag` VARCHAR(45) NOT NULL,
  `origem` VARCHAR(20) NOT NULL,
  `destino` VARCHAR(20) NOT NULL,
  `dt_partida` DATE NOT NULL,
  `hr_partida` TIME(0) NOT NULL,
  `cnpj_emp` VARCHAR(20) NOT NULL,
  `vl_voo` DECIMAL NOT NULL,
  PRIMARY KEY (`voo_tag`),
  INDEX `fk_tb_voo_tb_empresa1_idx` (`cnpj_emp` ASC),
  CONSTRAINT `fk_tb_voo_tb_empresa1`
    FOREIGN KEY (`cnpj_emp`)
    REFERENCES `aviao`.`tb_empresa` (`cnpj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aviao`.`tb_passagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aviao`.`tb_passagem` (
  `cpf_passageiro` VARCHAR(20) NULL,
  `pass_bagagem` INT NULL,
  `pass_localizador` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pass_localizador`),
  INDEX `fk_tb_passagem_tb_cliente1_idx` (`cpf_passageiro` ASC),
  CONSTRAINT `fk_tb_passagem_tb_cliente1`
    FOREIGN KEY (`cpf_passageiro`)
    REFERENCES `aviao`.`tb_cliente` (`cpf_cli`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aviao`.`tb_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aviao`.`tb_status` (
  `id_status` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(45) NULL,
  PRIMARY KEY (`id_status`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aviao`.`tb_voo_poltrona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aviao`.`tb_voo_poltrona` (
  `idtb_voo_poltrona` INT NOT NULL AUTO_INCREMENT,
  `voo_tag` VARCHAR(45) NOT NULL,
  `poltrona` INT NOT NULL,
  `localizador` VARCHAR(45) NULL,
  `status` INT NOT NULL,
  INDEX `fk_tb_voo_poltrona_tb_voo1_idx` (`voo_tag` ASC),
  INDEX `fk_tb_voo_poltrona_tb_passagem1_idx` (`localizador` ASC),
  INDEX `fk_tb_voo_poltrona_tb_status1_idx` (`status` ASC),
  PRIMARY KEY (`idtb_voo_poltrona`),
  CONSTRAINT `fk_tb_voo_poltrona_tb_voo1`
    FOREIGN KEY (`voo_tag`)
    REFERENCES `aviao`.`tb_voo` (`voo_tag`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_voo_poltrona_tb_passagem1`
    FOREIGN KEY (`localizador`)
    REFERENCES `aviao`.`tb_passagem` (`pass_localizador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_voo_poltrona_tb_status1`
    FOREIGN KEY (`status`)
    REFERENCES `aviao`.`tb_status` (`id_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aviao`.`tb_usuario_func`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aviao`.`tb_usuario_func` (
  `cpf_func` VARCHAR(20) NOT NULL,
  `usuario` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  INDEX `fk_tb_usuario_func_tb_funcionario1_idx` (`cpf_func` ASC),
  PRIMARY KEY (`cpf_func`),
  CONSTRAINT `fk_tb_usuario_func_tb_funcionario1`
    FOREIGN KEY (`cpf_func`)
    REFERENCES `aviao`.`tb_funcionario` (`cpf_func`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aviao`.`tb_usuario_cli`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aviao`.`tb_usuario_cli` (
  `cpf_cli` VARCHAR(20) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cpf_cli`),
  CONSTRAINT `fk_tb_usuario_cli_tb_cliente1`
    FOREIGN KEY (`cpf_cli`)
    REFERENCES `aviao`.`tb_cliente` (`cpf_cli`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `aviao` ;

-- -----------------------------------------------------
-- procedure criaVooPoltrona
-- -----------------------------------------------------

DELIMITER $$
USE `aviao`$$
CREATE PROCEDURE `criaVooPoltrona` (idVoo varchar(20), poltronas int)
BEGIN
	DECLARE numPoltrona INT;
    SET numPoltrona = 1;
    
    WHILE numPoltrona <= poltronas DO
    INSERT INTO `aviao`.`tb_voo_poltrona` (`voo_tag`,`poltrona`,`localizador`,`status`) VALUES (idVoo, numPoltrona, null, 1);
	SET numPoltrona = numPoltrona + 1;
    END WHILE;
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure criaVoo
-- -----------------------------------------------------

DELIMITER $$
USE `aviao`$$
CREATE PROCEDURE `criaVoo` (idVoo varchar(20), origem varchar(20), destino varchar(20), dataPartida date, horaPartida time(0), cnpj varchar(20), vlVoo decimal)
BEGIN
    INSERT INTO `aviao`.`tb_voo` (`voo_tag`,`origem`, `destino`, `dt_partida`, `hr_partida`,`cnpj_emp`, `vl_voo`) VALUES (idVoo, origem, destino, dataPartida, horaPartida, cnpj, vlVoo);
END;$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure updateCliPoltrona
-- -----------------------------------------------------

DELIMITER $$
USE `aviao`$$
CREATE PROCEDURE `updateCliPoltrona` (idVoo varchar(20), numPoltrona int, localizador varchar(20))
BEGIN
	UPDATE `aviao`.`tb_voo_poltrona` SET `localizador` = localizador,`status` = 2 WHERE `voo_tag` = idVoo AND `poltrona` = numPoltrona;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure updateStatusPoltronaManutencao
-- -----------------------------------------------------

DELIMITER $$
USE `aviao`$$
CREATE PROCEDURE `updateStatusPoltronaManutencao` (idVoo varchar(20), numPoltrona int, localizador varchar(20))
BEGIN
	UPDATE `aviao`.`tb_voo_poltrona` SET `localizador` = null , `status` = 3 WHERE `voo_tag` = idVoo AND `poltrona` = numPoltrona AND `localizador` = localizador;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure updateStatusPoltronaLivre
-- -----------------------------------------------------

DELIMITER $$
USE `aviao`$$
CREATE PROCEDURE `updateStatusPoltronaLivre` (idVoo varchar(20), numPoltrona int, localizador varchar(20))
BEGIN
	UPDATE `aviao`.`tb_voo_poltrona` SET `localizador` = null , `status` = 1 WHERE `voo_tag` = idVoo AND `poltrona` = numPoltrona AND `localizador` = localizador;
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `aviao`.`tb_status`
-- -----------------------------------------------------
START TRANSACTION;

USE `aviao`;

INSERT INTO `aviao`.`tb_status` (`id_status`, `status`) VALUES (1, 'Livre');
INSERT INTO `aviao`.`tb_status` (`id_status`, `status`) VALUES (2, 'Ocupada');
INSERT INTO `aviao`.`tb_status` (`id_status`, `status`) VALUES (3, 'Manutenção');

INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Acre','AC');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Alagoas','AL'); 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Amapá','AP');
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Amazonas','AM');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Bahia','BA');
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Ceará','CE'); 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Distrito Federal','DF');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Espírito Santo','ES');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Goiás','GO');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Maranhão','MA');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Mato Grosso','MT');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Mato Grosso do Sul','MS');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Minas Gerais','MG');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Pará','PA');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Paraíba','PB');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Paraná','PR');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Pernambuco','PE');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Piauí','PI');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Rio de Janeiro','RJ');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Rio Grande do Norte','RN');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Rio Grande do Sul','RS');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Rondônia','RO');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Roraima','RR');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Santa Catarina','SC');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('São Paulo','SP');	 
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Sergipe','SE');
INSERT INTO `aviao`.`tb_estado` (`estado`,`uf`) VALUES  ('Tocantins', 'TO');


COMMIT;

