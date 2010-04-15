LICENSE = "GPL"
SECTION = "x11/gnome/libs"

PR = "r2"

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

SRC_URI[archive.md5sum] = "16e6717b5d7da982db00fea6167188ef"
SRC_URI[archive.sha256sum] = "0c6c91a59e411d196fe56c814bd368224b04e11a341a8ad552398035e8f19d93"
