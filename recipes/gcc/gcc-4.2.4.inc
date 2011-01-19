require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

INC_PR = "r16"

SRC_URI = "${GNU_MIRROR}/gcc/gcc-${PV}/gcc-${PV}.tar.bz2;name=archive \
	file://100-uclibc-conf.patch \
	file://103-uclibc-conf-noupstream.patch \
	file://200-uclibc-locale.patch \
	file://203-uclibc-locale-no__x.patch \
	file://204-uclibc-locale-wchar_fix.patch \
	file://205-uclibc-locale-update.patch \
	file://300-libstdc++-pic.patch \
	file://301-missing-execinfo_h.patch \
	file://302-c99-snprintf.patch \
	file://303-c99-complex-ugly-hack.patch \
	file://304-index_macro.patch \
	file://305-libmudflap-susv3-legacy.patch \
	file://306-libstdc++-namespace.patch \
	file://307-locale_facets.patch \
	file://402-libbackend_dep_gcov-iov.h.patch \
	file://602-sdk-libstdc++-includes.patch \
	file://740-sh-pr24836.patch \
	file://800-arm-bigendian.patch \
	file://801-arm-bigendian-eabi.patch \
	file://904-flatten-switch-stmt-00.patch \
	file://arm-nolibfloat.patch \
	file://arm-softfloat.patch \
	file://gcc41-configure.in.patch \
	file://arm-thumb.patch \
	file://arm-thumb-cache.patch \
	file://zecke-xgcc-cpp.patch \
	file://unbreak-armv4t.patch \
	file://cache-amnesia.patch \
	file://gfortran.patch \
	file://gcc-4.0.2-e300c2c3.patch \
	file://fortran-static-linking.patch \
	file://intermask-bigendian.patch \
	file://libstdc++-hack-libtool-remove-lstdc++.patch \
	file://Makefile.in.patch \
"

SRC_URI_append_ep93xx = " \
        file://ep93xx/arm-crunch-readme.patch \
        file://ep93xx/arm-crunch-saveregs.patch \
        file://ep93xx/arm-crunch-scratch.patch \
        file://ep93xx/arm-crunch-eabi-ieee754-endian-littleword-littlebyte.patch \
        file://ep93xx/arm-crunch-eabi-mvf0-scratch-ieee754.patch \
        file://ep93xx/arm-crunch-20000320.patch \
        file://ep93xx/arm-crunch-disable-cmpdi.patch \
        file://ep93xx/arm-crunch-fix-64bit-const-offsets.patch \
        file://ep93xx/arm-crunch-fp_consts.patch \
        file://ep93xx/arm-crunch-neg-enable.patch \
        file://ep93xx/arm-crunch-neg-protect.patch \
        file://ep93xx/arm-crunch-repair-truncxfsi.patch \
        file://ep93xx/arm-crunch-floatsi-no-scratch.patch \
        file://ep93xx/arm-crunch-movsf-movdf-Uy.patch \
        file://ep93xx/arm-crunch-drop-thumb2.patch \
        file://ep93xx/arm-crunch-arm_dbx_register_number.patch \
        file://ep93xx/arm-crunch-pipeline.patch \
        file://ep93xx/arm-crunch-ccmav-mode.patch \
        file://ep93xx/arm-crunch-cfcpy-with-cfsh64.patch \
        file://ep93xx/arm-crunch-mieee.patch \
        file://ep93xx/arm-size-bugfix.patch \
        file://ep93xx/arm-prologue_use-length.patch \
        file://ep93xx/arm-crunch-cftruncd32-attr.patch \
        file://ep93xx/arm-crunch-fix-cirrus-reorg7.patch \
        file://ep93xx/arm-crunch-cirrus-di-flag.patch \
        file://ep93xx/arm-crunch-disable-floatsi.patch \
       "

PACKAGE_ARCH_ep93xx = "${MACHINE_ARCH}"

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch "

SRC_URI_append_sh4  = " file://sh_unwind.patch \
			file://cppdefault_cross.patch \
		      "
# with sysroot this change is not needed for gcc 4.3+ but its needed
# for older compilers because of bug in libtool as well as this PR
# http://gcc.gnu.org/bugzilla/show_bug.cgi?id=5291
# we append the .la munging specially for libstdc++ and libsupc++ here
# This change if needed for other compilers in use should be put
# in there specific inc file.

do_install_append () {
        for d in ${target_libdir} ${target_libdir}/nof; do
                sed -i "s|dependency_libs\s*=\s*.*|dependency_libs='-lm '|" ${D}$d/libsupc++.la || true
                sed -i "s|dependency_libs\s*=\s*.*|dependency_libs='-lm '|" ${D}$d/libstdc++.la || true
        done
}

# Language Overrides
FORTRAN = ""
FORTRAN_linux-gnueabi = ",fortran"
JAVA = ""

EXTRA_OECONF_BASE = "--enable-libssp --disable-bootstrap --enable-libgomp --disable-libmudflap"
EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp"

ARM_INSTRUCTION_SET = "arm"

SRC_URI[archive.md5sum] = "d79f553e7916ea21c556329eacfeaa16"
SRC_URI[archive.sha256sum] = "afba845e2d38547a63bd3976e90245c81ea176786f9e6966339c6d3761f1133a"
