# TODO: port to sdl.bbclass?
DESCRIPTION = "3D arcade space shooter"
HOMEPAGE = "http://www.realtech-vr.com/nogravity/"
LICENSE = "GPL"
SECTION = "x11/games"
DEPENDS = "libsdl-x11 zlib libpng libsdl-mixer libogg libvorbis"
PR = "r1"

SRC_URI = "http://zaurus.vivaphp.net/nogravity.tar.bz2;name=archive \
	   ${SOURCEFORGE_MIRROR}/nogravity/rt-nogravity-data.zip;name=data"

S = "${WORKDIR}/${PN}/src/Linux/"
PACKAGES += "${PN}-data"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-sound=sdl_mixer  --disable-opengl"

FILES_${PN} += "/usr/games/nogravity/no*"
FILES_${PN}-data = "/usr/games/nogravity/*.RMX"
PACKAGE_ARCH_${PN}-data = "all"
RRECOMMENDS+${PN} = "${PN}-data"

do_install_prepend() {
	install -d  ${D}/usr/games/nogravity/
	install -m 644 ${WORKDIR}/*.RMX ${D}/usr/games/nogravity/
}



SRC_URI[archive.md5sum] = "42d9e4cfd86b15826426797a0fb6d499"
SRC_URI[archive.sha256sum] = "f9c86a163bd27dc4fd05abb958bb857109a556a4a58f8d06663d49ac0559ac92"
SRC_URI[data.md5sum] = "c7536e907363ea1da63430b49e42931d"
SRC_URI[data.sha256sum] = "d7d5a3d17f492049fceb2b9ea22c4c2af7243506219d83f7005b77ae410add29"
