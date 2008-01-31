DESCRIPTION = "GNU All Mobile Managment Utilities"
SECTION = "console/network"
DEPENDS = "bluez-libs cmake-native"
LICENSE = "GPL"
HOMEPAGE = "http://www.gammu.org/"

SRC_URI = "http://dl.cihar.com/gammu/releases/gammu-${PV}.tar.bz2 "

inherit pkgconfig

do_configure() {
    cd ${S} && CMAKE_C_COMPILER=${TARGET_OS}-gcc ./configure --prefix=${prefix} --enable-shared --enable-backup
}

do_compile () {
        oe_runmake
}

do_install () {
        oe_runmake install DESTDIR=${D}
}

do_stage() {
        install -d ${STAGING_INCDIR}/gammu/
        install -m 0644 build-configure/include/*.h ${STAGING_INCDIR}/gammu/

        oe_libinstall -so -C build-configure/common libGammu ${STAGING_LIBDIR}
}

PACKAGES =+ "libgammu"

FILES_${PN} = "${bindir}/gammu"
FILES_libgammu = "${libdir}/libGammu.so*"
