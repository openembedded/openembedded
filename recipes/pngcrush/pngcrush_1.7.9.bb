DESCRIPTION = "Tool to optimize PNG images"
SECTION = "console/graphics"
HOMEPAGE = "http://pmt.sourceforge.net/pngcrush"

SRC_URI = "${SOURCEFORGE_MIRROR}/pmt/pngcrush-${PV}.tar.gz;name=src"

SRC_URI[src.md5sum] = "6e843bdaa1291ca072ae9afb4d6a09cc"
SRC_URI[src.sha256sum] = "644f0e11b9c60f00943063f93f1813d814466c3516a7924db4c90d64eb70af66"


#DEPENDS += "libsdl-net smpeg"

EXTRA_OEMAKE = "CC='${CC}' CFLAGS='${CFLAGS}' LD='${CC} ${LDFLAGS}'"

do_install () {
        install -d ${D}${bindir}
        install -m 755 ${BPN} ${D}${bindir}
}
