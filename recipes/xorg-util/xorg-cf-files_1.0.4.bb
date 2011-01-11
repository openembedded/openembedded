require xorg-util-common.inc

DESCRIPTION = "X Window System CF files"

PR = "r0"
PE = "1"

FILES_${PN} += " /usr/lib/X11/config"
SRC_URI[archive.md5sum] = "ff4502b6e31aac90e24ce134090d0e46"
SRC_URI[archive.sha256sum] = "8fc8a1224d2a716b1f3f1ca85dfda02387ab215251b8eddd03551eac998c9cb8"
