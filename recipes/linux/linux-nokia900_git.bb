require linux.inc

KERNEL_RELEASE = "2.6.28.10"
PV = "${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "e93534addfc33a2fefbca13cb86a8f787e4b650c"

SRC_URI = "\
  git://git.freesmartphone.org/linux-2.6.git;protocol=git;branch=nokia900/master \
  file://defconfig \
"
S = "${WORKDIR}/git"

CMDLINE_nokia900 = "snd-soc-rx51.hp_lim=42 snd-soc-tlv320aic3x.hp_dac_lim=6 console=tty1 root=/dev/mmcblk1p1 rootdelay=10 panic=20"

# Mark archs/machines that this kernel supports
COMPATIBLE_MACHINE = "nokia900"
DEFAULT_PREFERENCE = "-2"
DEFAULT_PREFERENCE_nokia900 = "1"
