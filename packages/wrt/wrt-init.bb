DESCRIPTION = "wrt init scripts"
SECTION = "base"
LICENSE = "GPL"

SRC_URI = "file://mount file://wrtboot"

do_install() {
	install -d ${D}${sysconfdir}/rcS.d \
		   ${D}${sysconfdir}/init.d
	
	install -m 0755 ${WORKDIR}/mount ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/wrtboot ${D}${sysconfdir}/init.d
	
	ln -s ../init.d/mount ${D}${sysconfdir}/rcS.d/S05mount
	ln -s ../init.d/wrtboot ${D}${sysconfdir}/rcS.d/S10wrtboot
}
