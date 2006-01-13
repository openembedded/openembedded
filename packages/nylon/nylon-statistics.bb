DESCRIPTION = "statistics & graphing for nylon"
RDEPENDS = "rrdtool"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "GPLv2"
PV = "1:0.0+cvs${SRCDATE}"
PR = "r1"

SRC_URI = "http://meshcube.org/download/${PN}_${SRCDATE}.tgz"
S = "${WORKDIR}/${PN}"

do_install() {
	install -d ${D}/srv/www/cgi-bin
	install -d ${D}${sbindir}
	ln -s /var/tmp ${D}/srv/www/rrd-img
	install -m 755 ${S}/*.html ${D}/srv/www/cgi-bin
	ln -s /var/tmp/nav.inc.html ${D}/srv/www/cgi-bin
	install -m 755 ${S}/collect.sh ${D}${sbindir}
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
