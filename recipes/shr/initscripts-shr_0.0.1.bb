DESCRIPTION = "SHR init scripts"
SECTION = "base"
PRIORITY = "required"
DEPENDS = ""
RDEPENDS = ""
LICENSE = "GPL"
PV = "0.0.1"
PR = "r15"

RPROVIDES_${PN} = "initscripts"
RCONFLICTS_${PN} = "initscripts"
RREPLACES_${PN} = "initscripts"

SRC_URI = "file://alignment.sh \
	   file://bootmisc.sh \
	   file://checkroot.sh \
	   file://finish.sh \
	   file://functions \
	   file://g_ether.sh \
	   file://hostname.sh \
	   file://mountall.sh \
	   file://mountdevsubfs.sh \
	   file://mountkernfs.sh \
	   file://mountnfs.sh \
	   file://populate-volatile.sh \
	   file://devpts \
	   file://volatiles \
	   file://halt \
	   file://reboot \
	   file://rmnologin \
	   file://save-rtc.sh \
	   file://sendsigs \
	   file://umountfs \
	   file://umountnfs.sh \
	   "
SRC_URI_append_palmpre = " file://usb-gadget.sh"

inherit base

do_install () {
#
# Create directories and install device independent scripts
#
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/rcS.d
	install -d ${D}${sysconfdir}/rc0.d
	install -d ${D}${sysconfdir}/rc1.d
	install -d ${D}${sysconfdir}/rc2.d
	install -d ${D}${sysconfdir}/rc3.d
	install -d ${D}${sysconfdir}/rc4.d
	install -d ${D}${sysconfdir}/rc5.d
	install -d ${D}${sysconfdir}/rc6.d
	install -d ${D}${sysconfdir}/default
	install -d ${D}${sysconfdir}/default/volatiles

	install -m 0755	${WORKDIR}/alignment.sh		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/bootmisc.sh		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/checkroot.sh		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/finish.sh		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/functions		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/g_ether.sh		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/hostname.sh		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/mountall.sh		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/mountnfs.sh		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/mountdevsubfs.sh	${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/mountkernfs.sh	${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/populate-volatile.sh	${D}${sysconfdir}/init.d

	install -m 0644	${WORKDIR}/devpts		${D}${sysconfdir}/default/devpts
	install -m 0644	${WORKDIR}/volatiles		${D}${sysconfdir}/default/volatiles/00_core

	install -m 0755	${WORKDIR}/halt			${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/reboot		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/rmnologin		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/save-rtc.sh		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/sendsigs		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/umountfs		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/umountnfs.sh		${D}${sysconfdir}/init.d

	if [ "${MACHINE}" == "palmpre" ]; then
		install -m 0755 ${WORKDIR}/usb-gadget.sh ${D}${sysconfdir}/init.d
		ln -sf ../init.d/usb-gadget.sh ${D}${sysconfdir}/rcS.d/S00usb-gadget.sh
	fi

#
# Create runlevel links
#
	ln -sf		../init.d/mountkernfs.sh	${D}${sysconfdir}/rcS.d/S01mountkernfs.sh
	ln -sf		../init.d/g_ether.sh		${D}${sysconfdir}/rcS.d/S02g_ether.sh
	ln -sf		../init.d/hostname.sh		${D}${sysconfdir}/rcS.d/S02hostname.sh
	ln -sf		../init.d/checkroot.sh		${D}${sysconfdir}/rcS.d/S02checkroot.sh
	ln -sf		../init.d/mountdevsubfs.sh	${D}${sysconfdir}/rcS.d/S04mountdevsubfs.sh
	ln -sf		../init.d/alignment.sh		${D}${sysconfdir}/rcS.d/S06alignment.sh
	ln -sf		../init.d/mountall.sh		${D}${sysconfdir}/rcS.d/S35mountall.sh
	ln -sf		../init.d/populate-volatile.sh	${D}${sysconfdir}/rcS.d/S37populate-volatile.sh
	ln -sf		../init.d/mountnfs.sh		${D}${sysconfdir}/rcS.d/S45mountnfs.sh
	ln -sf		../init.d/bootmisc.sh		${D}${sysconfdir}/rcS.d/S55bootmisc.sh
	ln -sf		../init.d/finish.sh		${D}${sysconfdir}/rcS.d/S99finish.sh

	ln -sf		../init.d/rmnologin		${D}${sysconfdir}/rc5.d/S99rmnologin

	ln -sf		../init.d/sendsigs		${D}${sysconfdir}/rc0.d/S20sendsigs
	ln -sf		../init.d/save-rtc.sh		${D}${sysconfdir}/rc0.d/S25save-rtc.sh
	ln -sf		../init.d/umountnfs.sh		${D}${sysconfdir}/rc6.d/S31umountnfs.sh
	ln -sf		../init.d/umountfs		${D}${sysconfdir}/rc0.d/S40umountfs
	ln -sf		../init.d/halt			${D}${sysconfdir}/rc0.d/S90halt

	ln -sf		../init.d/sendsigs		${D}${sysconfdir}/rc6.d/S20sendsigs
	ln -sf		../init.d/save-rtc.sh		${D}${sysconfdir}/rc6.d/S25save-rtc.sh
	ln -sf		../init.d/umountnfs.sh		${D}${sysconfdir}/rc6.d/S31umountnfs.sh
	ln -sf		../init.d/umountfs		${D}${sysconfdir}/rc6.d/S40umountfs
	ln -sf		../init.d/reboot		${D}${sysconfdir}/rc6.d/S90reboot

}
