DESCRIPTION = "The Portable Coroutine Library (PCL) implements the low level \
functionality for coroutines."
HOMEPAGE = "http://www.xmailserver.org/libpcl.html"
LICENSE = "GPL"
SECTION = "libs"

SRC_URI = "http://www.xmailserver.org/libpcl-${PV}.tar.gz"
S = "${WORKDIR}/libpcl-${PV}"

inherit autotools

do_stage () {
	autotools_stage_includes
	oe_libinstall -so -a -C pcl libpcl ${STAGING_LIBDIR}/
}

SRC_URI[md5sum] = "6d63c462911349de80109c0161ed6d37"
SRC_URI[sha256sum] = "3c64155a9218c0367f3b0afd4bd8a4a46cc467ad6c85e98952a4ef517b183686"
