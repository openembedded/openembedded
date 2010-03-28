require curl-common.inc
require curl-target.inc

PR = "${INC_PR}"

SRC_URI = "http://curl.haxx.se/download/curl-${PV}.tar.bz2;name=tarball \
           file://off_t_abi_fix.patch;patch=1;pnum=0"

SRC_URI[tarball.md5sum] = "3dda78c4a808d9a779dc3a2ae81b47d8"
SRC_URI[tarball.sha256sum] = "eb516915da615d8f6b2b855004d5d4b19c468f080e3736d7a73c5599b9acab11"

