DESCRIPTION = "This python module implements constants and \
functions for working with IEEE754 double-precision special values. \
It provides constants for Not-a-Number (NaN), Positive Infinity \
(Inf), and Negative Infinity (-Inf), as well as functions \
to test for these values."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "fpconst"
PR = "ml0"

SRC_URI = "http://pypi.python.org/packages/source/f/fpconst/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "10ba9e04129af23108d24c22c3a698b1"
SRC_URI[sha256sum] = "bd54e294c056c6d52b2037e91d7b2782d6805b24a74923dc80e1c9107acac707"
