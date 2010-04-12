DESCRIPTION = "Fusil is a Python library used to write fuzzing programs."
HOMEPAGE = "http://fusil.hachoir.org/"
SECTION = "devel/python"
LICENSE = "GPLv2"
SRCNAME = "python-wifi"

SRC_URI = "http://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

RDEPENDS_${PN} = "\
  python-ctypes \
  python-datetime \
"




SRC_URI[md5sum] = "0458e32f82900e03c9fd155442242638"
SRC_URI[sha256sum] = "a7087ac16ce2d1f146dd76cbfc442ae5b91774f4b8c8eba913c09d0c325eb12f"
