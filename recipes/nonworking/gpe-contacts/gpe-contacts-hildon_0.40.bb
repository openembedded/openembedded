require gpe-contacts.inc

PR ="r2"
SRC_URI = "${GPE_MIRROR}/gpe-contacts-${PV}.tar.bz2"

DEPENDS += "gtk+-2.6.4-1.osso7 libgpepimc-hildon libosso hildon-lgpl"
RDEPENDS = ""

EXTRA_OECONF += "--enable-hildon"

S = "${WORKDIR}/gpe-contacts-${PV}"


SRC_URI[md5sum] = "bd846bb88824dc58c7919e4354ab9b11"
SRC_URI[sha256sum] = "6fcbd13db6ee9c4b01504c4f7fcc940b5634775c71d61db98b8daf4ca71fff67"