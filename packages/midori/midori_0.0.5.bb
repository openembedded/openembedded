DESCRIPTION = "Midori is a lightweight web browser based on webkit-gtk"
HOMEPAGE = "http://software.twotoasts.de/?page=midori"
SECTION = "x11/network"
DEPENDS = "gtk+ webkit-gdk"
LICENSE = "GPL"

SRC_URI = "http://software.twotoasts.de/media/midori/midori-${PV}.tar.gz"

inherit autotools

