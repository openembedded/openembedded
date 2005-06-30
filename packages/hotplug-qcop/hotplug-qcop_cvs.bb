DESCRIPTION = "HotPlug -> QCOP Event Bridge"
SECTION = "opie/base"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
RDEPENDS = "opie-qcop hotplug"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/tools/hotplug-qcop"
S = "${WORKDIR}/hotplug-qcop"

inherit opie

sbindir=/sbin

do_install() {
	install -d ${D}${sbindir}
	install -m 0755 hotplug-qcop ${D}${sbindir}
	
	install -d ${D}${sysconfdir}/hotplug.d/default/
	ln -sf /sbin/hotplug-qcop ${D}${sysconfdir}/hotplug.d/default/11-qcop.hotplug
}

FILES_${PN} = "${sysconfdir} ${sbindir}"
