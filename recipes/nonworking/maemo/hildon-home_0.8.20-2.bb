PR         = "r2"
LICENSE    = "GPL"

DEPENDS = "gtk+-2.6.4-1.osso7 hildon-lgpl libosso hildon-base-lib hildon-libs osso-gnome-vfs2 osso-thumbnail"

SRC_URI = "http://repository.maemo.org/pool/maemo/ossw/source/h/${PN}/${PN}_${PV}.tar.gz \
           file://source.patch;patch=1;pnum=0 \
           file://noWerror.patch;patch=1;pnum=0"

S = "${WORKDIR}/hildon-home-0.8.20"

inherit autotools pkgconfig


SRC_URI[md5sum] = "dd62148b18abe1e02182abba91e1d55b"
SRC_URI[sha256sum] = "1b62825a44d7058e56162d6fc08d06454d30889cfaad6ff0bbd9e32bf4b0ce5c"
