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

DVSDK_HOST_PACKAGE_dm6446 = "\
    ti-codec-engine-sdk \
    ti-codec-combo-dm6446-sdk \
    ti-xdctools-sdk \
    ti-dmai-sdk \
    ti-dspbios-sdk \
    ti-cgt6x-sdk \
    "

DVSDK_HOST_PACKAGE_dm6467 = "\
    ti-codec-engine-sdk \
    ti-codec-combo-dm6467-sdk \
    ti-xdctools-sdk \
    ti-dmai-sdk \
    ti-dspbios-sdk \
    ti-cgt6x-sdk \
    "

DVSDK_HOST_PACKAGE_omap3 = "\
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
