DESCRIPTION = "Evince is a document viewer for document formats like pdf, ps, djvu."
LICENSE = "GPL"
SECTION = "x11/office"
DEPENDS = "nautilus gnome-icon-theme tiff libxt espgs gnome-doc-utils poppler libxml2 gtk+ gconf libglade gnome-keyring "
RDEPENDS = "espgs gnome-icon-theme"
PR = "r2"

inherit gnome pkgconfig gtk-icon-cache

SRC_URI += " file://no-help-dir.patch;patch=1"

EXTRA_OECONF = "  \
                 --enable-thumbnailer \
                 --enable-nautilus \ 
                 --disable-scrollkeeper \
                 --enable-djvu \
                 --enable-pixbuf \
		 "

FILES_${PN}-dbg += "${libdir}/evince/backends/.debug"

PACKAGES =+ "evince-nautilus-extension"

FILES_evince-nautilus-extension = "${libdir}/nautilus/*/*so"



SRC_URI[archive.md5sum] = "ad0e463ab1fe596fc52c03403a9b9f1e"
SRC_URI[archive.sha256sum] = "d8803313e2a0b3fa3fe20fe613ac3ec85ec6848d5d446dd02e9cc5be8194f65c"
