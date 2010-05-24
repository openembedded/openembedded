require gcc-common.inc

INC_PR = "r15"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	   file://gcc34-reverse-compare.patch;apply=yes \
	   file://gcc34-arm-ldm.patch;apply=yes \
	   file://gcc34-arm-ldm-peephole.patch;apply=yes \
	   file://gcc34-arm-tune.patch;apply=yes \
	   file://gcc-3.4.1-uclibc-100-conf.patch;apply=yes \
	   file://gcc-3.4.1-uclibc-200-locale.patch;apply=yes \
	   file://gcc-3.4.0-arm-lib1asm.patch;apply=yes \
	   file://gcc-3.4.0-arm-nolibfloat.patch;apply=yes \
	   file://gcc-3.4.0-arm-bigendian.patch;apply=yes \
	   file://gcc-3.4.0-arm-bigendian-uclibc.patch;apply=yes \
	   file://GCC3.4.0VisibilityPatch.diff;apply=yes \
	   file://15342.patch;apply=yes \
	   file://jarfix.patch;apply=yes \
	   file://always-fixincperm.patch;apply=yes \
	   file://GCOV_PREFIX_STRIP-cross-profile_3.4.patch;apply=yes \
	   file://zecke-xgcc-cpp.patch;apply=yes \
	   file://gcc-libgcc2-inhibit-libc.patch;apply=yes \
	   file://gcc4-mtune-compat.patch;apply=yes \
	   file://gcc34-configure.in.patch;apply=yes \
	   file://gcc34-thumb-support.patch;apply=yes \
	   file://gcc-cross-fixincl.patch;apply=yes \
	   file://gcc-posix-open-fix.patch;apply=yes \
	   "
SRC_URI_append = " file://zecke-no-host-includes.patch;apply=yes "

SRC_URI[archive.md5sum] = "b594ff4ea4fbef4ba9220887de713dfe"
SRC_URI[archive.sha256sum] = "3444179840638cb8664e8e53604900c4521d29d57785a5091202ee4937d8d0fd"
