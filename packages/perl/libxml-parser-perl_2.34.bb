SECTION = "libs"
LICENSE = "Artistic"
PR = "r2"

SRC_URI = "http://www.cpan.org/modules/by-module/XML/XML-Parser-${PV}.tar.gz"

S = "${WORKDIR}/XML-Parser-${PV}"

inherit cpan

FILES_${PN} = "${libdir}/perl5/*/*/auto/XML/Parser/Expat/* \
                ${libdir}/perl5/*/*/auto/XML/Parser/.packlist \
                ${libdir}/perl5/*/*/XML"
FILES_${PN}-dbg += "${libdir}/perl5/*/*/auto/XML/Parser/Expat/.debug"
