DESCRIPTION = "Developer Examples for Opie"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
DEPENDS = "opie-networksettings"
LICENSE = "GPL"
PV = "1.1.9+cvs-${CVSDATE}"
APPTYPE = "binary"
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/examples \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"
S = "${WORKDIR}/examples"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/bin/

        for i in `find . -perm 0755 -type f`
        do
                install -m 0755 $i ${D}${palmtopdir}/bin/`basename $i`
        done
}

