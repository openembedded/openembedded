require mythtv.inc

inherit qmake qt3x11

PR = "${SRCREV}+r3"
REALPV = "0.21"

SRCREV = "17789"
SRC_URI = "svn://svn.mythtv.org/svn/branches/release-0-21-fixes;module=mythtv;proto=http"

SRC_URI += " \
            file://ffmpeg-arm-update.diff;patch=1 \
            file://no-cortex-deadlock.patch;patch=1;pnum=2 \
            file://configure.patch;patch=1 \
            file://configh \
	    file://configmak \
	    "

S = "${WORKDIR}/mythtv"

QMAKE_PROFILES = "mythtv.pro"

mythlibs = "mythavutil mythavcodec mythavformat myth mythtv mythui mythfreemheg mythupnp mythlivemedia"
PACKAGES =+ "mythtv-backend mythtv-frontend mythtv-bin mythtv-filters mythtv-data"

FILES_${PN}-dbg += "${libdir}/mythtv/filters/.debug"
FILES_mythtv-backend = "${bindir}/mythbackend ${bindir}/mythcommflag ${bindir}/mythfilldatabase ${bindir}/mythtranscode"
FILES_mythtv-frontend = "${bindir}/mythfrontend ${datadir}/mythtv/i18n/mythfrontend_* ${datadir}/mythtv/*.ttf"
RDEPENDS_mythtv-frontend = "qt-x11-plugins-sqldrivers qt-x11-plugins-imageformats"
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

EXTRA_OECONF_armv5te = " --enable-armv5te "
EXTRA_OECONF_armv6 = " --enable-armv6 "
EXTRA_OECONF_armv7a = " --enable-armv6"

#build with support for the iwmmxt instruction and pxa270fb overlay support (pxa270 and up)
#not every iwmmxt machine has the lcd connected to pxafb, but building the module doesn't hurt
MY_ARCH := "${PACKAGE_ARCH}"
PACKAGE_ARCH = "${@base_contains('MACHINE_FEATURES', 'iwmmxt', 'iwmmxt', '${MY_ARCH}',d)}"

MY_TARGET_CC_ARCH := "${TARGET_CC_ARCH}"
TARGET_CC_ARCH = "${@base_contains('MACHINE_FEATURES', 'iwmmxt', '-march=iwmmxt -mtune=iwmmxt', '${MY_TARGET_CC_ARCH}',d)}"

EXTRA_OECONF_append = " ${@base_contains('MACHINE_FEATURES', 'iwmmxt', '--enable-pxa --enable-iwmmxt', '',d)} "

do_configure_prepend() {
# it's not autotools anyway, so we call ./configure directly
	find . -name "Makefile"|xargs rm -f

	./configure	--prefix=/usr		\
			--mandir=/usr/man 	\
			--cpu=${MYTHTV_ARCH}	\
			--arch=${MYTHTV_ARCH} \
			--disable-altivec	\
		 	--disable-directfb	\
			--disable-opengl-video \
			--disable-strip \
			--enable-v4l		\
			--enable-audio-oss	\
			--enable-proc-opt	\
			--enable-dvb		\
			--enable-libmp3lame \
			--cross-compile	\
			--dvb-path=${STAGING_INCDIR} \
			--with-bindings= \
			${EXTRA_OECONF}

	sed 's!PREFIX =.*!PREFIX = ${prefix}!;/INCLUDEPATH += $${PREFIX}\/include/d' < settings.pro > settings.pro.new
	mv settings.pro.new settings.pro
	for pro in ${S}/*/*pro ${S}/*/*/*pro ${S}/*/*/*/*pro ; do
		sed -i -e s:opengl::g $pro
	done
	sed -i /.SUBDIR/d ${S}/bindings/*pro
	cat ${WORKDIR}/configh >> ${S}/config.h
	cat ${WORKDIR}/configmak  ${OPTSMAK} >> ${S}/config.mak
}

python populate_packages_prepend () {
	new_packages = []

	def the_hook(file, pkg, pattern, format, basename):
		new_packages.append(pkg)

	do_split_packages(d, root=bb.data.expand('${datadir}/mythtv/themes', d), file_regex='(.*)', output_pattern='mythtv-theme-%s', description='MythTV theme %s', allow_dirs=True, hook=the_hook, prepend=True)

	bb.data.setVar("RDEPENDS_${PN}", "%s %s" % (bb.data.getVar("RDEPENDS_${PN}", d), " ".join(new_packages)), d)
}
