require xorg-lib-common.inc

DESCRIPTION = "A Sample Authorization Protocol for X"
DEPENDS += " xproto"
PROVIDES = "xau"
PE = "1"

XORG_PN = "libXau"

SRC_URI[archive.md5sum] = "0f2b88d857e0a3f5898e4759c541af46"
SRC_URI[archive.sha256sum] = "10d3ffa5f00d0c0a4083309ba68bdfa01dfdf912ef4cf2141e3f260b2edeb22c"
