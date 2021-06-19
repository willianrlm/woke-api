-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 19-Jun-2021 às 03:52
-- Versão do servidor: 5.7.31
-- versão do PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `woke`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidate`
--

DROP TABLE IF EXISTS `candidate`;
CREATE TABLE IF NOT EXISTS `candidate` (
  `id` bigint(20) NOT NULL,
  `date_application` datetime(6) DEFAULT NULL,
  `opinion` varchar(255) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5859evebv1forwxno1dj2x73m` (`company_id`),
  KEY `FKj9h7beyp5gsdtdb20km82b4fl` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `candidate`
--

INSERT INTO `candidate` (`id`, `date_application`, `opinion`, `company_id`, `user_id`) VALUES
(1, '2021-06-19 00:49:16.687000', 'POSITIVE', 1, 1),
(2, '2021-06-19 00:49:16.687000', 'POSITIVE', 1, 2),
(3, '2021-06-19 00:49:16.687000', 'POSITIVE', 1, 3),
(4, '2021-06-19 00:49:16.687000', 'POSITIVE', 1, 4),
(5, '2021-06-19 00:49:16.687000', 'NEGATIVE', 2, 5),
(6, '2021-06-19 00:49:16.687000', 'NEUTRAL', 4, 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `candidate_seq`
--

DROP TABLE IF EXISTS `candidate_seq`;
CREATE TABLE IF NOT EXISTS `candidate_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `candidate_seq`
--

INSERT INTO `candidate_seq` (`next_val`) VALUES
(7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `company`
--

INSERT INTO `company` (`id`, `description`, `name`) VALUES
(1, 'das buscas', 'Google'),
(2, 'dos servidores', 'Amazon'),
(3, 'das redes', 'Facebook'),
(4, 'dos windows', 'Microsoft'),
(5, 'das coisas caras', 'Apple');

-- --------------------------------------------------------

--
-- Estrutura da tabela `company_seq`
--

DROP TABLE IF EXISTS `company_seq`;
CREATE TABLE IF NOT EXISTS `company_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `company_seq`
--

INSERT INTO `company_seq` (`next_val`) VALUES
(6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `company_users`
--

DROP TABLE IF EXISTS `company_users`;
CREATE TABLE IF NOT EXISTS `company_users` (
  `company_id` bigint(20) NOT NULL,
  `users_id` bigint(20) NOT NULL,
  PRIMARY KEY (`company_id`,`users_id`),
  UNIQUE KEY `UK_m191oujoneqcc8u5cc13bt0j7` (`users_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `company_users`
--

INSERT INTO `company_users` (`company_id`, `users_id`) VALUES
(1, 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `contact`
--

DROP TABLE IF EXISTS `contact`;
CREATE TABLE IF NOT EXISTS `contact` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `contact`
--

INSERT INTO `contact` (`id`, `type`, `value`) VALUES
(1, 'EMAIL', 'willianrlm@gmail.com'),
(2, 'PHONE', '55996984336'),
(3, 'PHONE', '55996984336'),
(4, 'PHONE', '55996984336'),
(5, 'PHONE', '55996984336'),
(6, 'PHONE', '55996984336'),
(7, 'PHONE', '55996984336');

-- --------------------------------------------------------

--
-- Estrutura da tabela `contact_seq`
--

DROP TABLE IF EXISTS `contact_seq`;
CREATE TABLE IF NOT EXISTS `contact_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `contact_seq`
--

INSERT INTO `contact_seq` (`next_val`) VALUES
(8);

-- --------------------------------------------------------

--
-- Estrutura da tabela `person`
--

DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint(20) NOT NULL,
  `birthday` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `person`
--

INSERT INTO `person` (`id`, `birthday`, `name`) VALUES
(1, '1994-11-18 00:00:00.000000', 'Willian da Rocha Lopes Manucello'),
(2, '1992-11-18 00:00:00.000000', 'Fulano'),
(3, '1993-11-18 00:00:00.000000', 'Ciclano'),
(4, '1991-11-18 00:00:00.000000', 'Deutrano'),
(5, '1964-11-18 00:00:00.000000', 'Outrano'),
(6, '1974-11-18 00:00:00.000000', 'Ultimano');

-- --------------------------------------------------------

--
-- Estrutura da tabela `person_contacts`
--

DROP TABLE IF EXISTS `person_contacts`;
CREATE TABLE IF NOT EXISTS `person_contacts` (
  `person_id` bigint(20) NOT NULL,
  `contacts_id` bigint(20) NOT NULL,
  PRIMARY KEY (`person_id`,`contacts_id`),
  UNIQUE KEY `UK_2oebw8nrjf1nf9gmxox9g8vcs` (`contacts_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `person_contacts`
--

INSERT INTO `person_contacts` (`person_id`, `contacts_id`) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 6),
(6, 7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `person_seq`
--

DROP TABLE IF EXISTS `person_seq`;
CREATE TABLE IF NOT EXISTS `person_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `person_seq`
--

INSERT INTO `person_seq` (`next_val`) VALUES
(7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ew1hvam8uwaknuaellwhqchhb` (`login`),
  KEY `FKir5g7yucydevmmc84i788jp79` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `user`
--

INSERT INTO `user` (`id`, `login`, `password`, `person_id`) VALUES
(1, 'willianrlm', '$2a$10$fCgCbzfVXsI.6Zq3gdWaUOuW4Yjj9uVd.LNGCPd1MjNZQLPNDvm9G', 1),
(2, 'fulano', '1234', 2),
(3, 'ciclano', '43212', 3),
(4, 'deutrano', '$*&¨%#&#', 4),
(5, 'outrano', 'a1b2c3', 5),
(6, 'thelastone', 'senha', 6),
(7, 'google', '$2a$10$fCgCbzfVXsI.6Zq3gdWaUOuW4Yjj9uVd.LNGCPd1MjNZQLPNDvm9G', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
CREATE TABLE IF NOT EXISTS `user_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `user_seq`
--

INSERT INTO `user_seq` (`next_val`) VALUES
(8);

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `candidate`
--
ALTER TABLE `candidate`
  ADD CONSTRAINT `FK5859evebv1forwxno1dj2x73m` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`),
  ADD CONSTRAINT `FKj9h7beyp5gsdtdb20km82b4fl` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Limitadores para a tabela `company_users`
--
ALTER TABLE `company_users`
  ADD CONSTRAINT `FKd6f6rmuup769kyrt22kbfcv6g` FOREIGN KEY (`users_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKkwk4foy88lulxos847o0qt4ig` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`);

--
-- Limitadores para a tabela `person_contacts`
--
ALTER TABLE `person_contacts`
  ADD CONSTRAINT `FK12co01nuk6fydsukv7ddf0fhl` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FKryf85wpcvfgxhc9hlc5ucppi2` FOREIGN KEY (`contacts_id`) REFERENCES `contact` (`id`);

--
-- Limitadores para a tabela `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FKir5g7yucydevmmc84i788jp79` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
