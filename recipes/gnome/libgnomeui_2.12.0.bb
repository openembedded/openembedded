LICENSE = "GPL"
SECTION = "x11/gnome/libs"
PR = "r3"
DEPENDS = "libgnome libgnomecanvas libbonoboui gnome-keyring"
DESCRIPTION = "GNOME User Interface Library"

FILES_${PN} += "${libdir}/gtk-2.0/*/filesystems/lib*.so \
	${libdir}/libglade/*/lib*.so"

inherit gnome

FILES_${PN}-dev += "${libdir}/gtk-2.0/*/filesystems/*.la ${libdir}/gtk-2.0/*/filesystems/*.a ${libdir}/libglade/*/*.la ${libdir}/libglade/*/*.a"
FILES_${PN}-dbg += "${libdir}/gtk-2.0/*/filesystems/.debug/ ${libdir}/libglade/*/.debug/"

SRC_URI += "file://gnome-stock-pixbufs.h file://no-pixbuf-csource.patch;patch=1"

EXTRA_OECONF = "--disable-gtk-doc"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/gnome-stock-pixbufs.h ${S}/libgnomeui/pixmaps/gnome-stock-pixbufs.h
}

do_stage() {
autotools_stage_all
}

SRC_URI[archive.md5sum] = "342a5b8a9d427ff950a71a245a5f4485"
SRC_URI[archive.sha256sum] = "b29baf52bf2c80bf896d59cfd4c4c1515b7df56b14069834b0e78910b9088dfe"
