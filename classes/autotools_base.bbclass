# use autotools_stage_all for native packages
AUTOTOOLS_NATIVE_STAGE_INSTALL = "1"

EXTRA_OEMAKE = ""

inherit siteinfo

def _autotools_get_sitefiles(d):
    def inherits(d, *classes):
        if any(bb.data.inherits_class(cls, d) for cls in classes):
            return True

    if inherits(d, "native", "nativesdk"):
        return

    sitedata = siteinfo_data(d)
    for path in d.getVar("BBPATH", True).split(":"):
        for element in sitedata:
            filename = os.path.join(path, "site", element)
            if os.path.exists(filename):
                yield filename

# Space separated list of shell scripts with variables defined to supply test
# results for autoconf tests we cannot run at build time.
export CONFIG_SITE = "${@' '.join(_autotools_get_sitefiles(d))}"

def append_libtool_sysroot(d):
	if bb.data.getVar('LIBTOOL_HAS_SYSROOT', d, 1) == "yes":
		if bb.data.getVar('BUILD_SYS', d, 1) == bb.data.getVar('HOST_SYS', d, 1):
			return '--with-libtool-sysroot'
		else:
			return '--with-libtool-sysroot=${STAGING_DIR_HOST}'
	return ''

CONFIGUREOPTS = " --build=${BUILD_SYS} \
		  --host=${HOST_SYS} \
		  --target=${TARGET_SYS} \
		  --prefix=${prefix} \
		  --exec_prefix=${exec_prefix} \
		  --bindir=${bindir} \
		  --sbindir=${sbindir} \
		  --libexecdir=${libexecdir} \
		  --datadir=${datadir} \
		  --sysconfdir=${sysconfdir} \
		  --sharedstatedir=${sharedstatedir} \
		  --localstatedir=${localstatedir} \
		  --libdir=${libdir} \
		  --includedir=${includedir} \
		  --oldincludedir=${oldincludedir} \
		  --infodir=${infodir} \
		  --mandir=${mandir} \
		  ${@append_libtool_sysroot(d)} \
		"

oe_runconf () {
	if [ -x ${S}/configure ] ; then
		${S}/configure \
		${CONFIGUREOPTS} ${EXTRA_OECONF} "$@"
	else
		oefatal "no configure script found"
	fi
}

autotools_base_do_configure () {
	if [ -e ${S}/configure ]; then
		oe_runconf $@
	else
		oenote "nothing to configure"
	fi
}

autotools_base_do_install() {
	oe_runmake 'DESTDIR=${D}' install
}

EXPORT_FUNCTIONS do_configure do_install

PACKAGE_PREPROCESS_FUNCS += "${@['autotools_prepackage_lamangler',''][bb.data.getVar('LIBTOOL_HAS_SYSROOT', d, 1) == "yes"]}"
autotools_prepackage_lamangler () {
        for i in `find ${PKGD} -name "*.la"` ; do \
            sed -i -e 's:${STAGING_LIBDIR}:${libdir}:g;' \
                   -e 's:${D}::g;' \
                   -e 's:-I${WORKDIR}\S*: :g;' \
                   -e 's:-L${WORKDIR}\S*: :g;' \
                   $i
	done
}

# STAGE_TEMP_PREFIX is used for a speedup by packaged-staging
STAGE_TEMP="${WORKDIR}/temp-staging"
STAGE_TEMP_PREFIX = ""

autotools_stage_includes() {
	if [ "${INHIBIT_AUTO_STAGE_INCLUDES}" != "1" ]
	then
		rm -rf ${STAGE_TEMP}
		mkdir -p ${STAGE_TEMP}
		make DESTDIR="${STAGE_TEMP}" install
		cp -pPR ${STAGE_TEMP}/${includedir}/* ${STAGING_INCDIR}
		rm -rf ${STAGE_TEMP}
	fi
}

autotools_stage_dir() {
	sysroot_stage_dir $1 ${STAGE_TEMP_PREFIX}$2
}

autotools_stage_libdir() {
	sysroot_stage_libdir $1 ${STAGE_TEMP_PREFIX}$2
}

autotools_stage_all() {
	if [ "${INHIBIT_AUTO_STAGE}" = "1" ]
	then
		return
	fi
	rm -rf ${STAGE_TEMP}
	mkdir -p ${STAGE_TEMP}
	oe_runmake DESTDIR="${STAGE_TEMP}" install
	rm -rf ${STAGE_TEMP}/${mandir} || true
	rm -rf ${STAGE_TEMP}/${infodir} || true
	sysroot_stage_dirs ${STAGE_TEMP} ${STAGE_TEMP_PREFIX}
	rm -rf ${STAGE_TEMP}
}
