DESCRIPTION = "This is a small package that facilitates the unit testing process \
by aggregating PyUnit tests and making them easier to call from the command \
line and from within other unit tests."
SECTION = "devel/python"
HOMEPAGE = "http://oss.wxnet.org/pytester/index.html"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "pytester"
PR = "ml1"

SRC_URI = "${SOURCEFORGE_MIRROR}/meta-tools/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "8a7763e31e4cc3fdf9154c793dda3bc0"
SRC_URI[sha256sum] = "7d17f07aa470cac6afc1b7e68745c1bf1767913ce52b401296e21cab245fe26b"
