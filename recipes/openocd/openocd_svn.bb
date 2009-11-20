DESCRIPTION = "Free and Open On-Chip Debugging, In-System Programming and Boundary-Scan Testing"
HOMEPAGE = "http://openocd.berlios.de/"
LICENSE = "GPL"
PV = "0.0+svnr${SRCPV}"
PR = "r3"

inherit autotools

SRC_URI = "svn://svn.berlios.de/openocd;module=trunk \
           file://openocd-link-static.patch;patch=1"
S = "${WORKDIR}/trunk"

DEPENDS = "libftdi"
EXTRA_OECONF = " --enable-ft2232_libftdi --disable-ftdi2232 --disable-ftd2xx"
