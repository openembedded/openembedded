# use autotools_stage_all for native packages
AUTOTOOLS_NATIVE_STAGE_INSTALL = "1"

def autotools_deps(d):
	if bb.data.getVar('INHIBIT_AUTOTOOLS_DEPS', d, 1):
		return ''

	pn = bb.data.getVar('PN', d, 1)
	deps = ''

	if pn in ['autoconf-native', 'automake-native', 'help2man-native']:
		return deps
	deps += 'autoconf-native automake-native help2man-native '

	if pn not in ['libtool', 'libtool-native', 'libtool-cross']:
		deps += 'libtool-native '
		if (not oe.utils.inherits(d, 'native', 'nativesdk', 'cross',
		                          'sdk') and
		    not d.getVar('INHIBIT_DEFAULT_DEPS', True)):
			deps += 'libtool-cross '

	return deps + 'gnu-config-native '

EXTRA_OEMAKE = ""

DEPENDS_prepend = "${@autotools_deps(d)}"
DEPENDS_virtclass-native_prepend = "${@autotools_deps(d)}"
DEPENDS_virtclass-nativesdk_prepend = "${@autotools_deps(d)}"

inherit siteinfo

def _autotools_get_sitefiles(d):
    if oe.utils.inherits(d, 'native', 'nativesdk'):
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

acpaths = "default"
EXTRA_AUTORECONF = "--exclude=autopoint"

def autotools_set_crosscompiling(d):
	if not bb.data.inherits_class('native', d):
		return " cross_compiling=yes"
	return ""

def append_libtool_sysroot(d):
	if bb.data.getVar('LIBTOOL_HAS_SYSROOT', d, 1) == "yes":
		if bb.data.getVar('BUILD_SYS', d, 1) == bb.data.getVar('HOST_SYS', d, 1):
			return '--with-libtool-sysroot'
		else:
			return '--with-libtool-sysroot=${STAGING_DIR_HOST}'
	return ''

def distro_imposed_configure_flags(d):
	distro_features = bb.data.getVar('DISTRO_FEATURES', d, True) or ""
	distro_features = distro_features.split()
	flags = set()
	features = (('largefile', 'largefile'),
		('ipv6'     , 'ipv6'),
		('nls'      , 'nls'))

	for knob, cfgargs in features:
		if isinstance(cfgargs, basestring):
			cfgargs = [cfgargs]
		en_or_dis = knob in distro_features and "enable" or "disable"
		for flg in cfgargs:
			flags.add("--%s-%s" % (en_or_dis, flg))
	return " ".join(flags)

# EXTRA_OECONF_append = "${@autotools_set_crosscompiling(d)}"

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
		  ${@distro_imposed_configure_flags(d)} \
		"

oe_runconf () {
	if [ -x ${S}/configure ] ; then
		${S}/configure \
		${CONFIGUREOPTS} ${EXTRA_OECONF} "$@"
	else
		oefatal "no configure script found"
	fi
}

oe_autoreconf () {
	if [ x"${acpaths}" = xdefault ]; then
		acpaths=
		for i in `find ${S} -maxdepth 2 -name \*.m4|grep -v 'aclocal.m4'| \
			grep -v 'acinclude.m4' | sed -e 's,\(.*/\).*$,\1,'|sort -u`; do
			acpaths="$acpaths -I $i"
		done
	else
		acpaths="${acpaths}"
	fi
	AUTOV=`automake --version | head -n 1 | sed "s/.* //;s/\.[0-9]\+$//"`
	install -d ${STAGING_DATADIR}/aclocal
	install -d ${STAGING_DATADIR}/aclocal-$AUTOV
	acpaths="$acpaths -I${STAGING_DATADIR}/aclocal-$AUTOV -I ${STAGING_DATADIR}/aclocal"
	# autoreconf is too shy to overwrite aclocal.m4 if it doesn't look
	# like it was auto-generated.  Work around this by blowing it away
	# by hand, unless the package specifically asked not to run aclocal.
	if ! echo ${EXTRA_AUTORECONF} | grep -q "aclocal"; then
		rm -f aclocal.m4
	fi
	if [ -e configure.in ]; then
		CONFIGURE_AC=configure.in
	else
		CONFIGURE_AC=configure.ac
	fi
	if grep "^[[:space:]]*AM_GLIB_GNU_GETTEXT" $CONFIGURE_AC >/dev/null; then
		if grep "sed.*POTFILES" $CONFIGURE_AC >/dev/null; then
			: do nothing -- we still have an old unmodified configure.ac
		else
			echo "no" | glib-gettextize --force --copy
		fi
	else if grep "^[[:space:]]*AM_GNU_GETTEXT" $CONFIGURE_AC >/dev/null; then
		if [ -e ${STAGING_DATADIR}/gettext/config.rpath ]; then
			cp ${STAGING_DATADIR}/gettext/config.rpath ${S}/
		else
			oenote ${STAGING_DATADIR}/gettext/config.rpath not found. gettext is not installed.
		fi
	fi

	fi
	for aux in m4 `sed -n -e '/^[[:space:]]*AC_CONFIG_MACRO_DIR/s|[^(]*([[]*\([^])]*\)[]]*)|\1|p' $CONFIGURE_AC`; do
		mkdir -p ${aux}
	done
	autoreconf -Wcross --verbose --install --force ${EXTRA_AUTORECONF} $acpaths || oefatal "autoreconf execution failed."
	if grep "^[[:space:]]*[AI][CT]_PROG_INTLTOOL" $CONFIGURE_AC >/dev/null; then
		intltoolize --copy --force --automake
	fi
}

autotools_do_configure() {
	case ${PN} in
	autoconf*|automake*)
	;;
	*)
		find ${S} -name configure.in -o -name configure.ac | \
			while read fn; do
				rm -f `dirname $fn`/configure
			done
		if [ -e ${S}/configure.in -o -e ${S}/configure.ac ]; then
			olddir=`pwd`
			cd ${S}
			oe_autoreconf
			cd $olddir
		fi
	;;
	esac
	if [ -e ${S}/configure ]; then
		oe_runconf $@
	else
		oenote "nothing to configure"
	fi
}

autotools_do_install() {
	oe_runmake 'DESTDIR=${D}' install
}

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

EXPORT_FUNCTIONS do_configure do_install

