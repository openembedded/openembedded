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
