require linux.inc

KERNEL_RELEASE = "2.6.37"
PV = "${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "570058abb97844fd30c396772b1a078bf572dd0c"

SRC_URI = "\
  git://git.freesmartphone.org/linux-2.6.git;protocol=git;branch=nokia900/kernel-adaptation-n900-2.6.37-38.1 \
  file://defconfig \
"
S = "${WORKDIR}/git"

#CMDLINE_nokia900 = "snd-soc-rx51.hp_lim=42 snd-soc-tlv320aic3x.hp_dac_lim=6 console=tty1 root=/dev/mmcblk0p1 rootdelay=10 panic=20"

# Mark archs/machines that this kernel supports
COMPATIBLE_MACHINE = "nokia900"
DEFAULT_PREFERENCE = "-2"
DEFAULT_PREFERENCE_nokia900 = "1"
