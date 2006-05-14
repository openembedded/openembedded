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
