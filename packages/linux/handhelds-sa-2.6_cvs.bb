SECTION = "kernel"
DESCRIPTION = "handhelds.org Linux kernel for StrongArm processor based devices."
MAINTAINER = "Alex Lange <chicken@handhelds.org>"
LICENSE = "GPL"
#
COMPATIBLE_HOST = "arm.*-linux"

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/handhelds-sa-${PV}"

SRC_URI = "${HANDHELDS_CVS};module=linux/kernel26"

S = "${WORKDIR}/kernel26"
PV = "${K_MAJOR}.${K_MINOR}.${K_MICRO}-hh${HHV}+cvs${SRCDATE}"

K_MAJOR = "2"
K_MINOR = "6"
K_MICRO = "12"
HHV     = "0"

inherit kernel
#
PAKCAGE_ARCH = "ipaqsa"
PACKAGE_ARCH_jornada56x = "jornada56x"
PACKAGE_ARCH_jornada7xx = "jornada7xx"
PACKAGE_ARCH_simpad     = "simpad"

do_configure() {
	install -m 0644 ${S}/arch/arm/configs/${MACHINE}_defconfig ${S}/.config || die "No default configuration for ${MACHINE} available."
        (echo N; echo m; echo N) | oe_runmake oldconfig
}
