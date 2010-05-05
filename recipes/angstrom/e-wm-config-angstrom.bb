DESCRIPTION = "Enlightenment DR17 theme for Angstrom"
LICENSE = "MIT/BSD"
DEPENDS = "edje-native eet-native e-wm places gnome-icon-theme"

PACKAGES_DYNAMIC = "e-wm-config-angstrom*"

PR = "r14"

SRC_URI = " \
          file://configs \
          "
S = "${WORKDIR}/configs"

# [09:16:17] * koen mumbles something about binary config file
# [09:16:19] <raster> eet -d e.cfg config e.src
# [09:16:29] <raster> will get u a test dump of it (as e.src)
# [09:17:09] <raster> eet -e e.cfg config e.src 1
# [09:17:12] <raster> will re-encode 

do_compile() {
rm ${S}/patches -rf
for dir in ${S}/* ; do	
	cd $dir
	for i in *.src ; do
		eet -e $(echo $i | sed s:src:cfg:g) config $i 1
	done
done
}

do_install() {
 	for i in ${WORKDIR}/configs/* ; do
		install -d ${D}${datadir}/enlightenment/data/config/$(basename $i)/
    
		install -m 0644 ${S}/$(basename $i)/*.cfg ${D}${datadir}/enlightenment/data/config/$(basename $i)/
		install -m 0644 ${S}/$(basename $i)/*.desktop ${D}${datadir}/enlightenment/data/config/$(basename $i)/
		install -m 0644 ${S}/$(basename $i)/*.png ${D}${datadir}/enlightenment/data/config/$(basename $i)/
	done
}

RDEPENDS_${PN} = "e-wm places gnome-icon-theme"

python populate_packages_prepend () {
	angstrom_e_dir = bb.data.expand('${datadir}/enlightenment/data/config', d)
	do_split_packages(d, angstrom_e_dir, '(.*)', 'e-wm-config-%s', 'E17 window manager %s config', extra_depends='e-wm places gnome-icon-theme', allow_links=True, allow_dirs=True)
}

PACKAGE_ARCH = "all"

