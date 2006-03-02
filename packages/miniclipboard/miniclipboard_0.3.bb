SECTION = "x11/utils"
inherit gpe
LICENSE = "LGPL"
DESCRIPTION = "Clipboard management application"
DEPENDS = "libx11"
RDEPENDS = "gdk-pixbuf-loader-xpm"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
PR = "r1"

SRC_URI += "file://miniclipboard.desktop"

do_install() {
	install -d ${D}${bindir}
        install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/pixmaps
	install -m 0755 miniclipboard ${D}${bindir}/
	install -m 0644 ${WORKDIR}/miniclipboard.desktop ${D}${datadir}/applications/
	install -m 0644 copy.xpm ${D}${datadir}/pixmaps/
	install -m 0644 paste.xpm ${D}${datadir}/pixmaps/
}
