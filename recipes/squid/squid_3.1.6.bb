PR = "${INC_PR}.0"

include squid.inc

# GPLv2+ since 2.6.STABLE18
LICENSE = "GPL"

EXTRA_OECONF += "--enable-epoll --enable-icap-client --with-dl --enable-linux-netfilter"

EXTRA_OEMAKE += "DEFAULT_STYLESHEET=${sysconfdir}/squid/errorpage.css DEFAULT_CONFIG_DIR=${sysconfdir}/squid"

SRC_URI += " \
	file://squidv3-build-cf_gen.patch \
	file://fix-runs-in-configure.patch \
	"

SRC_URI[squid-3.1.6.md5sum] = "e9e2e9a9b5a305ba717be93ebb85f245"
SRC_URI[squid-3.1.6.sha256sum] = "e1de72d85a1b607e7dd477e29c4582b34f844af675211cb273421c920073f4fa"

do_configure_prepend() {
	export ac_cv_epoll_ctl=yes
	export ac_cv_epoll_works=yes
	export ac_cv_func_setresuid=yes
}

do_install_append() {
	mv ${D}${sysconfdir}/squid.conf.documented ${D}${sysconfdir}/squid/
}
