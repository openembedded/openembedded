DESCRIPTION = "Common Opie Sounds"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.8+cvs-${CVSDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/sounds"
S = "${WORKDIR}/sounds"

SOUNDS = "alarm touchsound keysound"

do_install() {
        install -d ${D}${palmtopdir}/sounds/
        for i in ${SOUNDS}
        do
                install $i.wav ${D}${palmtopdir}/sounds/$i.wav
        done
}

FILES_${PN} = "${palmtopdir}"
