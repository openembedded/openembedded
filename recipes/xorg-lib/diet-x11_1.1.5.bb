require libx11_${PV}.bb

SRC_URI += "file://X18NCMSstubs.diff \
            file://fix-disable-xlocale.diff \
            file://fix-utf8-wrong-define.patch"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libx11"

EXTRA_OECONF += "--disable-udc --disable-xcms --disable-xlocale --disable-xkb"
CFLAGS += "-D_GNU_SOURCE"
