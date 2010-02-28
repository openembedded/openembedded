require mythtv.inc

DEPENDS_{PN} += "libmyth"
DEPENDS_libmyth = "libmythdb libmythavutil libmythavcodec libmythavformat libmythswscale libmythhdhomerun \
	libmythtv libmythui libmythfreemheg libmythupnp libmythlivemedia"

RDEPENDS_${PN} = "mythtv-backend mythtv-frontend mythtv-bin mythtv-filters mythtv-database \
mysql5-server mysql5-client libmysqlclient qt4-plugin-sqldriver-sqlmysql xmltv"
RDEPENDS_${PN}_append_libc-glibc = " glibc-gconv-utf-16"

PR = "svnr${SRCPV}+r8"
PV = "0.22"

# REALPV is here to support release candidates
# OE in that case has as PV something like 0.21+0.22rc1
# but for packaging the real PV is needed
REALPV = "0.22"

SRCREV = "23565"
SRC_URI = "svn://svn.mythtv.org/svn/branches/release-0-22-fixes;module=mythtv;proto=http"

S = "${WORKDIR}/mythtv"

ALLOW_EMPTY_${PN} = "1"

QMAKE_PROFILES = "mythtv.pro"

SRC_URI += " \
        file://configure.patch;patch=1 \
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

PACKAGES =+ "mythtv-backend mythtv-frontend mythtv-bin mythtv-filters mythtv-database"
PACKAGES_DYNAMIC = "mythtv-theme-*"

FILES_${PN}-dbg += "${libdir}/mythtv/filters/.debug"
FILES_mythtv-backend = "${bindir}/mythbackend ${bindir}/mythcommflag ${bindir}/mythfilldatabase ${bindir}/mythtranscode"
FILES_mythtv-frontend = "${bindir}/mythfrontend ${datadir}/mythtv/i18n/mythfrontend_* ${datadir}/mythtv/*.ttf"
FILES_mythtv-bin = "${bindir}/*"
FILES_mythtv-filters = "${libdir}/mythtv/filters/*"
FILES_mythtv-database = "${datadir}/mythtv/sql/"

RRECOMMENDS_mythtv-frontend += "mythtv-theme-defaultmenu mythtv-theme-terra"

mythlibs = "mythdb mythavutil mythavcodec mythavformat mythswscale mythhdhomerun myth mythtv mythui mythfreemheg mythupnp mythlivemedia"

python __anonymous () {
    import bb
    mythlibs = bb.data.getVar('mythlibs', d).split()
    pv = bb.data.expand(bb.data.getVar("REALPV", d), d)
    for m in mythlibs:
        bb.data.setVar("FILES_lib%s%s" % (m, pv), "${libdir}/lib%s-%s.so.*" % (m, pv), d)
        bb.data.setVar("FILES_lib%s%s-dev" % (m, pv), "${libdir}/lib%s-%s.*" % (m, pv), d)
    packages = " ".join(map(lambda x: "lib%s%s lib%s%s-dev" % (x, pv, x, pv), mythlibs) + bb.data.getVar("PACKAGES", d).split())
    bb.data.setVar("PACKAGES", packages, d)
}
python populate_packages_prepend () {
        new_packages = []
        def the_hook(file, pkg, pattern, format, basename):
                new_packages.append(pkg)
        do_split_packages(d, root=bb.data.expand('${datadir}/mythtv/themes', d), file_regex='(.*)', output_pattern='mythtv-theme-%s', description='MythTV theme %s', allow_dirs=True, hook=the_hook, prepend=True)
        bb.data.setVar("RDEPENDS_${PN}", "%s %s" % (bb.data.getVar("RDEPENDS_${PN}", d), " ".join(new_packages)), d)
}
