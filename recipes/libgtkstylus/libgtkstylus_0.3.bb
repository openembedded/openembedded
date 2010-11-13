DESCRIPTION = "GTK plugin for stylus based systems"
SECTION = "libs"
DEPENDS = "gtk+"
LICENSE = "LGPL"
PR = "r7"

inherit autotools

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2 \
	file://makefile.patch \
	file://gtkstylus.sh"

do_install_append() {
	install -d ${D}/${sysconfdir}/X11/Xsession.d
	install -m 755 ${WORKDIR}/gtkstylus.sh ${D}/${sysconfdir}/X11/Xsession.d/45gtkstylus
}

FILES_${PN} = "/etc ${libdir}/gtk-2.0/*/modules/lib*.so.*"
FILES_${PN}-dev = "${libdir}/gtk-2.0/*/modules/lib*.so \
		    ${libdir}/gtk-2.0/*/modules/*.la \
		    ${libdir}/gtk-2.0/*/modules/*.a"
FILES_${PN}-dbg = "${libdir}/gtk-2.0/*/modules/.debug"

SRC_URI[md5sum] = "211bd08961ad78bdeeaab4f33f20c639"
SRC_URI[sha256sum] = "1964a9fb46e5f57bda75bfc37e19036b32c6a7d57bf13020776dfaaca348920b"
