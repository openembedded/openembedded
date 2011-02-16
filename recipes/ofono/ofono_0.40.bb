require ofono.inc

PR = "${INC_PR}.0"

SRC_URI  = "http://www.kernel.org/pub/linux/network/ofono/${P}.tar.bz2 \
            file://sierra-mc8790.patch \
            file://ofono"

SRC_URI[md5sum] = "a986891d41fdb025c01455008e108075"
SRC_URI[sha256sum] = "e5c6532ea109ddacecc87031c4c8a37a604cbc26e063a2d1338b951bb226ec9a"
