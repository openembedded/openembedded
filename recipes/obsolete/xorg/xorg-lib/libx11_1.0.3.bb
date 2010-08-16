require libx11.inc
LICENSE = "XFree86"
DEPENDS = "${COMMON_DEPENDS}"
PR = "${INC_PR}.0"

SRC_URI += " file://ruutf8.patch"
SRC_URI[archive.md5sum] = "60b787a812c92d33f71860e4e19cb59d"
SRC_URI[archive.sha256sum] = "fb42f2400c3709a0c2c17f27cc4a902c191ebd6228c70698891bf3a13ea5b3ac"

EXTRA_OECONF += " --without-xcb"
