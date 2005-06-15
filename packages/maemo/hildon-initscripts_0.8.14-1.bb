PR         = "r1"
LICENSE    = "GPL"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"

DEPENDS = "gtk+-2.6.4-1.osso7 matchbox-wm dbus"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/h/${PN}/${PN}_${PV}.tar.gz \
           file://hildon-initscripts-source.patch;patch=1;pnum=0"

S = "${WORKDIR}/hildon-initscripts-0.8.14"

inherit autotools pkgconfig

