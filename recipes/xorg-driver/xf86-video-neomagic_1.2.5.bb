require xorg-driver-video.inc
DESCRIPTION = "X11 driver for NeoMagic 2200, 2160, 2097, 2093, 2090, 2070"
DEPENDS += " xf86dgaproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "423b82b776444f88adbf207fb6a82c1a"
SRC_URI[archive.sha256sum] = "c0b69e83a4bd6c257a2bf55b33a7442d33df451d37561fa8ae00fb1566b1504b"
