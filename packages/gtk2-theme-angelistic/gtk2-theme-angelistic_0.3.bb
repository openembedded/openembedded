SECTION = "x11/base"
LICENSE = "GPL"
SRC_URI = "file://gtkrc file://gtkrc-global"
DEPENDS = "gnome-themes"
RDEPENDS = "gtk-engine-mist"
PR = "r3"

FILES_${PN} += "${datadir}/themes"

do_install() {
	install -d ${D}${datadir}/themes/Angelistic/gtk-2.0
	install -m 0644 ${WORKDIR}/gtkrc ${D}${datadir}/themes/Angelistic/gtk-2.0/

	install -d ${D}${sysconfdir}/gtk-2.0
	install -m 0644 ${WORKDIR}/gtkrc-global ${D}${sysconfdir}/gtk-2.0/gtkrc
}
