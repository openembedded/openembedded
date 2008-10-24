gcclibdir ?= "${libdir}/gcc"
BINV ?= "${PV}"

PACKAGES = "${PN} ${PN}-symlinks \
            g++-noemu g++-noemu-symlinks \
	    cpp-noemu cpp-noemu-symlinks"

FILES_${PN} = "${bindir}/${TARGET_PREFIX}gcc \
	       ${bindir}/${TARGET_PREFIX}gccbug \
	       ${libexecdir}/gcc/${TARGET_SYS}/${BINV}/cc1 \
	       ${libexecdir}/gcc/${TARGET_SYS}/${BINV}/collect2 \
	       ${gcclibdir}/${TARGET_SYS}/${BINV}/*.o \
	       ${gcclibdir}/${TARGET_SYS}/${BINV}/specs \
	       ${gcclibdir}/${TARGET_SYS}/${BINV}/lib* \
	       ${gcclibdir}/${TARGET_SYS}/${BINV}/include \
	       ${libdir}/gcc/${TARGET_SYS}/${BINV}/libgcc_s.so"
FILES_${PN}-symlinks = "${bindir}/cc \
			${bindir}/gcc \
			${bindir}/gccbug"

FILES_cpp-noemu = "${bindir}/${TARGET_PREFIX}cpp \
	     ${base_libdir}/cpp"
FILES_cpp-noemu-symlinks = "${bindir}/cpp"

FILES_g++-noemu = "${bindir}/${TARGET_PREFIX}g++ \
		   ${libexecdir}/gcc/${TARGET_SYS}/${BINV}/cc1plus"
FILES_g++-noemu-symlinks = "${bindir}/c++ \
			    ${bindir}/g++"

do_install () {
	autotools_do_install

	# Cleanup some of the ${libdir}{,exec}/gcc stuff ...
	rm -r ${D}${libdir}/gcc/${TARGET_SYS}/${BINV}/install-tools
	rm -r ${D}${libexecdir}/gcc/${TARGET_SYS}/${BINV}/install-tools

	# Hack around specs file assumptions
	test -f ${D}${libdir}/gcc/${TARGET_SYS}/${BINV}/specs && sed -i -e '/^*cross_compile:$/ { n; s/1/0/; }' ${D}${libdir}/gcc/${TARGET_SYS}/${BINV}/specs

	# Using --with-slibdir instead of this hack below..
	# Move libgcc_s into /lib
	#mkdir -p ${D}${base_libdir}
	#mv ${D}${libdir}/libgcc_s.so.* ${D}${base_libdir}
	rm -f ${D}${libdir}/libgcc_s.so
	ln -sf `echo ${libdir}/gcc/${TARGET_SYS}/${BINV} \
		| tr -s / \
		| sed -e 's,^/,,' -e 's,[^/]*,..,g'`/lib/libgcc_s.so.1 \
		      ${D}${libdir}/gcc/${TARGET_SYS}/${BINV}/libgcc_s.so

	# We don't need libtool libraries
	rm -f ${D}${libdir}/libg2c.la &>/dev/null || true

	# Cleanup manpages..
	rm -rf ${D}${mandir}/man7

	# We use libiberty from binutils
	rm -f ${D}${libdir}/libiberty.a

	cd ${D}${bindir}

	# We care about g++ not c++
	rm -f *c++

	# We don't care about the gcc-<version> ones for this
	rm -f *gcc-?.?*

	# These sometimes show up, they are strange, we remove them
	rm -f ${TARGET_ARCH}-*${TARGET_ARCH}-*

	# Symlinks so we can use these trivially on the target
#	ln -sf ${TARGET_SYS}-g77 g77
	ln -sf ${TARGET_SYS}-g++ g++
	ln -sf ${TARGET_SYS}-gcc gcc
#	ln -sf g77 f77
	ln -sf g++ c++
	ln -sf gcc cc
	ln -sf ${bindir}/${TARGET_SYS}-cpp ${D}${base_libdir}/cpp
	ln -sf ${bindir}/${TARGET_SYS}-cpp ${D}${bindir}/cpp
}
