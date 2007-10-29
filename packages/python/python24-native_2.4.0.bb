DESCRIPTION = "Python Programming Language"
HOMEPAGE = "http://www.python.org"
LICENSE = "PSF"
SECTION = "devel/python"
PRIORITY = "optional"
DEPENDS = ""
PR = "r2"

EXCLUDE_FROM_WORLD = "1"

SRC_URI = "http://www.python.org/ftp/python/2.4/Python-2.4.tar.bz2 \
           file://bindir-libdir.patch;patch=1 \
           file://cross-distutils.patch;patch=1 \
           file://dont-modify-shebang-line.patch;patch=1"
S = "${WORKDIR}/Python-2.4"

inherit autotools native

prefix = "${STAGING_DIR_NATIVE}${layout_prefix}"
exec_prefix = "${STAGING_DIR_NATIVE}${layout_exec_prefix}"

EXTRA_OECONF = "--with-threads --with-pymalloc --with-cyclic-gc \
                --without-cxx --with-signal-module --with-wctype-functions"
EXTRA_OEMAKE = 'BUILD_SYS="" HOST_SYS=""'

do_configure() {
	# the autofoo stuff is too old to allow regenerating
	oe_runconf
}

do_stage_append() {
	# install pgen for later usage with non-native builds
	install Parser/pgen ${STAGING_BINDIR_NATIVE}/
}

