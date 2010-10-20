inherit autotools_base

def autotools_deps(d):
	if bb.data.getVar('INHIBIT_AUTOTOOLS_DEPS', d, 1):
		return ''

	pn = bb.data.getVar('PN', d, 1)
	deps = ''

	if pn in ['autoconf-native', 'automake-native']:
		return deps
	deps += 'autoconf-native automake-native '

	if not pn in ['libtool', 'libtool-native', 'libtool-cross']:
		deps += 'libtool-native '
		if not bb.data.inherits_class('native', d) \
                        and not bb.data.inherits_class('cross', d) \
                        and not bb.data.inherits_class('sdk', d) \
                        and not bb.data.getVar('INHIBIT_DEFAULT_DEPS', d, 1):
                    deps += 'libtool-cross '
	return deps

DEPENDS_prepend = "${@autotools_deps(d)}"
DEPENDS_virtclass-native_prepend = "${@autotools_deps(d)}"
DEPENDS_virtclass-nativesdk_prepend = "${@autotools_deps(d)}"

acpaths = "default"
EXTRA_AUTORECONF = "--exclude=autopoint"

gnu_configize_here() {
	if [ -n "`_autoconf_trace AC_CANONICAL_BUILD`" ]; then
		macrodir="`_autoconf_trace AC_CONFIG_MACRO_DIR|cut -d: -f4|tail -n 1`"
		if [ -z "$macrodir" ]; then
			macrodir="."
		fi
		if [ ! -e ${STAGING_DATADIR_NATIVE}/gnu-config/config.sub ]; then
			oefatal "gnu-config data files missing"
		fi
		oenote "Updating config.sub and config.guess in $macrodir"
		ln -sf ${STAGING_DATADIR_NATIVE}/gnu-config/config.sub \
		    $macrodir/config.sub
		ln -sf ${STAGING_DATADIR_NATIVE}/gnu-config/config.guess \
		    $macrodir/config.guess
	fi
}

gnu_configize() {
	subdirs="`_autoconf_trace AC_CONFIG_SUBDIRS|cut -d: -f4`"
	for dir in $subdirs .; do
		if [ ! -e "$olddir/$dir" ]; then
			continue
		fi

		pushd $dir
		gnu_configize_here
		popd
	done
}

do_configure_prepend () {
	alias gnu-configize=gnu_configize
}

_autoconf_trace () {
	autoconf -t "$@" 2>/dev/null
}

oe_autoreconf () {
	aclocal "$@"
	for subdir in $(_autoconf_trace AC_CONFIG_SUBDIRS | cut -d: -f4); do
		pushd $subdir
		oe_autoreconf "$@"
		popd
	done

	rm -f configure
	autoreconf --install --symlink --force --no-recursive ${EXTRA_AUTORECONF} "$@"
	if [ -n "`_autoconf_trace AM_GLIB_GNU_GETTEXT`" ]; then
		if [ -e configure.in ]; then
			CONFIGURE_AC=$srcdir/configure.in
		else
			CONFIGURE_AC=$srcdir/configure.ac
		fi
		if grep -q "sed.*POTFILES" $CONFIGURE_AC; then
			: do nothing -- we still have an old unmodified configure.ac
		else
			echo "no" | glib-gettextize --force
		fi
	elif [ -n "`_autoconf_trace AM_GNU_GETTEXT`" ]; then
		if [ -e ${STAGING_DATADIR}/gettext/config.rpath ]; then
			ln -sf ${STAGING_DATADIR}/gettext/config.rpath .
		else
			oenote ${STAGING_DATADIR}/gettext/config.rpath not found. gettext is not installed.
		fi
	fi
	if [ -n "`_autoconf_trace AC_PROG_INTLTOOL -t IT_PROG_INTLTOOL`" ]; then
		intltoolize --force --automake
	fi

	gnu_configize_here
}

autotools_do_configure() {
	case ${PN} in
	autoconf*|automake*)
	;;
	*)
		if [ -e ${S}/configure.in -o -e ${S}/configure.ac ]; then
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
			pushd ${S}
			oe_autoreconf $acpaths
			popd
		fi
	;;
	esac
	if [ -e ${S}/configure ]; then
		oe_runconf $@
	else
		oenote "nothing to configure"
	fi
}

EXPORT_FUNCTIONS do_configure
