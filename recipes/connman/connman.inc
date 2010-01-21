DESCRIPTION = "The Moblin Connection Manager"
HOMEPAGE = "http://www.moblin.org/projects/projects_connman.php"
SECTION = "libs/network"
LICENSE = "GPL"
# we need to define the depends here, the dynamic stuff is too late
DEPENDS  = "libnl2 wpa-supplicant dbus glib-2.0 ppp busybox dhclient resolvconf bluez4"

EXTRA_OECONF += "\
    ac_cv_path_WPASUPPLICANT=/usr/sbin/wpa_supplicant \
    ac_cv_path_DHCLIENT=/sbin/dhclient \
    ac_cv_path_UDHCPC=/sbin/udhcpc \
    ac_cv_path_RESOLVCONF=/sbin/resolvconf \
    ac_cv_path_PPPD=/usr/sbin/pppd \
"

INITSCRIPT_NAME = "connman"
INITSCRIPT_PARAMS = "start 05 5 2 . stop 22 0 1 6 ."

PARALLEL_MAKE = ""

inherit autotools pkgconfig update-rc.d

do_configure_append() {
	ln -sf . include/connman
}

do_compile_append() {
	sed -i -e s:deny:allow:g src/connman-dbus.conf
}

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/connman ${D}${sysconfdir}/init.d/connman
}

do_stage() {
	autotools_stage_all
}

python populate_packages_prepend() {
	depmap = dict( pppd="ppp", udhcp="busybox connman-scripts", dhclient="dhclient", wifi="wpa-supplicant", resolvconf="resolvconf", bluetooth="bluez4" )
	packages = []
	hook = lambda file,pkg,b,c,d:packages.append((file,pkg))
	plugin_dir = bb.data.expand('${libdir}/connman/plugins/', d)
	plugin_name = bb.data.expand('${PN}-plugin-%s', d)
	do_split_packages(d, plugin_dir, '^(.*).so$', plugin_name, '${PN} plugin for %s', extra_depends='', hook=hook )
	for (file, package) in packages:
		plugintype = package.split( '-' )[-1]
		if plugintype in depmap:
			rdepends = bb.data.getVar( "RDEPENDS_%s" % package, d )
			bb.note( "Adding rdependency on %s to package %s" % ( depmap[plugintype], package ) )
			bb.data.setVar("RDEPENDS_%s" % package, depmap[plugintype], d)
}

PACKAGES_DYNAMIC = "${PN}-plugin-*"

PACKAGES += "${PN}-scripts ${PN}-test-utils"

FILES_${PN} = "${bindir}/* ${sbindir}/* ${libexecdir}/* ${libdir}/lib*.so.* \
            ${sysconfdir} ${sharedstatedir} ${localstatedir} \
            ${base_bindir}/* ${base_sbindir}/* ${base_libdir}/*.so* ${datadir}/${PN} \
            ${datadir}/pixmaps ${datadir}/applications \
            ${datadir}/idl ${datadir}/omf ${datadir}/sounds \
            ${libdir}/bonobo/servers \
            ${datadir}/dbus-1/system-services/*"

FILES_${PN}-test-utils += "${libdir}/connman/test/*"

FILES_${PN}-scripts += "${libdir}/connman/scripts"
FILES_${PN}-dbg += "${libdir}/connman/*/.debug"
FILES_${PN}-dev += "${libdir}/connman/*/*.la"

