require xorg-driver-video.inc

PE = "1"

DESCRIPTION = "X.Org X server -- SiS USB display driver"
DEPENDS += " xineramaproto xf86miscproto"
SRC_URI[archive.md5sum] = "7b1f5465f423a859f306f4f1d6306a1b"
SRC_URI[archive.sha256sum] = "76b79c9b7d3b35b8e2e5354569bf0936c4afd39a9dcbdf66327714d75137930a"
