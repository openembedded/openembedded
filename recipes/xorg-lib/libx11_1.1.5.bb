require libx11.inc
PR = "${INC_PR}.0"

DEPENDS = "${COMMON_DEPENDS}"
EXTRA_OECONF += " --without-xcb"

SRC_URI[archive.md5sum] = "d1512d65dadd4f48c779d4749e7753a8"
SRC_URI[archive.sha256sum] = "da9272900e41615e9c5dc25d84730b8966da6f5c8f4c40418dca2ad040fc8b82"
