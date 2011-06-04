DESCRIPTION = "Opie Package Manager"
SECTION = "opie/settings"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "opkg"
APPNAME = "packagemanager"

S = "${WORKDIR}/${APPNAME}"

inherit opie

EXTRA_QMAKEVARS_PRE += "LIBIPK_INC_DIR=${STAGING_INCDIR}/libopkg"
export CONFIG_LIBOPK_DEP=y

do_install() {
    install -d ${D}${palmtopdir}/pics/${APPNAME}
    install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}
