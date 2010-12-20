LICENSE = "LGPL"
DEPENDS = "e2fsprogs gssdp libsoup-2.4 libxml2"

require gupnp.inc

inherit autotools pkgconfig

FILES_${PN} = "${libdir}/*.so.*"
FILES_${PN}-dev += "${bindir}/gupnp-binding-tool"

SRC_URI[md5sum] = "91b4337d22f6dd931888a33553ab945a"
SRC_URI[sha256sum] = "f78e4b0a361b67805892c1a0e72f3cef92fbc96112157895660a478979ddeef4"
