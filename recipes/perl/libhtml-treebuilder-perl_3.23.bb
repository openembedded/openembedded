DESCRIPTION = "HTML::TreeBUilder - Class is for HTML syntax trees that get built out of HTML source"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r3"

RDEPENDS = "perl-module-extutils-makemaker"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PE/PETEK/HTML-Tree-${PV}.tar.gz"

S = "${WORKDIR}/HTML-Tree-${PV}"

inherit cpan

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "6352f50be402301f79b580dd235d7762"
SRC_URI[sha256sum] = "f5175acf262f3710dce899796ea3e353049939400b100706d03df2f08803c8de"
