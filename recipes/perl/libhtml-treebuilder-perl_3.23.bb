DESCRIPTION = "HTML::TreeBUilder - Class is for HTML syntax trees that get built out of HTML source"
SECTION = "libs"
LICENSE = "Artistic|GPL"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PE/PETEK/HTML-Tree-${PV}.tar.gz"

S = "${WORKDIR}/HTML-Tree-${PV}"

inherit cpan
