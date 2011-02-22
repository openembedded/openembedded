PR = "${INC_PR}.1"

include squid.inc

EXTRA_OECONF += "--enable-epoll --enable-icap-client --with-dl --enable-linux-netfilter"

EXTRA_OEMAKE += "DEFAULT_STYLESHEET=${sysconfdir}/squid/errorpage.css DEFAULT_CONFIG_DIR=${sysconfdir}/squid"

SRC_URI += " \
	file://squidv3-build-cf_gen.patch \
	file://fix-runs-in-configure.patch \
	"

SRC_URI[squid-3.1.9.md5sum] = "896ace723445ac168986ba8854437ce3"
SRC_URI[squid-3.1.9.sha256sum] = "bcc0d8e391a442fdeef0fe4676d89eddfce3cd9d9391ba6c217b1aa57b378f03"

do_configure_prepend() {
	export ac_cv_epoll_ctl=yes
	export ac_cv_epoll_works=yes
	export ac_cv_func_setresuid=yes
	# Patch up the various config scripts to refer to sysroot
	for i in `find ${S} -name config.test`; do
	    sed -i -e 's|/usr|${STAGING_DIR_HOST}${exec_prefix}|g' \
	           -e 's|/opt|${STAGING_DIR_HOST}/opt|g' "$i"
	done
}

do_install_append() {
	mv ${D}${sysconfdir}/squid.conf.documented ${D}${sysconfdir}/squid/
}
