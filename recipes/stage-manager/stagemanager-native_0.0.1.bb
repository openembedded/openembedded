DESCRIPTION = "Helper script for packaged-staging.bbclass"
PR = "r15"

SRC_URI = "file://stage-manager \
           file://stage-manager-opkg \
           file://stage-manager-opkg-build "
LICENSE = "GPLv2"

PACKAGE_ARCH = "all"

inherit native

DEPENDS = " "
PACKAGE_DEPENDS = " "
PATCHDEPENDENCY = ""
INHIBIT_DEFAULT_DEPS = "1"

PSTAGING_DISABLED = "1"

NATIVE_INSTALL_WORKS = "1"
do_install() {
	install -d ${STAGING_BINDIR}
	install -m 0755 ${WORKDIR}/stage-manager ${STAGING_BINDIR}
	install -m 0755 ${WORKDIR}/stage-manager-opkg ${STAGING_BINDIR}
	install -m 0755 ${WORKDIR}/stage-manager-opkg-build ${STAGING_BINDIR}
}
