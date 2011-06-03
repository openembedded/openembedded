LICENSE = "MIT"

PV = "${DISTRO_VERSION}"

PACKAGES = "${PN}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
	mkdir -p ${D}${sysconfdir}
	echo "Aurora ${DISTRO_VERSION}" > ${D}${sysconfdir}/aurora-version
	echo "Built from branch: ${METADATA_BRANCH}" >> ${D}${sysconfdir}/aurora-version
	echo "Revision: ${METADATA_REVISION}" >> ${D}${sysconfdir}/aurora-version
}
