DESCRIPTION = "This package provides the nylon specific init and configuration scripts."
HOMEPAGE = "http://meshcube.org/meshwiki/NyLon"
DEPENDS = "hostap-utils"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "GPLv2"
PV = "cvs${CVSDATE}"

SRC_URI = "svn://meshcube.org/svn/scripts;module=${PN};proto=http"
S = "${WORKDIR}/${PN}"

do_install() {
	(cd ${S}; tar -c --exclude .svn -f - . ) | tar -C ${D} -xpf -
}

pkg_postinst() {
#!/bin/sh
update-rc.d hostap defaults 14
update-rc.d bridge defaults 15
update-rc.d ipaliases defaults 16
update-rc.d firewall defaults 20
update-rc.d routing defaults 20
update-rc.d emergency-ip defaults 98
update-rc.d flash-backup start 38 S . stop 38 0 6 .
update-rc.d dummydate start 50 S . stop 50 0 6 .
if test "x$D" == "x"; then
	mkdir -p /etc/cron/crontabs
	if ! grep -q flash-backup /etc/cron/crontabs/root; then
		echo "adding crontab"
		echo "0 * * * *    /etc/init.d/flash-backup backup" >> /etc/cron/crontabs/root
	fi
	update-rc.d -s busybox-cron defaults
fi
}

pkg_postrm() {
#!/bin/sh -e
update-rc.d hostap remove
update-rc.d bridge remove
update-rc.d ipaliases remove
update-rc.d firewall remove
update-rc.d routing remove
update-rc.d emergency-ip remove
update-rc.d flash-backup remove
update-rc.d dummydate remove
}

CONFFILES_${PN} = "/etc/nylon/backup.list /etc/nylon/bridge.conf /etc/nylon/configip.conf /etc/nylon/hostap.conf /etc/nylon/interfaces.conf /etc/nylon/macfilter.list /etc/nylon/route.list"
