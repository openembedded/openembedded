require cairo.inc

DEPENDS = "cairo"
DESCRIPTION = "C++ bindings for Cairo graphics library"
PR = "r0"

SRC_URI = "http://cairographics.org/releases/cairomm-${PV}.tar.gz"

#EXTRA_OECONF = "--disable-docs"

SRC_URI[md5sum] = "5d862facfbd0098c9bae618b61f7c8e6"
SRC_URI[sha256sum] = "a137ccd4a6cde6c9e9553966534702d2e7f6f44c755dfe128d9fb26ed2697fe7"
