DESCRIPTION = "Asio 0.3.7 for work with boost, should be moved into boost package once integrated into the boost distribution."
HOMEPAGE = "http://asio.sf.net/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "Boost Software License"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/asio/boost_asio_0_3_7.tar.bz2"

# mtx-[12] use 2.4 kernels but the kernel-libc-headers are from kernel 2.6,
# thus the automatic epoll detection does not work in epoll_reactor_fwd.hpp.
SRC_URI_append_mtx-1 = " file://disable-epoll.patch;patch=1"
SRC_URI_append_mtx-2 = " file://disable-epoll.patch;patch=1"

S = "${WORKDIR}/boost_asio_0_3_7"

do_configure() {
}

do_compile() {
}

do_install() {
	cd ${S}
	install -d ${D}/usr/include
	cp -dpR boost ${D}/usr/include
}

do_stage() {
	cd ${S}
	install -d -m 775 ${STAGING_INCDIR}
	cp -dpR boost ${STAGING_INCDIR}
}

FILES_${PN}-dev = "/usr/include"
