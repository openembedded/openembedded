require ti-dm365mm-module.inc

PV = "01_00_03"

SRC_URI[dm365mmtarball.md5sum] = "852f775c437299ddec13abaa9b220e43"
SRC_URI[dm365mmtarball.sha256sum] = "6c46ad48f1c02db9bd5dca1fa110e6956fd357026e148dd87cb6d57fc264b129"


#This is a kernel module, don't set PR directly
MACHINE_KERNEL_PR_append = "a"
