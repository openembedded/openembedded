require util-linux-ng.inc

PR = "${INC_PR}.1"

SRC_URI += "file://uclibc-compile.patch;patch=1 \
           "

EXTRA_OECONF += " --enable-libuuid --enable-libblkid \
		--disable-fsck"
LDFLAGS_append_libc-uclibc = " -lintl"
PACKAGES_DYNAMIC += "libuuid*"

do_configure_prepend_chinook-compat () {

	for i in  lt~obsolete.m4 ltsugar.m4 libtool.m4 ltoptions.m4 ltversion.m4
	do
		rm ${S}/m4/${i}
	done
}
