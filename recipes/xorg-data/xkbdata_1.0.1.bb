require xorg-data-common.inc
PE = "1"

RDEPENDS = "xkbcomp"

FILES_${PN} += " /usr/share/X11/xkb"


SRC_URI[archive.md5sum] = "9bf179be9a195953dc5f4c15e23ab7f0"
SRC_URI[archive.sha256sum] = "94e1909faa9bf754c0e78a6bea8fa6e16c0931c4a2eb1f2252b7f0fa480cb4df"
