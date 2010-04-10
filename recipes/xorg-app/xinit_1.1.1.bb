require xorg-app-common.inc

DESCRIPTION = "X Window System initializer"
PE = "1"

FILES_${PN} += "${libdir}X11/xinit"

SRC_URI[archive.md5sum] = "93c73705ed9eb1e1a6b6938405672f2b"
SRC_URI[archive.sha256sum] = "b103d2cf9e1cd8b049e28bb1109f3da3a14287bbce3ab8b2f427d55a6e5f4785"
