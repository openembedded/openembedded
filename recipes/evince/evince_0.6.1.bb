DESCRIPTION = "Evince is a document viewer for document formats like pdf, ps, djvu."
LICENSE = "GPL"
SECTION = "x11/office"
DEPENDS = "tiff libxt espgs poppler gtk+ libgnomeui libgnomeprint libgnomeprintui"
RDEPENDS = "espgs gconf"
RRECOMMENDS = "gnome-vfs-plugin-file"
PR = "r1"

inherit gnome pkgconfig

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/evince/0.6/${PN}-${PV}.tar.bz2 \
          file://more-no-doc.patch;patch=1"

FILES_${PN} += "${datadir}/icons"

SRC_URI[md5sum] = "55a1d4af3cac209c7cfbe83b7ffcee1d"
SRC_URI[sha256sum] = "ee72f48ec0c76a8f44d8a6aed6759d43a147a9d5bb2b15f06460c4d6ef86025e"
