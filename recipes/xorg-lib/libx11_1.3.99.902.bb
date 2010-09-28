require libx11.inc
#--without-xcb is not an option anymore
#http://cgit.freedesktop.org/xorg/lib/libX11/commit/?id=15e5eaf62897b3179d1fbe457cb19f886f0449f8
DEPENDS_virtclass-native = "libxcb-native ${COMMON_DEPENDS}"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "dd824b76739a23fb466518f4acabb77b"
SRC_URI[archive.sha256sum] = "9435dc0214afea0567f5f9f894cc62e44505511e4221dc936df361f14817bf2e"
