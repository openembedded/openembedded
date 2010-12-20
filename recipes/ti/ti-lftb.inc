DESCRIPTION = "Linux Functional Test Bench"
HOMEPAGE = "http://arago-project.org/git/projects/?p=test-automation/target-code/psp/lftb.git;a=summary"
LICENSE="BSD"

INC_PR = "r0"

DEPENDS = "virtual/kernel"

PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(dm365|dm355|dm6446|dm6467|omapl137|omapl138|omap3|ti816x)"

S = "${WORKDIR}/git"

#Machine specific overrides
PLATFORM_omap3evm="omap35x"
PLATFORM_am180x-evm="am18x"
PLATFORM_am3517-evm="am3517"
PLATFORM_am37x-evm="am37x"
PLATFORM_beagleboard="beagle"
PLATFORM_da830-omapl137-evm="am17x"
PLATFORM_da850-omapl138-evm="am18x"
PLATFORM_am181x-evm="am18x"
PLATFORM_dm355-evm="dm355"
PLATFORM_dm365-evm="dm365"
PLATFORM_dm37x-evm="am37x"
PLATFORM_dm6446-evm="dm644x"
PLATFORM_dm6467-evm="dm646x"
PLATFORM_ti816x="ti816x"

do_compile() {
    cd ${S}
    make KERNEL_DIR=${STAGING_KERNEL_DIR} PLATFORM=${PLATFORM} TOOL_PREFIX=${TARGET_PREFIX}
}

do_install() {
    install -d ${D}${bindir}/lftb
    make INSTALL_DIR=${D}${bindir}/lftb install

    # Remove unneeded tarball placed in bindir by install target
    rm -rf ${D}${bindir}/lftb.tar.gz
}

INSANE_SKIP_${PN} = True

FILES_${PN} = "${bindir}/lftb"
