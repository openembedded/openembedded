gcclibdir ?= "${libdir}/gcc"
S = "${WORKDIR}/gcc-${PV}"
B = "${S}/build.${HOST_SYS}.${TARGET_SYS}"
BINV ?= "${PV}"

LANGUAGES ?= "c,c++"

EXTRA_OECONF_DEP ?= ""

EXTRA_OECONF = "\
	${@['--enable-clocale=generic', ''][bb.data.getVar('USE_NLS', d, 1) != 'no']} \
	--disable-shared \
	--enable-languages=${LANGUAGES} \
	--enable-threads=win32 \
	--enable-c99 \
	--enable-long-long \
	--disable-maintainer-mode \
	--disable-bootstrap \
	--enable-target-optspace \
	--disable-win32-registry \
	--without-x \
	--program-prefix=${TARGET_PREFIX} \
	${EXTRA_OECONF_PATHS} \
	${EXTRA_OECONF_DEP}"

EXTRA_OECONF_PATHS = " \
	--with-local-prefix=${prefix}/local \
	--with-gxx-include-dir=${includedir}/c++/${BINV}"

CPP = ""
CPPFLAGS = ""

do_configure () {
	oe_runconf
}

do_stage () {
	# Fixup various .la files
	sed -i -e "s|installed=yes|installed=no|" -e "s|dependency_libs\s*=\s*.*|dependency_libs='-L${STAGING_DIR_HOST}${layout_libdir} ${LIBGCCS_VAR} -lc -lm '|" ${STAGING_DIR_HOST}${layout_libdir}/libsupc++.la || true
	sed -i -e "s|installed=yes|installed=no|" -e "s|dependency_libs\s*=\s*.*|dependency_libs='-L${STAGING_DIR_HOST}${layout_libdir} ${LIBGCCS_VAR} -lc -lm '|" ${STAGING_DIR_HOST}${layout_libdir}/libstdc++.la || true
	sed -i -e "s|installed=yes|installed=no|" -e "s|dependency_libs\s*=\s*.*|dependency_libs='-L${STAGING_DIR_HOST}${layout_libdir} ${LIBGCCS_VAR} -lc -lm '|" ${STAGING_DIR_HOST}${layout_libdir}/libg2c.la || true
	sed -i -e "s|installed=yes|installed=no|" -e "s|dependency_libs\s*=\s*.*|dependency_libs='-L${STAGING_DIR_HOST}${layout_libdir} ${LIBGCCS_VAR} -lc -lm '|" ${STAGING_DIR_HOST}${layout_libdir}/libobjc.la || true
}
