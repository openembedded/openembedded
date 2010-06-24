require libx11.inc
LICENSE = "XFree86"
PR = "r7"

DEPENDS = "${COMMON_DEPENDS}"
EXTRA_OECONF += " --without-xcb"

SRC_URI += " file://ruutf8.patch"

SRC_URI[archive.md5sum] = "58f0537f21183e27149cf906a1b6bef9"
SRC_URI[archive.sha256sum] = "f99e4ce6d8e3b8833957978fe22223897b0e636c83580f2b07eff0388eb75294"
