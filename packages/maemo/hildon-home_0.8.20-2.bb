PR         = "r1"
LICENSE    = "GPL"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"

DEPENDS = "gtk+-2.6.4-1.osso7 hildon-lgpl libosso hildon-base-lib hildon-libs osso-gnome-vfs2 osso-thumbnail"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/h/${PN}/${PN}_${PV}.tar.gz \
           file://source.patch;patch=1;pnum=0"

S = "${WORKDIR}/hildon-home-0.8.20"

inherit autotools pkgconfig

