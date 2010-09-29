DESCRIPTION = "OSI Certified implementation of a complete cluster engine"
LICENSE = "BSD"
DEPENDS = "groff-native"

PR = "r1"

SRC_URI = " \
	ftp://ftp@corosync.org/downloads/corosync-${PV}/corosync-${PV}.tar.gz \
	file://fix-lcrso-linkage.patch \
	file://corosync-docs.patch \
	file://init \
	file://corosync.conf \
	file://volatiles \
	file://fix-define-semun-union.patch \
	"
SRC_URI[md5sum] = "43e97ef0d964ccb4063f40a4478eb679"
SRC_URI[sha256sum] = "424b0590e52a08cf9066f9edbac4edf84e9d9bff54dd5036fb681d917db02bc8"

inherit autotools update-rc.d

INITSCRIPT_NAME = "corosync-daemon"

EXTRA_OECONF = "--disable-nss"

FILES_${PN}-dbg += "${libexecdir}/lcrso/.debug"

do_install_append() {
	install -d ${D}/${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/default/volatiles
	# Original init script is too bashy
	rm -f ${D}/${sysconfdir}/init.d/corosync
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
