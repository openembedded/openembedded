DESCRIPTION = "Lightweight and minimal (~20K) dumb-terminal emulation program."
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "http://efault.net/npat/hacks/picocom/dist/picocom-${PV}.tar.gz \
           file://nolock.patch;patch=1 \
           file://gcc4.patch;patch=1"

CFLAGS_append = ' -DVERSION_STR=\\"${PV}\\"'

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ${PN} pcasc pcxm pcym pczm ${D}${bindir}/
}
