require xorg-app-common.inc

DESCRIPTION = "X Window System initializer"
PE = "1"

FILES_${PN} += "${libdir}X11/xinit"

SRC_URI[archive.md5sum] = "8b882d9e2deed9d85469a3beaec566a3"
SRC_URI[archive.sha256sum] = "15781cf2b15af8a2535ecc49acce77cc16573571344a71dcbe198ec12e5bb774"
