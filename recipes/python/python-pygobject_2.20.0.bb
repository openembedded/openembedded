DESCRIPTION = "Python GObject bindings"
SECTION = "devel/python"
LICENSE = "LGPL"
DEPENDS = "libffi python-pygobject-native-${PV}"
PE = "1"

PR = "r1"

MAJ_VER = "${@bb.data.getVar('PV',d,1).split('.')[0]}.${@bb.data.getVar('PV',d,1).split('.')[1]}"

SRC_URI = "\
  ftp://ftp.gnome.org/pub/GNOME/sources/pygobject/${MAJ_VER}/pygobject-${PV}.tar.bz2 \
  file://generate-constants.patch;patch=1 \
"
S = "${WORKDIR}/pygobject-${PV}"

FILESPATH = "${FILE_DIRNAME}/python-pygobject:${FILE_DIRNAME}/files"

inherit autotools distutils-base pkgconfig

# necessary to let the call for python-config succeed
export BUILD_SYS
export HOST_SYS

export GOBJECT_INTROSPECTION_CFLAGS="-pthread -I${STAGING_INCDIR}/gobject-introspection-1.0 -I${STAGING_INCDIR}/glib-2.0 -I${STAGING_LIBDIR}/glib-2.0/include"

do_install_append() {
	install -d ${D}${datadir}/pygobject/
	cp -dpfR docs/* ${D}${datadir}/pygobject/
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
