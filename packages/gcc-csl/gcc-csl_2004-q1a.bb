SECTION = "devel"
inherit autotools gettext

DESCRIPTION = "The GNU cc and gcc C compilers."
LICENSE = "GPL"
MAINTAINER = "Gerald Britton <gbritton@doomcom.org>"
BROKEN = "1"

# libgcc libstdc++ libg2c are listed in our FILES_*, but are actually
# packaged in the respective cross packages.
PACKAGES = "${PN} ${PN}-symlinks \
            ${PN}-c++ ${PN}-c++-symlinks \
            ${PN}-f77 ${PN}-f77-symlinks \
            libstdc++-dev libg2c-dev \
            ${PN}-doc"

FILES_${PN} = "${bindir}/${TARGET_PREFIX}gcc \
	       ${bindir}/${TARGET_PREFIX}cpp \
	       ${bindir}/${TARGET_PREFIX}gcov \
	       ${bindir}/${TARGET_PREFIX}gccbug \
	       ${libexecdir}/gcc/${TARGET_SYS}/${PV}/cc1 \
	       ${libexecdir}/gcc/${TARGET_SYS}/${PV}/collect2 \
	       ${libdir}/gcc/${TARGET_SYS}/${PV}/*.o \
	       ${libdir}/gcc/${TARGET_SYS}/${PV}/specs \
	       ${libdir}/gcc/${TARGET_SYS}/${PV}/lib* \
	       ${libdir}/gcc/${TARGET_SYS}/${PV}/include"

FILES_${PN}-symlinks = "${bindir}/cc \
			${bindir}/gcc \
			${bindir}/cpp \
			${bindir}/gcov \
			${bindir}/gccbug"

FILES_${PN}-f77 = "${bindir}/${TARGET_PREFIX}g77 \
		   ${libexecdir}/gcc/${TARGET_SYS}/${PV}/f771"

FILES_${PN}-f77-symlinks = "${bindir}/g77 \
			    ${bindir}/f77"

# Called from within gcc-cross, so libdir is set wrong
#FILES_libg2c = "${libdir}/libg2c.so.*"
FILES_libg2c = "${libdir}/libg2c.so.*"

FILES_libg2c-dev = "${libdir}/libg2c.so \
			  ${libdir}/libg2c.a \
			  ${libdir}/libfrtbegin.a"

FILES_${PN}-c++ = "${bindir}/${TARGET_PREFIX}g++ \
		   ${libexecdir}/gcc/${TARGET_SYS}/${PV}/cc1plus"

FILES_${PN}-c++-symlinks = "${bindir}/c++ \
			    ${bindir}/g++"

FILES_libgcc = "/lib/libgcc_s.so.*"

# Called from within gcc-cross, so libdir is set wrong
#FILES_libstdc++ = "${libdir}/libstdc++.so.*"
FILES_libstdc++ = "${libdir}/libstdc++.so.*"

FILES_libstdc++-dev = "${includedir}/c++/${PV} \
		       ${libdir}/libstdc++.so \
		       ${libdir}/libstdc++.la \
		       ${libdir}/libstdc++.a \
		       ${libdir}/libsupc++.la \
		       ${libdir}/libsupc++.a"

FILES_${PN}-doc = "${infodir} \
		   ${mandir} \
		   ${libdir}/gcc/${TARGET_SYS}/${PV}/include/README"

#	   file://gcc34-pre-modify.patch;patch=1
SRC_URI = "http://www.codesourcery.com/public/gnu_toolchain/arm/2004-Q1A/gcc-${PV}.tar.gz \
	   file://gcc34-reverse-compare.patch;patch=1 \
	   file://gcc34-arm-ldm.patch;patch=1 \
	   file://gcc34-arm-ldm-peephole.patch;patch=1 \
	   file://gcc34-arm-tune.patch;patch=1 \
	   file://gcc34-15089.patch;patch=1 \
	   file://gcc34-15666.patch;patch=1 \
	   file://gcc-uclibc-3.4.0-100-conf.patch;patch=1 \
	   file://gcc-uclibc-3.4.0-200-code.patch;patch=1 \
	   file://gcc-3.4.0-arm-lib1asm.patch;patch=1 \
	   file://gcc-3.4.0-arm-nolibfloat.patch;patch=1"

python do_unpack () {
	bb.build.exec_func('base_do_unpack', d)
	bb.build.exec_func('fix_perms', d)
}

fix_perms () {
	chmod -R u+w ${S}
}

