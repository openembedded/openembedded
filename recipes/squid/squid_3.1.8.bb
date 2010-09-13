PR = "${INC_PR}.0"

include squid.inc

EXTRA_OECONF += "--enable-epoll --enable-icap-client --with-dl --enable-linux-netfilter"

EXTRA_OEMAKE += "DEFAULT_STYLESHEET=${sysconfdir}/squid/errorpage.css DEFAULT_CONFIG_DIR=${sysconfdir}/squid"

SRC_URI += " \
	file://squidv3-build-cf_gen.patch \
	file://fix-runs-in-configure.patch \
	"

SRC_URI[squid-3.1.8.md5sum] = "a8160dfba55ab7c400c622b72d39fc13"
SRC_URI[squid-3.1.8.sha256sum] = "088d4e798ca49e11713facccbd7ef3e7f9b16fc6eb86d59d0c43aa14d66501fe"

do_configure_prepend() {
	export ac_cv_epoll_ctl=yes
	export ac_cv_epoll_works=yes
	export ac_cv_func_setresuid=yes
}

do_install_append() {
	mv ${D}${sysconfdir}/squid.conf.documented ${D}${sysconfdir}/squid/
}
