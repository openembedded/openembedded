DESCRIPTION = "Params::Validate - Validate method/function parameters"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
PR = "r6"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/Params-Validate-0.86.tar.gz"

S = "${WORKDIR}/Params-Validate-${PV}"

inherit cpan

FILES_${PN} = "${libdir}/perl5/*/*/auto/Params/Validate/* \
                ${libdir}/perl5/*/*/auto/Params/Validate/.packlist \
                ${libdir}/perl5/*/*/Params \
                ${libdir}/perl5/*/*/Attribute"
FILES_${PN}-dbg += "${libdir}/perl5/*/*/auto/Params/Validate/.debug"
