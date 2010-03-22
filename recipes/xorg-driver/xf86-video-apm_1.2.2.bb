require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "This is the Alliance Promotion driver for XFree86 4.0+"

DEPENDS += " xf86rushproto"

SRC_URI += "file://get-rid-of-host-includes.patch;patch=1"
SRC_URI[archive.md5sum] = "48441a19aaf015570b267f2a8e67d8ab"
SRC_URI[archive.sha256sum] = "678edd063e1d5e7c7f72ccdda2388c5857559847b3d313c94d659f9bd51c1752"
