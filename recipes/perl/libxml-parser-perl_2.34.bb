DESCRIPTION = "XML::Parser - A perl module for parsing XML documents"
SECTION = "libs"
LICENSE = "Artistic"
DEPENDS += "expat expat-native"
PR = "r13"

SRC_URI = "http://www.cpan.org/modules/by-module/XML/XML-Parser-${PV}.tar.gz"

S = "${WORKDIR}/XML-Parser-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/XML/Parser/Expat/* \
                ${PERLLIBDIRS}/XML"

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "84d9e0001fe01c14867256c3fe115899"
SRC_URI[sha256sum] = "55386de7bf78f67ad2b9ef664a578db66ee53f512a28eb067cd2303f5e23d740"
