require linux-kexecboot.inc

KERNEL_RELEASE = "2.6.37-nokia900-meego"
PV = "${KERNEL_RELEASE}+gitr${SRCPV}"

SRCREV = "7b81b4d55839514f2d801cd06855c8d422cfc3ac"

PR = "${INC_PR}.0"

SRC_URI = "\
  git://git.freesmartphone.org/linux-2.6.git;protocol=git;branch=nokia900/kernel-adaptation-n900-2.6.37-57.1 \
  file://defconfig \
"
S = "${WORKDIR}/git"

CMDLINE_nokia900 = "console=ttyO2,115200n8 console=tty0 omapfb.vram=0:2M,1:2M,2:2M mtdoops.mtddev=2"

# Mark archs/machines that this kernel supports
COMPATIBLE_MACHINE = "nokia900"
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_nokia900 = "1"
