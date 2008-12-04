LICENSE = "MIT"

PV = "${DISTRO_VERSION}"
PR = "r2"
PE = "1"

PACKAGES = "${PN}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

export METADATA_REVISION
export METADATA_BRANCH

do_install() {
	mkdir -p ${D}${sysconfdir}
	echo "Angstrom ${DISTRO_VERSION}" > ${D}${sysconfdir}/angstrom-version
	echo "Built from branch: ${METADATA_BRANCH}" >> ${D}${sysconfdir}/angstrom-version
	echo "Revision: ${METADATA_REVISION}" >> ${D}${sysconfdir}/angstrom-version
}
