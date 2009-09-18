DESCRIPTION = "A minimal PDF viewer based on gtk and poppler"
HOMEPAGE = "http://www.emma-soft.com/projects/epdfview/"
LICENSE = "GPLv2"
SECTION = "x11/applications"
DEPENDS = "poppler gtk+ cups"

SRC_URI = "http://www.emma-soft.com/projects/epdfview/chrome/site/releases/epdfview-${PV}.tar.bz2 \
          "

SRC_URI_append_shr = "file://acroread.png \
                     "

inherit autotools

do_compile_append () {
	sed -i 's|\$.*prefix./|/usr/|' data/epdfview.desktop
}

do_compile_append_shr () {
	sed -i 's/Icon=.*/Icon=acroread/' data/epdfview.desktop
}

do_install_append_shr () {
	install -d ${D}${datadir}/pixmaps/
	install -m 0644 ${WORKDIR}/acroread.png ${D}${datadir}/pixmaps/
}

FILES_${PN}_append_shr = "${datadir}/pixmaps/acroread.png"