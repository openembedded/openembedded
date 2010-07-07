PR = "${INC_PR}.0"

include squid.inc

# GPLv2+ since 2.6.STABLE18
LICENSE = "GPL"

EXTRA_OECONF += "--enable-epoll --enable-icap-client --with-dl --enable-linux-netfilter"

EXTRA_OEMAKE += "DEFAULT_STYLESHEET=${sysconfdir}/squid/errorpage.css DEFAULT_CONFIG_DIR=${sysconfdir}/squid"

SRC_URI += " \
	file://squidv3-build-cf_gen.patch \
	file://fix-runs-in-configure.patch \
	file://fix-ltdl-usage.patch \
	"

SRC_URI[squid-3.1.4.md5sum] = "3fb544ae02fadc2b4085f62bb927e861"
SRC_URI[squid-3.1.4.sha256sum] = "13ea33907c64f417afaf596b04550cd950f57dc43357d309ffa92cfac2de58f6"

do_configure_prepend() {
	export ac_cv_epoll_ctl=yes
	export ac_cv_epoll_works=yes
	export ac_cv_func_setresuid=yes
}

do_install_append() {
	mv ${D}${sysconfdir}/squid.conf.documented ${D}${sysconfdir}/squid/
}
