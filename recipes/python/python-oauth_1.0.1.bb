DESCRIPTION = "Library for OAuth version 1.0a."
HOMEPAGE = "http://code.google.com/p/oauth/"
SECTION = "devel/python"
LICENSE = "MIT"
SOURCE = "oauth"
PR = "r0"

SRC_URI = "http://pypi.python.org/packages/source/o/${SOURCE}/${SOURCE}-${PV}.tar.gz"
SRC_URI[md5sum] = "30ed3cc8c11d7841a89feab437aabf81"
SRC_URI[sha256sum] = "e769819ff0b0c043d020246ce1defcaadd65b9c21d244468a45a7f06cb88af5d"

S = "${WORKDIR}/${SOURCE}-${PV}"

inherit setuptools
