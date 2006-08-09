DESCRIPTION = "Dreamcrypt/Firecrypt Conditional Access Daemon"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PV = "1.0"
PR = "r2"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/dccamd-${MACHINE} \
	    http://sources.dreamboxupdate.com/download/7020/wdog-${MACHINE} \
	    file://dccamd.sh"

S = "${WORKDIR}"

inherit update-rc.d

INHIBIT_PACKAGE_STRIP = "1"

INITSCRIPT_NAME = "dccamd"
INITSCRIPT_PARAMS = "start 40 S ."

do_install() {
	install -d ${D}/usr/bin
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/dccamd.sh ${D}/etc/init.d/dccamd
	md5sum ${WORKDIR}/dccamd-${MACHINE}
	install -m 0755 ${WORKDIR}/dccamd-${MACHINE} ${D}/usr/bin/dccamd
	md5sum ${D}/usr/bin/dccamd
	install -m 0755 ${WORKDIR}/wdog-${MACHINE} ${D}/usr/bin/wdog
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/"
