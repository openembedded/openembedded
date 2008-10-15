DESCRIPTION = "GNU All Mobile Managment Utilities"
SECTION = "console/network"
DEPENDS = "bluez-libs cmake-native"
LICENSE = "GPL"
HOMEPAGE = "http://www.gammu.org/"
PR = "r1"

SRC_URI = "http://dl.cihar.com/gammu/releases/gammu-${PV}.tar.bz2 "

# it is CMake based but when inherit cmake it builds static binary/library
inherit autotools pkgconfig

do_configure() {
    cd ${S} && CMAKE_C_COMPILER=${TARGET_OS}-gcc ./configure --prefix=${prefix} --enable-shared --enable-backup
}

do_stage() {
    autotools_stage_all
}

# gammu has a non-standard uninstalled .pc file, which confuses pkgconfig.bbclass.
# Replace it by custom do_stage_append():
do_stage_append () {
	install -d ${PKG_CONFIG_DIR}
	cat build-configure/cfg/gammu.pc > ${PKG_CONFIG_DIR}/gammu.pc
}

PACKAGES =+ "libgammu"

FILES_${PN} = "${bindir}/gammu ${bindir}/jadmaker"
FILES_${PN}-dev += "${bindir}/gammu-config"
FILES_libgammu = "${libdir}/libGammu.so.*"
