require ti-dsplink-module.inc

#This is a kernel module, don't set PR directly
MACHINE_KERNEL_PR_append = "b"                                                  

# tconf from xdctools dislikes '.' in pwd :/
PV = "1_61_03"

do_configure_append() {
    # dsplink makefile is hard-coded to use kbuild only on OMAP3530.
    # we are forcing  to use kbuild on other platforms.
    sed -i 's/OMAP3530/${DSPLINKPLATFORM}/g' ${DSPLINK}/gpp/src/Makefile
}
