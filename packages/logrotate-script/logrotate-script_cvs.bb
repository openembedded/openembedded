DESCRIPTION = "simple logrotate bash script"
RDEPENDS = "busybox"
SECTION = "admin"
PRIORITY = "optional"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "GPL"

SRC_URI = "svn://meshcube.org/svn/scripts;module=logrotate"
S = "${WORKDIR}/${PN}"

do_install() {
	(cd ${S}; tar -c --exclude .svn -f - . ) | tar -C ${D} -xpf -
}

pkg_postinst() {
#!/bin/sh -e
ROOTCRON=/etc/cron/crontabs/root

test -e /etc/cron/crontabs/root \
 && grep '^[^#].*logrotate' $ROOTCRON > /dev/null \
 || echo "*/5 * * * *       /bin/bash ${sbindir}/logrotate -m 0600 -o root -g root -s 800 -l 3 /tmp/messages" >> $ROOTCRON

/etc/init.d/cron restart

exit 0
}
