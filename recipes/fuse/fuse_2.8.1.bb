require fuse.inc

PR = "r0"

EXTRA_OECONF = " --disable-kernel-module"

#package utils in a sperate package and stop debian.bbclass renaming it to libfuse-utils, we want it to be fuse-utils
PACKAGES =+ "fuse-utils-dbg fuse-utils libulockmgr libulockmgr-dev libulockmgr-dbg"
FILES_${PN} += "${libdir}/libfuse.so.*"
FILES_${PN}-dev += "${libdir}/libfuse*.la"

FILES_libulockmgr = "${libdir}/libulockmgr.so.*"
FILES_libulockmgr-dev += "${libdir}/libulock*.la"
FILES_libulockmgr-dbg += "${libdir}/.debug/libulock*"

FILES_fuse-utils = "${bindir} ${base_sbindir}"
FILES_fuse-utils-dbg = "${bindir}/.debug ${base_sbindir}/.debug"
DEBIAN_NOAUTONAME_fuse-utils = "1"
DEBIAN_NOAUTONAME_fuse-utils-dbg = "1"

fakeroot do_stage() {
        autotools_stage_all
}

SRC_URI[md5sum] = "0e3505ce90155983f1bc995eb2cf6fa7"
SRC_URI[sha256sum] = "007f1056ce329a7c9976ab7b68d3361991261e188f36364d0406f8ee457d2eaf"
