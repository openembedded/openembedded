DESCRIPTION = "Uses mmap to map in a file as a perl variable."
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SW/SWALTERS/Sys-Mmap-${PV}.tar.gz"

S = "${WORKDIR}/Sys-Mmap-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "e65a007157e3e26807db52299497109d"
SRC_URI[sha256sum] = "e064a939bf7e37774b89a39515ecf96c4d19c81e050bcf0dae28d1eab4d86196"
