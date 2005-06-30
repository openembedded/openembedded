LICENSE = GPL
SECTION = "x11/gnome"
PR = "r0"
DESCRIPTION = "GNOME library for reading .desktop files"
inherit gnome

DEPENDS = "gnome-common libgnomeui"

EXTRA_AUTORECONF = "-I ${STAGING_DIR}/${HOST_SYS}/share/aclocal/gnome2-macros"

do_configure_prepend () {
	cp ${STAGING_DIR}/${HOST_SYS}/share/gnome-common/data/omf.make ${S}
}

do_stage () {
	install -d ${STAGING_INCDIR}/gnome-desktop-2.0/libgnome/
#	install -d ${STAGING_INCDIR}/gnome-desktop-2.0/libgnomeui/
	install -m 0644 libgnome-desktop/libgnome/gnome-desktop-item.h ${STAGING_INCDIR}/gnome-desktop-2.0/libgnome/
#	install -m 0644 libgnome-desktop/libgnomeui/gnome-ditem-edit.h ${STAGING_INCDIR}/gnome-desktop-2.0/libgnomeui/
#	install -m 0644 libgnome-desktop/libgnomeui/gnome-hint.h ${STAGING_INCDIR}/gnome-desktop-2.0/libgnomeui/
	oe_libinstall -C libgnome-desktop/.libs -so libgnome-desktop-2 ${STAGING_LIBDIR}
	
 
}
