DESCRIPTION = "version - Perl extension for Version Objects"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/J/JP/JPEACOCK/version-${PV}.tar.gz"

S = "${WORKDIR}/version-${PV}"

inherit cpan
