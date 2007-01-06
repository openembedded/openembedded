DESCRIPTION = "Common Opie pictures usable from all applications"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

S = "${WORKDIR}"

SHIP_INLINE_PICS = "yes"
INLINE_PICS_smallscreen = "pics/inline"
INLINE_PICS_bigscreen = "pics-hires/inline"

do_install() {
	install -d ${D}${palmtopdir}/pics/addressbook/
	install -d ${D}${palmtopdir}/pics/datebook/
	install -d ${D}${palmtopdir}/pics/todo/
	install -m 0664 pics/*.png ${D}${palmtopdir}/pics/
	install -m 0664 pics/addressbook/*.png ${D}${palmtopdir}/pics/addressbook/
	install -m 0664 pics/datebook/*.png ${D}${palmtopdir}/pics/datebook/
	install -m 0664 pics/todo/*.png ${D}${palmtopdir}/pics/todo/	

	if [ "${SHIP_INLINE_PICS}" == "yes" ]; then
		install -m 0664 ${INLINE_PICS_${GUI_MACHINE_CLASS}}/*.png ${D}${palmtopdir}/pics/
	fi
}

FILES_${PN} = "${palmtopdir}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

