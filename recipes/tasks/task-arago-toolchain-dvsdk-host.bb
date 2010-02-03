DESCRIPTION = "Host packages for a standalone Arago SDK or external toolchain"
PR = "r18"
ALLOW_EMPTY = "1"

inherit sdk

PACKAGES = "${PN}"

DVSDK_HOST_PACKAGE = "\
    ti-xdctools-sdk \
    ti-xdais-sdk \
    ti-codecs-dm365-sdk \
    ti-codecs-dm355-sdk \
    ti-dm365mm-module-sdk \
    ti-codec-engine-sdk \
    ti-framework-components-sdk \
    ti-linuxutils-sdk \
    ti-dmai-sdk \
    ti-dvsdk-demos-sdk \
    "

DVSDK_HOST_PACKAGE_dm6446-evm = "\
    ti-codec-engine-sdk \
    ti-codec-combo-dm6446-sdk \
    ti-xdctools-sdk \
    ti-dmai-sdk \
    ti-dspbios-sdk \
    ti-cgt6x-sdk \
    "

DVSDK_HOST_PACKAGE_dm6467-evm = "\
    ti-codec-engine-sdk \
    ti-codec-combo-dm6467-sdk \
    ti-xdctools-sdk \
    ti-dmai-sdk \
    ti-dspbios-sdk \
    ti-cgt6x-sdk \
    "

DVSDK_HOST_PACKAGE_dm6467t-evm = "\
    ti-dspbios-sdk \
    ti-dspbiosutils-sdk \
    ti-codec-engine-sdk \
    ti-dmai-sdk \
    ti-dsplink-module-sdk \
    ti-dvsdk-demos-sdk \
    ti-edma3-lld-sdk \
    ti-framework-components-sdk \
    ti-linuxutils-sdk \
    ti-codec-combo-dm6467-sdk \
    ti-xdais-sdk \
    ti-xdctools-sdk \
    ti-cgt6x-sdk \
    "

DVSDK_HOST_PACKAGE_omap3evm = "\
    ti-codec-engine-sdk \
    ti-codec-combo-omap3530-sdk \
    ti-xdctools-sdk \
    ti-dmai-sdk \
    ti-dspbios-sdk \
    ti-cgt6x-sdk \
    "

DVSDK_HOST_PACKAGE_beagleboard = "\
    ti-codec-engine-sdk \
    ti-codec-combo-omap3530-sdk \
    ti-xdctools-sdk \
    ti-dmai-sdk \
    ti-dspbios-sdk \
    ti-cgt6x-sdk \
    "

RDEPENDS_${PN} = "\
    task-arago-toolchain-host \
    ${DVSDK_HOST_PACKAGE} \
    ti-legacy-dvsdk \
    "
