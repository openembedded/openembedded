SECTION = "base"
DESCRIPTION = "netkit-base includes the inetd daemon."
LICENSE = "BSD"
PR = "r2"

SRC_URI = "ftp://ftp.uk.linux.org/pub/linux/Networking/netkit/netkit-base-${PV}.tar.gz \
           file://configure.patch \
           file://mconfig.patch \
           file://gcc4_buildfix.patch \
           file://init \
           file://inetd.conf"

inherit update-rc.d

INITSCRIPT_NAME = "inetd"
INITSCRIPT_PARAMS = "start 20 2 3 4 5 . stop 20 0 1 6 ."

EXTRA_OEMAKE = "-C inetd"

do_compile () {
        sed -e 's:^CC=.*:CC=${CC}:' \
            -e 's:^CFLAGS=.*:CFLAGS=${CFLAGS}:' \
            -e 's:^LDFLAGS=.*:LDFLAGS=${LDFLAGS}:' \
            -i ${S}/MCONFIG
        oe_runmake
}

do_install () {
	install -d ${D}${sysconfdir}/init.d ${D}${sbindir}
	install -m 0755 inetd/inetd ${D}${sbindir}/inetd
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/inetd
	install -m 0644 ${WORKDIR}/inetd.conf ${D}${sysconfdir}
}


SRC_URI[md5sum] = "1f0193358e92559ec0f598b09ccbc0ec"
SRC_URI[sha256sum] = "16dd81625ebfc8f5dcb0dfd2e6bac223aad325a9405d66a556fe349446b3c332"
