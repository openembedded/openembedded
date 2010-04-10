DESCRIPTION = "Ncurses based Music Player Daemon (mpd) Client"
HOMEPAGE = "http://www.musicpd.org/ncmpc.shtml"
SECTION = "console/multimedia"
LICENSE = "GPLv2"
DEPENDS = "ncurses glib-2.0"

SRC_URI = "http://mercury.chem.pitt.edu/~shank/ncmpc-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "c90668b12f3676c73913a863482ec405"
SRC_URI[sha256sum] = "aa0a6162e8543e01304f7dc2f6b227babebda9f2430664e6deae0277444cb817"
