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

SRC_URI[archive.md5sum] = "16691f6bdc7c09445c457387adaba1f1"
SRC_URI[archive.sha256sum] = "6a1499a1e50ac89210a9a1fdb36bc070ef6d1a02764a0f8d90de314dba01972e"
