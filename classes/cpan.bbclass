#
# This is for perl modules that use the old Makefile.PL build system
#
inherit cpan-base

NATIVE_INSTALL_WORKS = "1"

cpan_do_configure () {
	yes '' | perl Makefile.PL ${EXTRA_CPANFLAGS}
	if [ "${BUILD_SYS}" != "${HOST_SYS}" ]; then
		. ${STAGING_LIBDIR}/perl/config.sh
		sed -i -e "s:\(SITELIBEXP = \).*:\1${sitelibexp}:" \
			-e "s:\(SITEARCHEXP = \).*:\1${sitearchexp}:" \
			-e "s:\(INSTALLVENDORLIB = \).*:\1${D}${datadir}/perl5:" \
			-e "s:\(INSTALLVENDORARCH = \).*:\1${D}${libdir}/perl5:" \
			-e "s:\(INSTALLVENDORMAN1DIR = \).*:\1${D}${man1dir}:" \
			-e "s:\(INSTALLVENDORMAN3DIR = \).*:\1${D}${man3dir}:" \
			-e "s:\(INSTALLVENDORBIN = \).*:\1${D}${bindir}:" \
			-e "s:\(INSTALLVENDORSCRIPT = \).*:\1${D}${bindir}:" \
			-e "s:\(LDDLFLAGS.*\)${STAGING_LIBDIR_NATIVE}:\1${STAGING_LIBDIR}:" \
			Makefile
	fi
}

cpan_do_compile () {
	oe_runmake PASTHRU_INC="${CFLAGS}" CCFLAGS="${CFLAGS}" LD="${CCLD}"
}

cpan_do_install () {
	oe_runmake DESTDIR="${D}" install_vendor
	for PERLSCRIPT in `grep -rIl '#!${bindir}/perl' ${D}`; do
		sed -i -e 's|^#!${bindir}/perl|#!/usr/bin/env perl|' $PERLSCRIPT
	done
}

EXPORT_FUNCTIONS do_configure do_compile do_install
