# Cherokee web server
DESCRIPTION = "Cherokee Web Server fast and secure"
LICENSE = "GPL"
DEPENDS = "openssl pcre"
SRC_URI = "http://www.0x50.org/download/0.4/${PV}/${P}.tar.gz \
	  file://configure.patch;patch=1 \
	  file://Makefile.in.patch;patch=1 \
	  file://Makefile.cget.patch;patch=1 \
	  file://util.patch;patch=1"

inherit autotools

LEAD_SONAME = "libcherokee-base"

EXTRA_OECONF = "--enable-tls=openssl --disable-static --disable-nls"

do_configure() {
	gnu-configize
	oe_runconf
}

do_install_prepend () {
	$BUILD_CC -DHAVE_SYS_STAT_H -o cherokee_replace cherokee_replace.c
}
