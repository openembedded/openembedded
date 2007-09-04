PV = "${DISTRO_VERSION}"

PACKAGES = "${PN}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
	mkdir -p ${D}${sysconfdir}
	echo "Angstrom ${DISTRO_VERSION}" > ${D}${sysconfdir}/angstrom-version

}
