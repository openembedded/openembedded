require e2fsprogs-libs.inc

SRC_URI += "file://ldflags.patch;patch=1"

EXTRA_OECONF=" --enable-elf-shlibs "

do_compile_prepend () {
	find ./ -print|xargs chmod u=rwX
	( cd util; ${BUILD_CC} subst.c -o subst )
}
