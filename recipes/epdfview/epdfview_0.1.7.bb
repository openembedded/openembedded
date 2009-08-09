DESCRIPTION = "A minimal PDF viewer based on gtk and poppler"
HOMEPAGE = "http://www.emma-soft.com/projects/epdfview/"
LICENSE = "GPLv2"
SECTION = "x11/applications"
DEPENDS = "poppler gtk+ cups"
PR = "r8"

SRC_URI = "http://www.emma-soft.com/projects/epdfview/chrome/site/releases/epdfview-${PV}.tar.bz2 \
	   file://acroread.png\
	  "

inherit autotools


do_compile_append () {
	sed -i 's/Icon=.*/Icon=acroread/' data/epdfview.desktop
}

do_install_append () {
	install -d ${D}${datadir}/pixmaps/
	install -m 0644 ${WORKDIR}/acroread.png ${D}${datadir}/pixmaps/
}

FILES_${PN} += "${datadir}/pixmaps/acroread.png"