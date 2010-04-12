DESCRIPTION = "DateTime::Format::Strptime - Parse and format strp and strf time patterns"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/R/RI/RICKM/DateTime-Format-Strptime-${PV}.tgz"

S = "${WORKDIR}/DateTime-Format-Strptime-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "bf7f6b219e34411aa3f5d0de56fda393"
SRC_URI[sha256sum] = "d6439f657d21da062ee78692c0fb2979fe92ce681e7126ee4b929431ec4c2cde"
