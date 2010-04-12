require libx11_${PV}.bb

SRC_URI += "file://X18NCMSstubs.diff;patch=1 \
	    file://fix-disable-xlocale.diff;patch=1 \
            file://fix-utf8-wrong-define.patch;patch=1"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/libx11"

EXTRA_OECONF += "--disable-udc --disable-xcms --disable-xlocale --disable-xkb"
CFLAGS += "-D_GNU_SOURCE"

SRC_URI[archive.md5sum] = "4d43d3e472c552d2f191ecdd4e75112c"
SRC_URI[archive.sha256sum] = "4a2f566e2ea5dd955c875cb8fa9c18dd725324fc5cf4e23c803442e31ab8917a"
