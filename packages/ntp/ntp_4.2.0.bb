DESCRIPTION = "The Network Time Protocol (NTP) is used to \
synchronize the time of a computer client or server to \
another server or reference time source, such as a radio \
or satellite receiver or modem."
HOMEPAGE = "http://ntp.isc.org/bin/view/Main/WebHome"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "ntp"
PR = "r3"
# OE core: this is here to prevent this version of ntp from
# changing OE distros other than openslug.  This code has
# only been tested on openslug.  Feel free to remove these lines!
DEFAULT_PREFERENCE = -1
DEFAULT_PREFERENCE_openslug = 0

SRC_URI = "http://www.eecis.udel.edu/~ntp/ntp_spool/ntp4/${P}.tar.gz \
	file://ntpdc.Makefile.am.maybe-layout.patch;patch=1 \
	file://ntpd \
	file://ntp.conf \
	file://ntpdate"


INITSCRIPT_NAME = "ntpd"
# No dependencies, so just go in at the standard level (20)
INITSCRIPT_PARAMS = "defaults"

inherit autotools update-rc.d

# The ac_cv_header_readline_history is to stop ntpdc depending on either
# readline or curses
EXTRA_OECONF = "--without-openssl --without-crypto ac_cv_header_readline_history_h=no"
CFLAGS_append = " -DPTYS_ARE_GETPT -DPTYS_ARE_SEARCHED"

PACKAGES = "ntpdate ntp-bin ntp"
# NOTE: you don't need ntpdate, use "ntpdc -q -g -x"
PROVIDES = "ntpdate-${PV} ntpdate-${PV}-${PR} ntpdate"

# This should use rc.update
FILES_ntpdate = "${bindir}/ntpdate ${sysconfdir}/init.d/ntpdate"
#This is too painful - perl is only needed for ntp-wait and ntptrace, which are
#perl scripts, and installing perl is an enormous overhead for a user who only
#needs ntpq
#RDEPENDS_ntp-bin = perl
FILES_ntp-bin = "${bindir}/ntp-wait ${bindir}/ntpdc ${bindir}/ntpq ${bindir}/ntptime ${bindir}/ntptrace"
FILES_ntp = "${bindir}/ntpd ${bindir}/tickadj ${sysconfdir}/ntp.conf ${sysconfdir}/init.d/ntpd"

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
