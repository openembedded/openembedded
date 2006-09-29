DESCRIPTION = "Log::Log4perl - Log4j implementation for Perl"
SECTION = "libs"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>"
LICENSE = "Artistic|GPL"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MS/MSCHILLI/Log-Log4perl-1.06.tar.gz"

S = "${WORKDIR}/Log-Log4perl-${PV}"

inherit cpan
