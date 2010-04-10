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

SRC_URI[md5sum] = "6f0bd0bcda35c6a96cc3853f16ba82d4"
SRC_URI[sha256sum] = "ea32ca58b6500d9061177da23ef03f918ef0c5bbbdd082a843f4834cef9c4957"
