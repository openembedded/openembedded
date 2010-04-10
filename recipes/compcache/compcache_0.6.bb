HOMEPAGE = "http://code.google.com/p/compcache"
DESCRIPTION = "Kernel drivers version 0.6x and related tool for the compcache (compressed in-memory swap device for linux)"
LICENSE = "GPLv2"

inherit module

SRC_URI = "http://compcache.googlecode.com/files/${PN}-${PV}.tar.gz \
	file://003-compcache-0.6-KERNELDIR.patch;patch=1 \
	file://001-compcache-rzscontrol-cross-compile.patch;patch=1 \
	file://002-compcache-modules-install.patch;patch=1 \
	   "
TARGET_CC_ARCH += "${LDFLAGS}"

PACKAGES = "kernel-module-compcache compcache-utils compcache-utils-dbg compcache-utils-doc"

FILES_kernel-module-compcache = ${FILES_compcache}
FILES_compcache-utils = "${bindir}/rzscontrol"
FILES_compcache-utils-dbg = "${bindir}/.debug/rzscontrol"
FILES_compcache-utils-doc = "${mandir}/man1/rzscontrol.1"

do_install_prepend() {
	mkdir -p ${D}${bindir}
	mkdir -p ${D}${mandir}/man1
	install -m 0755 ${S}/sub-projects/rzscontrol/rzscontrol ${D}${bindir}
	install -m 0644 ${S}/sub-projects/rzscontrol/man/rzscontrol.1 ${D}${mandir}/man1
}


SRC_URI[md5sum] = "0a574643c0eb857b946adcd5d5a22eb0"
SRC_URI[sha256sum] = "e5f697be6c1b7bfb9ac9ba5b8d836ff20f880c161f998c482caba83caf443c0c"
