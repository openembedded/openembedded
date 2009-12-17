require linux.inc

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_at91sam9263ek = "1"

BASE_KERNEL_VERSION = "2.6.22"
KERNEL_VERSION = "2.6.23-rc3"
KERNEL_RELEASE = "2.6.23-rc3"

PR = "r1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${BASE_KERNEL_VERSION}.tar.bz2 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/v2.6.23/patch-${KERNEL_VERSION}.bz2;patch=1 \
           file://defconfig \
           "

SRC_URI_append_kb9202 = " http://maxim.org.za/AT91RM9200/2.6/2.6.23-rc3-at91.patch.gz;patch=1 \
                        "
SRC_URI_append_at91sam9263ek = " http://maxim.org.za/AT91RM9200/2.6/2.6.23-rc3-at91.patch.gz;patch=1 \
                               "

S = "${WORKDIR}/linux-${BASE_KERNEL_VERSION}"


