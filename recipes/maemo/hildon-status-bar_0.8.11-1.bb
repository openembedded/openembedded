PR         = "r1"
LICENSE    = "GPL"

DEPENDS = "hildon-lgpl libosso hildon-libs"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/h/${PN}/${PN}_${PV}.tar.gz \
           file://source.patch;patch=1;pnum=0"

S = "${WORKDIR}/hildon-status-bar-0.8.11"

inherit autotools pkgconfig


SRC_URI[md5sum] = "7948087bfe3b1bf8025a37fbb64bde44"
SRC_URI[sha256sum] = "eca16f42de8e4a213acb3ba0978fa56fbdf2f38e5be5882163753068ab4a15cd"
