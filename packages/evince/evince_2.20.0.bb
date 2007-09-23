DESCRIPTION = "Evince is a document viewer for document formats like pdf, ps, djvu."
LICENSE = "GPL"
SECTION = "x11/office"
DEPENDS = "tiff djvulibre libxt espgs gnome-doc-utils poppler libxml2 gtk+ gnome-vfs gconf libglade gnome-keyring "
RDEPENDS = "espgs "
RRECOMMENDS = "gnome-vfs-plugin-file"
PR = "r2"

inherit gnome pkgconfig gtk-icon-cache

SRC_URI += "file://no-icon-theme.diff;patch=1;pnum=0 \
            file://no-help-dir.patch;patch=1"

EXTRA_OECONF = " --without-libgnome \
                 --disable-thumbnailer \
		 --disable-scrollkeeper \
		 --enable-djvu \
		 "

