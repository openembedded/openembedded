DESCRIPTION = "Log::Log4perl - Log4j implementation for Perl"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r5"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MS/MSCHILLI/Log-Log4perl-${PV}.tar.gz"

S = "${WORKDIR}/Log-Log4perl-${PV}"

inherit cpan

BBCLASSEXTEND="native"
