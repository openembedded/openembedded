DESCRIPTION = "Bluetooth manager for Opie"
SECTION = "opie/settings"
PRIORITY = "optional"
DEPENDS = "libopietooth1 obexftp"
RDEPENDS_${PN} = "opie-bluepin"
LICENSE = "GPL"
APPNAME = "bluetooth-manager"

S = "${WORKDIR}/manager"

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${STAGING_INCDIR}/opietooth"
EXTRA_QMAKEVARS_PRE += "LIBOBEXFTP_INC_DIR=${STAGING_INCDIR}/obexftp"

inherit opie

# Files: plugins/application/libbluetooth-manager.so* bin/bluetooth-manager apps/Settings/bluetooth-manager.desktop pics/opietooth/* pics/opietooth/icons/*
do_install() {
        install -d ${D}${palmtopdir}/pics/opietooth/
        install -d ${D}${palmtopdir}/pics/opietooth/icons/
        install -m 0644 ${WORKDIR}/pics/opietooth/*.png ${D}${palmtopdir}/pics/opietooth/
        install -m 0644 ${WORKDIR}/pics/opietooth/icons/*.png ${D}${palmtopdir}/pics/opietooth/icons/
}
