DESCRIPTION = "Lossless data compression library"
HOMEPAGE = "http://www.oberhumer.com/opensource/lzo/"
LICENSE = "GPLv2+"
SECTION = "libs"
PRIORITY = "optional"

SRC_URI = "http://www.oberhumer.com/opensource/lzo/download/lzo-${PV}.tar.gz"
SRC_URI[md5sum] = "0c3d078c2e8ea5a88971089a2f02a726"
SRC_URI[sha256sum] = "8b1b0da8f757b9ac318e1c15a0eac8bdb56ca902a2dd25beda06c0f265f22591"

S = "${WORKDIR}/lzo-${PV}"

inherit autotools

EXTRA_OECONF = "--enable-shared"

do_configure() {
	gnu-configize --force
	oe_runconf
}

BBCLASSEXTEND = "native"

