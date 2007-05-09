require fuse.inc

PR = "r2"

#package utils in a sperate package and stop debian.bbclass renaming it to libfuse-utils, we want it to be fuse-utils
PACKAGES += "fuse-utils"
FILES_${PN} = "${libdir}/*.so.*"
FILES_${PN}-dev += "${libdir}/*.la"
FILES_fuse-utils = "${bindir} ${base_sbindir}"
DEBIAN_NOAUTONAME_fuse-utils = "1"
EXTRA_OECONF = " --disable-kernel-module"

fakeroot do_stage() {
	autotools_stage_all
}


