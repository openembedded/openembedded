DESCRIPTION = "version - Perl extension for Version Objects"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r4"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JP/JPEACOCK/version-${PV}.tar.gz"

S = "${WORKDIR}/version-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/version/vxs/* \
                ${PERLLIBDIRS}/auto/version/.packlist \
                ${PERLLIBDIRS}/version/* \
                ${PERLLIBDIRS}/version.pm"
FILES_${PN}-dbg += "${PERLLIBDIRS}/auto/version/vxs/.debug"
