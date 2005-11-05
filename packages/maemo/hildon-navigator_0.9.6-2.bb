PR         = "r2"
LICENSE    = "GPL"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de"

DEPENDS = "gtk+-2.6.4-1.osso7 libmatchbox gconf hildon-lgpl libosso osso-af-settings hildon-base-lib"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/h/${PN}/${PN}_${PV}.tar.gz \
           file://source.patch;patch=1;pnum=0"

S = "${WORKDIR}/hildon-navigator-0.9.6"

inherit autotools pkgconfig

#FILES_${PN} += " ${libdir}/outo/*.so" 
