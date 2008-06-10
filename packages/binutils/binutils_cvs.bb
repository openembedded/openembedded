FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-cvs"
PV = "0.0+cvs${SRCDATE}"
PR = "r3"

require binutils.inc

S = "${WORKDIR}/src"

SRC_URI = "cvs://anoncvs:anoncvs@sources.redhat.com/cvs/src;module=binutils;method=pserver;localdir=src \
     file://build_fix.patch;patch=1 \
     file://binutils-2.16.91.0.6-objcopy-rename-errorcode.patch;patch=1 \
     file://110-arm-eabi-conf.patch;patch=1 \
     file://binutils-uclibc-300-001_ld_makefile_patch.patch;patch=1 \
     file://binutils-uclibc-300-006_better_file_error.patch;patch=1 \
     file://binutils-uclibc-300-012_check_ldrunpath_length.patch;patch=1"

#EXTRA_OECONF = "--with-sysroot=/"

do_configure_prepend () {
    # RP: 
    # Remove rda and libgloss since they won't cross compile 
    # we don't need them anyway...
    # Also remove gdb, we build that separately.
    rm ${S}/gdb -Rf
    rm ${S}/rda -Rf
    rm ${S}/libgloss -Rf
}
