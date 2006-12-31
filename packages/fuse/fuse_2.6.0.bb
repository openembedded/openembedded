require fuse.inc

SRC_URI += "file://not-run-updaterc.d-on-host.patch;patch=1"

EXTRA_OECONF = " --disable-kernel-module"

#package utils in a sperate package and stop debian.bbclass renaming it to libfuse-utils, we want it to be fuse-utils
PACKAGES =+ "lib${PN} libulockmgr"
FILES_${PN}-dev += 	"${libdir}/*.la"
FILES_lib${PN} = 	"${libdir}/libfuse*.so.*"
FILES_libulockmgr = 	"${libdir}/libulockmgr.so.*"

fakeroot do_stage() {
	autotools_stage_all
}


