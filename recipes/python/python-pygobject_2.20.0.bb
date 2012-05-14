DESCRIPTION = "Python GObject bindings"
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
DEPENDS = "libffi python-pygobject-native-${PV} glib-2.0"
PE = "1"

PR = "r4"

MAJ_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"

SRC_URI = "\
  ftp://ftp.gnome.org/pub/GNOME/sources/pygobject/${MAJ_VER}/pygobject-${PV}.tar.bz2 \
  file://generate-constants.patch \
"
S = "${WORKDIR}/pygobject-${PV}"

inherit autotools distutils-base pkgconfig

# necessary to let the call for python-config succeed
export BUILD_SYS
export HOST_SYS

# It picks up the introspection pc for the host sysroot without a knob to disable it, so force it to false
do_configure_prepend() {
	sed -i 's:have_gobject_introspection=true:have_gobject_introspection=false:g' configure.ac
}

do_install_append() {
	install -d ${D}${datadir}/pygobject/
	cp -PpRfR docs/* ${D}${datadir}/pygobject/
	install -d ${D}${datadir}/gtk-doc/html/pygobject/
	cp docs/style.css ${D}${datadir}/gtk-doc/html/pygobject/
}

PACKAGES += "${PN}-lib"

RDEPENDS_${PN} += "python-textutils"

FILES_${PN} = "${libdir}/python*"
FILES_${PN}-lib = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir} ${datadir}"
FILES_${PN}-dbg += "${libdir}/.debug"

SRC_URI[md5sum] = "10e1fb79be3d698476a28b1e1b0c5640"
SRC_URI[sha256sum] = "41e923a3f4426a3e19f6d154c424e3dac6f39defca77af602ac6272ce270fa81"
