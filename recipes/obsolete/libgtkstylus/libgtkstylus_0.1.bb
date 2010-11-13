DESCRIPTION = "GTK plugin for stylus based systems"
SECTION = "libs"
DEPENDS = "gtk+"
PR = "r1"
LICENSE = "LGPL"
FILES_${PN} = "/etc ${libdir}/gtk-2.0"

inherit autotools

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.bz2 \
	file://gtkstylus.sh"

do_install_append() {
	install -d ${D}${sysconfdir}/profile.d
	install ${WORKDIR}/gtkstylus.sh ${D}${sysconfdir}/profile.d/
}


SRC_URI[md5sum] = "fea0cf7333623ca2d8954b202d2cd89f"
SRC_URI[sha256sum] = "be7359f95c926bc40d6be82aea835cd8a53459719249a625cdca879827470593"
