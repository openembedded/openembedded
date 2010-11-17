require xorg-driver-video.inc
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "579bee487309b1bdc8329bf627d43413"
SRC_URI[archive.sha256sum] = "b24a7cb2d87e416561e25122eab2cd48fc64a2ba105238456eefef16f29f38a3"
