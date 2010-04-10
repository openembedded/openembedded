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

SRC_URI[md5sum] = "009813067e40c73c28c23fde8d9abfd5"
SRC_URI[sha256sum] = "0dbfafc713c8fa6bb798cf806e18af1c9e55ab6bd117cdb12d1a565014a7d282"
