DESCRIPTION = "Enblend/Enfuse - combine image with no seams"
LICENSE = "GPLv2"

DEPENDS = "tiff jpeg plotutils boost"

SRC_URI = "http://downloads.sourceforge.net/project/enblend/enblend-enfuse/enblend-enfuse-${PV}/enblend-enfuse-${PV}.tar.gz"
SRC_URI[md5sum] = "2e7c950061e0085fd75d94576130250f"
SRC_URI[sha256sum] = "a12a44c2a07894f27e1d5a1675728175a943c89b91c1ac9abacce62f08c253c4"

S = "${WORKDIR}/enblend-enfuse-4.0-753b534c819d"

inherit autotools

# Disable parallel make, the link step takes >2GB of ram otherwise
PARALLEL_MAKE = ""

