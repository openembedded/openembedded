DESCRIPTION = "C and C++ INI Library"
PRIORITY = "optional"
PV = "0.0+gitr${SRCPV}"
PKGV = "${GITPKGVTAG}"
PR = "r1"
LICENSE = "BSD"
RDEPENDS_${PN}-dev = ""

SRCREV = "53c81b2d5641551070947bd69ce4c23f17685804"
SRC_URI = "git://projetos.ossystems.com.br/git/libinih.git;protocol=git"

S = "${WORKDIR}/git"

inherit gitpkgv cmake
