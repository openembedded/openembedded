LICENSE = "MIT"

PV = "${DISTRO_VERSION}"
PR = "r2"
PE = "1"

PACKAGES = "${PN}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

do_install() {
	mkdir -p ${D}${sysconfdir}
	echo "KaeilOS ${DISTRO_VERSION}" > ${D}${sysconfdir}/kaeilos-version
	echo "Built from branch: ${METADATA_BRANCH}" >> ${D}${sysconfdir}/kaeilos-version
	echo "Revision: ${METADATA_REVISION}" >> ${D}${sysconfdir}/kaeilos-version
}
