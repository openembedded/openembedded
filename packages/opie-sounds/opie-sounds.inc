DESCRIPTION = "Common Opie Sounds"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

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
