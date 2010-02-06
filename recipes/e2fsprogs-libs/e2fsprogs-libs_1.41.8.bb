require e2fsprogs-libs.inc
SRC_URI = "${SOURCEFORGE_MIRROR}/e2fsprogs/e2fsprogs-libs-${PV}.tar.gz \
	  "

PR = "r1"

EXTRA_OECONF += " --enable-elf-shlibs "

do_configure() {
        oe_runconf
}

do_compile_prepend () {
	find ./ -print|xargs chmod u=rwX
	( cd util; ${BUILD_CC} subst.c -o subst )
}
