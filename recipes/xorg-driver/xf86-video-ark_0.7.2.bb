require xorg-driver-video.inc
DESCRIPTION = "X.Org X server -- ark display driver"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI += "file://get-rid-of-host-includes.patch"
SRC_URI[archive.md5sum] = "4745f5c722b030962cc56eb2443894a0"
SRC_URI[archive.sha256sum] = "db1ef3e15ebd382837f16c1143035dfd9fa6465a77ae2e850201f71508065741"
