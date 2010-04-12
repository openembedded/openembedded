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

SRC_URI[md5sum] = "ab94d3da364c7cbd5b78d76f1875b0f6"
SRC_URI[sha256sum] = "bcead46b0bd887c3987e977a0a7d4c547b0f70f926d45e253784137569f57b9a"
