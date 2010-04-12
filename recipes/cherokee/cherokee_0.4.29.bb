# Cherokee web server
DESCRIPTION = "Cherokee Web Server fast and secure"
LICENSE = "GPL"
SECTION = "network"
DEPENDS = "openssl libpcre"
SRC_URI = "http://www.0x50.org/download/0.4/${PV}/${P}.tar.gz \
	  file://configure.patch;patch=1 \
	  file://Makefile.in.patch;patch=1 \
	  file://Makefile.cget.patch;patch=1 \
	  file://util.patch;patch=1"
INC_PR = "r7"
PR = "${INC_PR}.0"

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

SRC_URI[md5sum] = "854e6e61a69781746496012658d8ef98"
SRC_URI[sha256sum] = "7091536ef2a51d2548ac6268cc846dda9c37f7f7348597868c793f42b9be7d78"