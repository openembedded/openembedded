require linux.inc

PR = "r1"

S = "${WORKDIR}/linux-${PV}"

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_simone = "1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2;name=kernel \
           file://defconfig"

SRC_URI[kernel.md5sum] = "260551284ac224c3a43c4adac7df4879"
SRC_URI[kernel.sha256sum] = "5099786d80b8407d98a619df00209c2353517f22d804fdd9533b362adcb4504e"

# part of 2.6.24.7 patchset from Sim.One project
# other patches needs work
SRC_URI_append_simone = " \
			file://ep93xx/edb9301-fix-machine-id.patch;patch=1 \
			file://ep93xx/simone-board-def.patch;patch=1 \
			file://ep93xx/ep93xx-regs.patch;patch=1 \
			file://ep93xx/ep93xx-i2c.patch;patch=1 \
			file://ep93xx/ep93xx-touchscreen.patch;patch=1 \
			file://ep93xx/ep93xx-spi.patch;patch=1 \
			file://ep93xx/ep93xx-cpuinfo.patch;patch=1 "
