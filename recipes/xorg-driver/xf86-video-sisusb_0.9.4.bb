require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- SiS USB display driver"
DEPENDS += " xineramaproto xf86miscproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "1d7a1d4d09aa953bf09acb8467b16a59"
SRC_URI[archive.sha256sum] = "2bbb27a9df362bb782216d7e664e0f125e7edc8765d0461d191049dc0273aa2c"
