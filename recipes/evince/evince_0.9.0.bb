DESCRIPTION = "Evince is a document viewer for document formats like pdf, ps, djvu."
LICENSE = "GPL"
SECTION = "x11/office"
DEPENDS = "tiff libxt espgs gnome-doc-utils poppler libxml2 gtk+ gnome-vfs gconf libglade gnome-keyring "
RDEPENDS = "espgs "
RRECOMMENDS = "gnome-vfs-plugin-file"
PR = "r2"

inherit gnome pkgconfig gtk-icon-cache

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/evince/0.9/${PN}-${PV}.tar.bz2 \
           file://no-icon-theme.diff;patch=1;pnum=0 \
           file://no-help-dir.patch;patch=1"

EXTRA_OECONF = "--without-libgnome --disable-thumbnailer --disable-scrollkeeper"

