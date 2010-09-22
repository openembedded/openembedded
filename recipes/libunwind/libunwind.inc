DESCRIPTION = "a portable and efficient C programming interface (API) to determine the call-chain of a program"
HOMEPAGE = "http://www.nongnu.org/libunwind"
LICENSE = "MIT"
INC_PR = "r1"

SRC_URI = "http://download.savannah.nongnu.org/releases/${BPN}/${BPN}-${PV}.tar.gz;name=archive"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools

EXTRA_OECONF_arm = "--enable-debug-frame"

BBCLASSEXTEND = "native"
