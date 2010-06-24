DESCRIPTION = "OSI Certified implementation of a complete cluster engine"
LICENSE = "BSD"

PR = "r1"

SRC_URI = " \
	ftp://ftp@corosync.org/downloads/corosync-${PV}/corosync-${PV}.tar.gz \
	file://fix-lcrso-linkage.patch \
	file://init \
	file://corosync.conf \
	file://volatiles \
	"
SRC_URI[md5sum] = "82d91373585f0d48cb98a8599a237e48"
SRC_URI[sha256sum] = "ad41e3133659a5fb32e878aa85199aba6cc84aa5e0e913b4f6e31c4a4805f9d9"


inherit autotools_stage update-rc.d

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
