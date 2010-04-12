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

SRC_URI[md5sum] = "129d960e30498f2a68d31c2c40b145af"
SRC_URI[sha256sum] = "bd9669e5f1a43d1cfcff4d3dc5f18736ba7c950c8ba7b71b1d9cf4436a3783b3"
