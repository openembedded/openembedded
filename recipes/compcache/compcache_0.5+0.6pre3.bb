HOMEPAGE = "http://code.google.com/p/compcache"
DESCRIPTION = "Kernel drivers version 0.6x and related tool for the compcache (compressed in-memory swap device for linux)"
LICENSE = "GPLv2"

inherit module

SRC_URI = "http://compcache.googlecode.com/files/${PN}-0.6pre3.tar.gz \
	file://000-compcache-KERNELDIR.patch;patch=1 \
	file://001-compcache-rzscontrol-cross-compile.patch;patch=1 \
	file://002-compcache-modules-install.patch;patch=1 \
	   "
S = "${WORKDIR}/${PN}-0.6pre3"

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


SRC_URI[md5sum] = "532fbc4e6a8ae0670ec15a49484f313f"
SRC_URI[sha256sum] = "3e54f26665bd1b7ece4e4621a15f82da66a95bafd04286d447be5a596790a7db"
