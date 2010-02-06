require abiword-2.5.inc

PR = "r4"

SRC_URI = "http://www.abisource.com/downloads/abiword/${PV}/source/abiword-${PV}.tar.gz \
           file://autogen-common.sh \
	   file://nodolt.patch;patch=1"

do_configure() {
	autotools_do_configure
}

EXTRA_OECONF = " --disable-static  \
                 --enable-plugins \
                 --enable-collab-backend-xmpp \
                 --enable-collab-backend-tcp \
                 --enable-collab-backend-service \
                 --with-libwmf-config=${STAGING_DIR} \
"
DEPENDS += " libwmf-native gtkmathview "
RCONFLICTS = "abiword-embedded"

FILES_${PN} 			+= "${libdir}/libabiword-*.so ${datadir}/mime-info ${datadir}/abiword-${SHRT_VER}/certs ${datadir}/abiword-${SHRT_VER}/ui ${datadir}/abiword-${SHRT_VER}/xsl* ${datadir}/abiword-${SHRT_VER}/mime-info ${datadir}/abiword-${SHRT_VER}/Pr*.xml"
FILES_abiword-strings           += "${datadir}/abiword-${SHRT_VER}/strings"
FILES_abiword-systemprofiles    += "${datadir}/abiword-${SHRT_VER}/system.profile*"

PACKAGES_DYNAMIC = "abiword-meta abiword-plugin-*"

do_configure_prepend () {
	install -m 0755 ${WORKDIR}/autogen-common.sh ${S}/autogen-common.sh
	cd ${S}
	./autogen-common.sh
}

python populate_packages_prepend () {
	abiword_libdir    = bb.data.expand('${libdir}/abiword-2.8/plugins', d)
	do_split_packages(d, abiword_libdir, '(.*)\.so$', 'abiword-plugin-%s', 'Abiword plugin for %s', extra_depends='')

	metapkg = "abiword-meta"
	bb.data.setVar('ALLOW_EMPTY_' + metapkg, "1", d)
	bb.data.setVar('FILES_' + metapkg, "", d)
	blacklist = [ 'abiword-plugins-dbg', 'abiword-plugins', 'abiword-plugins-doc', 'abiword-plugins-dev', 'abiword-plugins-locale' ]
	metapkg_rdepends = []
	packages = bb.data.getVar('PACKAGES', d, 1).split()
	for pkg in packages[1:]:
		if not pkg in blacklist and not pkg in metapkg_rdepends and not pkg.count("-dev") and not pkg.count("-dbg") and not pkg.count("static") and not pkg.count("locale") and not pkg.count("abiword-doc"):
			print "Modifying ", pkg
			metapkg_rdepends.append(pkg)
	bb.data.setVar('RDEPENDS_' + metapkg, ' '.join(metapkg_rdepends), d)
	bb.data.setVar('DESCRIPTION_' + metapkg, 'abiword-plugin meta package', d)
	packages.append(metapkg)
	bb.data.setVar('PACKAGES', ' '.join(packages), d)
}

FILES_${PN}-dev += "${libdir}/abiword-${SHRT_VER}/plugins/*.la"
FILES_${PN}-dbg += "${libdir}/abiword-${SHRT_VER}/plugins/.debug"

