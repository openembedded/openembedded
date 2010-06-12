DESCRIPTION = "OSI Certified implementation of a complete cluster engine"
LICENSE = "BSD"

PR = "r0"

SRC_URI = " \
	ftp://ftp@corosync.org/downloads/corosync-${PV}/corosync-${PV}.tar.gz \
	file://fix-lcrso-linkage.patch \
	file://init \
	file://corosync.conf \
	file://volatiles \
	"
SRC_URI[md5sum] = "03b8cc311619c07ae1a84a5d59f13d0b"
SRC_URI[sha256sum] = "4dd2aa43d82bb22c9bfed146da4ea2e07134d413a42f164dff86da9f34719fc9"

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
