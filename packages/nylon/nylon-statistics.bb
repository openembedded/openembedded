DESCRIPTION = "statistics & graphing for nylon"
RDEPENDS = "rrdtool"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "GPLv2"

SRC_URI = "svn://meshcube.org/svn/application;module=${PN};proto=http"
S = "${WORKDIR}/${PN}"

do_install() {
	install -d ${D}/srv/www/cgi-bin
	install -d ${D}/${sbindir}
	ln -s /var/tmp ${D}/srv/www/rrd-img
	install -m 755 ${S}/*.html ${D}/srv/www/cgi-bin
	install -m 755 ${S}/collect.sh ${D}/${sbindir}
}

pkg_postinst() {
if test "x$D" == "x"; then
	mkdir -p /etc/cron/crontabs
	if ! grep -q collect.sh /etc/cron/crontabs/root; then
		echo "adding crontab"
		echo "*/5 * * * *    /usr/sbin/collect.sh" >> /etc/cron/crontabs/root
	fi
	update-rc.d -s busybox-cron defaults
	if [ ! -e /etc/httpd.conf ]; then
		echo "A:*" > /etc/httpd.conf
	fi	
	update-rc.d -s busybox-httpd defaults
fi
}

FILES_${PN} += "/srv"