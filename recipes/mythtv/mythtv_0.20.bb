require mythtv.inc

inherit qmake2 qt3x11

DEPENDS += "openchrome"
PR = "r1"

SRC_URI += "file://configure.patch;patch=1 \
            file://libmyth-libdir.patch;patch=1"

# Seen on the mythtv web page:
# http://www.mythtv.org/mc/fix-mythweb-in-0.20.diff;patch=1

QMAKE_PROFILES = "mythtv.pro"

mythlibs = "mythavutil mythavcodec mythavformat myth mythtv mythui mythfreemheg mythupnp mythlivemedia"
PACKAGES =+ "mythtv-backend mythtv-frontend mythtv-bin mythtv-filters mythtv-data"

FILES_mythtv-backend = "${bindir}/mythbackend ${bindir}/mythcommflag ${bindir}/mythfilldatabase ${bindir}/mythtranscode"
FILES_mythtv-frontend = "${bindir}/mythfrontend ${datadir}/mythtv/i18n/mythfrontend_* ${datadir}/mythtv/*.ttf"
RDEPENDS_mythtv-frontend = "qt-x11-plugins-sqldrivers qt-x11-plugins-imageformats"
FILES_mythtv-bin = "${bindir}"
FILES_mythtv-filters = "${libdir}/mythtv/filters"
FILES_mythtv-data = "${datadir}"
RDEPENDS_${PN} = "mythtv-backend mythtv-frontend mythtv-bin mythtv-filters mythtv-data"
ALLOW_EMPTY_${PN} = "1"

PACKAGES_DYNAMIC = "mythtv-theme-*"

python __anonymous () {
    import bb

    mythlibs = bb.data.getVar('mythlibs', d).split()
    pv = bb.data.expand(bb.data.getVar("PV", d), d)

    for m in mythlibs:
        bb.data.setVar("FILES_lib%s%s" % (m, pv), "${libdir}/lib%s-%s.so.*" % (m, pv), d)
        bb.data.setVar("FILES_lib%s%s-dev" % (m, pv), "${libdir}/lib%s-%s.*" % (m, pv), d)

    packages = " ".join(map(lambda x: "lib%s%s lib%s%s-dev" % (x, pv, x, pv), mythlibs) + bb.data.getVar("PACKAGES", d).split())

    bb.data.setVar("PACKAGES", packages, d)
}
do_configure_prepend() {
# it's not autotools anyway, so we call ./configure directly
	find . -name "Makefile"|xargs rm -f
	./configure	--prefix=/usr		\
			--mandir=/usr/man 	\
			--cpu=${MYTHTV_ARCH}	\
			--enable-mmx		\
			--disable-altivec	\
			--enable-v4l		\
			--enable-audio-oss	\
			--enable-proc-opt	\
			--enable-xvmc		\
			--enable-xvmc-pro	\
			--enable-dvb		\
			--dvb-path=${STAGING_INCDIR}

	sed 's!PREFIX =.*!PREFIX = ${prefix}!;/INCLUDEPATH += $${PREFIX}\/include/d' < settings.pro > settings.pro.new
	mv settings.pro.new settings.pro
}

python populate_packages_prepend () {
	new_packages = []

	def the_hook(file, pkg, pattern, format, basename):
		new_packages.append(pkg)

	do_split_packages(d, root=bb.data.expand('${datadir}/mythtv/themes', d), file_regex='(.*)', output_pattern='mythtv-theme-%s', description='MythTV theme %s', allow_dirs=True, hook=the_hook, prepend=True)

	bb.data.setVar("RDEPENDS_${PN}", "%s %s" % (bb.data.getVar("RDEPENDS_${PN}", d), " ".join(new_packages)), d)
}
