DESCRIPTION = "GTK plugin for stylus based systems"
SECTION = "libs"
DEPENDS = "gtk+"
LICENSE = "LGPL"
PR = "r6"

inherit autotools

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2 \
	file://makefile.patch;patch=1 \
	file://gtkstylus.sh"

do_install_append() {
	install -d ${D}/${sysconfdir}/X11/Xsession.d
	install -m 755 ${WORKDIR}/gtkstylus.sh ${D}/${sysconfdir}/X11/Xsession.d/45gtkstylus
}

FILES_${PN} = "/etc ${libdir}/gtk-2.0/*/modules/*.so*"

SRC_URI[md5sum] = "211bd08961ad78bdeeaab4f33f20c639"
SRC_URI[sha256sum] = "1964a9fb46e5f57bda75bfc37e19036b32c6a7d57bf13020776dfaaca348920b"
