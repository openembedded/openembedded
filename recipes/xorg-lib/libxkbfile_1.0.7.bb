require xorg-lib-common.inc
DESCRIPTION = "X11 keyboard file manipulation library"
LICENSE = "GPL"
DEPENDS += "virtual/libx11 kbproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "59b4fe0bdf8d9b05e45b59e8fe9e7516"
SRC_URI[archive.sha256sum] = "667e370a733b96b647a40211430cfc41dd2160c9a2aa701d0c839c626d0f2ae5"

BBCLASSEXTEND = "native"
