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


SRC_URI[archive.md5sum] = "f9414b4dbfdff9a8f7f2f146a351e05a"
SRC_URI[archive.sha256sum] = "30dbad09953d92e48cc27681d601d0a55e30dc8e82a89c173098187bd7b35e61"
