require conf/machine/include/tune-cortexa8.inc
PREFERRED_PROVIDER_virtual/kernel = "linux-omap"
# Increase this everytime you change something in the kernel
MACHINE_KERNEL_PR = "r50"

KERNEL_IMAGETYPE = "uImage"

UBOOT_ENTRYPOINT = "0x80008000"
UBOOT_LOADADDRESS = "0x80008000"

# Only build u-boot, xload is optional
EXTRA_IMAGEDEPENDS += "u-boot"

# TI DVSDK stuff:
CODEC_INSTALL_DIR ?= "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combo"
CODEC             ?= "${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ti-codec-combo"
DEVICES           ?= "OMAP3530"
DSPCFG            ?= "OMAP3530SHMEM"
DSPLINKDSPCFG     ?= "OMAP3530SHMEM"
DSPLINKGPPOS      ?= "OMAPLSP"
DSPLINKPLATFORM   ?= "OMAP3530"
DSPLINKSOC        ?= "3530"
DSPPOWERSOC       ?= "omap3530"
GPPOS             ?= "LINUX_GCC"
LPMDSPPOWERSOC    ?= "omap3530"
PLATFORM          ?= "omap3530"
XDC_PLATFORM      ?= "ti.platforms.evm3530"

