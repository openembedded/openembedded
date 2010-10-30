require libx11.inc
#--without-xcb is not an option anymore
#http://cgit.freedesktop.org/xorg/lib/libX11/commit/?id=15e5eaf62897b3179d1fbe457cb19f886f0449f8
DEPENDS_virtclass-native = "libxcb-native ${COMMON_DEPENDS}"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "3e8ed7a91f70bb819b5dab9c124a7062"
SRC_URI[archive.sha256sum] = "50205aad0646c0ab13aff8e8eaec7c5cddff416d3a012f83c5661ad98e49736f"
