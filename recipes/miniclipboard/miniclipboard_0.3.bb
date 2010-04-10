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

SRC_URI[md5sum] = "8bea461bf4136aedbe110b6aec184d72"
SRC_URI[sha256sum] = "7f9c937c0f04760d215f7e7d9ca2709f8148e69be2693206d1ae81e2c88a656e"
