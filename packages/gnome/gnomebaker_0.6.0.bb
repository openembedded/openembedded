DESCRIPTION = "Gnomebaker is a GTK2/GNOME cd burning application. "
LICENSE = "GPLv2"

DEPENDS = "gtk+ libnotify libgnome libgnomeui libxml2 libglade gstreamer"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/icons"


