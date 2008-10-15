SECTION = "base"
DESCRIPTION = "netkit-base includes the inetd daemon."
LICENSE = "BSD"
PR = "r1"

SRC_URI = "ftp://ftp.uk.linux.org/pub/linux/Networking/netkit/netkit-base-${PV}.tar.gz \
           file://configure.patch;patch=1 \
           file://mconfig.patch;patch=1 \
           file://init \
           file://inetd.conf"

inherit update-rc.d

INITSCRIPT_NAME = "inetd"
INITSCRIPT_PARAMS = "start 20 2 3 4 5 . stop 20 0 1 6 ."

EXTRA_OEMAKE = "-C inetd"

do_compile () {
	oe_runmake 'CC=${CC}' 'LD=${LD}' all
}

do_install () {
	install -d ${D}${sysconfdir}/init.d ${D}${sbindir}
	install -m 0755 inetd/inetd ${D}${sbindir}/inetd
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/inetd
	install -m 0644 ${WORKDIR}/inetd.conf ${D}${sysconfdir}
}

