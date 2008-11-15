DESCRIPTION = "FuGrep is a Python library for fuzzy pattern matching."
HOMEPAGE = "http://www.j-raedler.de/pages/software/fugrep.php"
SECTION = "devel/python"
LICENSE = "${PN}"
SRCNAME = "FuGrep"
PR = "ml0"

SRC_URI = "http://www.j-raedler.de/media/Software/FuGrep-${PV}.zip"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
