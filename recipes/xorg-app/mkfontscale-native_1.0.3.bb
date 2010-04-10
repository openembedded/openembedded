DESCRIPTION = "X mkfontscale app"
SECTION = "x11/applications"
LICENSE = "MIT-X"
S="${WORKDIR}/mkfontscale-${PV}"

DEPENDS = "libx11-native libfontenc-native freetype-native"

SRC_URI = "${XORG_MIRROR}/individual/app/mkfontscale-${PV}.tar.bz2"

inherit native autotools pkgconfig

SRC_URI[md5sum] = "1d608771aca9695b828cec1e34178fd1"
SRC_URI[sha256sum] = "0458a3a5525b4ab458a018648ef8575afc191f904364c00e27876a7bd53af020"
