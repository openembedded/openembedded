require xorg-driver-video.inc

PE = "1"

DESCRIPTION = "X.Org X server -- SiS USB display driver"
DEPENDS += " xineramaproto xf86miscproto"
SRC_URI[archive.md5sum] = "42069e70578bf3fb353cdacad186f6c0"
SRC_URI[archive.sha256sum] = "b3ca934ce3e31f4a162bf263cad3913edccc46906d09132118b74a2095c157d9"
