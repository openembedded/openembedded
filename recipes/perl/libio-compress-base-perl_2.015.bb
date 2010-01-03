DESCRIPTION = "IO::Compress::Base - Base Class for IO::Compress modules"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS += "expat expat-native"
PR = "r0"

SRC_URI = "http://www.cpan.org/modules/by-module/IO/IO-Compress-Base-${PV}.tar.gz"

S = "${WORKDIR}/IO-Compress-Base-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan

FILES_${PN} = "${datadir}/perl5"
