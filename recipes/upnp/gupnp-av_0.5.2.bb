LICENSE = "LGPL"
DEPENDS = "gupnp"

require gupnp.inc

SRC_URI += "file://nodoc.patch"

inherit autotools pkgconfig

SRC_URI[md5sum] = "15ccfbb17553bf1cb00bf8e1d801005e"
SRC_URI[sha256sum] = "dfd438f40e31047d6f06db30db05d5f876c6294a8509f170482d712f552e9892"
