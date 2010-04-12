DESCRIPTION = "A text mode OSS soundmixer"
SECTION = "console/multimedia"
PRIORITY = "optional"
DEPENDS = "ncurses"
LICENSE = "GPL"
SRC_URI = "http://www.stack.nl/~brama/projects/nmixer/src/nmixer-${PV}.tar.gz"

inherit autotools

do_compile() {
	oe_runmake nmixer INCLUDES=-I${STAGING_INCDIR}/
}


SRC_URI[md5sum] = "02108108f5b0aafdf10207aa86d1b976"
SRC_URI[sha256sum] = "aac281c7437e4007236eb461a668311eb3453e85012acf619aa3d62683330a6a"
