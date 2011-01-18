require gdb-cross.inc
LICENSE = "GPLv3"

PR = "${INC_PR}.0"

SRC_URI += " \
            file://gdb-6.8-fix-compile-karmic.patch \
	    file://gdb-fix-sim-ppc.patch \
           "
SRC_URI[md5sum] = "950b766466bee748e554765c86b8b495"
SRC_URI[sha256sum] = "34919cb51334c8149ae36ed086f35e79fe3fa2b2a85b568d7c0edad20cd972d4"

