DESCRIPTION = "A full featured personal video recorder system."
HOMEPAGE = "http://www.mythtv.org"
LICENSE = "GPLv2"
SECTION = "x11/multimedia"
DEPENDS = "jack alsa-lib libxinerama libxv libxxf86vm libxvmc lirc pulseaudio \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'lame', d)}"
RDEPENDS_${PN} = "libmyth mythtv-backend mythtv-frontend mythtv-bin mythtv-filters mythtv-database \
	   mysql5-server mysql5-client libmysqlclient qt4-plugin-sqldriver-sqlmysql xmltv"
#RDEPENDS_${PN} = "qt-x11-plugins-sqldrivers qt-x11-plugins-imageformats"
RDEPENDS_${PN}_append_libc-glibc = " glibc-gconv-utf-16"

ARM_INSTRUCTION_SET = "arm"

QMAKE_PROFILES = "mythtv.pro"

PR = "svnr${SRCPV}+r0"
PV = "0.23"

# REALPV is here to support release candidates
# OE in that case has as PV something like 0.21+0.22rc1
# but for packaging the real PV is needed
REALPV = "0.23"

SRCREV = "27202"
SRC_URI = "svn://svn.mythtv.org/svn/branches/release-0-23-fixes;module=mythtv;proto=http"

S = "${WORKDIR}/mythtv"

ALLOW_EMPTY_${PN} = "1"

QMAKE_PROFILES = "mythtv.pro"

SRC_URI += " \
        file://configure.patch \
        "

inherit qmake2 qt4x11

EXTRA_MYTHTVCONF_armv7a = "--cpu=cortex-a8"
EXTRA_MYTHTVCONF_armv5te = "--cpu=armv5te"
EXTRA_MYTHTVCONF ?= ""
EXTRA_OECONF = " \
        --cross-prefix=${TARGET_PREFIX} \
        --sysroot=${STAGING_DIR_HOST} \
        --prefix=${prefix} \
        --arch=${TARGET_ARCH} \
        \
        --extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-cxxflags="${TARGET_CXXFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-ldflags="${TARGET_LDFLAGS}" \
        ${EXTRA_MYTHTVCONF} \
        "

do_configure_prepend() {
# it's not autotools anyway, so we call ./configure directly
        find . -name "Makefile"|xargs rm -f
        ./configure     --qmake=qmake2          \
                        --disable-altivec        \
                         --disable-opengl        \
                        --disable-stripping        \
                        --disable-xvmc                \
                        --enable-v4l                \
                        --enable-audio-oss        \
                        --enable-dvb                \
                        --enable-libmp3lame \
            --dvb-path=${STAGING_INCDIR} \
                        --without-bindings=perl,python \
                        ${EXTRA_OECONF}
}

do_install() {
        oe_runmake INSTALL_ROOT=${D} install
        install -d ${D}${datadir}/mythtv
        install -d ${D}${datadir}/mythtv/sql
        install -m 0644 ${S}/database/mc.sql ${D}${datadir}/mythtv/sql
}

PACKAGES =+ "libmyth mythtv-backend mythtv-frontend mythtv-bin mythtv-filters mythtv-database"
PACKAGES_DYNAMIC = "mythtv-theme-*"

FILES_libmyth = "${libdir}/lib*.so.*"
FILES_libmyth-dev = "${libdir}/lib*.so ${libdir}/lib*.a ${incdir}/*"
FILES_libmyth-dbg = "${libdir}/.debug
FILES_${PN}-dbg += "${libdir}/mythtv/filters/.debug"
FILES_mythtv-backend = "${bindir}/mythbackend ${bindir}/mythcommflag ${bindir}/mythfilldatabase ${bindir}/mythtranscode"
FILES_mythtv-frontend = "${bindir}/mythfrontend ${datadir}/mythtv/i18n/mythfrontend_* ${datadir}/mythtv/*.ttf"
FILES_mythtv-bin = "${bindir}/*"
FILES_mythtv-filters = "${libdir}/mythtv/filters/*"
FILES_mythtv-database = "${datadir}/mythtv/sql/"

RRECOMMENDS_mythtv-frontend += "mythtv-theme-defaultmenu mythtv-theme-terra"

mythlibs = "mythdb mythavutil mythavcodec mythavformat mythswscale mythhdhomerun myth mythtv mythui mythfreemheg mythupnp mythlivemedia"

python populate_packages_prepend () {
        new_packages = []
        def the_hook(file, pkg, pattern, format, basename):
                new_packages.append(pkg)
        do_split_packages(d, root=bb.data.expand('${datadir}/mythtv/themes', d), file_regex='(.*)', output_pattern='mythtv-theme-%s', description='MythTV theme %s', allow_dirs=True, hook=the_hook, prepend=True)
        bb.data.setVar("RDEPENDS_${PN}", "%s %s" % (bb.data.getVar("RDEPENDS_${PN}", d), " ".join(new_packages)), d)
}
