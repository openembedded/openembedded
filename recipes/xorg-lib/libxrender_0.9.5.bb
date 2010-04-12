require xorg-lib-common.inc

DESCRIPTION = "X11 Rendering Extension client library"
LICENSE = "BSD-X"
DEPENDS += "virtual/libx11 renderproto xproto xdmcp"
PR = "r1"
PE = "1"

XORG_PN = "libXrender"

SRC_URI[archive.md5sum] = "276dd9e85daf0680616cd9f132b354c9"
SRC_URI[archive.sha256sum] = "bc0590438a4be2b674cbac6f4ad46e5a89acd02aa94817da0fa8eb3ef05ed5d5"
