DESCRIPTION = "Free and Open On-Chip Debugging, In-System Programming and Boundary-Scan Testing"
HOMEPAGE = "http://openocd.berlios.de/"
LICENSE = "GPL"
PV = "0.0+svn${SRCDATE}"

DEPENDS = "libftdi"

SRC_URI = "svn://svn.berlios.de/;module=openocd"

S = "${WORKDIR}/openocd/trunk"

inherit autotools

EXTRA_OECONF = "--enable-ft2232_libftdi --enable-parport-ppdev"
