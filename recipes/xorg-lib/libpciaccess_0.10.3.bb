require xorg-lib-common.inc

DEPENDS += "xproto virtual/libx11"

SRC_URI += "file://fix-mtrr-check.patch;patch=1"

SRC_URI[archive.md5sum] = "6d5468debf76fac84576ca26c9535821"
SRC_URI[archive.sha256sum] = "2f609ad3b5688ae66dcd18d7cdd1fc6b68531a2a85f89798f6cfb5eda6d680dc"
