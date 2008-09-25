LICENSE = "GPL"
SECTION = "x11/gnome/libs"

DEPENDS = "libxml2 libgnomecups glib-2.0 pango libart-lgpl fontconfig popt gnome-common"

inherit flow-lossage pkgconfig gnome

FILES_${PN}-dbg += "${libdir}/libgnomeprint/${PV}/modules/transports/.debug \
		    ${libdir}/libgnomeprint/${PV}/modules/.debug  ${libdir}/libgnomeprint/${PV}/modules/*/.debug"

do_stage() {
	autotools_stage_all
}
