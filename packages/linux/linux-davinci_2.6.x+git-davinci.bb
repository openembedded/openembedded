require linux-omap.inc

# uncomment the below to get the latest and greatest and avoid a full reparse
# or override in it local.conf like this: DAVINCI_SRCREV_pn-linux-davinci = "${@bb.fetch.get_srcrev(d)}"
#DAVINCI_SRCREV = "${@bb.fetch.get_srcrev(d)}"
DAVINCI_SRCREV ?= "f5691bc8f65a08a6cb9900a5c7099a36b2b9b7a7"
SRCREV = "${DAVINCI_SRCREV}"

DEFAULT_PREFERENCE = "-1"

PV = "2.6.27+2.6.28-rc6+gitr${SRCREV}"

COMPATIBLE_MACHINE = "(davinci-dvevm|davinci-sffsdr)"

SRC_URI = "git://source.mvista.com/git/linux-davinci-2.6.git;protocol=git \
           file://defconfig"

S = "${WORKDIR}/git"
