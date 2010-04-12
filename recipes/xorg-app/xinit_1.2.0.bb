require xorg-app-common.inc

DESCRIPTION = "X Window System initializer"
PE = "1"
PR = "r1"

DEPENDS += "util-linux-ng"

FILES_${PN} += "${libdir}X11/xinit"

SRC_URI[archive.md5sum] = "fe1696cab2fbed6fa059d0cd1c53ac13"
SRC_URI[archive.sha256sum] = "ab61663a4421753132d4aac97a873ed20697c4761cb434640f48f350fb65087f"
