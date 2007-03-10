DESCRIPTION = "With FUSE it is possible to implement a fully functional filesystem in a userspace program"
HOMEPAGE = "http://fuse.sf.net"
LICENSE = "GPL"
DEPENDS = "fakeroot-native"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/fuse/${P}.tar.gz \
          file://not-run-updaterc.d-on-host.patch;patch=1"

inherit autotools pkgconfig

EXTRA_OECONF = " --disable-kernel-module"

fakeroot do_stage() {
	autotools_stage_all
}

# Package the fuse utils and libs in seperate packages
PACKAGES += "lib${PN} libulockmgr"
FILES_${PN}-dev += 	"${libdir}/*.la"
FILES_lib${PN} = 	"${libdir}/libfuse*.so.*"
FILES_libulockmgr = 	"${libdir}/libulockmgr.so.*"
