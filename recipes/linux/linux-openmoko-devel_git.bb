require linux.inc
require linux-openmoko.inc

DEFAULT_PREFERENCE = "-1"

KERNEL_RELEASE = "2.6.29"
KERNEL_VERSION = "${KERNEL_RELEASE}"

SRCREV = "a15608f241a40b41fed5bffe511355c2067c4e88"
OEV = "oe1"
PV = "${KERNEL_RELEASE}-${OEV}+gitr${SRCPV}"
PR = "r2"

SRC_URI = "\
  git://git.openmoko.org/git/kernel.git;protocol=git;branch=andy-tracking \
"
S = "${WORKDIR}/git"

CONFIG_NAME_om-gta01 = "gta01_moredrivers_defconfig"
CONFIG_NAME_om-gta02 = "gta02_packaging_defconfig"

do_configure_prepend() {

        # Rename getline in ./scripts/unifdef.c
        # Kernels up to 2.6.29 are currently failing to build unifdef.c,
        # clashing with exposed getline() from <stdio.h>
        # see https://patchwork.kernel.org/patch/11166/
        # committed in 2.6.29 (commit d15bd1067b1fcb2b7250d22bc0c7c7fea0b759f7)

        sed -i -e 's/getline/parseline/g' ${S}/scripts/unifdef.c

	install -m 644 ./arch/arm/configs/${CONFIG_NAME} ${WORKDIR}/defconfig-oe
	cat ${WORKDIR}/defconfig-oe.patch | patch -p0 -d ${WORKDIR}
}
