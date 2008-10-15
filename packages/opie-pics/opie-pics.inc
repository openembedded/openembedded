DESCRIPTION = "Common Opie pictures usable from all applications"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r2"

S = "${WORKDIR}"

SHIP_INLINE_PICS = "yes"
INLINE_PICS = '${@base_conditional("GUI_MACHINE_CLASS", "bigscreen", "pics-hires/inline", "pics/inline", d)}'

do_install() {
	install -d ${D}${palmtopdir}/pics/addressbook/
	install -d ${D}${palmtopdir}/pics/datebook/
	install -d ${D}${palmtopdir}/pics/todo/
	install -d ${D}${palmtopdir}/pics/opie/
	install -m 0664 pics/*.png ${D}${palmtopdir}/pics/
	install -m 0664 pics/addressbook/*.png ${D}${palmtopdir}/pics/addressbook/
	install -m 0664 pics/datebook/*.png ${D}${palmtopdir}/pics/datebook/
	install -m 0664 pics/todo/*.png ${D}${palmtopdir}/pics/todo/	
	install -m 0664 pics/opie/*.png ${D}${palmtopdir}/pics/opie/	

	if [ "${SHIP_INLINE_PICS}" == "yes" ]; then
		install -m 0664 ${INLINE_PICS}/*.png ${D}${palmtopdir}/pics/
	fi
}

FILES_${PN} = "${palmtopdir}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

