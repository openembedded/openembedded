DESCRIPTION = "Lingua::EN::Numbers::Ordinate -- go from cardinal number (3) to ordinal ("3rd")"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/S/SB/SBURKE/Lingua-EN-Numbers-Ordinate-${PV}.tar.gz"

S = "${WORKDIR}/Lingua-EN-Numbers-Ordinate-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "e92078fafd9108a137972c4e9bae9e99"
SRC_URI[sha256sum] = "350a6de884a6295974f2919c5af76d4103368e855ac8fe739460f4d55aee7719"
