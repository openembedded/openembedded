PR = "r5"

require util-linux.inc

SRC_URI = "http://ftp.cwi.nl/aeb/util-linux/util-linux-${PV}.tar.gz \
           file://MCONFIG \
           file://make_include \
           file://swapargs.h \
           file://defines.h \
           file://my_dev_t.h.diff;patch=1 \
           file://ioctl.diff;patch=1;pnum=1"

SRC_URI[md5sum] = "997adf78b98d9d1c5db4f37ea982acff"
SRC_URI[sha256sum] = "9c239b947b9a7352d88625073ab512d601da92a00703f73dc1e1b83b78b4ca1d"
