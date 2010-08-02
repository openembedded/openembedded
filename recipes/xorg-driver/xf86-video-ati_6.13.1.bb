require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- ATI display driver"
DEPENDS += " xineramaproto xf86miscproto drm xf86driproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "d65ae11cc66146c7006dbf5acebde413"
SRC_URI[archive.sha256sum] = "f9b12482165d99acf58c3b0ada925f7939cc0553f645db9f483e41db66a08b59"
