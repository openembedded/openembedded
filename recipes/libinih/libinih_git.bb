DESCRIPTION = "C and C++ INI Library"
PRIORITY = "optional"
PV = "0.0+gitr${SRCPV}"
PKGV = "${GITPKGVTAG}"
PR = "r0"
LICENSE = "BSD"
RDEPENDS_${PN}-dev = ""

SRCREV = "${AUTOREV}"
SRC_URI = "git://projetos.ossystems.com.br/git/libinih.git;protocol=git"

S = "${WORKDIR}/git"

inherit gitpkgv cmake
