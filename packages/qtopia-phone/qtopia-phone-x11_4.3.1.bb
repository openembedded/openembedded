# This is qtopia-phone recipe heavilly based off the one in the qtopia-phone
# distribution.
#
# Please DO NOT merge this file into OE, it is not suitable for that yet as
# it compiles both native and target binaries. This requires stuff to be
# installed on the host which is against the aim of OE.

DESCRIPTION = "Qtopia OpenSource"
SECTION = "qtopia-phone"
LICENSE = "GPL"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
DEPENDS = "glib-2.0 dbus freetype alsa-lib bluez-libs virtual/libx11 fontconfig xft libxext libxrender libxrandr libxcursor libxtst"
RDEPENDS = "atd tzdata"
PROVIDES = "qtopia-phone"
PR = "r8"
SRCREV = "${AUTOREV}"
SRC_URI = "git://git.openmoko.org/git/qtopia.git;protocol=git \
           file://Xsession.d/99qtopia \
           file://qtopia.sh"

S = "${WORKDIR}/git"

inherit pkgconfig

TARGET-DEVICE="${@base_contains('MACHINE', 'nokia770', ' nokia770', '',d)}"
TARGET-DEVICE="${@base_contains('MACHINE', 'nokia800', ' nokia770', '',d)}"
TARGET-DEVICE="${@base_contains('MACHINE', 'spitz', ' c3200', '',d)}"
TARGET-DEVICE="${@base_contains('MACHINE', 'tosa', ' c3200', '',d)}"
TARGET-DEVICE="${@base_contains('MACHINE', 'fic-gta01', 'ficgta01', '',d)}"
TARGET-DEVICE="${@base_contains('MACHINE', 'fic-gta02', 'ficgta01', '',d)}"

require qtopia-phone_arch.inc

QT_ARCH = "${@qtopia_arch(d)}"
QT_ENDIAN = "${@qtopia_endian(d)}"
PLATFORM = "${BUILD_OS}-g++"
BUILDDIR = "${WORKDIR}/build"
OE_QT_PREFIX = "/opt/Qtopia"

export OE_QMAKE_CC="${CC}"
export OE_QMAKE_CFLAGS="${CFLAGS}"
export OE_QMAKE_CXX="${CXX}"
export OE_QMAKE_LDFLAGS="${LDFLAGS}"
export OE_QMAKE_AR="${AR}"
export OE_QMAKE_STRIP="echo"
export OE_QMAKE_RPATH="-Wl,-rpath-link,"

do_configure() {

# This qmake some how does not honor env var, let us fix it by sed force
sed -i s%$\(OE_QMAKE_CC\)%"${CC}"%g               ${S}/devices/${TARGET-DEVICE}/mkspecs/qws/linux-oe-g++/qmake.conf
sed -i s%$\(OE_QMAKE_CFLAGS\)%"${CFLAGS}"%g       ${S}/devices/${TARGET-DEVICE}/mkspecs/qws/linux-oe-g++/qmake.conf
sed -i s%$\(OE_QMAKE_CXX\)%"${CXX}"%g             ${S}/devices/${TARGET-DEVICE}/mkspecs/qws/linux-oe-g++/qmake.conf
sed -i s%$\(OE_QMAKE_CXXFLAGS\)%"${CXXFLAGS}"%g   ${S}/devices/${TARGET-DEVICE}/mkspecs/qws/linux-oe-g++/qmake.conf
sed -i s%$\(OE_QMAKE_LINK\)%"${CXX}"%g            ${S}/devices/${TARGET-DEVICE}/mkspecs/qws/linux-oe-g++/qmake.conf
sed -i s%$\(OE_QMAKE_LDFLAGS\)%"${LDFLAGS}"%g     ${S}/devices/${TARGET-DEVICE}/mkspecs/qws/linux-oe-g++/qmake.conf
sed -i s%$\(OE_QMAKE_AR\)%"${AR}"%g               ${S}/devices/${TARGET-DEVICE}/mkspecs/qws/linux-oe-g++/qmake.conf
sed -i s%$\(OE_QMAKE_STRIP\)%"echo"%g             ${S}/devices/${TARGET-DEVICE}/mkspecs/qws/linux-oe-g++/qmake.conf


unset CC
unset CXX
unset CFLAGS
unset CXXFLAGS
unset LDFLAGS


mkdir -p ${BUILDDIR}
cd ${BUILDDIR}
echo yes | ${S}/configure -xplatform linux-oe-g++ -arch ${QT_ARCH} ${QT_ENDIAN} -prefix ${OE_QT_PREFIX} -device ${TARGET-DEVICE} -verbose \
                          -no-drm -no-sxe -displaysize 480x640 -dbus -debug -extra-qtopiacore-config "-qt-libjpeg -qt-zlib -qt-libpng -no-iconv -no-sm -fontconfig -xrender -xrandr" \
                           -I${STAGING_INCDIR}/freetype2 -I${STAGING_INCDIR}/fontconfig -I${STAGING_INCDIR}/dbus-1.0

}

do_compile() {
    cd ${BUILDDIR}
    oe_runmake
}

do_stage() {
}


do_install() {
   cd ${BUILDDIR}
   oe_runmake install INSTALL_ROOT=${D}${OE_QT_PREFIX} IMAGE=${D}${OE_QT_PREFIX}

   # Install freedesktop.org .desktop files for enlightenment
   install -d ${D}${datadir}/applications
   for app in "${S}/apps-fdo/"*; do
     for file in "$app"/*.desktop; do
        install -m 0644 $file ${D}${datadir}/applications/
     done
   done 

   # Install good icons for the desktop files

   # Make sure qpe gets launched by X
   install -d ${D}/${sysconfdir}/X11/Xsession.d
   install -m 0755 ${WORKDIR}/Xsession.d/99qtopia ${D}${sysconfdir}/X11/Xsession.d/

   # Install some scripts
   install -d ${D}${bindir}
   install -m 0755 ${S}/bin/qcop-x11-launch ${D}${bindir}

   install -d ${D}${sysconfdir}/profile.d/
   install -m 0755 ${WORKDIR}/qtopia.sh ${D}${sysconfdir}/profile.d/
}

FILES_${PN} += "${OE_QT_PREFIX}/bin ${OE_QT_PREFIX}/help  \
                ${OE_QT_PREFIX}/lib/*.so.* ${OE_QT_PREFIX}/plugins/*/*.so \
                ${OE_QT_PREFIX}/qtopia_db.sqlite ${OE_QT_PREFIX}/sounds \
                ${OE_QT_PREFIX}/etc ${OE_QT_PREFIX}/i18n \
                ${OE_QT_PREFIX}/pics ${OE_QT_PREFIX}/qt_plugins/*/*.so \
                ${OE_QT_PREFIX}/services"

FILES_${PN}-dbg += "${OE_QT_PREFIX}/lib/.debug/ ${OE_QT_PREFIX}/bin/.debug/ \
                    ${OE_QT_PREFIX}/plugins/*/.debug/ ${OE_QT_PREFIX}/qt_plugins/*/.debug/ "

FILES_${PN}-dev += "${OE_QT_PREFIX}/lib/*.so"

