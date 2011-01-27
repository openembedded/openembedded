DESCRIPTION = "Manipulates and accesses URI strings"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
RDEPENDS_${PN} += " perl-module-extutils-makemaker perl-module-mime-base64"
PR = "r5"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/URI-${PV}.tar.gz"

S = "${WORKDIR}/URI-${PV}"

inherit cpan

BBCLASSEXTEND="native"

PACKAGE_ARCH = "all"

SRC_URI[md5sum] = "e66a2ab45da92a2c5f67a495c88999f5"
SRC_URI[sha256sum] = "34ece72deedebfe7d52da90990e49d79e7c62319837def69ed943316bfb74291"
