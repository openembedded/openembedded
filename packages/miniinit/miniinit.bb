DESCRIPTION = "minimal init."
SECTION = "base"
LICENSE = "GPL"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"

# SERIAL_CONSOLE is generally defined by the MACHINE .conf.
# Set PACKAGE_ARCH appropriately.
PACKAGE_ARCH_${PN} = "${MACHINE_ARCH}"

SRC_URI = "file://rcS file://inittab"

do_install() {
	install -d ${D}${sysconfdir} \
		   ${D}${sysconfdir}/rcS.d \
		   ${D}${sysconfdir}/rc2.d \
		   ${D}${sysconfdir}/init.d
	
	install -m 0644 ${WORKDIR}/inittab ${D}${sysconfdir}/inittab
	install -m 0755 ${WORKDIR}/rcS ${D}${sysconfdir}/init.d
	
	if [ ! -z "${SERIAL_CONSOLE}" ]; then
		echo "${SERIAL_CONSOLE}::askfirst:/bin/sh --login" >> ${D}${sysconfdir}/inittab
	fi
}
