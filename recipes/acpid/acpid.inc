SECTION = "base"
DESCRIPTION = "A daemon for delivering ACPI events."
LICENSE="GPL"

INC_PR = "r5"

SRC_URI = "${SOURCEFORGE_MIRROR}/acpid/acpid-${PV}.tar.gz \
           file://init \
           file://powerbtn-acpi-support"

inherit update-rc.d

INITSCRIPT_NAME = "acpid"
INITSCRIPT_PARAMS = "defaults"

EXTRA_OEMAKE = ""
do_compile () {
	oe_runmake 'CC=${CC}' 'CROSS=${HOST_PREFIX}'
}

do_install () {
	install -d ${D}${bindir} 
	oe_runmake 'INSTPREFIX=${D}' install
	install -d ${D}${sysconfdir}/init.d
	cat ${WORKDIR}/init | sed -e's,/usr/sbin,${sbindir},g' > ${D}${sysconfdir}/init.d/acpid
	chmod 755 ${D}${sysconfdir}/init.d/acpid
	install -d ${D}${sysconfdir}/acpi/events
	install -m 0644 ${WORKDIR}/powerbtn-acpi-support ${D}${sysconfdir}/acpi/events/
}
