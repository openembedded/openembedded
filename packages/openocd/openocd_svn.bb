HOMEPAGE = "http://openocd.berlios.de/"
DESCRIPTION = "Free and Open On-Chip Debugging, In-System Programming and Boundary-Scan Testing"
LICENSE = "GPL"

PV = "0.0+svn${SRCDATE}"

inherit autotools

SRC_URI = "svn://svn.berlios.de/;module=${PN}"

S = "${WORKDIR}/${PN}/trunk"
EXTRA_OECONF = "  --disable-ftdi2232 --disable-ftd2xx"  


