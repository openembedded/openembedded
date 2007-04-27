SECTION = "libs"
LICENSE = "Artistic"
PR = "r3"

SRC_URI = "http://www.cpan.org/modules/by-module/XML/XML-Parser-${PV}.tar.gz"

S = "${WORKDIR}/XML-Parser-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/XML/Parser/Expat/* \
                ${PERLLIBDIRS}/auto/XML/Parser/.packlist \
                ${PERLLIBDIRS}/XML"
FILES_${PN}-dbg += "${PERLLIBDIRS}/auto/XML/Parser/Expat/.debug"
