require curl-common.inc
require curl-target.inc

PR = "${INC_PR}.1"

SRC_URI = "http://curl.haxx.se/download/curl-${PV}.tar.bz2 \
           file://off_t_abi_fix.patch;striplevel=0"

SRC_URI[md5sum] = "eafde5b933bce1c1dca82d1054c8d967"
SRC_URI[sha256sum] = "653b3214005c778a8c642af4e5dea46c74f7bf51017a568bb8725ea9eda73643"
