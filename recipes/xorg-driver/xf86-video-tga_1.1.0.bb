require xorg-driver-video.inc
DESCRIPTION = "DEC 21030 X11 driver"
DEPENDS += " xf86dgaproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "9eda4d4490706b2dd8f4ecdbaf779856"
SRC_URI[archive.sha256sum] = "50143dfdd259fd114dc2f41518a4898d5407bf55422251df75812b96a1fa6e9b"
