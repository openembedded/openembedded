PR = "r2"

include util-linux.inc

SRC_URI = "http://ftp.cwi.nl/aeb/util-linux/util-linux-${PV}.tar.gz \
           file://MCONFIG \
           file://make_include \
           file://swapargs.h \
           file://defines.h \
           file://my_dev_t.h.diff;patch=1 \
           file://ioctl.diff;patch=1;pnum=1"
