PR = "${INC_PR}.0"

include squid.inc

EXTRA_OECONF += "--enable-epoll --enable-icap-client --with-dl --enable-linux-netfilter"

EXTRA_OEMAKE += "DEFAULT_STYLESHEET=${sysconfdir}/squid/errorpage.css DEFAULT_CONFIG_DIR=${sysconfdir}/squid"

SRC_URI += " \
	file://squidv3-build-cf_gen.patch \
	file://fix-runs-in-configure.patch \
	"

SRC_URI[squid-3.1.7.md5sum] = "83e7aabc1b5bb5b7c83f6dc2f32ca418"
SRC_URI[squid-3.1.7.sha256sum] = "5252180a262bdd2cc4ab8afe40c1989c21035bdfe4eaa0bcb19589e3d316d4ac"


do_configure_prepend() {
	export ac_cv_epoll_ctl=yes
	export ac_cv_epoll_works=yes
	export ac_cv_func_setresuid=yes
}

do_install_append() {
	mv ${D}${sysconfdir}/squid.conf.documented ${D}${sysconfdir}/squid/
}
