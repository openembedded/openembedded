DESCRIPTION = "Evince is a document viewer for document formats like pdf, ps, djvu."
LICENSE = "GPL"
SECTION = "x11/office"
DEPENDS = "nautilus gnome-icon-theme tiff libxt espgs gnome-doc-utils poppler libxml2 gtk+ gconf libglade gnome-keyring "
RDEPENDS = "espgs gnome-icon-theme"

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

FILES_${PN}-dbg += "${libdir}/evince/*/*/.debug"
FILES_evince-nautilus-extension = "${libdir}/nautilus/*/*so"



SRC_URI[archive.md5sum] = "ed8b9fb5c5d6feafd19f0114b736c9ef"
SRC_URI[archive.sha256sum] = "5165adb77af7dd355c600bc1fce4bcc7de2538ed02d0f87028660096a61af489"
