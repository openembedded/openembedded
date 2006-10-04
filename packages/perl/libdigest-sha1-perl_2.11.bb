DESCRIPTION = "Digest::SHA1 - Perl interface to the SHA-1 algorithm"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
PR = "r7"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/Digest-SHA1-${PV}.tar.gz"

S = "${WORKDIR}/Digest-SHA1-${PV}"

inherit cpan

FILES_${PN} = "${libdir}/perl5/*/*/auto/Digest/SHA1/* \
                ${libdir}/perl5/*/*/auto/Digest/SHA1/.packlist \
                ${libdir}/perl5/*/*/Digest"
FILES_${PN}-dbg += "${libdir}/perl5/*/*/auto/Digest/SHA1/.debug"
