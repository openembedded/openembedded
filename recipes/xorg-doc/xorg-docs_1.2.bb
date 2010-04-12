require xorg-doc-common.inc

DESCRIPTION = "The documentation in this package is from xc/doc in the monolithic \
source tree."

DEPENDS += " intltool"

PE = "1"

FILES_${PN} += " /usr/share/X11/doc"


SRC_URI[archive.md5sum] = "f817c5df43817846c1b27bac83da74d7"
SRC_URI[archive.sha256sum] = "23648ac11d5cc57f3e1e747a73bd1c4f83c42a657969814af0d399fdd3d7beec"
