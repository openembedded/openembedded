require libx11_${PV}.bb

SRC_URI += "file://X18NCMSstubs.diff;patch=1 \
	    file://fix-disable-xlocale.diff;patch=1 \
            file://fix-utf8-wrong-define.patch;patch=1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libx11"

EXTRA_OECONF += "--disable-udc --disable-xcms --disable-xlocale --disable-xkb"
CFLAGS += "-D_GNU_SOURCE"

SRC_URI[archive.md5sum] = "710bf38a9477a5a1b235bc94f1d0593c"
SRC_URI[archive.sha256sum] = "b77e4fd2bbd4092e7e78d0964760ad8ab160caccd4bc6d7d0c87a23febaea85e"
