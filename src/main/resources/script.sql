CREATE SCHEMA IF NOT EXISTS `sosfauna` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `sosfauna` ;

CREATE TABLE IF NOT EXISTS `sosfauna`.`orgaos_login` (
  `id` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `senha` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `sosfauna`.`orgaos` (
  `id` VARCHAR(255) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `cnpj` VARCHAR(18) NOT NULL,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  `telefone` VARCHAR(11) NOT NULL,
  `rede_social` VARCHAR(255) NULL DEFAULT NULL,
  `endereco` VARCHAR(255) NOT NULL,
  `foto_perfil` BLOB NULL DEFAULT NULL,
  `acesso` TINYINT(1) NOT NULL,
  `data_criacao` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `id_orgao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cnpj` (`cnpj` ASC) VISIBLE,
  INDEX `id_orgao` (`id_orgao` ASC) VISIBLE,
  CONSTRAINT `orgaos_ibfk_1`
    FOREIGN KEY (`id_orgao`)
    REFERENCES `sosfauna`.`orgaos_login` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `sosfauna`.`animais_adocao` (
  `id` VARCHAR(255) NOT NULL,
  `nome` VARCHAR(255) NULL DEFAULT NULL,
  `especie` VARCHAR(255) NULL DEFAULT NULL,
  `idade` INT NOT NULL,
  `sexo` VARCHAR(255) NULL DEFAULT NULL,
  `foto` BLOB NULL DEFAULT NULL,
  `data_criacao` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `status_adocao` VARCHAR(255) NULL DEFAULT NULL,
  `id_orgao` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_orgao` (`id_orgao` ASC) VISIBLE,
  CONSTRAINT `animais_adocao_ibfk_1`
    FOREIGN KEY (`id_orgao`)
    REFERENCES `sosfauna`.`orgaos` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `sosfauna`.`usuarios_login` (
  `id` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `senha` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `sosfauna`.`usuarios` (
  `id` VARCHAR(255) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `dt_nascimento` DATE NULL DEFAULT NULL,
  `telefone` VARCHAR(11) NULL DEFAULT NULL,
  `foto_perfil` BLOB NULL DEFAULT NULL,
  `data_criacao` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `acesso` TINYINT(1) NOT NULL,
  `id_usuario` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `cpf` (`cpf` ASC) VISIBLE,
  INDEX `id_usuario` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `usuarios_ibfk_1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `sosfauna`.`usuarios_login` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `sosfauna`.`denuncias` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `animal` VARCHAR(255) NOT NULL,
  `denunciado` VARCHAR(50) NULL DEFAULT NULL,
  `descricao` TEXT NOT NULL,
  `data_ocorrido` DATE NOT NULL,
  `hora_ocorrido` TIME NOT NULL,
  `bairro` VARCHAR(100) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  `rua` VARCHAR(50) NOT NULL,
  `cep` VARCHAR(10) NULL DEFAULT NULL,
  `data_criacao` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `id_usuario` VARCHAR(255) NULL DEFAULT NULL,
  `status_denuncia` ENUM('Em Aberto', 'Em Analise', 'Em Diligencia', 'Concluida', 'Cancelada') NOT NULL DEFAULT 'Em Aberto',
  `id_orgao` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_usuario` (`id_usuario` ASC) VISIBLE,
  INDEX `id_orgao` (`id_orgao` ASC) VISIBLE,
  CONSTRAINT `denuncias_ibfk_1`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `sosfauna`.`usuarios` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE,
  CONSTRAINT `denuncias_ibfk_2`
    FOREIGN KEY (`id_orgao`)
    REFERENCES `sosfauna`.`orgaos` (`id`)
    ON DELETE SET NULL
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `sosfauna`.`reset_senha_orgao` (
  `id` VARCHAR(255) NOT NULL,
  `codigo_orgao` VARCHAR(255) NULL DEFAULT NULL,
  `data_de_expiracao_orgao` DATETIME(6) NULL DEFAULT NULL,
  `orgao_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK34i3by3rac05b6rkgn7km7f7m` (`orgao_id` ASC) VISIBLE,
  CONSTRAINT `FKd6nqnxv6t95mu6q52dxhfk2bn`
    FOREIGN KEY (`orgao_id`)
    REFERENCES `sosfauna`.`orgaos_login` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `sosfauna`.`reset_senha_usuario` (
  `id` VARCHAR(255) NOT NULL,
  `codigo_usuario` VARCHAR(255) NULL DEFAULT NULL,
  `data_de_expiracao_user` DATETIME(6) NULL DEFAULT NULL,
  `usuario_id` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UKbyn17egu6i1y3ul7ieqihx9x9` (`usuario_id` ASC) VISIBLE,
  CONSTRAINT `FKjh4e93cn35biflwui10evp0gu`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `sosfauna`.`usuarios_login` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;