require xorg-driver-video.inc

PE = "1"

DESCRIPTION = "X.Org X server -- SiS USB display driver"
DEPENDS += " xineramaproto xf86miscproto"
SRC_URI[archive.md5sum] = "be59e9c2d9458cee0b5006549c14a95d"
SRC_URI[archive.sha256sum] = "1df9a90ecc31d5fb63de7c970555f166dab24c0f633b54aaac4ee82fa7b49bb2"
