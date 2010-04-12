DESCRIPTION = "HTML form validation, generation, and conversion package"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
SRCNAME = "FormEncode"
PR = "ml0"

inherit setuptools

SRC_URI = "http://pypi.python.org/packages/source/F/FormEncode/FormEncode-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

SRC_URI[md5sum] = "7030996497f3cf012bc9e99b4ca3e920"
SRC_URI[sha256sum] = "be21e3d5fa2edd1f5ff5952f67e6574dae15a027b26415910dfe813902fd5985"
