DESCRIPTION = "GTK plugin for stylus based systems"
SECTION = "libs"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"
DEPENDS = "gtk+"
LICENSE = "LGPL"
FILES_${PN} = "/etc ${libdir}/gtk-2.0/2.4.0/modules/*.so*"
PR = "r4"

inherit autotools

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2 \
	file://makefile.patch;patch=1 \
	file://gtkstylus.sh"

do_install_append() {
	install -d ${D}/${sysconfdir}/X11/Xsession.d
	install -m 755 ${WORKDIR}/gtkstylus.sh ${D}/${sysconfdir}/X11/Xsession.d/45gtkstylus
}

