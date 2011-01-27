DESCRIPTION = "List::MoreUtils - Provide the stuff missing in List::Util"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
HOMEPAGE = "http://datetime.perl.org/"
PR = "r1"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/V/VP/VPARSEVAL/List-MoreUtils-${PV}.tar.gz"
SRC_URI[md5sum] = "3a6ec506f40662ab1296c48c5eb72016"
SRC_URI[sha256sum] = "b4948b26851d9d9ac611eb487ecb92815dc3c5ee64e414bc67211b48590f62b7"

S = "${WORKDIR}/List-MoreUtils-${PV}"

inherit cpan

BBCLASSEXTEND="native"
