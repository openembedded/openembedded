DESCRIPTION = "Common Opie pictures usable from all applications"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

S = "${WORKDIR}"

SHIP_INLINE_PICS = "yes"
INLINE_PICS = "pics/inline"
INLINE_PICS_tosa  = "pics-hires/inline"
INLINE_PICS_c7x0  = "pics-hires/inline"
INLINE_PICS_spitz = "pics-hires/inline"
INLINE_PICS_akita = "pics-hires/inline"

do_install() {
	install -d ${D}${palmtopdir}/pics/addressbook/
	install -d ${D}${palmtopdir}/pics/datebook/
	install -d ${D}${palmtopdir}/pics/todo/
	install -m 0664 pics/*.png ${D}${palmtopdir}/pics/
	install -m 0664 pics/addressbook/*.png ${D}${palmtopdir}/pics/addressbook/
	install -m 0664 pics/datebook/*.png ${D}${palmtopdir}/pics/datebook/
	install -m 0664 pics/todo/*.png ${D}${palmtopdir}/pics/todo/	

	if [ "${SHIP_INLINE_PICS}" == "yes" ]; then
		install -m 0664 ${INLINE_PICS}/*.png ${D}${palmtopdir}/pics/
	fi
}

FILES_${PN} = "${palmtopdir}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

