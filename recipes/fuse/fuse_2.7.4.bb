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



SRC_URI[md5sum] = "4879f06570d2225667534c37fea04213"
SRC_URI[sha256sum] = "c8b070ece5d4e09bd06eea6c28818c718f803d93a4b85bacb9982deb8ded49e6"
