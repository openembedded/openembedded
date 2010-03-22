DESCRIPTION = "a portable and efficient C programming interface (API) to determine the call-chain of a program"
HOMEPAGE = "http://www.nongnu.org/libunwind"
LICENSE = "MIT"
INC_PR = "r0"

SRC_URI = "http://download.savannah.nongnu.org/releases/libunwind/${PN}-${PV}.tar.gz;name=archive"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools

BBCLASSEXTEND = "native"
