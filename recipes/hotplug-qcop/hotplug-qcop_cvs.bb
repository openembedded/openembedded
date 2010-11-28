DESCRIPTION = "HotPlug -> QCOP Event Bridge"
SECTION = "opie/base"
RDEPENDS_${PN} = "opie-qcop hotplug"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/tools/hotplug-qcop"
S = "${WORKDIR}/hotplug-qcop"

inherit opie

sbindir="/sbin"

do_install() {
	install -d ${D}${sbindir}
	install -m 0755 hotplug-qcop ${D}${sbindir}

	install -d ${D}${sysconfdir}/hotplug.d/default/
	ln -sf /sbin/hotplug-qcop ${D}${sysconfdir}/hotplug.d/default/11-qcop.hotplug
}

FILES_${PN} = "${sysconfdir} ${sbindir}"
