DESCRIPTION = "Opie Package Manager"
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libipkg "
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "packagemanager"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/settings/${APPNAME};cvsdate=${CVSDATE} \
           ${HANDHELDS_CVS};module=opie/pics;cvsdate=${CVSDATE} \
           ${HANDHELDS_CVS};module=opie/apps"
S = "${WORKDIR}/${APPNAME}"

inherit opie

EXTRA_QMAKEVARS_PRE = 'LIBIPK_INC_DIR=${STAGING_INCDIR}/libipkg'

do_install() {
    install -d ${D}${palmtopdir}/pics/${APPNAME}
    install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}
