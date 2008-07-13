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

