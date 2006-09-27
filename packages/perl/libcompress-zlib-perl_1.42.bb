DESCRIPTION = "Compress::Zlib - Interface to zlib compression library"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PM/PMQS/Compress-Zlib-1.42.tar.gz"

S = "${WORKDIR}/Compress-Zlib-${PV}"

inherit cpan

# Stop from searching /include - should put this in cpan class?
export CCFLAGS = "${CFLAGS}"
