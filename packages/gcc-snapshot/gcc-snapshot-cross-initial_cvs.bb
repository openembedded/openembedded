SECTION = "devel"
include gcc-snapshot-cross_cvs.bb

DEPENDS = "virtual/${TARGET_PREFIX}binutils virtual/${TARGET_PREFIX}libc-initial"
PROVIDES = "virtual/${TARGET_PREFIX}gcc-initial"

PACKAGES = ""

# This is intended to be a -very- basic config
EXTRA_OECONF = "--with-local-prefix=${CROSS_DIR}/${TARGET_SYS} \
		--with-newlib \
		--disable-shared \
		--disable-threads \
		--disable-multilib \
		--disable-__cxa_atexit \
		--enable-languages=c \
		--enable-target-optspace \
		--program-prefix=${TARGET_PREFIX}"

do_stage_prepend () {
	mkdir -p ${CROSS_DIR}/lib/gcc/${TARGET_SYS}/${PV}
	ln -sf libgcc.a ${CROSS_DIR}/lib/gcc/${TARGET_SYS}/${PV}/libgcc_eh.a
}

# Override the method from gcc-cross so we don't try to install libgcc
do_install () {
	oe_runmake 'DESTDIR=${D}' install
}
