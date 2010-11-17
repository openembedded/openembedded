require libx11.inc
DEPENDS = "${COMMON_DEPENDS}"
PR = "${INC_PR}.2"

SRC_URI += " file://configure.ac-nios2.patch"
SRC_URI[archive.md5sum] = "d1512d65dadd4f48c779d4749e7753a8"
SRC_URI[archive.sha256sum] = "da9272900e41615e9c5dc25d84730b8966da6f5c8f4c40418dca2ad040fc8b82"

EXTRA_OECONF += " --without-xcb"
