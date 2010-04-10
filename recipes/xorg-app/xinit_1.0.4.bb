require xorg-app-common.inc

DESCRIPTION = "X Window System initializer"
PE = "1"

FILES_${PN} += "${libdir}X11/xinit"

SRC_URI[archive.md5sum] = "9df52a504dc04313a6650fae364ae04a"
SRC_URI[archive.sha256sum] = "1e7056db4441ccb0dff0f77503e3fd49a370aecdecf95ce6066116ca8244bf52"
