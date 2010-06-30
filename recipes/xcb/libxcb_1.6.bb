include libxcb.inc
PR = "${INC_PR}.1"

SRC_URI = "http://xcb.freedesktop.org/dist/libxcb-${PV}.tar.bz2 \
        file://configure_git.patch"

DEPENDS += "libpthread-stubs"

SRC_URI[md5sum] = "cba9f6d1137ef00d9b326726d0bab6fd"
SRC_URI[sha256sum] = "1ae6c81774a4637e90879d50db9017a2cc6c3f524e1baedc63ba72d44cad2936"
