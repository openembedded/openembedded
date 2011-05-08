DESCRIPTION = "Native version Qt/[X11|Mac|Embedded]"
DEPENDS = "zlib-native dbus-native"
SECTION = "libs"
HOMEPAGE = "http://www.trolltech.com"
PRIORITY = "optional"
LICENSE = "GPL"
PROVIDES = "qt4-tools-native"

INC_PR = "r0"

inherit native

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-everywhere-opensource-src-${PV}.tar.gz \
           file://qt-config.patch \
           file://g++.conf \
           file://linux.conf"
S = "${WORKDIR}/qt-everywhere-opensource-src-${PV}"

EXTRA_OECONF = "-prefix ${prefix} \
                -L ${STAGING_LIBDIR_NATIVE} \
                -I ${STAGING_INCDIR_NATIVE} \
                -qt-libjpeg -qt-gif -system-zlib \
                -no-libjpeg -no-libpng -no-libmng -no-libtiff \
                -no-accessibility \
                -no-cups \
                -no-nas-sound \
                -no-nis -no-openssl \
                -verbose -release \
                -embedded -no-freetype -no-glib -no-iconv \
                -exceptions -xmlpatterns \
                -qt3support"

# yank default -e, otherwise we get the following error:
# moc_qbuffer.cpp: No such file or directory
EXTRA_OEMAKE = " "

do_configure() {
   (echo o; echo yes) | ./configure ${EXTRA_OECONF} || die "Configuring qt failed. EXTRA_OECONF was ${EXTRA_OECONF}"
}

TOBUILD = "\
  src/tools/moc \
  src/corelib \
  src/sql \
  src/xml \
  src/network \
  src/tools/uic \
  src/tools/rcc \
  src/xmlpatterns \
  src/dbus \
  src/gui \
  src/testlib \
  src/qt3support \
"

do_compile() {
    for i in ${TOBUILD}; do
        cd ${S}/$i && oe_runmake CC="${CC}" CXX="${CXX}"
    done
}

NATIVE_INSTALL_WORKS = "1"

do_install() {
    for i in ${TOBUILD}; do
        cd ${S}/$i && oe_runmake install INSTALL_ROOT=${D}
    done
}
