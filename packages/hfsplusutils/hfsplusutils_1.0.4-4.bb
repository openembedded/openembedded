DESCRIPTION = "HFS plus file system utilities"
SECTION = "base"
LICENSE = "GPL"
PR = "r1"

S="${WORKDIR}/${P}"

inherit kernel-arch autotools pkgconfig

DEPENDS = " rpm2cpio-native"

SRC_URI = "http://penguinppc.org/historical/hfsplus/hfsplusutils-1.0.4-4.src.rpm \
	   file://hfsplusutils-1.0.4-errno.patch;patch=1 \
	   file://hfsplusutils-1.0.4-gcc4.patch;patch=1 \
	   file://hfsplusutils-1.0.4-glob.patch;patch=1 \
	   file://hfsplusutils-1.0.4-string.patch;patch=1 \
		"

do_unpack() {
        if ! test -f hfsplus.tz2 ; then
                rpm2cpio.pl ${DL_DIR}/${P}.src.rpm | cpio -i --make-directories
                bunzip2 hfsplus.tz2
		tar -xf hfsplus.tz2.out
		mv hfsplus ${P}
        fi
}
