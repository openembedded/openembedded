LICENSE = "MIT"

PV = "${DISTRO_VERSION}"

INHIBIT_DEFAULT_DEPS = "1"
PACKAGES = "${PN}"
PACKAGE_ARCH = "all"

export METADATA_REVISION
export METADATA_BRANCH

do_install() {
	mkdir -p ${D}${sysconfdir}
	echo "${DISTRO_NAME} ${DISTRO_VERSION}" > ${D}${sysconfdir}/${DISTRO}-version
	echo "Built from branch: ${METADATA_BRANCH}" >> ${D}${sysconfdir}/${DISTRO}-version
	echo "Revision: ${METADATA_REVISION}" >> ${D}${sysconfdir}/${DISTRO}-version
}
