DESCRIPTION = "wrt init scripts"
SECTION = "base"
LICENSE = "GPL"

SRC_URI = "file://mount file://wrtboot file://wrtvlans file://finished"

do_install() {
	install -d ${D}${sysconfdir}/rcS.d \
		   ${D}${sysconfdir}/rc2.d \
		   ${D}${sysconfdir}/init.d
	
	install -m 0755 ${WORKDIR}/mount ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/wrtboot ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/wrtvlans ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/finished ${D}${sysconfdir}/init.d
	
	ln -s ../init.d/mount ${D}${sysconfdir}/rcS.d/S05mount
	ln -s ../init.d/wrtboot ${D}${sysconfdir}/rcS.d/S10wrtboot
	ln -s ../init.d/wrtvlans ${D}${sysconfdir}/rcS.d/S30wrtvlans
	ln -s ../init.d/finished ${D}${sysconfdir}/rc2.d/S99finished
}
