require gpe-contacts.inc

PR ="r2"
SRC_URI = "${GPE_MIRROR}/gpe-contacts-${PV}.tar.bz2"

DEPENDS += "gtk+-2.6.4-1.osso7 libgpepimc-hildon libosso hildon-lgpl"
RDEPENDS = ""

EXTRA_OECONF += "--enable-hildon"

S = "${WORKDIR}/gpe-contacts-${PV}"


SRC_URI[md5sum] = "3df07fc223f781fe7d6e3e9ec820ecd2"
SRC_URI[sha256sum] = "e2c141aba89e8e0c88c2b4b7af3bf3a62d95a3e74d8564715e2175fd86706547"