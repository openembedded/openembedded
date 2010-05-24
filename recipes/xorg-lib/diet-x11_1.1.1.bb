SECTION = "x11/base"
require libx11_${PV}.bb

EXTRA_OECONF += "--disable-udc --enable-xcms --disable-xlocale --disable-xkb"
CFLAGS += "-D_GNU_SOURCE"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libx11"

SRC_URI += "file://X18NCMSstubs.diff;apply=yes \
	    file://fix-disable-xlocale.diff;apply=yes \
            file://fix-utf8-wrong-define.patch;apply=yes \
	    file://xim.patch;apply=yes \
	    file://xchar2b.patch;apply=yes"
