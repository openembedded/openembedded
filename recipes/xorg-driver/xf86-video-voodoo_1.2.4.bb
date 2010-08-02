require xorg-driver-video.inc
DESCRIPTION = "X11 driver for Voodoo/Voodoo2"
DEPENDS += " xf86dgaproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "ce8b848e00883ecb88b21ca03891b780"
SRC_URI[archive.sha256sum] = "f00238bbcf61dba726deedcd4d7416923844e3b0116671a1b1df8bf43d224741"
