require libx11.inc
PR = "r7"

DEPENDS = "${COMMON_DEPENDS}"
EXTRA_OECONF += " --without-xcb"

SRC_URI += " file://ruutf8.patch"

SRC_URI[archive.md5sum] = "848b80f77b20ae1fa5c882bbfa531ebc"
SRC_URI[archive.sha256sum] = "5359db57793430429786b648ac570d4ab205797306e049bf1e8675250af21541"
