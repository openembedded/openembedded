SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
DEPENDS = "expat jpeg zlib libpng"
DESCRIPTION = "SVG parser library"
PR = "r1"

SRC_URI = "http://cairographics.org/snapshots/libsvg-${PV}.tar.gz \
           file://configure_fix.patch \
           file://gcc4_and_expat.patch"

EXTRA_OECONF = "--with-expat"

inherit autotools pkgconfig

SRC_URI[md5sum] = "ce0715e3013f78506795fba16e8455d3"
SRC_URI[sha256sum] = "4c3bf9292e676a72b12338691be64d0f38cd7f2ea5e8b67fbbf45f1ed404bc8f"
