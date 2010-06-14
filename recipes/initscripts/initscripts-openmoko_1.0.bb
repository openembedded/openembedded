DESCRIPTION = "Openmoko init scripts"
SECTION = "base"
PRIORITY = "required"
LICENSE = "GPL"
DEPENDS = ""
RDEPENDS_${PN} = ""
PR = "r1"

RCONFLICTS_${PN} = "initscripts"

SRC_URI = "file://bootmisc.sh \
	   file://campgsm \
	   file://checkroot.sh \
	   file://finish.sh \
	   file://functions \
	   file://hostname.sh \
	   file://led-trigger.sh \
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

SRC_URI_append_arm = " file://alignment.sh"

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

	if [ "${TARGET_ARCH}" = "arm" ]; then
		install -m 0755 ${WORKDIR}/alignment.sh	${D}${sysconfdir}/init.d
	fi
	install -m 0755	${WORKDIR}/bootmisc.sh		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/campgsm		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/checkroot.sh		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/finish.sh		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/functions		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/hostname.sh		${D}${sysconfdir}/init.d
	install -m 0755	${WORKDIR}/led-trigger.sh	${D}${sysconfdir}/init.d
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

#
# Create runlevel links
#
	ln -sf		../init.d/hostname.sh		${D}${sysconfdir}/rcS.d/S02hostname.sh
	ln -sf		../init.d/mountkernfs.sh	${D}${sysconfdir}/rcS.d/S02mountkernfs.sh
	ln -sf		../init.d/mountdevsubfs.sh	${D}${sysconfdir}/rcS.d/S04mountdevsubfs.sh
	if [ "${TARGET_ARCH}" = "arm" ]; then
		ln -sf	../init.d/alignment.sh		${D}${sysconfdir}/rcS.d/S06alignment
	fi
	#ln -sf		../init.d/campgsm		${D}${sysconfdir}/rcS.d/S07campgsm
	ln -sf		../init.d/checkroot.sh		${D}${sysconfdir}/rcS.d/S10checkroot.sh
	ln -sf		../init.d/mountall.sh		${D}${sysconfdir}/rcS.d/S35mountall.sh
	ln -sf		../init.d/populate-volatile.sh	${D}${sysconfdir}/rcS.d/S37populate-volatile.sh
	ln -sf		../init.d/mountnfs.sh		${D}${sysconfdir}/rcS.d/S45mountnfs.sh
	ln -sf		../init.d/bootmisc.sh		${D}${sysconfdir}/rcS.d/S55bootmisc.sh
	ln -sf		../init.d/led-trigger.sh	${D}${sysconfdir}/rcS.d/S97led-trigger.sh
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
