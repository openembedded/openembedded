DESCRIPTION = "version - Perl extension for Version Objects"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r9"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JP/JPEACOCK/version-${PV}.tar.gz"

S = "${WORKDIR}/version-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/version/vxs/* \
                ${PERLLIBDIRS}/version/* \
                ${PERLLIBDIRS}/version.pm"

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "eb5464a77d342ab5eb21f2fb82670d1c"
SRC_URI[sha256sum] = "7fb38ae6ce9ff7b4f9f46838bbb4d1fce577afddfbb3cc89e37cd8cbc81d795c"
