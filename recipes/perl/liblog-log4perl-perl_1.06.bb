DESCRIPTION = "Log::Log4perl - Log4j implementation for Perl"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r5"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/MS/MSCHILLI/Log-Log4perl-${PV}.tar.gz"

S = "${WORKDIR}/Log-Log4perl-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "a7bda690ec0ad0bed457fa525e28034a"
SRC_URI[sha256sum] = "ffac9cd4a6fbc59618bf4e79c389a927491a81b448528278e010a190e2483544"
