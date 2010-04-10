DESCRIPTION = "Fusil is a Python library used to write fuzzing programs."
HOMEPAGE = "http://fusil.hachoir.org/"
SECTION = "devel/python"
LICENSE = "GPLv2"
SRCNAME = "fusil"
PR = "r1"

SRC_URI = "http://pypi.python.org/packages/source/f/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

RDEPENDS_${PN} = "\
  python-ptrace \
  python-ctypes \
  python-lang \
  python-logging \
  python-datetime \
  python-shell \
  python-resource \
  python-subprocess \
"

SRC_URI[md5sum] = "e7dfc39fd169e8ba72b0aeb304acb25b"
SRC_URI[sha256sum] = "85f9a52578c9af3d2a062097144cb6dc507fff7df7e286479010e65cf6b6f23d"
