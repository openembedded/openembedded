require xorg-driver-video.inc
PE = "1"

DESCRIPTION = "X.Org X server -- ark display driver"

SRC_URI += "file://get-rid-of-host-includes.patch;patch=1"
SRC_URI[archive.md5sum] = "4745f5c722b030962cc56eb2443894a0"
SRC_URI[archive.sha256sum] = "db1ef3e15ebd382837f16c1143035dfd9fa6465a77ae2e850201f71508065741"
