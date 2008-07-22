DESCRIPTION = "A full featured personal video recorder system."
HOMEPAGE = "http://www.mythtv.org"
LICENSE = "GPL"
SECTION = "x11/multimedia"
DEPENDS = "jack alsa-lib lame libxinerama libxv libxxf86vm libxvmc lirc"
#RDEPENDS_${PN} = "qt-x11-plugins-sqldrivers qt-x11-plugins-imageformats"

SRC_URI = "http://www.mythtv.org/mc/mythtv-${PV}.tar.bz2"

inherit qmake2 qt4x11


QMAKE_PROFILES = "mythtv.pro"

def mythtv_arch(d):
        import bb, re
        arch = bb.data.getVar('TARGET_ARCH', d, 1)
        if re.match("^i.86$", arch):
                arch = "x86"
        elif arch == "x86_64":
                arch = "x86"
        elif arch == "arm":
                arch = "${BASE_PACKAGE_ARCH}"
        return arch

MYTHTV_ARCH := "${@mythtv_arch(d)}"

do_install() {
	oe_runmake INSTALL_ROOT=${D} install
}
