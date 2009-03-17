DESCRIPTION = "An MP3 command line encoder"
HOMEPAGE = "http://unimut.fsk.uni-heidelberg.de/demi/comprec/index.html"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "http://unimut.fsk.uni-heidelberg.de/demi/comprec/comprec-${PV}.tar.gz \
	   file://makefile.patch;patch=1"

export AS = "${TARGET_PREFIX}as"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 shine ${D}${bindir}/shine
}
