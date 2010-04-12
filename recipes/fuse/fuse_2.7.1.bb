require fuse.inc

PR = "r0"

SRC_URI += "file://not-run-updaterc.d-on-host.patch;patch=1"

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



SRC_URI[md5sum] = "f95b4a238a3df5a92e9013ecb55c2c17"
SRC_URI[sha256sum] = "e4639f9e08f0b8cc9f4a0bb8cbe47da06fa57cb310b2c5a82221e0a9ba969e9a"
