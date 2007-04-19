DESCRIPTION = "Dreamcrypt/Firecrypt Conditional Access Daemon"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PV = "1.1"
PR = "r2"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/dccamd-${MACHINE}-${PV} \
	    http://sources.dreamboxupdate.com/download/7020/wdog-${MACHINE} \
	    file://dccamd.sh"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

do_install() {
	install -d ${D}/usr/bin
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/dccamd-${MACHINE}-${PV} ${D}/usr/bin/dccamd
	install -m 0755 ${WORKDIR}/wdog-${MACHINE} ${D}/usr/bin/wdog
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/"
