DESCRIPTION = "libascenario data files"
LICENSE = "MIT"
PV = "0.1.0"
PR = "r0"

SRC_URI = "\
  file://default \
  file://default.conf \
"

do_install() {
	install -d ${D}${sysconfdir}/alsa/scenario/default/
	# master conf
	install -m 0644 ${WORKDIR}/default.conf ${D}${sysconfdir}/alsa/scenario/
	# scenarii
	install -m 0644 ${WORKDIR}/default/* ${D}${sysconfdir}/alsa/scenario/default/
}

FILES_${PN} = "\
	${sysconfdir} \
"
PACKAGE_ARCH_${PN} = "all"
