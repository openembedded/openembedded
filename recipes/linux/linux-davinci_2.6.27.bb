require linux-omap.inc

DEFAULT_PREFERENCE = "-1"

# uncomment the below to get the latest and greatest and avoid a full reparse
# or override in it local.conf like this: DAVINCI_SRCREV_pn-linux-davinci = "${@bb.fetch.get_srcrev(d)}"
#DAVINCI_SRCREV = "${@bb.fetch.get_srcrev(d)}"
DAVINCI_SRCREV ?= "9d6ed804d27b9452fb96d68b16ee5f124a07e4f9"
SRCREV = "${DAVINCI_SRCREV}"

PV = "2.6.27"
PR = "r0"

COMPATIBLE_MACHINE = "(davinci-dvevm)"

SRC_URI = "git://source.mvista.com/git/linux-davinci-2.6.git;protocol=git \
           file://defconfig"

S = "${WORKDIR}/git"
