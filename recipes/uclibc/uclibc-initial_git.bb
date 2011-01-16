SECTION = "base"
require uclibc_git.bb

DEPENDS = "linux-libc-headers ncurses-native virtual/${TARGET_PREFIX}gcc-initial"
PROVIDES = "virtual/${TARGET_PREFIX}libc-initial"
PACKAGES = ""

do_install() {
	# Install initial headers into the cross dir
	make PREFIX=${D} DEVEL_PREFIX=${prefix}/ RUNTIME_PREFIX=/ \
		install_headers install_startfiles
	${CC} -nostdlib -nostartfiles -shared -x c /dev/null \
		-o lib/libc.so
	${CC} -nostdlib -nostartfiles -shared -x c /dev/null \
		-o lib/libm.so
	install -d ${D}${libdir}
	install -m 755 lib/lib[cm].so ${D}${libdir}
}
do_compile() {
}
