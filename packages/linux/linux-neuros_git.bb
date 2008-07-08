require linux.inc

DESCRIPTION = "Linux kernel for Neuros OSD devices"

SRCREV = "723849a80153f079a653d06a660f63fec67f6d1e"

PV = "2.6.23-${PR}+git${SRCREV}"
PR = "r4"

COMPATIBLE_MACHINE = "(neuros-osd|neuros-osd2)"

SRC_URI = "git://git.neurostechnology.com/git/linux-davinci-2.6;protocol=git;branch=neuros \
           file://defconfig"

S = "${WORKDIR}/git"
