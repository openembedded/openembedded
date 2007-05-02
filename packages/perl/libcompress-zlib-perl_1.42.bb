DESCRIPTION = "Compress::Zlib - Interface to zlib compression library"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r5"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PM/PMQS/Compress-Zlib-${PV}.tar.gz"

S = "${WORKDIR}/Compress-Zlib-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/Compress/Zlib/* \
                ${PERLLIBDIRS}/auto/Compress/Zlib/.packlist \
                ${PERLLIBDIRS}/Compress"
FILES_${PN}-dbg += "${PERLLIBDIRS}/auto/Compress/Zlib/.debug"
