DESCRIPTION = "Locale::gettext - message handling functions"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "virtual/libintl"
PR = "r9"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PV/PVANDRY/gettext-${PV}.tar.gz"

S = "${WORKDIR}/gettext-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/Locale/gettext/* \
                ${PERLLIBDIRS}/Locale"

SRC_URI[md5sum] = "f3d3f474a1458f37174c410dfef61a46"
SRC_URI[sha256sum] = "27367f3dc1be79c9ed178732756e37e4cfce45f9e2a27ebf26e1f40d80124694"
