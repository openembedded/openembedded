require xorg-driver-video.inc
DESCRIPTION = "X.org server -- Geode GX2/LX display driver"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "a99c521db731c2f1df309057a8465e4c"
SRC_URI[archive.sha256sum] = "28d845d727d99bfa4d4b93c5486ec01b72eb222e0910a766089db1103b1c2d92"

COMPATIBLE_HOST = "i.86.*-linux"
