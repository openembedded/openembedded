require libx11.inc
PR = "r7"

DEPENDS = "${COMMON_DEPENDS}"
EXTRA_OECONF += " --without-xcb"

SRC_URI[archive.md5sum] = "1469a5a8aa8d288dce6f4c45d2f68dc3"
SRC_URI[archive.sha256sum] = "bdbd6d239435c1736f5c532b12e8078761db8db5f37ab3195fe11c3e5b692c1c"
