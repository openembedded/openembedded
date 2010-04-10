require xorg-lib-common.inc

DESCRIPTION = "X11 Video extension library"
LICENSE = "GPL"
DEPENDS += "libxext videoproto"
PR = "r1"

XORG_PN = "libXv"

SRC_URI[archive.md5sum] = "723a0275227165383e967a1ca8899b52"
SRC_URI[archive.sha256sum] = "4d3cc49b6f4da6d396196054eca23a91df1a41001c736dcfd22fec5a5c7428c8"
