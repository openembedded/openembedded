SECTION = "console/network"
DEPENDS = "db3 pcre postfix-native"
LICENSE = "IPL"
SRC_URI = "ftp://ftp.porcupine.org/mirrors/postfix-release/official/postfix-${PV}.tar.gz \
	   file://${FILESDIR}/makedefs.patch;patch=1 \
	   file://${FILESDIR}/install.patch;patch=1"
S = "${WORKDIR}/postfix-${PV}"

export SYSLIBS = "-lpcre -ldb -lnsl -lresolv ${LDFLAGS}"
export EXPORT = "AUXLIBS='-lpcre' CCARGS='-DHAS_PCRE ${CFLAGS}' OPT='' DEBUG='-g'"
export CC_append = " -DHAS_PCRE ${CFLAGS}"
export EXTRA_OEMAKE = "-e"
export POSTCONF = "${STAGING_BINDIR}/postconf"

do_compile () {
	unset CFLAGS CPPFLAGS CXXFLAGS
	oe_runmake makefiles
	oe_runmake
}

do_install () {
	sh ./postfix-install 'install_root=${D}' -non-interactive
}
