require u-boot.inc

PV = "2008.10+${PR}+git"
PR ="r2"
PE = "1"

SRC_URI = "git://git.labs.kernelconcepts.de/u-boot-topas.git/;protocol=git;tag=ca81d0245469af242e9a73360e46e99235eaadbf \
          "

UBOOT_MACHINE_topas910 = "topas910_config"

S = "${WORKDIR}/git/u-boot-topas910/"

do_compile () {
        unset LDFLAGS
        unset CFLAGS
        unset CPPFLAGS
        oe_runmake ${UBOOT_MACHINE}
        oe_runmake all
#        oe_runmake tools env
        oe_runmake tools
}

