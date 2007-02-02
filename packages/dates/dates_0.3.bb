DESCRIPTION = "Dates is a calendar application."
SECTION = "x11"
LICENSE = "LGPL"

DEPENDS = "glib-2.0 gtk+ libglade eds-dbus"

SRC_URI = "http://projects.o-hand.com/sources/dates/${P}.tar.gz"

inherit autotools pkgconfig gtk-icon-cache

FILES_${PN} += "${datadir}/pixmaps/dates.png"

