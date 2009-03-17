require linux-omap.inc

# uncomment the below to get the latest and greatest and avoid a full reparse
# or override in it local.conf like this: DAVINCI_SRCREV_pn-linux-davinci = "${@bb.fetch.get_srcrev(d)}"
#DAVINCI_SRCREV = "${@bb.fetch.get_srcrev(d)}"
DAVINCI_SRCREV ?= "f5691bc8f65a08a6cb9900a5c7099a36b2b9b7a7"
SRCREV = "${DAVINCI_SRCREV}"

PV = "2.6.25"
#PV = "2.6.25+2.6.26-rc0+git${SRCREV}"
PR = "r2"

COMPATIBLE_MACHINE = "(davinci-dvevm|davinci-sffsdr)"

SRC_URI = "git://source.mvista.com/git/linux-davinci-2.6.git;protocol=git \
           file://8250_davinci.patch;patch=1 \
           file://defconfig"

SRC_URI_append_davinci-sffsdr = " file://sffsdr.patch;patch=1"

S = "${WORKDIR}/git"
