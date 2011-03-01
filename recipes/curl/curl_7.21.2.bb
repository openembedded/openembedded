require curl-common.inc
require curl-target.inc

PR = "${INC_PR}.0"

SRC_URI = "http://curl.haxx.se/download/curl-${PV}.tar.bz2 \
           file://off_t_abi_fix.patch;striplevel=0"

SRC_URI[md5sum] = "ca96df88e044c7c25d19692ec8b250b2"
SRC_URI[sha256sum] = "f4a632e704f28767e6bbffcc6112db0590b1c9d50d8226d706ad39632355bf21"
