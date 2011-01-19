require gcc-common.inc
LICENSE = "GPLv3"

DEPENDS = "mpfr gmp"
NATIVEDEPS = "mpfr-native gmp-native"

INC_PR = "r21"

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
	file://pr34130.patch \
	file://fortran-static-linking.patch \
	file://intermask-bigendian.patch \
	file://Makefile.in.patch \
"


SRC_URI_append_avr32 = " \
        file://gcc-4.2.2.atmel.1.0.8.patch.bz2 \
	file://901-avr32-fix-no-cond-exec-before-reload.patch \
	file://902-avr32-fix-sync-insn-instructions.patch \
	file://903-avr32-fix-removal-of-redundant-cast-operations.patch \
"


SRC_URI_append_ep93xx = " \
        file://arm-crunch-saveregs.patch \
        file://arm-crunch-20000320.patch \
        file://arm-crunch-compare.patch \
        file://arm-crunch-compare-unordered.patch \
        file://arm-crunch-compare-geu.patch \
        file://arm-crunch-eabi-ieee754.patch \
        file://arm-crunch-eabi-ieee754-div.patch \
        file://arm-crunch-64bit-disable0.patch \
        file://arm-crunch-offset.patch \
        file://arm-crunch-fp_consts.patch \
        file://arm-crunch-neg2.patch \
        file://arm-crunch-predicates3.patch \
        file://arm-crunch-cfcvtds-disable.patch \
        file://arm-crunch-floatsi-disable.patch \
        file://arm-crunch-truncsi-disable.patch \
        file://arm-crunch-cfcvt64-disable.patch \
        file://arm-crunch-cirrus-bugfixes.patch \
       "

PACKAGE_ARCH_ep93xx = "${MACHINE_ARCH}"

SRC_URI_append_sh3  = " file://sh3-installfix-fixheaders.patch "

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

EXTRA_OECONF_BASE = "--enable-libssp --disable-bootstrap --disable-libgomp --disable-libmudflap"
EXTRA_OECONF_INITIAL = "--disable-libmudflap --disable-libgomp --disable-libssp"
EXTRA_OECONF_INTERMEDIATE = "--disable-libmudflap --disable-libgomp --disable-libssp"

ARM_INSTRUCTION_SET = "arm"

SRC_URI[archive.md5sum] = "7ae33781417a35a2eb03ee098a9f4490"
SRC_URI[archive.sha256sum] = "673b85d780a082c014ded4ac11f8269a3fe893b4dbb584d65b8602d50b3872b1"
