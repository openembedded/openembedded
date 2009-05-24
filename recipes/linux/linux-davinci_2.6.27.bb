require linux-omap.inc

#DEFAULT_PREFERENCE = "-1"

# uncomment the below to get the latest and greatest and avoid a full reparse
# or override in it local.conf like this: DAVINCI_SRCREV_pn-linux-davinci = "${@bb.fetch.get_srcrev(d)}"
#DAVINCI_SRCREV = "${@bb.fetch.get_srcrev(d)}"
DAVINCI_SRCREV ?= "9d6ed804d27b9452fb96d68b16ee5f124a07e4f9"
SRCREV = "${DAVINCI_SRCREV}"

# The main PR is now using MACHINE_KERNEL_PR, for davinci see conf/machine/include/davinci.inc
PV = "2.6.27"

COMPATIBLE_MACHINE = "(davinci-dvevm)"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/khilman/linux-davinci.git;protocol=git \
           file://defconfig"

S = "${WORKDIR}/git"
