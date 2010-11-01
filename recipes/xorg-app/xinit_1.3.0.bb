require xorg-app-common.inc
DESCRIPTION = "X Window System initializer"
DEPENDS += "util-linux-ng"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "bc4e8b7d1919597cc37a0d24aa149dda"
SRC_URI[archive.sha256sum] = "ba76e36e1a42a7cf76505b7e6fc4777f5d14f45ddff74341abfb7dd10d5fe04c"

FILES_${PN} += "${libdir}X11/xinit"
