DESCRIPTION = "Library for parsing configuration files."
HOMEPAGE = "http://www.nongnu.org/confuse/"
LICENSE = "LGPL"
SECTION = "libs"

SRC_URI = "http://www.intra2net.com/de/produkte/opensource/ftdi/TGZ/confuse-${PV}.tar.gz \
	   file://exclude-tests.patch;patch=1"
S = "${WORKDIR}/confuse-${PV}"

inherit autotools lib_package

EXTRA_OECONF = "--enable-shared"

do_stage() {
    autotools_stage_all
}

