DESCRIPTION = "version - Perl extension for Version Objects"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JP/JPEACOCK/version-${PV}.tar.gz"

S = "${WORKDIR}/version-${PV}"

inherit cpan

FILES_${PN} = "${libdir}/perl5/*/*/auto/version/vxs/* \
                ${libdir}/perl5/*/*/auto/version/.packlist \
                ${libdir}/perl5/*/*/version/* \
                ${libdir}/perl5/*/*/version.pm"
FILES_${PN}-dbg += "${libdir}/perl5/*/*/auto/version/vxs/.debug"
