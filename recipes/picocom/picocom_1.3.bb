DESCRIPTION = "Picocom is a lightweight and minimal (~20K) dumb-terminal emulation program. "
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
SRC_URI = "http://picocom.googlecode.com/files/picocom-${PV}.tar.gz"

CFLAGS_append = ' -DVERSION_STR=\\"${PV}\\"'

do_compile() {
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${PN} pcasc pcxm pcym pczm ${D}${bindir}/
}

SRC_URI[md5sum] = "21865bf2891222082afc44afdd80aeaa"
SRC_URI[sha256sum] = "ed3e0190a1940cf08a167429aa3fd25b3ae7313fdf126f851a9abccc89845ee6"
