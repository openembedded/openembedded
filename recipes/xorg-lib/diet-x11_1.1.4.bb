require libx11_${PV}.bb

SRC_URI += "file://X18NCMSstubs.diff;patch=1 \
            file://fix-disable-xlocale.diff;patch=1 \
            file://fix-utf8-wrong-define.patch;patch=1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libx11"

EXTRA_OECONF += "--disable-udc --disable-xcms --disable-xlocale --disable-xkb"
CFLAGS += "-D_GNU_SOURCE"

SRC_URI[archive.md5sum] = "1469a5a8aa8d288dce6f4c45d2f68dc3"
SRC_URI[archive.sha256sum] = "bdbd6d239435c1736f5c532b12e8078761db8db5f37ab3195fe11c3e5b692c1c"
