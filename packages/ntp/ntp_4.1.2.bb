DESCRIPTION = "The Network Time Protocol (NTP) is used to \
synchronize the time of a computer client or server to \
another server or reference time source, such as a radio \
or satellite receiver or modem."
HOMEPAGE = "http://ntp.isc.org/bin/view/Main/WebHome"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "ntp"
PR = "r3"

SRC_URI = "http://www.eecis.udel.edu/~ntp/ntp_spool/ntp4/ntp-4.1/ntp-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://readline.patch;patch=1 \
	   file://ntpdate"

inherit autotools

EXTRA_OECONF = "--without-openssl"
CFLAGS_append = " -DPTYS_ARE_GETPT -DPTYS_ARE_SEARCHED"

PACKAGES =+ "ntpdate"

FILES_ntpdate = "${bindir}/ntpdate /etc/init.d/ntpdate"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/ntpdate ${D}${sysconfdir}/init.d
}

pkg_postinst_ntpdate_nylon() {
if test "x$D" != "x"; then
	exit 1
else
	if ! grep -q ntpdate /etc/cron/crontabs/root; then
		echo "adding crontab"
		test -d /etc/cron/crontabs || mkdir -p /etc/cron/crontabs
		echo "30 * * * *    ${bindir}/ntpdate -s -u pool.ntp.org" >> /etc/cron/crontabs/root
	fi
	update-rc.d -s busybox-cron defaults
	update-rc.d -s ntpdate defaults 30
fi
}
