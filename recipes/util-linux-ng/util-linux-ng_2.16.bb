require util-linux-ng.inc

PR = "${INC_PR}"

SRC_URI += "file://uclibc-compile.patch;patch=1 \
"

EXTRA_OECONF += " --enable-libuuid --enable-libblkid \
		--disable-fsck"
LDFLAGS_append_libc-uclibc = " -lintl"
PACKAGES_DYNAMIC += "libuuid*"
