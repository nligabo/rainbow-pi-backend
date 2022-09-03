CREATE TABLE `tb_profissionais` (
   `id_profissional` bigint NOT NULL AUTO_INCREMENT,
  `nome_profissional` varchar(255) DEFAULT NULL,
  `email_profissional` varchar(255) DEFAULT NULL,
  `cpf_profissional` varchar(15) DEFAULT NULL,
  `profissao_profissional` varchar(255) DEFAULT NULL,
 `registro_profissional` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_profissional`)
)