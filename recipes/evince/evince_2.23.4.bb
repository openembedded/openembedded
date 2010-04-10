DESCRIPTION = "Evince is a document viewer for document formats like pdf, ps, djvu."
LICENSE = "GPL"
SECTION = "x11/office"
DEPENDS = "gnome-icon-theme tiff libxt espgs gnome-doc-utils poppler libxml2 gtk+ gnome-vfs gconf libglade gnome-keyring "
RDEPENDS = "espgs gnome-icon-theme"
RRECOMMENDS = "gnome-vfs-plugin-file"
PR = "r2"

inherit gnome pkgconfig gtk-icon-cache

SRC_URI += " file://no-help-dir.patch;patch=1"

EXTRA_OECONF = " --without-libgnome \
                 --disable-thumbnailer \
		 --disable-scrollkeeper \
		 --enable-djvu \
		 "
FILES_${PN}-dbg = "${libdir}/evince/backends/.debug"


SRC_URI[archive.md5sum] = "4e353edd6481f67ee534a40d4b7f3b8c"
SRC_URI[archive.sha256sum] = "c424e6dd5cc0d998a311f5c49835de9803da4dbcb74ca7fbda29c1b953bf6d6b"
