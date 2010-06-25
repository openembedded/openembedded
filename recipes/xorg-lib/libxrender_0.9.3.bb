require xorg-lib-common.inc
DESCRIPTION = "X11 Rendering Extension client library"
LICENSE = "BSD-X"
DEPENDS += "virtual/libx11 renderproto xproto"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "307132fce2e551ad2c641bddf8480f16"
SRC_URI[archive.sha256sum] = "9882ba2d74e9ca5cfd0c2231ac8eba14d8fc59d538c787fa639f8d77c996bbef"

BBCLASSEXTEND = "native nativesdk"

XORG_PN = "libXrender"
