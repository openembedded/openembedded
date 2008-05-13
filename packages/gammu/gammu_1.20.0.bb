DESCRIPTION = "GNU All Mobile Managment Utilities"
SECTION = "console/network"
DEPENDS = "bluez-libs cmake-native"
LICENSE = "GPL"
HOMEPAGE = "http://www.gammu.org/"

SRC_URI = "http://dl.cihar.com/gammu/releases/gammu-${PV}.tar.bz2 "

# it is CMake based but when inherit cmake it builds static binary/library
inherit autotools pkgconfig

do_configure() {
    cd ${S} && CMAKE_C_COMPILER=${TARGET_OS}-gcc ./configure --prefix=${prefix} --enable-shared --enable-backup
}

PACKAGES =+ "libgammu"

FILES_${PN} = "${bindir}/gammu ${bindir}/jadmaker"
FILES_${PN}-dev += "${bindir}/gammu-config"
FILES_libgammu = "${libdir}/libGammu.so.*"
