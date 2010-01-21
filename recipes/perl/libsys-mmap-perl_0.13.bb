DESCRIPTION = "Uses mmap to map in a file as a perl variable."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SW/SWALTERS/Sys-Mmap-${PV}.tar.gz"

S = "${WORKDIR}/Sys-Mmap-${PV}"

inherit cpan

BBCLASSEXTEND="native"
