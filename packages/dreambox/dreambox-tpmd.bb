DESCRIPTION = "Dreambox TPM Daemon"
SECTION = "base"
PRIORITY = "optional"
LICENSE = "proprietary"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

PV = "1"

SRC_URI = "http://sources.dreamboxupdate.com/download/7020/tpmd-${MACHINE}-${PV} \
	file://tpmd"

S = "${WORKDIR}"

INHIBIT_PACKAGE_STRIP = "1"

do_install() {
	install -d ${D}/usr/bin \
                   ${D}${sysconfdir}/init.d \
                   ${D}${sysconfdir}/rcS.d

	install -m 0755 ${WORKDIR}/tpmd-${MACHINE}-${PV} ${D}/usr/bin/tpmd
	install -m 0755 ${WORKDIR}/tpmd ${D}${sysconfdir}/init.d

	ln -sf ../init.d/tpmd ${D}${sysconfdir}/rcS.d/S10tpmd
}

PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/"
