LICENSE = "GPL"
SECTION = "x11/gnome/libs"
PR = "r1"
DEPENDS = "libgnome libgnomecanvas libbonoboui gnome-keyring"
DESCRIPTION = "GNOME User Interface Library"

DEFAULT_PREFERENCE = "-1"

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

SRC_URI[archive.md5sum] = "d9b975952bf5feee8818d3fb18cca0b3"
SRC_URI[archive.sha256sum] = "552c34d20f30847429e342e6c6ddeece707b69a5abe9aeeafcfeb65cec2eebd7"
