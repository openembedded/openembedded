DESCRIPTION = "libevnet provides a suite of interfaces, \
all built around libevent, useful to network daemons."
SECTION = "libs"
LICENSE = "${PN}"
HOMEPAGE = "http://www.25thandclement.com/~william/projects/libevnet.html"
DEPENDS = "libarena libevent openssl"

SRC_URI = "http://www.25thandclement.com/~william/projects/releases/libevnet-${PV}.tgz \
           file://stdargs.patch;patch=1"

do_stage() {
	oe_libinstall -C src -a libevnet ${STAGING_LIBDIR}
	#FIXME: stage headers
}

SRC_URI[md5sum] = "65884ee4548e2d7c48b9c59acec5ba70"
SRC_URI[sha256sum] = "3bc2b8d1cd657b2f8f8ec82168791f7b0fce8c8161ab24eee4b577d5876026e0"
