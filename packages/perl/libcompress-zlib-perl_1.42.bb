DESCRIPTION = "Compress::Zlib - Interface to zlib compression library"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PM/PMQS/Compress-Zlib-1.42.tar.gz"

S = "${WORKDIR}/Compress-Zlib-${PV}"

inherit cpan
