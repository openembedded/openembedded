DESCRIPTION = "DSP Gateway Utilities"
HOMEPAGE = "http://dspgateway.sourceforge.net"
LICENSE = "GPL"
DEPENDS = "bison flex udev"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/dspgateway/dspgw-${PV}-arm.tar.bz2 \
           file://yytext_ptr.patch;patch=1 \
           file://dsp \
           file://dsp.rules "

S = "${WORKDIR}/dspgw-${PV}-arm/src/utils"

CFLAGS += "-g -Wall -I${WORKDIR}/dspgw-${PV}-arm/include"

inherit update-rc.d

INITSCRIPT_NAME = "dsp"
INITSCRIPT_PARAMS = "defaults"

# Skipping...
do_configure () {
}

# Skipping...
do_stage () {
}

do_compile () {
        cd ${S}/dsp_dld/arm && oe_runmake
        cd ${S}/dspctl && oe_runmake
}

do_install () {
        install -d ${D}${sbindir}
        install -d ${D}${sysconfdir}/init.d
        install -d ${D}${sysconfdir}/udev/rules.d
        install -m 0655 ${S}/dspctl/dspctl ${D}${sbindir}
        install -m 0655 ${S}/dsp_dld/arm/dsp_dld ${D}${sbindir}
        install -m 0655 ${S}/dsp_dld/arm/dld_client ${D}${sbindir}
        install -m 0755 ${WORKDIR}/dsp ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/dsp.rules ${D}${sysconfdir}/udev/rules.d/
}
