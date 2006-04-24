DESCRIPTION = "A Bible study program utilizing the Sword library."
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libopiecore2 libopieui2 sword"
APPNAME = "dagger"

EXTRA_QMAKEVARS_PRE += "LIBSWORD_INC_DIR=${STAGING_INCDIR}/sword"

S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

