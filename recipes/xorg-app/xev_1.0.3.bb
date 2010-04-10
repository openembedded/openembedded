require xorg-app-common.inc

DESCRIPTION = "X Event Viewer"
LICENSE = "MIT"
PE = "1"

SRC_URI += "file://diet-x11.patch;patch=1"

SRC_URI[archive.md5sum] = "a9532c3d1683c99bb5df1895cb3a60b1"
SRC_URI[archive.sha256sum] = "d4ac7ae154ee9733be27a5f55586abb9362c768f5fb8a4fc7fd2645100a9313a"
