LICENSE = "LGPL"
DEPENDS = "gnupnp gstreamer"

require gupnp.inc

inherit autotools

FILES_${PN} = "${libdir}/*.so.*"

SRC_URI[md5sum] = "ab485bf263d0a3d2f771817241c970b9"
SRC_URI[sha256sum] = "782e4e45abcba1b3fe34276580653f4dbfbe8a26eee69a290675dfa7faa309f8"
