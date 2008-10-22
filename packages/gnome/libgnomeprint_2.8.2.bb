LICENSE = "GPL"
SECTION = "x11/gnome/libs"
PR = "r2"

DEPENDS = "libxml2 libgnomecups glib-2.0 pango libart-lgpl fontconfig popt gnome-common"

inherit flow-lossage pkgconfig gnome

FILES_${PN}-dbg += "${libdir}/libgnomeprint/2.8.2/modules/transports/.debug \
		    ${libdir}/libgnomeprint/2.8.2/modules/.debug"

do_stage() {
	install -d ${STAGING_LIBDIR}
	oe_libinstall -so -a -C libgnomeprint libgnomeprint-2-2 ${STAGING_LIBDIR}
	gnome_stage_includes
}
