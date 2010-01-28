DESCRIPTION = "Tool to optimize PNG images"
SECTION = "console/graphics"
HOMEPAGE = "http://pmt.sourceforge.net/pngcrush"

SRC_URI = "${SOURCEFORGE_MIRROR}/pmt/pngcrush-${PV}.tar.gz"

#DEPENDS += "libsdl-net smpeg"

EXTRA_OEMAKE = "CC='${CC}' CFLAGS='${CFLAGS}' LD='${CC}'"

do_install () {
        install -d ${D}${bindir}
        install -m 755 ${BPN} ${D}${bindir}
}
