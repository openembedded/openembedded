require xorg-driver-video.inc
DESCRIPTION = "DEC 21030 X11 driver"
DEPENDS += " xf86dgaproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "bcbceda78395de74544c83b46a7700cd"
SRC_URI[archive.sha256sum] = "70a4754ef6602cf48d910b9727d015cb3cae946c096ef260b56dfe2f80cdb855"
