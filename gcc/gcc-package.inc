gcclibdir ?= "${libdir}/gcc"

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
	       ${gcclibdir}/${TARGET_SYS}/${PV}/*.o \
	       ${gcclibdir}/${TARGET_SYS}/${PV}/specs \
	       ${gcclibdir}/${TARGET_SYS}/${PV}/lib* \
	       ${gcclibdir}/${TARGET_SYS}/${PV}/include"
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
FILES_libg2c = "${libdir}/libg2c.so.*"
FILES_libg2c-dev = "${libdir}/libg2c.so \
			  ${libdir}/libg2c.a \
			  ${libdir}/libfrtbegin.a"

FILES_${PN}-c++ = "${bindir}/${TARGET_PREFIX}g++ \
		   ${libexecdir}/gcc/${TARGET_SYS}/${PV}/cc1plus"
FILES_${PN}-c++-symlinks = "${bindir}/c++ \
			    ${bindir}/g++"

FILES_libgcc = "/lib/libgcc_s.so.1"

# Called from within gcc-cross, so libdir is set wrong
FILES_libstdc++ = "${libdir}/libstdc++.so.*"
FILES_libstdc++-dev = "${includedir}/c++/${PV} \
		       ${libdir}/libstdc++.so \
		       ${libdir}/libstdc++.la \
		       ${libdir}/libstdc++.a \
		       ${libdir}/libsupc++.la \
		       ${libdir}/libsupc++.a"

FILES_${PN}-doc = "${infodir} \
		   ${mandir} \
		   ${gcclibdir}/${TARGET_SYS}/${PV}/include/README"


do_install () {
	autotools_do_install

	# Cleanup some of the /usr/lib{,exec}/gcc stuff ...
	rm -r ${D}/${libdir}/gcc/${TARGET_SYS}/${PV}/install-tools
	rm -r ${D}/${libexecdir}/gcc/${TARGET_SYS}/${PV}/install-tools

	# Hack around specs file assumptions
	sed -i -e '/^*cross_compile:$/ { n; s/1/0/; }' ${D}/${libdir}/gcc/${TARGET_SYS}/${PV}/specs

	# Move libgcc_s into /lib
	mkdir -p ${D}/lib
	mv ${D}/${libdir}/libgcc_s.so.* ${D}/lib
	rm ${D}/${libdir}/libgcc_s.so
	ln -sf `echo ${libdir}/gcc/${TARGET_SYS}/${PV} \
		| tr -s / \
		| sed -e 's,^/,,' -e 's,[^/]*,..,g'`/lib/libgcc_s.so.1 \
		      ${D}/${libdir}/gcc/${TARGET_SYS}/${PV}/libgcc_s.so

	# We don't need libtool libraries
	rm ${D}/${libdir}/libg2c.la

	# Cleanup manpages..
	rm -r ${D}/${mandir}/man7

	# We use libiberty from binutils
	rm ${D}/${libdir}/libiberty.a

	cd ${D}/${bindir}

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
