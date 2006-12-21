require gtkmm.inc

SRC_URI = "${GNOME_MIRROR}/gtkmm/2.4/gtkmm-${PV}.tar.bz2"

do_stage () {
	oe_libinstall -so -C atk/atkmm libatkmm-1.6 ${STAGING_LIBDIR}
	oe_libinstall -so -C pango/pangomm libpangomm-1.4 ${STAGING_LIBDIR}
	oe_libinstall -so -C gdk/gdkmm libgdkmm-2.4 ${STAGING_LIBDIR}
	oe_libinstall -so -C gtk/gtkmm libgtkmm-2.4 ${STAGING_LIBDIR}

	autotools_stage_includes

	install -m 0644 gdk/gdkmmconfig.h ${STAGING_INCDIR}/gtkmm-2.4
	install -m 0644 gtk/gtkmmconfig.h ${STAGING_INCDIR}/gtkmm-2.4
}
