DESCRIPTION = "With FUSE it is possible to implement a fully functional filesystem in a userspace program"
HOMEPAGE = "http://fuse.sf.net"
LICENSE = "LGPL"

PR = "r0"

DEPENDS = "fakeroot-native"
RRECOMMENDS_${PN} = "fuse-module kernel-module-fuse"

SRC_URI = "${SOURCEFORGE_MIRROR}/fuse/${P}.tar.gz \
	   file://not-run-updaterc.d-on-host.patch;patch=1" 


inherit autotools pkgconfig
EXTRA_OECONF = " --disable-kernel-module"

fakeroot do_install() {
	oe_runmake install DESTDIR=${D}
}

#package utils in a sperate package and stop debian.bbclass renaming it to libfuse-utils, we want it to be fuse-utils
PACKAGES =+ "lib${PN} libulockmgr"
FILES_${PN}-dev += 	"${libdir}/*.la"
FILES_lib${PN} = 	"${libdir}/libfuse*.so.*"
FILES_libulockmgr = 	"${libdir}/libulockmgr.so.*"


fakeroot do_stage() {
	autotools_stage_all
}


