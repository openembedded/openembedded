DESCRIPTION = "Manipulates and accesses URI strings"
SECTION = "libs"
LICENSE = "Artistic|GPL"
#RDEPENDS += " libmime-base64-perl libnet-perl"
PR = "r2"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GA/GAAS/URI-${PV}.tar.gz"

S = "${WORKDIR}/URI-${PV}"

inherit cpan

BBCLASSEXTEND="native"

PACKAGE_ARCH = "all"

SRC_URI[md5sum] = "d6ba96cc3e650af6537675e016e83d3e"
SRC_URI[sha256sum] = "3d325b52c9d1e7aa2fbf67131f1f5ee39964cbe54e864bcfb9808af274a9eb4a"
