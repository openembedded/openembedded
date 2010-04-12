DESCRIPTION = "statistics & graphing for nylon"
RDEPENDS = "rrdtool"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPLv2"
#SRCDATE = "20050909"
SRCDATE = "20051022"
PV = "1.0.0+cvs${SRCDATE}"
PR = "r1"

SRC_URI = "http://download.berlin.freifunk.net/meshcube.org/nylon/stable/sources/${PN}_gruen.4g__${SRCDATE}.tar.gz"
S = "${WORKDIR}/${PN}"
INHIBIT_PACKAGE_STRIP = "1"

do_install() {
	install -d ${D}/srv/www/cgi-bin
	install -d ${D}/${sbindir}
	ln -s /var/tmp ${D}/srv/www/rrd-img
	install -m 755 ${S}/*.html ${D}/srv/www/cgi-bin
	ln -s /var/tmp/nav.inc.html ${D}/srv/www/cgi-bin
	install -m 755 ${S}/collect.sh ${D}/${sbindir}
}

pkg_postinst() {
if test "x$D" != "x"; then
	exit 1
else
	if ! grep -q collect.sh /etc/cron/crontabs/root; then
		echo "adding crontab"
		test -d /etc/cron/crontabs || mkdir -p /etc/cron/crontabs
		echo "*/5 * * * *    ${sbindir}/collect.sh" >> /etc/cron/crontabs/root
	fi
	update-rc.d -s busybox-cron defaults
	/etc/init.d/busybox-cron reload
	if [ ! -e /etc/httpd.conf ]; then
		echo "A:*" > /etc/httpd.conf
	fi
	update-rc.d -s busybox-httpd defaults

	if ! grep -q "/var/lib/rrd/" /etc/nylon/backup.list; then
		echo "adding to backup list"
		echo "/var/lib/rrd/" >> /etc/nylon/backup.list
	fi
fi
}

FILES_${PN} += "/srv"

SRC_URI[md5sum] = "318a328926d72b61e689673b90d53f17"
SRC_URI[sha256sum] = "c532fe3a05417cd28d27e81839733d162a133a01bbd1acf8600796351d0a3f8b"
