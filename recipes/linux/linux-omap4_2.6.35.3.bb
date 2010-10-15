COMPATIBLE_MACHINE = "omap4430-panda"

require multi-kernel.inc

CORTEXA8FIXUP = "no"

SRCREV = "6931849710b21c0688a24646b15ff9db782b21d9"

SRC_URI = "git://kernel.ubuntu.com/ubuntu/ubuntu-maverick.git;protocol=git;branch=ti-omap4 \
           file://defconfig"

S = "${WORKDIR}/git"
