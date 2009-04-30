require mythtv.inc

inherit qmake2 qt4x11

DEFAULT_PREFERENCE = "-1"

PV = "0.21+0.22rc+svnr${SRCPV}"
PR = "r0"
REALPV = "0.22"

SRCREV = "20947"
SRC_URI = "svn://svn.mythtv.org/svn/trunk;module=mythtv;proto=http"

S = "${WORKDIR}/mythtv"

QMAKE_PROFILES = "mythtv.pro"

mythlibs = "mythdb mythavutil mythavcodec mythavformat mythswscale mythhdhomerun myth mythtv mythui mythfreemheg mythupnp mythlivemedia"
PACKAGES =+ "mythtv-backend mythtv-frontend mythtv-bin mythtv-filters mythtv-data"

FILES_${PN}-dbg += "${libdir}/mythtv/filters/.debug"
FILES_mythtv-backend = "${bindir}/mythbackend ${bindir}/mythcommflag ${bindir}/mythfilldatabase ${bindir}/mythtranscode"
FILES_mythtv-frontend = "${bindir}/mythfrontend ${datadir}/mythtv/i18n/mythfrontend_* ${datadir}/mythtv/*.ttf"
FILES_mythtv-bin = "${bindir}/*"
FILES_mythtv-filters = "${libdir}/mythtv/filters/*"
FILES_mythtv-data = "${datadir}"
RDEPENDS_${PN} = "mythtv-backend mythtv-frontend mythtv-bin mythtv-filters mythtv-data"
ALLOW_EMPTY_${PN} = "1"

PACKAGES_DYNAMIC = "mythtv-theme-*"

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

EXTRA_MYTHTVCONF_armv7a  = "--cpu=cortex-a8"
EXTRA_MYTHTVCONF ?= ""

EXTRA_OECONF = " \
        --cross-prefix=${TARGET_PREFIX} \
        --sysroot=${STAGING_DIR_HOST} \
        --prefix=${prefix} \
        \
        --arch=${TARGET_ARCH} \
        --extra-cflags="${TARGET_CFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-cxxflags="${TARGET_CXXFLAGS} ${HOST_CC_ARCH}${TOOLCHAIN_OPTIONS}" \
        --extra-ldflags="${TARGET_LDFLAGS}" \
        ${EXTRA_MYTHTVCONF} \
"

do_configure_prepend() {
# it's not autotools anyway, so we call ./configure directly
	find . -name "Makefile"|xargs rm -f

	./configure     --qmake=qmake2          \
			--disable-altivec	\
		 	--disable-opengl	\
			--disable-stripping	\
			--disable-xvmc		\
			--enable-v4l		\
			--enable-audio-oss	\
			--enable-dvb		\
			--enable-libmp3lame \
            --dvb-path=${STAGING_INCDIR} \
			--without-bindings=perl,python \
			${EXTRA_OECONF}
}

python populate_packages_prepend () {
	new_packages = []

	def the_hook(file, pkg, pattern, format, basename):
		new_packages.append(pkg)

	do_split_packages(d, root=bb.data.expand('${datadir}/mythtv/themes', d), file_regex='(.*)', output_pattern='mythtv-theme-%s', description='MythTV theme %s', allow_dirs=True, hook=the_hook, prepend=True)

	bb.data.setVar("RDEPENDS_${PN}", "%s %s" % (bb.data.getVar("RDEPENDS_${PN}", d), " ".join(new_packages)), d)
}
