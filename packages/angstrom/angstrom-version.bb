PV = "${DISTRO_VERSION}"

PACKAGES = "${PN}"

do_compile() {
	mkdir -p ${D}${sysconfdir}
	echo "Angstrom ${DISTRO_VERSION}" > ${D}${sysconfdir}/angstrom-version

}
