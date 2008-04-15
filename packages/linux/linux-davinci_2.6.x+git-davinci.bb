require linux-omap.inc

# uncomment the below to get the latest and greatest and avoid a full reparse
# or override in it local.conf like this: SRCREV_pn-linux-davinci = "${@bb.fetch.get_srcrev(d)}"
#SRCREV = "${@bb.fetch.get_srcrev(d)}"
SRCREV ?= "758eda6a823eacb2412b3c71da5f0ad07a16469d"

PV = "2.6.24+2.6.25-rc8-git${SRCREV}"
PR = "r1"

COMPATIBLE_MACHINE = "(davinci-dvevm|davinci-sffsdr)"

SRC_URI = "git://source.mvista.com/git/linux-davinci-2.6.git;protocol=git \
           file://defconfig"

SRC_URI_append_davinci-sffsdr = " file://sffsdr.patch;patch=1"

S = "${WORKDIR}/git"
