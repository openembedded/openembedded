LICENSE = GPL
SECTION = "x11/gnome/libs"
PR = "r1"
DEPENDS = "libgnome libgnomecanvas libbonoboui gnome-keyring"
DESCRIPTION = "GNOME User Interface Library"

FILES_${PN} += "${libdir}/gtk-2.0/*/filesystems/lib*.so \
	${libdir}/libglade/*/lib*.so"

inherit gnome

SRC_URI += "file://gnome-stock-pixbufs.h file://no-pixbuf-csource.patch;patch=1"

EXTRA_OECONF = "--disable-gtk-doc"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/gnome-stock-pixbufs.h ${S}/libgnomeui/pixmaps/gnome-stock-pixbufs.h
}

do_stage() {
	gnome_stage_includes
	oe_libinstall -C libgnomeui -a -so libgnomeui-2 ${STAGING_LIBDIR}
}
