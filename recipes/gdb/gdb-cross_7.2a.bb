require gdb-cross.inc
LICENSE = "GPLv3"

PR = "${INC_PR}.0"

SRC_URI += " \
            file://gdb-6.8-fix-compile-karmic.patch \
	    file://gdb-fix-sim-ppc.patch \
           "
S = ${WORKDIR}/gdb-7.2

SRC_URI[md5sum] = "a9a8d0ea1ae57837fada5415bd0f92ff"
SRC_URI[sha256sum] = "9f51739cd45c158aa5df2e7abb703a304b5370e2e9e43c70f5cc0b1c4be5d0c2"

