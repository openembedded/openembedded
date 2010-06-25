require libx11.inc
DEPENDS = "${COMMON_DEPENDS}"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "1469a5a8aa8d288dce6f4c45d2f68dc3"
SRC_URI[archive.sha256sum] = "bdbd6d239435c1736f5c532b12e8078761db8db5f37ab3195fe11c3e5b692c1c"

EXTRA_OECONF += " --without-xcb"
