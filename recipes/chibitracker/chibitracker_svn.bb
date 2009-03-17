DESCRIPTION = "Chibitracker is an impulse tracker clone based on SDL"
LICENSE = "GPL"
HOMEPAGE = "http://www.chibitracker.com"
SECTION = "multimedia"
AUTHOR = "Juan Linietsky <reduzio@gmail.com>"
DEPENDS = "virtual/libsdl libsdl-mixer"
PV = "0.9.9+svn${SRCDATE}"

SRC_URI = "svn://svn.berlios.de/chibitracker;module=trunk"
S = "${WORKDIR}/trunk"

inherit scons

