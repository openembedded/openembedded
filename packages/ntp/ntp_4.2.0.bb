require ntp.inc

PR = "r9"

SRC_URI = "http://www.eecis.udel.edu/~ntp/ntp_spool/ntp4/ntp-4.2/${P}.tar.gz \
	file://ntpdc.Makefile.am.maybe-layout.patch;patch=1 \
	file://ipv6only-workaround.patch;patch=1 \
        file://gcc4.patch;patch=1 \
	file://ntpd \
	file://ntp.conf \
	file://ntpdate"

PROVIDES = "ntpdate-${PV} ntpdate-${PV}-${PR} ntpdate"

#This is too painful - perl is only needed for ntp-wait and ntptrace, which are
#perl scripts, and installing perl is an enormous overhead for a user who only
#needs ntpq
#RDEPENDS_ntp-bin = perl
# ntp originally includes tickadj. It's split off for inclusion in small firmware images on platforms
# with wonky clocks (e.g. OpenSlug)
RDEPENDS_${PN} = "${PN}-tickadj"
FILES_${PN}-bin = "${bindir}/ntp-wait ${bindir}/ntpdc ${bindir}/ntpq ${bindir}/ntptime ${bindir}/ntptrace"
FILES_${PN} = "${bindir}/ntpd ${sysconfdir}/ntp.conf ${sysconfdir}/init.d/ntpd"
FILES_${PN}-tickadj = "${bindir}/tickadj"

do_install_append() {
	install -d ${D}/${sysconfdir}/init.d
	install -m 644 ${WORKDIR}/ntp.conf ${D}/${sysconfdir}
	install -m 755 ${WORKDIR}/ntpdate ${D}/${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/ntpd ${D}/${sysconfdir}/init.d
}

pkg_postinst_ntpdate_nylon() {
if test "x$D" != "x"; then
	exit 1
else
	if ! grep -q ntpdate /etc/cron/crontabs/root; then
		echo "adding crontab"
		test -d /etc/cron/crontabs || mkdir -p /etc/cron/crontabs
		echo "30 * * * *    /usr/bin/ntpdate -s -u pool.ntp.org" >> /etc/cron/crontabs/root
	fi
	update-rc.d -s busybox-cron defaults
	update-rc.d -s ntpdate defaults 30
fi
}
