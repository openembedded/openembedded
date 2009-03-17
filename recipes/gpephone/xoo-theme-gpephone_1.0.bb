LICENSE     = "LiPS"
DESCRIPTION = "A neutral cellphone theme for Xoo."
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "xoo-vm"

SRC_URI = "file://gpephone.png \
           file://gpephone.xml"

FILES_${PN} += "${datadir}"

do_install () {
	install -d  ${D}${datadir}/xoo/
	install -m644 ${WORKDIR}/gpephone* ${D}${datadir}/xoo/
}
