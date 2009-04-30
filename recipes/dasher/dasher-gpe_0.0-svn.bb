LICENSE="GPL"
PV = "0.0+svnr${SRCPV}"
PR = "r1"
DEPENDS = "libxsettings-client libglade libxtst gconf gtk+"
SECTION = "gpe"
SRC_URI = "svn://svn.gnome.org/svn/dasher;module=trunk \
	file://configure-lossage.patch;patch=1"

S = "${WORKDIR}/trunk"
FILES_${PN} += "${datadir}/dasher"

inherit autotools


EXTRA_OECONF = "--with-gpe --without-gnome --without-speech --without-a11y"
LDFLAGS_append = '-Wl,--export-dynamic'

do_configure_prepend() {
	rm -f m4/libtool.m4
	intltoolize --force
}

do_install_append () {
	install -d ${D}${datadir}/pixmaps/
	mv ${D}${datadir}/icons/dasher.png ${D}${datadir}/pixmaps/
}

python populate_packages_prepend () {
	do_split_packages(d, bb.data.expand("${datadir}/dasher", d), "training_(.*).txt", "dasher-training-data-%s", "Dasher training data for %s", prepend=True)
}

