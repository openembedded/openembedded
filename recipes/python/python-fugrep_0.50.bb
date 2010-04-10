DESCRIPTION = "FuGrep is a Python library for fuzzy pattern matching."
HOMEPAGE = "http://www.j-raedler.de/pages/software/fugrep.php"
SECTION = "devel/python"
LICENSE = "${PN}"
SRCNAME = "FuGrep"
PR = "ml1"

SRC_URI = "http://www.j-raedler.de/media/Software/FuGrep-${PV}.zip"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "83b738d805e17c226f43bbac453a0631"
SRC_URI[sha256sum] = "14b0fb8ce8a97a0bf7d8f5be57f6bb67dc9e5273f1f465f3babe994c44db3d87"
