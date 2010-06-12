DESCRIPTION = "Evince is a document viewer for document formats like pdf, ps, djvu."
LICENSE = "GPL"
SECTION = "x11/office"
DEPENDS = "tiff djvulibre libxt espgs gnome-doc-utils poppler libxml2 gtk+ gnome-vfs gconf libglade gnome-keyring "
RDEPENDS_${PN} = "espgs "
RRECOMMENDS_${PN} = "gnome-vfs-plugin-file"
PR = "r3"

inherit gnome pkgconfig gtk-icon-cache

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/evince/0.9/${PN}-${PV}.tar.bz2 \
           file://no-icon-theme.diff;striplevel=0 \
           file://no-help-dir.patch"

EXTRA_OECONF = " --without-libgnome \
                 --disable-thumbnailer \
		 --disable-scrollkeeper \
		 --enable-djvu \
		 "


SRC_URI[md5sum] = "defd7e5f9e8299da9d65b0ad025ccfac"
SRC_URI[sha256sum] = "aab3a4c14612664edfee07b305994d375843be998c5154058458a7afe886a179"
