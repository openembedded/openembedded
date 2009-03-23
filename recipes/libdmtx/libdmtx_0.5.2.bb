DESCRIPTION = "libdmtx is for reading and writing Data Matrix barcodes"
HOMEPAGE = "http://www.libdmtx.org/"
LICENSE = "GPLv2"
AUTHOR = "Mike Laughton"
SECTION = "libs"
PRIORITY = "optional"

PR = "r0"

DEPENDS = "libpng tiff"

SRC_URI = "${SOURCEFORGE_MIRROR}/libdmtx/libdmtx-${PV}.tar.gz"

inherit autotools
