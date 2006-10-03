#
# This is for perl modules that use the old Makefile.PL build system
#
FILES_${PN} += '${libdir}/perl5'
EXTRA_CPANFLAGS = ""

DEPENDS  += "perl-native"
RDEPENDS += "perl"

cpan_do_configure () {
	perl Makefile.PL ${EXTRA_CPANFLAGS}
	if [ "${BUILD_SYS}" != "${HOST_SYS}" ]; then
		. ${STAGING_DIR}/${TARGET_SYS}/perl/config.sh
		sed -e "s:\(SITELIBEXP = \).*:\1${sitelibexp}:; s:\(SITEARCHEXP = \).*:\1${sitearchexp}:; s:\(INSTALLVENDORLIB = \).*:\1${D}${libdir}/perl5/site_perl/${version}:; s:\(INSTALLVENDORARCH = \).*:\1${D}${libdir}/perl5/site_perl/${version}:" < Makefile > Makefile.new
		mv Makefile.new Makefile
	fi
}

cpan_do_compile () {
	# You must use gcc to link on sh
	OPTIONS=""
	if test ${TARGET_ARCH} = "sh3" -o ${TARGET_ARCH} = "sh4"; then
		OPTIONS="LD=${TARGET_ARCH}-${TARGET_OS}-gcc"
	fi
        oe_runmake PASTHRU_INC="${CFLAGS}" CCFLAGS="${CFLAGS}" $OPTIONS
}

cpan_do_install () {
	oe_runmake install_vendor
}

EXPORT_FUNCTIONS do_configure do_compile do_install
