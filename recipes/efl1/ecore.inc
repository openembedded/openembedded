DESCRIPTION = "Ecore is the Enlightenment application framework library"
LICENSE = "MIT BSD"
DEPENDS = "curl eet evas tslib libxtst libxcomposite libxinerama libxscrnsaver libxdamage libxrandr libxcursor libxprintutil"
# optional
# DEPENDS += "directfb libsdl-x11 openssl virtual/libiconv"
PV = "0.9.9.060+svnr${SRCREV}"
PR = "r0"

inherit efl

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/ecore"

python populate_packages_prepend() {
	plugindir = bb.data.expand('${libdir}/', d)
	do_split_packages(d,
		plugindir,
		'^libecore_(.+)-ver-pre-svn-(.*)\.so\.(.*)',
		'ecore-lib-%s',
		'ECore support for %s',
		extra_depends = '',
		aux_files_pattern = ['${libdir}/libecore_%s*.so.*'] )
}

FILES_${PN} = "${libdir}/libecore-ver-pre-svn*.so.*"
PACKAGES_DYNAMIC = "ecore-lib-*"
