DESCRIPTION = "OSI Certified implementation of a complete cluster engine"
LICENSE = "BSD"

PR = "r0"

SRC_URI = " \
	ftp://ftp@corosync.org/downloads/corosync-${PV}/corosync-${PV}.tar.gz;name=tar \
	file://fix-lcrso-linkage.patch \
	file://init \
	file://corosync.conf \
	file://volatiles \
	"
SRC_URI[tar.md5sum] = "cba5eb5da41630f53e54b90c449c056d"
SRC_URI[tar.sha256sum] = "d919d9817c4cde9e3d38e6f79731d9e1cd53485c6160bd253d888fa58a87a43d"

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
