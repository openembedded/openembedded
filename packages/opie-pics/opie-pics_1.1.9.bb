DESCRIPTION = "Common Opie pictures usable from all applications"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PR = "r0"


SRC_URI = "${HANDHELDS_CVS};module=opie/pics;tag=${TAG}"
S = "${WORKDIR}/pics"

do_install() {
	install -d ${D}${palmtopdir}/pics/addressbook/
	install -d ${D}${palmtopdir}/pics/datebook/
	install -d ${D}${palmtopdir}/pics/todo/
	install -m 0664 *.png ${D}${palmtopdir}/pics/
	install -m 0664 addressbook/*.png ${D}${palmtopdir}/pics/addressbook/
	install -m 0664 datebook/*.png ${D}${palmtopdir}/pics/datebook/
	install -m 0664 todo/*.png ${D}${palmtopdir}/pics/todo/	
	
}

FILES_${PN} = "${palmtopdir}"
