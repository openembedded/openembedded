#default to soft-floats if distro/machine/local.conf don't define anything else
TARGET_FPU   ?=  "soft"
TARGET_CC_ARCH = "-mcpu=405"
PACKAGE_ARCH = "ppc405"
