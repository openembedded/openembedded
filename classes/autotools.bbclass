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

	return deps + 'gnu-config-native '

DEPENDS_prepend = "${@autotools_deps(d)}"
DEPENDS_virtclass-native_prepend = "${@autotools_deps(d)}"
DEPENDS_virtclass-nativesdk_prepend = "${@autotools_deps(d)}"

acpaths = "default"
EXTRA_AUTORECONF = "--exclude=autopoint"

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
			mkdir -p m4
			autoreconf -Wcross --verbose --install --force ${EXTRA_AUTORECONF} $acpaths || oefatal "autoreconf execution failed."
			if grep "^[[:space:]]*[AI][CT]_PROG_INTLTOOL" $CONFIGURE_AC >/dev/null; then
				intltoolize --copy --force --automake
			fi
			cd $olddir
		fi
	;;
	esac
	autotools_base_do_configure
}

EXPORT_FUNCTIONS do_configure
