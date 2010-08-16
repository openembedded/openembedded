require libx11.inc
DEPENDS = "${COMMON_DEPENDS}"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "4d43d3e472c552d2f191ecdd4e75112c"
SRC_URI[archive.sha256sum] = "4a2f566e2ea5dd955c875cb8fa9c18dd725324fc5cf4e23c803442e31ab8917a"

EXTRA_OECONF += " --without-xcb"
