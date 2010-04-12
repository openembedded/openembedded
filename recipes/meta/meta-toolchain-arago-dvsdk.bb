TOOLCHAIN_HOST_TASK = "task-arago-toolchain-dvsdk-host"
TOOLCHAIN_TARGET_TASK = "task-arago-toolchain-dvsdk-target"

DVSDK_TARGET_EXCLUDE_dm355 = "\
    ti-linuxutils \
    ti-dm355mm-module \
    ti-codec-combo-dm355 \
    ti-dmai-apps \
    "

DVSDK_TARGET_EXCLUDE_dm365 = "\
    ti-linuxutils \
    ti-dm365mm-module \
    ti-codec-combo-dm365 \
    ti-dmai-apps \
    "

DVSDK_TARGET_EXCLUDE_dm6446 = "\
    ti-linuxutils \
    ti-dsplink-module \
    ti-codec-combo-dm6446 \
    ti-dmai-apps \
    "

DVSDK_TARGET_EXCLUDE_dm6467 = "\
    ti-dm355mm-module \
    ti-dmai-apps \
    "

DVSDK_TARGET_EXCLUDE_omap3 = "\
    ti-linuxutils \
    ti-dsplink-module \
    ti-lpm-module \
    ti-codec-combo-omap3530 \
    ti-dmai-apps \
    "

TOOLCHAIN_TARGET_EXCLUDE += "\
    ${DVSDK_TARGET_EXCLUDE} \
    "

require meta-toolchain-arago.bb

PR = "r10"

SDK_SUFFIX = "dvsdk"
