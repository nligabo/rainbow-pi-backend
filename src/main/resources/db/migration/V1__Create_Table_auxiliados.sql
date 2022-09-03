	CREATE TABLE `tb_auxiliados` (
   `id_auxiliado` bigint NOT NULL AUTO_INCREMENT,
  `email_auxiliado` varchar(255) DEFAULT NULL,
  `nome_auxiliado` varchar(255) DEFAULT NULL,
  `endereco_auxiliado` varchar(15) DEFAULT NULL,
  `telefone_auxiliado` varchar(15) DEFAULT NULL,
  `cpf_auxiliado` varchar(15) DEFAULT NULL,
  `tipodeajuda_auxiliado` varchar(255) DEFAULT NULL,
 `datanasc_auxiliado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_auxiliado`)
)