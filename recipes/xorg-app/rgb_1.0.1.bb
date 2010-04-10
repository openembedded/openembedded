require xorg-app-common.inc
PE = "1"

DEPENDS += " xproto util-macros"

FILES_${PN} += "${datadir}/X11"



SRC_URI[archive.md5sum] = "255222b3ab3af671289a6b4844e9f393"
SRC_URI[archive.sha256sum] = "f635bc02f72f62c248af8a19aa6931e9f2d061cca258c12c1468d486602990ad"
