require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- ATI display driver"
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "395e23ad026e4246dd70bbd2143688b5"
SRC_URI[archive.sha256sum] = "e457285096e1e40f53ae5b58b948906c69add5160cc38ce510f0d15e82d91c75"
