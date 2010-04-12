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

SRC_URI[md5sum] = "08fcc5f6bb9e7676a2569386d5ea9f70"
SRC_URI[sha256sum] = "437c5fac2376e416b4427501d1b074da5aa6b8fea756a0d61aec22686f025721"
