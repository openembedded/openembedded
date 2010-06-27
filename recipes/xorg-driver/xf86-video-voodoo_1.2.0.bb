require xorg-driver-video.inc
DESCRIPTION = "X11 driver for Voodoo/Voodoo2"
DEPENDS += " xf86dgaproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "7c681d9b57f5e1f798263fc1a9d99245"
SRC_URI[archive.sha256sum] = "b79ba6d5d4300570c00f8be37c536f47f2d78c18845f70f525da2a29e47c4b8c"
