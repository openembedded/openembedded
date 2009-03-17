SECTION = "x11/utils"
inherit gpe
LICENSE = "GPL"
DESCRIPTION = "Clipboard management application"
DEPENDS = "virtual/libx11 libxpm"
RDEPENDS = "gdk-pixbuf-loader-xpm"
PR = "r2"

SRC_URI += "file://miniclipboard.desktop \
            file://makefile.patch;patch=1;pnum=0"

do_install() {
	install -d ${D}${bindir}
        install -d ${D}${datadir}/applications
	install -d ${D}${datadir}/pixmaps
	install -m 0755 miniclipboard ${D}${bindir}/
	install -m 0644 ${WORKDIR}/miniclipboard.desktop ${D}${datadir}/applications/
	install -m 0644 copy.xpm ${D}${datadir}/pixmaps/
	install -m 0644 paste.xpm ${D}${datadir}/pixmaps/
}
