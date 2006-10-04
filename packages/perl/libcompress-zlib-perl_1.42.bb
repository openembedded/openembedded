DESCRIPTION = "Compress::Zlib - Interface to zlib compression library"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
PR = "r3"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PM/PMQS/Compress-Zlib-${PV}.tar.gz"

S = "${WORKDIR}/Compress-Zlib-${PV}"

inherit cpan

FILES_${PN} = "${libdir}/perl5/*/*/auto/Compress/Zlib/* \
                ${libdir}/perl5/*/*/auto/Compress/Zlib/.packlist \
                ${libdir}/perl5/*/*/Compress"
FILES_${PN}-dbg += "${libdir}/perl5/*/*/auto/Compress/Zlib/.debug"
