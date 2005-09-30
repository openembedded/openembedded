DESCRIPTION = "Edje is a complex graphical design & layout library."
# can also install vim data files
DEPENDS = "virtual/evas virtual/ecore eet embryo edje-native virtual/imlib2"
LICENSE = "MIT"
PR = "r1"

inherit efl

SRC_URI += "http://cvs.sourceforge.net/viewcvs.py/*checkout*/enlightenment/e17/libs/edje/m4/ac_expand_dir.m4?rev=1.1 \
            http://cvs.sourceforge.net/viewcvs.py/*checkout*/enlightenment/e17/libs/edje/m4/ac_path_generic.m4?rev=1.2"

LEAD_SONAME = "libedje.so"

FILES_${PN}-dev += "${bindir}"

RDEPENDS_${PN}-dev += "cpp"

do_configure_prepend() {
	install -D "${WORKDIR}/ac_expand_dir.m4?rev=1.1" "${S}/m4/ac_expand_dir.m4"
	mv "${WORKDIR}/ac_path_generic.m4?rev=1.2" "${S}/m4/ac_path_generic.m4"
	aclocal -I m4
}
