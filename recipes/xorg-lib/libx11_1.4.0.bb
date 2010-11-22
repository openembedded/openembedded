require libx11.inc
#--without-xcb is not an option anymore
#http://cgit.freedesktop.org/xorg/lib/libX11/commit/?id=15e5eaf62897b3179d1fbe457cb19f886f0449f8
DEPENDS_virtclass-native = "libxcb-native ${COMMON_DEPENDS}"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "b63d9f7493a61df51d0c0be04ac435e4"
SRC_URI[archive.sha256sum] = "b2f8fcf30b72226ed5e83975ed1b0665c5fcb3d77d626cc0e66d58f951d1cffb"
