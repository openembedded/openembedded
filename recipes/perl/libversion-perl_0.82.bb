DESCRIPTION = "version - Perl extension for Version Objects"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
RDEPENDS_${PN} += "perl-module-file-temp perl-module-test-more"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JP/JPEACOCK/version-${PV}.tar.gz"
SRC_URI[md5sum] = "c073f079557297003d805b535711c5d1"
SRC_URI[sha256sum] = "973e29dd82c4bb49ee1724d61f3cdd3c26052db7911aeb2852224acda8ba80bf"

BBCLASSEXTEND = "native"

S = "${WORKDIR}/version-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/version/vxs/* \
                ${PERLLIBDIRS}/version/* \
                ${PERLLIBDIRS}/version.pm"
