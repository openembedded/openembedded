DESCRIPTION = "Qiv is a very small and pretty fast gdk/Imlib image viewer."
LICENSE = "GPLv2"
SECTION = "x11/graphics"
DEPENDS = "gtk+-1.2 imlib"
PR = "r1"

SRC_URI = "http://www.klografx.net/qiv/download/qiv-1.9-src.tgz \
		file://makefile.patch;patch=1 \
		"
inherit pkgconfig binconfig

CFLAGS += " -lSM -lICE -lXdmcp"

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${mandir}/man1/

	install -s -m 0755 qiv ${D}${bindir}/qiv
        install -m 0644 qiv.1 ${D}${mandir}/man1/qiv.1
}
