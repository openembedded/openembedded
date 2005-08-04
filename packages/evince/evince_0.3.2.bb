DESCRIPTION = "Evince is simply a document viewer"
LICENSE = "GPL"
DEPENDS = "tiff espgs poppler gtk+ libgnomeui libgnomeprint libgnomeprintui"
RDEPENDS = "espgs"
RRECOMMENDS = "gnome-vfs-plugin-file"

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/evince/0.3/${PN}-${PV}.tar.bz2 \
		file://no-doc.patch;patch=1"

EXTRA_OECONF = "--disable-tiff"

inherit gnome pkgconfig


