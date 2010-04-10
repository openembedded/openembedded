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

SRC_URI[md5sum] = "dba850728cfa65403d5b699fd302399f"
SRC_URI[sha256sum] = "b3b8da5e458f56246f735b499b32bc2a3a039d2d4092b1b249c60a188c2314d5"
