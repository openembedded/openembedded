DESCRIPTION = "DSP Gateway Utilities"
HOMEPAGE = "http://dspgateway.sourceforge.net"
LICENSE = "GPL"
DEPENDS = "bison flex udev"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/dspgateway/dspgw-${PV}-arm.tar.bz2 \
           file://yytext_ptr.patch \
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

SRC_URI[md5sum] = "0bf037f418d5bf890bc3eef0b0e3fe6a"
SRC_URI[sha256sum] = "6591e9b85f222df7f57855bb8afc20f6a5845e35f44198406c31649a5ce2bfd1"

