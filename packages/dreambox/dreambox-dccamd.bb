DESCRIPTION = "Dreamcrypt/Firecrypt Conditional Access Daemon"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PV = "1.0"
PR = "r2"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/dccamd \
	    http://sources.dreamboxupdate.com/download/7020/wdog \
	    file://dccamd.sh"

S = "${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "dccamd"
INITSCRIPT_PARAMS = "start 40 S ."

do_install() {
	install -d ${D}/usr/bin
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/dccamd.sh ${D}/etc/init.d/dccamd
	install -m 0755 ${WORKDIR}/dccamd ${D}/usr/bin/dccamd
	install -m 0755 ${WORKDIR}/wdog ${D}/usr/bin/wdog
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/"
