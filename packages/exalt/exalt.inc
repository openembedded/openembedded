DESCRIPTION = "Exalt is a network manager for the windows manager Enlightenment DR17."
AUTHOR = "John Lee <john_lee@openmoko.com>"
HOMEPAGE = "http://watchwolf.fr/wiki/doku.php?id=exalt"
PV = "0.0.0+svnr${SRCREV}"

SRC_URI = "svn://svn.berlios.de/exalt/trunk;module=${EXALT_MODULE};proto=svn"

S = "${WORKDIR}/${EXALT_MODULE}"

inherit autotools pkgconfig

EXALT_MODULE ?= "${PN}"
