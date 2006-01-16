DESCRIPTION = "Edje is a complex graphical design & layout library."
# can also install vim data files
DEPENDS = "virtual/evas virtual/ecore eet embryo edje-native virtual/imlib2"
LICENSE = "MIT"
PR = "r1"

inherit efl

SRC_URI += "cvs://anonymous@thinktux.net/root;module=e17/libs/edje/m4;date=20060101"

LEAD_SONAME = "libedje.so"

FILES_${PN}-dev += "${bindir}"

RDEPENDS_${PN}-dev += "cpp"

do_configure_prepend() {
	install -d "${S}/m4"
	install "${WORKDIR}/m4/"*.m4 "${S}/m4"
	aclocal -I m4
}
