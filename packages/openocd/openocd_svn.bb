HOMEPAGE = "http://openocd.berlios.de/"
DESCRIPTION = "Free and Open On-Chip Debugging, In-System Programming and Boundary-Scan Testing"
LICENSE = "GPL"

inherit autotools

SRC_URI = "svn://svn.berlios.de/;module=${PN}"

S = "${WORKDIR}/${PN}"
EXTRA_OECONF = "  --disable-ftdi2232 --disable-ftd2xx"  


