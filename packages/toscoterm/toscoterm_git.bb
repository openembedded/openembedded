DESCRIPTION = "A very small and simple terminal emulator"
SECTION = "x11/applications"
LICENSE = "GPLv3"
DEPENDS = "vte"
HOMEPAGE = "https://projetos.ossystems.com.br/projects/show/toscoterm"
PV = "0.0+git${SRCDATE}"
PR = "r1"

SRC_URI = "git://projetos.ossystems.com.br/git/toscoterm.git;protocol=git"

S = "${WORKDIR}/git"

inherit autotools
