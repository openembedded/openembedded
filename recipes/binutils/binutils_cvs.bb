FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-cvs"
PV = "0.0+cvs${SRCDATE}"
INC_PR = "r5"
PR = "${INC_PR}.1"

require binutils.inc

S = "${WORKDIR}/src"
EXTRA_OEMAKE = "configure-build-libiberty"
SRC_URI = "cvs://anoncvs:anoncvs@sources.redhat.com/cvs/src;module=binutils;method=pserver;localdir=src \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch;patch=1 \
     file://binutils-uclibc-100-uclibc-conf.patch;patch=1 \
     file://110-arm-eabi-conf.patch;patch=1 \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch;patch=1 \
     file://binutils-uclibc-300-006_better_file_error.patch;patch=1 \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch;patch=1 \
     file://binutils-uclibc-gas-needs-libm.patch;patch=1 \
     "

do_compile () {
	oe_runmake all-ld all-binutils all-gas
}
do_install () {
	oe_runmake install-ld install-binutils install-gas
}
do_stage () {
        oe_libinstall -so -a -C opcodes libopcodes ${STAGING_LIBDIR}/
        oe_libinstall -a -C libiberty libiberty ${STAGING_LIBDIR}/
        oe_libinstall -so -a -C bfd libbfd ${STAGING_LIBDIR}/
        install -m 0644 ${S}/include/dis-asm.h ${STAGING_INCDIR}/
        install -m 0644 ${S}/include/symcat.h ${STAGING_INCDIR}/
        install -m 0644 ${S}/include/libiberty.h ${STAGING_INCDIR}/
        install -m 0644 ${S}/include/ansidecl.h ${STAGING_INCDIR}/
        install -m 0644 ${S}/include/bfdlink.h ${STAGING_INCDIR}/
        install -m 0644 bfd/bfd.h ${STAGING_INCDIR}/
}
