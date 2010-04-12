SRC_URI = "http://gnokii.org/download/gnocky/gnocky-${PV}.tar.bz2"
LICENSE = "GPL"
DEPENDS = "gtk+ gnokii"
DESCRIPTION = "GTK+ frontend for Gnokii"

inherit autotools


SRC_URI[md5sum] = "239cfb4b743dc69723acbd01c44e7128"
SRC_URI[sha256sum] = "fb11b959c039f1a2c5471b2dc1270607acfc15fb667a69c2d4bdb0970b3595bb"
