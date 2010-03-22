DESCRIPTION = "OSI Certified implementation of a complete cluster engine"
LICENSE = "BSD"

SRC_URI = " \
	ftp://ftp@corosync.org/downloads/corosync-${PV}/corosync-${PV}.tar.gz;name=tar \
	file://fix-lcrso-linkage.patch;patch=1 \
	file://init \
	file://corosync.conf \
	file://volatiles \
	"
SRC_URI[tar.md5sum] = "789bea831a97977e56900477c3022cc1"
SRC_URI[tar.sha256sum] = "3cee3be9f747c7031da9eafdffa5e3009513f4ac93ce021a49574e3de1fd93f0"

inherit autotools_stage update-rc.d

INITSCRIPT_NAME = "corosync-daemon"

EXTRA_OECONF = "--disable-nss"

FILES_${PN}-dbg += "${libexecdir}/lcrso/.debug"

do_install_append() {
	install -d ${D}/${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/default/volatiles
	install -m 0755 ${WORKDIR}/init ${D}/${sysconfdir}/init.d/corosync-daemon
	install -m 0644 ${WORKDIR}/corosync.conf ${D}/${sysconfdir}/corosync/corosync.conf.example
	install -m 0644 ${WORKDIR}/volatiles ${D}${sysconfdir}/default/volatiles/05_corosync
}

pkg_postinst_${PN} () {
	set -e
	grep haclient /etc/group || addgroup haclient
	grep hacluster /etc/passwd || adduser --disabled-password --home=/var/lib/heartbeat --ingroup haclient -g "HA cluster" hacluster
	/etc/init.d/populate-volatile.sh update
}
