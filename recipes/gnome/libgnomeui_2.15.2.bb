LICENSE = "GPL"
SECTION = "x11/gnome/libs"
PR = "r0"
DEPENDS = "libgnome libgnomecanvas libbonoboui gnome-keyring"
DESCRIPTION = "GNOME User Interface Library"

DEFAULT_PREFERENCE = "-1"

FILES_${PN} += "${libdir}/gtk-2.0/*/filesystems/lib*.so \
	${libdir}/libglade/*/lib*.so"

inherit gnome

SRC_URI += "file://gnome-stock-pixbufs.h file://no-pixbuf-csource.patch;patch=1"

EXTRA_OECONF = "--disable-gtk-doc"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/gnome-stock-pixbufs.h ${S}/libgnomeui/pixmaps/gnome-stock-pixbufs.h
}

do_stage() {
autotools_stage_all
}

SRC_URI[archive.md5sum] = "ec5841c2c01d79e97bc363414e446240"
SRC_URI[archive.sha256sum] = "3bb709d3dbb7287482d236e418e9ca4b858f28dfd374c6840f0aebae6b206894"
