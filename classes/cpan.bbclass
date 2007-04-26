#
# This is for perl modules that use the old Makefile.PL build system
#
FILES_${PN} += '${libdir}/perl5 ${datadir}/perl5'
EXTRA_CPANFLAGS ?= ""

DEPENDS  += "perl-native"
RDEPENDS += "perl"

# Determine the staged version of perl from the perl configuration file
def get_perl_version(d):
	import os, bb, re
    	cfg = bb.data.expand('${STAGING_DIR}/${HOST_SYS}/perl/config.sh', d)
	try:
		f = open(cfg, 'r')
	except IOError:
		return None
	l = f.readlines();
	f.close();
	r = re.compile("version='(\d\.\d\.\d)'")
	for s in l:
		m = r.match(s)
		if m:
			return m.group(1)
	return None

# Only 5.8.7 and 5.8.4 existed at the time we moved to the new layout
def is_new_perl(d):
    	ver = get_perl_version(d)
	if ver == "5.8.4" or ver == "5.8.7":
		return "no"
	return "yes"

IS_NEW_PERL = "${@is_new_perl(d)}"

cpan_do_configure () {
	perl Makefile.PL ${EXTRA_CPANFLAGS}
	if [ "${BUILD_SYS}" != "${HOST_SYS}" ]; then
		. ${STAGING_DIR}/${TARGET_SYS}/perl/config.sh
		if [ "${IS_NEW_PERL}" = "yes" ]; then
			sed -i -e "s:\(SITELIBEXP = \).*:\1${sitelibexp}:" \
				-e "s:\(SITEARCHEXP = \).*:\1${sitearchexp}:" \
				-e "s:\(INSTALLVENDORLIB = \).*:\1${D}${datadir}/perl5:" \
				-e "s:\(INSTALLVENDORARCH = \).*:\1${D}${libdir}/perl5:" \
				-e "s:\(LDDLFLAGS.*\)${STAGING_DIR}/${BUILD_SYS}/lib:\1${STAGING_LIBDIR}:" \
				Makefile
		else
			sed -i -e "s:\(SITELIBEXP = \).*:\1${sitelibexp}:" \
				-e "s:\(SITEARCHEXP = \).*:\1${sitearchexp}:" \
				-e "s:\(INSTALLVENDORLIB = \).*:\1${D}${libdir}/perl5/site_perl/${version}:" \
				-e "s:\(INSTALLVENDORARCH = \).*:\1${D}${libdir}/perl5/site_perl/${version}:" \
				-e "s:\(LDDLFLAGS.*\)${STAGING_DIR}/${BUILD_SYS}/lib:\1${STAGING_LIBDIR}:" \
				Makefile
		fi
	fi
}

cpan_do_compile () {
	if [ "${IS_NEW_PERL}" = "yes" ]; then
		oe_runmake PASTHRU_INC="${CFLAGS}" CCFLAGS="${CFLAGS}" LD=${TARGET_SYS}-gcc
	else
		# You must use gcc to link on sh
		OPTIONS=""
		if test ${TARGET_ARCH} = "sh3" -o ${TARGET_ARCH} = "sh4"; then
			OPTIONS="LD=${TARGET_ARCH}-${TARGET_OS}-gcc"
		fi
		if test ${TARGET_ARCH} = "powerpc" ; then
			OPTIONS="LD=${TARGET_ARCH}-${TARGET_OS}-gcc"
		fi
		oe_runmake PASTHRU_INC="${CFLAGS}" CCFLAGS="${CFLAGS}" $OPTIONS
	fi
}

cpan_do_install () {
	oe_runmake install_vendor
}

EXPORT_FUNCTIONS do_configure do_compile do_install
