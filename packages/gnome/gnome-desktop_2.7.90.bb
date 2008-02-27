require gnome-desktop.inc

PR = "r0"

inherit gnome

EXTRA_OECONF = ""
EXTRA_AUTORECONF = "-I ${STAGING_DATADIR}/aclocal/gnome2-macros"

do_stage () {
	install -d ${STAGING_INCDIR}/gnome-desktop-2.0/libgnome/
#	install -d ${STAGING_INCDIR}/gnome-desktop-2.0/libgnomeui/
	install -m 0644 libgnome-desktop/libgnome/gnome-desktop-item.h ${STAGING_INCDIR}/gnome-desktop-2.0/libgnome/
#	install -m 0644 libgnome-desktop/libgnomeui/gnome-ditem-edit.h ${STAGING_INCDIR}/gnome-desktop-2.0/libgnomeui/
#	install -m 0644 libgnome-desktop/libgnomeui/gnome-hint.h ${STAGING_INCDIR}/gnome-desktop-2.0/libgnomeui/
	oe_libinstall -C libgnome-desktop/.libs -so libgnome-desktop-2 ${STAGING_LIBDIR}


}
