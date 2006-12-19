require gtkmm.inc

PR = "r1"

SRC_URI = "${GNOME_MIRROR}/gtkmm/2.8/gtkmm-${PV}.tar.bz2"

do_stage () {
	autotools_stage_all

	install -d ${STAGING_INCDIR}/gtkmm-2.4
	install -m 0644 gdk/gdkmmconfig.h ${STAGING_INCDIR}/gtkmm-2.4
	install -m 0644 gtk/gtkmmconfig.h ${STAGING_INCDIR}/gtkmm-2.4
}