gccbuild_uclibc_do_patch () {
	#
	# Hack things to use the correct shared lib loader
	#
	#LIST=`grep -lr -- "-dynamic-linker.*\.so[\.0-9]*" .`
	#if [ -n "$LIST" ] ; then
	#	perl -i -p -e "s,-dynamic-linker.*\.so[\.0-9]*},-dynamic-linker /lib/ld-uClibc.so.0},;" $LIST
	#fi

	#
	# Prevent system glibc start files from leaking in uninvited...
	#
	perl -i -p -e "s,standard_startfile_prefix_1 = \".*,standard_startfile_prefix_1 = \"${CROSS_DIR}/${TARGET_SYS}/lib/\";,;" gcc/gcc.c
	perl -i -p -e "s,standard_startfile_prefix_2 = \".*,standard_startfile_prefix_2 = \"${CROSS_DIR}/${TARGET_SYS}/usr/lib/\";,;" gcc/gcc.c

	#
	# Prevent system glibc include files from leaking in uninvited...
	#
	perl -i -p -e "s,^NATIVE_SYSTEM_HEADER_DIR.*,NATIVE_SYSTEM_HEADER_DIR=${CROSS_DIR}/${TARGET_SYS}/include,;" gcc/Makefile.in
	perl -i -p -e "s,^CROSS_SYSTEM_HEADER_DIR.*,CROSS_SYSTEM_HEADER_DIR=${CROSS_DIR}/${TARGET_SYS}/include,;" gcc/Makefile.in
	perl -i -p -e "s,^#define.*STANDARD_INCLUDE_DIR.*,#define STANDARD_INCLUDE_DIR \"${CROSS_DIR}/${TARGET_SYS}/include\",;" gcc/cppdefault.h

	#
	# Prevent system glibc libraries from being found by collect2 
	# when it calls locatelib() and rummages about the system looking 
	# for libraries with the correct name...
	#
	perl -i -p -e "s,\"/lib,\"${CROSS_DIR}/${TARGET_SYS}/lib,g;" \
		gcc/collect2.c
	perl -i -p -e "s,\"/usr/,\"${CROSS_DIR}/${TARGET_SYS}/usr/,g;" \
		gcc/collect2.c

	#
	# Prevent gcc from using the unwind-dw2-fde-glibc code
	#
	perl -i -p -e "s,^#ifndef inhibit_libc,#define inhibit_libc
#ifndef inhibit_libc,g;" gcc/unwind-dw2-fde-glibc.c
}

python do_patch () {
    import bb, re
    bb.build.exec_func('base_do_patch', d)
    if (re.match('.*uclibc$', bb.data.getVar('TARGET_OS', d, 1)) != None):
        bb.build.exec_func('gccbuild_uclibc_do_patch', d)
}

S = "${WORKDIR}/gcc-${PV}"
B = "${S}/build.${HOST_SYS}.${TARGET_SYS}"

EXTRA_OECONF = "--with-gnu-ld \
                --enable-shared \
                --enable-multilib \
                --enable-target-optspace \
                --enable-languages=c,c++,f77 \
                --enable-threads=posix \
                --enable-c99 \
                --enable-long-long \
                --enable-symvers=gnu \
                --program-prefix=${TARGET_PREFIX} \
                ${EXTRA_OECONF_PATHS} \
                ${EXTRA_OECONF_DEP}"

EXTRA_OECONF_PATHS = "--with-local-prefix=${prefix}/local \
                      --with-gxx-include-dir=${includedir}/c++/${PV}"

EXTRA_OECONF_DEP = ""
EXTRA_OECONF_uclibc = "--disable-__cxa_atexit"
EXTRA_OECONF_glibc = "--enable-__cxa_atexit"
EXTRA_OECONF_append_openmn = " --with-float=soft "

python __anonymous () {
    import bb, re
    if (re.match('linux-uclibc$', bb.data.getVar('TARGET_OS', d, 1)) != None):
        bb.data.setVar('EXTRA_OECONF_DEP', '${EXTRA_OECONF_uclibc}', d)
    elif (re.match('linux$', bb.data.getVar('TARGET_OS', d, 1)) != None):
        bb.data.setVar('EXTRA_OECONF_DEP', '${EXTRA_OECONF_glibc}', d)
}

do_configure () {
	# Setup these vars for cross building only
	if [ "${BUILD_SYS}" != "${HOST_SYS}" ]; then
		export CC_FOR_TARGET="${CCACHE} ${HOST_PREFIX}gcc"
		export GCC_FOR_TARGET="${CCACHE} ${HOST_PREFIX}gcc"
		export CXX_FOR_TARGET="${CCACHE} ${HOST_PREFIX}g++"
		export AS_FOR_TARGET="${HOST_PREFIX}as"
		export LD_FOR_TARGET="${HOST_PREFIX}ld"
		export NM_FOR_TARGET="${HOST_PREFIX}nm"
		export AR_FOR_TARGET="${HOST_PREFIX}ar"
		export RANLIB_FOR_TARGET="${HOST_PREFIX}ranlib"
	fi
	(cd ${S} && gnu-configize) || die "failure running gnu-configize"
	oe_runconf
}

do_install () {
	autotools_do_install

	# Cleanup some of the ${libdir}{,exec}/gcc stuff ...
	rm -r ${D}${libdir}/gcc/${TARGET_SYS}/${PV}/install-tools
	rm -r ${D}${libexecdir}/gcc/${TARGET_SYS}/${PV}/install-tools

	# Move libgcc_s into /lib
	mkdir -p ${D}${base_libdir}
	mv ${D}${libdir}/libgcc_s.so.* ${D}${base_libdir}
	rm ${D}${libdir}/libgcc_s.so
	ln -sf `echo ${libdir}/gcc/${TARGET_SYS}/${PV} \
		| tr -s / \
		| sed -e 's,^/,,' -e 's,[^/]*,..,g'`/lib/libgcc_s.so.? \
		      ${D}${libdir}/gcc/${TARGET_SYS}/${PV}/libgcc_s.so

	# We don't need libtool libraries
	rm ${D}${libdir}/libg2c.la

	# Cleanup manpages..
	rm -r ${D}${mandir}/man7

	# We use libiberty from binutils
	rm ${D}${libdir}/libiberty.a

	cd ${D}${bindir}

	# We care about g++ not c++
	rm *c++

	# We don't care about the gcc-<version> ones for this
	rm *gcc-?.?*

	# These sometimes show up, they are strange, we remove them
	rm -f ${TARGET_ARCH}-*${TARGET_ARCH}-*

	# Symlinks so we can use these trivially on the target
	ln -sf ${TARGET_SYS}-g77 g77
	ln -sf ${TARGET_SYS}-g++ g++
	ln -sf ${TARGET_SYS}-gcc gcc
	ln -sf g77 f77
	ln -sf g++ c++
	ln -sf gcc cc
}
