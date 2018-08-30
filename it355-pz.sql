-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 29, 2017 at 06:43 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `it355-pz`
--

-- --------------------------------------------------------

--
-- Table structure for table `jela`
--

CREATE TABLE `jela` (
  `idJela` int(11) NOT NULL,
  `nazivJela` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `opisJela` text COLLATE utf8_bin,
  `cenaJela` double DEFAULT NULL,
  `sasatojciJela` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `vremeSpremanja` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `jela`
--

INSERT INTO `jela` (`idJela`, `nazivJela`, `opisJela`, `cenaJela`, `sasatojciJela`, `vremeSpremanja`) VALUES
(2, 'drugo', 'Spremljeno na specijalan nacin pomocu balsbdlabsldbalsbd\r\nljabsilblabsfila', 200, 'mleko, jaja, secer, so, brasno', '20'),
(3, 'trece', 'Spremljeno na specijalan nacin pomocu recepta moje bakesdasdadasdasdasdsad\nxcvxcvxcvxc', 450, 'mleko, jaja, secer, so, brasno', '200'),
(6, 'deseto jelo', 'asdsads', 800, 'asdasdasd', '100'),
(5, 'Neko jelo', 'qweqwewqe\r\nasdasd\r\nqwewqe', 5000, 'asdasdasdasdasdasds', '500'),
(7, 'jelo', 'jlkjkljkljlkjjljlkjkl', 10, 'asdads', '10');

-- --------------------------------------------------------

--
-- Table structure for table `restorani`
--

CREATE TABLE `restorani` (
  `idRestorana` int(11) NOT NULL,
  `nazivRestorana` varchar(50) COLLATE utf8_bin NOT NULL,
  `lokacijaRestorana` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `radnoVreme` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `vrsteKuhunja` varchar(255) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `restorani`
--

INSERT INTO `restorani` (`idRestorana`, `nazivRestorana`, `lokacijaRestorana`, `radnoVreme`, `vrsteKuhunja`) VALUES
(1, 'asd', 'Knez Mihajlova 32', '08-20h', 'Kineska, Meksicka, Tajlandska');

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE `rezervacija` (
  `idRezervacije` int(11) NOT NULL,
  `datumRezervacije` varchar(1024) COLLATE utf8_bin NOT NULL,
  `vremeRezervacije` varchar(1024) COLLATE utf8_bin NOT NULL,
  `imeKorisnika` varchar(1024) COLLATE utf8_bin NOT NULL,
  `prezimeKorisnika` varchar(1024) COLLATE utf8_bin NOT NULL,
  `usernameKorisnika` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `idRestorana` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`idRezervacije`, `datumRezervacije`, `vremeRezervacije`, `imeKorisnika`, `prezimeKorisnika`, `usernameKorisnika`, `idRestorana`) VALUES
(1, 'asd', 'asd', 'asd', 'asd', 'admin', 1),
(2, 'asd', 'asd', 'asd', 'asd', 'admin', 1),
(3, 'asd', 'asd', 'asd', 'asd', 'admin', 1),
(5, 'qwe', 'qwe', 'qwe', 'qwe', 'admin', 1);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `idKorisnika` int(11) NOT NULL,
  `username` varchar(45) COLLATE utf8_bin NOT NULL,
  `password` varchar(45) COLLATE utf8_bin NOT NULL,
  `email` varchar(100) COLLATE utf8_bin NOT NULL,
  `telefon` varchar(100) COLLATE utf8_bin NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  `role` varchar(45) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`idKorisnika`, `username`, `password`, `email`, `telefon`, `enabled`, `role`) VALUES
(1, 'admin', 'admin', 'admin@admin.com', '1234456', 1, 'ROLE_ADMIN'),
(3, 'asd', 'asd', 'asd', '1345678', 1, 'ROLE_USER'),
(4, 'ivan', 'ivan', 'ivan@ivan.com', '45678123', 1, 'ROLE_USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jela`
--
ALTER TABLE `jela`
  ADD PRIMARY KEY (`idJela`);

--
-- Indexes for table `restorani`
--
ALTER TABLE `restorani`
  ADD PRIMARY KEY (`idRestorana`),
  ADD UNIQUE KEY `idRestorana` (`idRestorana`),
  ADD UNIQUE KEY `UK_lgw70058tb5j85f9qcypowv3l` (`nazivRestorana`),
  ADD UNIQUE KEY `nazivRestorana` (`nazivRestorana`),
  ADD UNIQUE KEY `UK_d2i6ne9154lttlfu63ndymong` (`idRestorana`),
  ADD KEY `idRestorana_2` (`idRestorana`),
  ADD KEY `idRestorana_3` (`idRestorana`);

--
-- Indexes for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD PRIMARY KEY (`idRezervacije`),
  ADD KEY `nazivRestorana` (`idRestorana`),
  ADD KEY `usernameKorisnika` (`usernameKorisnika`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`idKorisnika`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jela`
--
ALTER TABLE `jela`
  MODIFY `idJela` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `restorani`
--
ALTER TABLE `restorani`
  MODIFY `idRestorana` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `idKorisnika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD CONSTRAINT `FK_dtgi5ilgiwpdjp7o7bbperieb` FOREIGN KEY (`idRestorana`) REFERENCES `restorani` (`idRestorana`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
