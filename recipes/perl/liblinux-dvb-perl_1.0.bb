DESCRIPTION = "Linux::DVB - interface to (some parts of) the Linux DVB API"
SECTION = "libs"
LICENSE = "unknown"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/M/ML/MLEHMANN/Linux-DVB-${PV}.tar.gz"

S = "${WORKDIR}/Linux-DVB-${PV}"

inherit cpan

BBCLASSEXTEND="native"
