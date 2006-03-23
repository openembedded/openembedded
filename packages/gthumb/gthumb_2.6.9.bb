DESCRIPTION = "gThumb is an image viewer and browser for the GNOME Desktop."
LICENSE = "GPL"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"

DEPENDS = "gtk+ libexif libgnome libgnomeui libgnomeprintui"
SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/gnome* ${datadir}/application-registry/*"



