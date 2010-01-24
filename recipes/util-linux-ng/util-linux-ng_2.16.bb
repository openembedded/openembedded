require util-linux-ng.inc

PR = "${INC_PR}.4"

SRC_URI += "file://uclibc-compile.patch;patch=1 \
            file://tls.patch;patch=1 \
	    file://util-linux-ng-replace-siginterrupt.patch;patch=1 \
           "

EXTRA_OECONF += " --enable-libuuid --enable-libblkid \
		--disable-fsck"
LDFLAGS_append_libc-uclibc = " -lintl"
PACKAGES_DYNAMIC += "libuuid*"

