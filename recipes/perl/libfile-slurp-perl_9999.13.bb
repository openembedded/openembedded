DESCRIPTION = "File::Slurp - Efficient Reading/Writing of Complete Files"
SECTION = "libs"
LICENSE = "Artistic|GPL"
HOMEPAGE = "http://search.cpan.org/~uri/"
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/D/DR/DROLSKY/File-Slurp-${PV}.tar.gz"

S = "${WORKDIR}/File-Slurp-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "ac3cd9d466b99d1534762ff3549aaa66"
SRC_URI[sha256sum] = "bb053bfcca0986958de1cf8a120250b25ed40ae2aaf17c5527fe9c1d098cb3e5"
