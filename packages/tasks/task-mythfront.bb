DESCRIPTION = "Meta-package for MythTV diskless frontend"
PR = "r16"

inherit task

RDEPENDS_${PN} = "xserver-xorg mythtv-frontend mythtv-filters mythtv-theme-g.a.n.t mythtv-theme-default lirc lirc-modules ttf-bitstream-vera fontconfig-utils setserial snes9x ntp mythfront-config gpe-dm mythfront-session bootlogd font-cursor-misc font-misc-misc xf86-input-keyboard xf86-input-mouse"

RDEPENDS_${PN}_append_epia = " xorg-driver-openchrome mesa-dri-driver-unichrome"

PACKAGE_ARCH_epia = "${MACHINE_ARCH}"

LICENSE = "MIT"

# there is a -march=586 somewhere in the source tree of mythtv
COMPATIBLE_HOST = 'i.86.*-linux'
