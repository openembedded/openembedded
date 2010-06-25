require libx11_${PV}.bb
PR = "${INC_PR}.0"

SRC_URI += "file://X18NCMSstubs.diff \
            file://fix-disable-xlocale.diff \
            file://fix-utf8-wrong-define.patch"

EXTRA_OECONF += "--without-xcb --disable-udc --disable-xcms --disable-xlocale --disable-xkb"

CFLAGS += "-D_GNU_SOURCE"
