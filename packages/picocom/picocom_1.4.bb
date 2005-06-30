DESCRIPTION = "Picocom is a lightweight and minimal (~20K) dumb-terminal emulation program. "
SECTION = "console/utils"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
SRC_URI = "http://efault.net/npat/hacks/picocom/dist/picocom-${PV}.tar.gz"

CFLAGS_append = ' -DVERSION_STR=\\"${PV}\\"'

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${PN} pcasc pcxm pcym pczm ${D}${bindir}/
}
