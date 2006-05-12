DESCRIPTION = "libelf is an ELF object file access library. \
The elf library provides routines to access, and manipulate, Elf object files."
LICENSE = "LGPL"
SECTION = "libs"

SRC_URI = "http://www.mr511.de/software/libelf-${PV}.tar.gz \
           http://www.stud.uni-hannover.de/~michael/software/libelf-${PV}.tar.gz"

inherit autotools

PARALLEL_MAKE = ""

do_configure_prepend () {
	if test ! -e acinclude.m4; then
		cp aclocal.m4 acinclude.m4
	fi
}

do_install () {
	oe_runmake 'prefix=${D}${prefix}' 'exec_prefix=${D}${exec_prefix}' \
		   'libdir=${D}${libdir}' 'includedir=${D}${includedir}' \
		   install
}

do_stage () {
	oe_libinstall -so -C lib libelf ${STAGING_LIBDIR}/
	install -d ${STAGING_INCDIR}/libelf
	for i in libelf.h nlist.h gelf.h sys_elf.h; do
		install -m 0644 lib/$i ${STAGING_INCDIR}/libelf/
	done
	make includedir=${STAGING_INCDIR} install-compat
}
