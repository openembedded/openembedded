DESCRIPTION = "Gnomebaker is a GTK2/GNOME cd burning application. "
LICENSE = "GPLv2"

DEPENDS = "gtk+ libnotify libgnome libgnomeui libxml2 libglade gstreamer"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/icons"



SRC_URI[md5sum] = "351363497017121d3a1d43b0e3a0f515"
SRC_URI[sha256sum] = "b1639296a7c5de7fbc37464ed70d68007edcb884eb4b5983a1c5f9028f50fb0b"
