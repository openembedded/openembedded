DESCRIPTION = "Pyrex is a language specially designed for writing Python extension modules. \
It's designed to bridge the gap between the nice, high-level, easy-to-use world of Python \
and the messy, low-level world of C."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "Pyrex"
PR = "ml1"

SRC_URI = "\
  http://www.cosc.canterbury.ac.nz/greg.ewing/python/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
  file://pyrex-fix-optimized-mode.patch;patch=1 \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "3b3d8397c2c9a58fc59a90e2b49c651a"
SRC_URI[sha256sum] = "dd60bc66b1627d3cbd0950499017dfd57a0705bb12493bb0de2a7b9b5c0873bc"
