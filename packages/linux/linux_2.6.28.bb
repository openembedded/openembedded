require linux.inc

# DESCRIPTION = "Linux kernel for AT91 processors"
MAINTAINER = "Ulf Samuelsson <ulf.samuelsson@atmel.com>"
KERNEL_RELEASE = "2.6.28"

P="linux-2.6.28"
PN="linux"
PV="2.6.28"

PR = "r0"


# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"

DEFAULT_PREFERENCE_at91sam9263ek = "28"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.28.tar.bz2 \
           file://defconfig"


S = "${WORKDIR}/schedutils-${PV}"


