DESCRIPTION = "ZeroMQ looks like an embeddable networking library but acts like a concurrency framework"
HOMEPAGE = "http://www.zeromq.org"
LICENSE = "LGPLv3+"
LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=66ea8704398d7996daeacd2fbd2b9dbd"

PR = "r0"

DEPENDS += "util-linux-ng"

S = "${WORKDIR}/zeromq-${PV}"

SRC_URI = "http://download.zeromq.org/zeromq-${PV}.tar.gz"

inherit autotools

do_configure_prepend() {
	./autogen.sh
}

SRC_URI[md5sum] = "77b9ca20e8f2426874022080f41d7b0b"
SRC_URI[sha256sum] = "a1bbb352a9dbf34b18a3999b22a8db2d51e4a52508d098528d771811533f9fd0"
