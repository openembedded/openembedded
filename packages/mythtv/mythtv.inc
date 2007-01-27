DESCRIPTION = "A full featured personal video recorder system."
HOMEPAGE = "http://www.mythtv.org"
LICENSE = "GPL"
SECTION = "x11/multimedia"
DEPENDS = "libxinerama lame libxv libxxf86vm libxvmc lirc qt-x11-free"
RDEPENDS_${PN} = "qt-x11-plugins-sqldrivers qt-x11-plugins-imageformats"

SRC_URI = "http://www.mythtv.org/mc/mythtv-${PV}.tar.bz2"

inherit qmake qt3x11

# there is a -march=586 somewhere in the source tree
COMPATIBLE_HOST = 'i.86.*-linux'

QMAKE_PROFILES = "mythtv.pro"

def mythtv_arch(d):
        import bb, re
        arch = bb.data.getVar('TARGET_ARCH', d, 1)
        if re.match("^i.86$", arch):
                arch = "x86"
        elif arch == "x86_64":
                arch = "x86"
        elif arch == "arm":
                arch = "armv4l"
        return arch

MYTHTV_ARCH := "${@mythtv_arch(d)}"

do_install() {
	oe_runmake INSTALL_ROOT=${D} install
}
