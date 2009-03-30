require oprofile.inc

RDEPENDS += "binutils-symlinks"
RRECOMMENDS += "kernel-vmlinux"
PR = "r11"

SRC_URI = "${SOURCEFORGE_MIRROR}/oprofile/oprofile-${PV}.tar.gz \
           file://armv6_fix.patch;patch=1 \
           file://oparchive_fix.patch;patch=1 \
           file://root_option.patch;patch=1 \
           file://opstart.patch;patch=1 \
           file://fix-arith.patch;patch=1;pnum=0 \
           file://gcc43x-fix.patch;patch=1 \
           file://armv7a.diff;patch=1 \
           file://acinclude.m4"
