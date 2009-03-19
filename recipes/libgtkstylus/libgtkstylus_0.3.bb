DESCRIPTION = "GTK plugin for stylus based systems"
SECTION = "libs"
DEPENDS = "gtk+"
LICENSE = "LGPL"
PR = "r5"

inherit autotools

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2 \
	file://makefile.patch;patch=1 \
	file://gtkstylus.sh"

do_install_append() {
	install -d ${D}/${sysconfdir}/X11/Xsession.d
	install -m 755 ${WORKDIR}/gtkstylus.sh ${D}/${sysconfdir}/X11/Xsession.d/45gtkstylus
}

FILES_${PN} = "/etc ${libdir}/gtk-2.0/*/modules/*.so*"

