DESCRIPTION = "Lingua::EN::Numbers::Ordinate -- go from cardinal number (3) to ordinal ("3rd")"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SB/SBURKE/Lingua-EN-Numbers-Ordinate-${PV}.tar.gz"

S = "${WORKDIR}/Lingua-EN-Numbers-Ordinate-${PV}"

inherit cpan

BBCLASSEXTEND="native"
