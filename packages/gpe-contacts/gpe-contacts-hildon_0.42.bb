include gpe-contacts.inc

PR="r2"
SRC_URI = "${GPE_MIRROR}/gpe-contacts-${PV}.tar.bz2"

DEPENDS += "gtk+-2.6.4-1.osso7 libgpepimc-hildon libosso hildon-lgpl"
RDEPENDS = ""

EXTRA_OECONF += "--enable-hildon"

S = "${WORKDIR}/gpe-contacts-${PV}"

