SECTION = "base"
DESCRIPTION = "netkit-base includes the inetd daemon."
LICENSE = "BSD"
SRC_URI = "ftp://ftp.uk.linux.org/pub/linux/Networking/netkit/netkit-base-${PV}.tar.gz \
           file://configure.patch;patch=1 \
           file://mconfig.patch;patch=1 \
           file://init \
           file://inetd.conf"

EXTRA_OEMAKE = "-C inetd"
do_compile () {
	oe_runmake 'CC=${CC}' 'LD=${LD}' all
}

do_install () {
	install -d ${D}${sysconfdir}/init.d ${D}${sbindir}
	install -m 0755 inetd/inetd ${D}${sbindir}/inetd
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/inetd
	install -m 0644 ${WORKDIR}/inetd.conf ${D}${sysconfdir}
}

pkg_postinst () {
	if test -n "${D}"; then
		D="-r $D"
	fi
	update-rc.d $D inetd start 20 2 3 4 5 . stop 20 0 1 6 .
}

pkg_prerm () {
	if test -n "${D}"; then
		D="-r $D"
	fi
	update-rc.d $D inetd remove
}
