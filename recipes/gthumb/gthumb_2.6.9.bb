DESCRIPTION = "gThumb is an image viewer and browser for the GNOME Desktop."
LICENSE = "GPL"

DEPENDS = "gtk+ libexif libgnome libgnomeui libgnomeprintui"
SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/gnome* ${datadir}/application-registry/*"



