
LICENSE="GPL"
PR = "r1"
DEPENDS = "libxsettings-client libglade libxtst gconf gtk+"
SECTION = "gpe"
SRC_URI = "cvs://anonymous@anoncvs.gnome.org/cvs/gnome;module=dasher;date=20040828 \
	file://configure-lossage.patch;patch=1"

S = "${WORKDIR}/dasher"
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

