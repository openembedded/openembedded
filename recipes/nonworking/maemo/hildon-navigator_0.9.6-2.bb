PR         = "r2"
LICENSE    = "GPL"

DEPENDS = "gtk+-2.6.4-1.osso7 libmatchbox gconf hildon-lgpl libosso osso-af-settings hildon-base-lib"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/h/${PN}/${PN}_${PV}.tar.gz \
           file://source.patch;patch=1;pnum=0"

S = "${WORKDIR}/hildon-navigator-0.9.6"

inherit autotools pkgconfig

#FILES_${PN} += " ${libdir}/outo/*.so"

SRC_URI[md5sum] = "e2c2bdfb741f4e2a7d3d696597890139"
SRC_URI[sha256sum] = "51005d8161b45a422158f04e76b244394aa5eb99b5098b2846f989ee9845b9e6"
