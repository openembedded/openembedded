DESCRIPTION = "Dweba is a framework to develop distributed and web applications \
for the python programming language."
HOMEPAGE = "http://www.threekong.com"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
PR = "ml0"

RPV = "1.0.0-pre14"

SRC_URI = "http://www.threekong.com/download/dweba/dweba-${RPV}.tar.gz"
S = "${WORKDIR}/dweba-${RPV}"

inherit distutils
