require libx11_${PV}.bb

EXTRA_OECONF += "--without-xcb --disable-udc --disable-xcms --disable-xlocale --disable-xkb"
CFLAGS += "-D_GNU_SOURCE"

SRC_URI += "file://X18NCMSstubs.diff \
	    file://fix-disable-xlocale.diff \
            file://fix-utf8-wrong-define.patch"
PR = "${INC_PR}.0"

