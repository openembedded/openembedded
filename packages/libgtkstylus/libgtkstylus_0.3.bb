DESCRIPTION = "GTK plugin for stylus based systems"
SECTION = "libs"
MAINTAINER = "Philip Blundell <pb@handhelds.org>"
DEPENDS = "gtk+"
LICENSE = "LGPL"
FILES_${PN} = "/etc ${libdir}/gtk-2.0"
PR = "r1"

inherit autotools

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2 \
	file://makefile.patch;patch=1 \
	file://gtkstylus.sh"

do_install_append() {
	install -d ${D}/${sysconfdir}/profile.d
	install ${WORKDIR}/gtkstylus.sh ${D}/${sysconfdir}/profile.d/
}

