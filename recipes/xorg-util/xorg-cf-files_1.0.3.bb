require xorg-util-common.inc

DESCRIPTION = "X Window System CF files"

PR = "r2"
PE = "1"

FILES_${PN} += " /usr/lib/X11/config"
SRC_URI[archive.md5sum] = "bca2403beb209952d66dc57be5a2f789"
SRC_URI[archive.sha256sum] = "9a5e3533a4156a0e308ced437bde722cb291becc2276bdd0952e30b3b5060e92"
