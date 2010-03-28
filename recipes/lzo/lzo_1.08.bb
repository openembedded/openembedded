DESCRIPTION = "Lossless data compression library"
HOMEPAGE = "http://www.oberhumer.com/opensource/lzo/"
LICENSE = "GPLv2"
SECTION = "libs"
PRIORITY = "optional"
PR = "r15"

SRC_URI = "http://www.oberhumer.com/opensource/lzo/download/lzo-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--enable-shared"

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"
