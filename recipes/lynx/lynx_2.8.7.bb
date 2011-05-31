DESCRIPTION = "text web browser"
SECTION = "console/network"
DEPENDS = "ncurses openssl"
LICENSE = "GPL"
HOMEPAGE = "http://lynx.isc.org/"
PR = "r0"
S = "${WORKDIR}/${PN}${@bb.data.getVar('PV',d,1).replace('.', '-')}"

SRC_URI = "http://lynx.isc.org/${PN}${PV}/${PN}${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--with-ssl=${STAGING_DIR_HOST}${layout_exec_prefix} --with-curses-dir=${STAGING_DIR_HOST}${layout_exec_prefix} --enable-nls --with-screen=ncursesw --enable-locale-charset --enable-ipv6 --enable-persistent-cookies"

do_configure() {
	# prevent import of ncursesw6-config from host system
	# only ncurses-config (version 5) is available in the tree
	sed -i 's/}6/}6-does-not-exist-in-oe/g' aclocal.m4 configure
	# configure.in cannot be easily rebuilt
	oe_runconf\
	ac_cv_path_TELNET=${bindir}/telnet\
	ac_cv_path_TN3270=no\
	ac_cv_path_RLOGIN=${bindir}/rlogin\
	ac_cv_path_MV=/bin/mv\
	ac_cv_path_GZIP=/bin/gzip\
	ac_cv_path_UNCOMPRESS=/bin/gunzip\
	ac_cv_path_UNZIP=${bindir}/unzip\
	ac_cv_path_BZIP2=${bindir}/bzip2\
	ac_cv_path_TAR=/bin/tar\
	ac_cv_path_COMPRESS=no\
	ac_cv_path_RM=/bin/rm\
	ac_cv_path_UUDECODE=${bindir}/uudecode\
	ac_cv_path_UUDECODE=${bindir}/uudecode\
	ac_cv_path_ZCAT=/bin/zcat\
	ac_cv_path_ZIP=${bindir}/zip\
	ac_cv_path_INSTALL=${bindir}/install
}

SRC_URI[md5sum] = "cb936aef812e4e463ab86cbbe14d4db9"
SRC_URI[sha256sum] = "301bda96ad3cd5032805e8d5315a42061a11e472e3d3a7baee3a2879517ef627"
