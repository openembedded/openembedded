DESCRIPTION = "Compress::Zlib - Interface to zlib compression library"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r10"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PM/PMQS/Compress-Zlib-${PV}.tar.gz"

S = "${WORKDIR}/Compress-Zlib-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/Compress/Zlib/* \
                ${PERLLIBDIRS}/Compress"

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "1ab76bfd6731d80f6abbd1643c90cabd"
SRC_URI[sha256sum] = "7794d91711e8c9e526431da72c53bb08e14790f326d0e330d9e9d651f3f6fc6c"
