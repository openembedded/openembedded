require xorg-app-common.inc

DESCRIPTION = "X Window System initializer"
PE = "1"

FILES_${PN} += "${libdir}X11/xinit"

SRC_URI[archive.md5sum] = "521574088fbd688edbf91e6bae674265"
SRC_URI[archive.sha256sum] = "06c1049f6b63d1c368a1e03e2392097919b22ff24899e190de3577bffe6fe524"
