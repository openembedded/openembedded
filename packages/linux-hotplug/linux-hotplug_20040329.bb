SECTION = "base"
DESCRIPTION = "This package contains the scripts necessary \
for hotplug Linux support, and lets you plug in new devices \
and use them immediately."
LICENSE = "GPL"
RPROVIDES = "hotplug"
RCONFLICTS = "hotplug"
RREPLACES = "hotplug"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/utils/kernel/hotplug/hotplug-2004_03_29.tar.gz \
	   file://busybox.patch;patch=1 \
           file://fix-net.agent \
           file://update-usb.usermap \
           file://logcheck-ignore \
	   file://sleeve.agent file://sleeve.rc file://mmc.agent \
	   file://usbd.agent"
S = "${WORKDIR}/hotplug-2004_03_29"

INITSCRIPT_NAME = "hotplug"
INITSCRIPT_PARAMS = "start 40 S . stop 89 0 6 ."

inherit update-rc.d

do_compile () {
	:
}

oldmandir := "${mandir}"
oldsbindir := "${sbindir}"
prefix = ""
exec_prefix = ""
FILES_hotplug_append = " ${oldsbindir}"
FILES_hotplug-doc_append = " ${oldmandir}"

export DEBFIX = "sed -e 's:sysconfig/usb:default/hotplug.usb:'"
do_install () {
	install -d ${D}${sysconfdir}/logcheck/ignore.d \
		   ${D}${oldmandir} ${D}${oldsbindir}
	oe_runmake prefix=${D}${prefix} exec_prefix=${D}${exec_prefix} \
		   etcdir=${D}${sysconfdir} sbindir=${D}${sbindir} \
		   mandir=${D}${oldmandir} install
	sh ${WORKDIR}/fix-net.agent ${D}
	install -m 0755 ${WORKDIR}/update-usb.usermap ${D}${oldsbindir}/
	install -m 0644 ${WORKDIR}/logcheck-ignore ${D}${sysconfdir}/logcheck/ignore.d/hotplug
	install -m 0755 ${WORKDIR}/sleeve.agent ${D}${sysconfdir}/hotplug/
	install -m 0755 ${WORKDIR}/sleeve.rc ${D}${sysconfdir}/hotplug/
	install -m 0755 ${WORKDIR}/mmc.agent ${D}${sysconfdir}/hotplug/
	install -m 0755 ${WORKDIR}/usbd.agent ${D}${sysconfdir}/hotplug/
}
