require xorg-lib-common.inc

DESCRIPTION = "X11 keyboard file manipulation library"
LICENSE= "GPL"
DEPENDS += "virtual/libx11 kbproto"
PR = "r1"
PE = "1"

SRC_URI[archive.md5sum] = "b01156e263eca8177e6b7f10441951c4"
SRC_URI[archive.sha256sum] = "2ca43c1f6b2782994167a328471aa859d366cd7303c6dcbc8bda951a84a06039"
