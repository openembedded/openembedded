DESCRIPTION = "version - Perl extension for Version Objects"
SECTION = "libs"
LICENSE = "Artistic|GPL"
RDEPENDS_${PN} += "perl-module-file-temp perl-module-test-more"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JP/JPEACOCK/version-${PV}.tar.gz;name=version-perl-${PV}"
SRC_URI[version-perl-0.80.md5sum] = "0add2a0132d582ad81d62b4e38fd3f92"
SRC_URI[version-perl-0.80.sha256sum] = "256d7dec1f3ac8f5fe44919ec07c9a7b940916234c03d2f6b3762dd8a5ff2208"

BBCLASSEXTEND = "native"

S = "${WORKDIR}/version-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/version/vxs/* \
                ${PERLLIBDIRS}/version/* \
                ${PERLLIBDIRS}/version.pm"
