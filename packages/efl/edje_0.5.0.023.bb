DESCRIPTION = "Edje is a complex graphical design & layout library."
# can also install vim data files
DEPENDS = "virtual/evas virtual/ecore eet embryo edje-native virtual/imlib2"
LICENSE = "MIT"
PR = "r3"

PACKAGES += "edje-utils"
FILES_edje-utils += "${bindir} ${datadir}/edje/data/template ${datadir}/edje/include"
RDEPENDS_edje-utils += "cpp"

inherit efl

FILES_${SRCNAME}-themes = ""

SRC_URI += "cvs://anonymous@thinktux.net/root;module=e17/libs/edje/m4;date=20060101"

LEAD_SONAME = "libedje.so"

do_configure_prepend() {
	install -d "${S}/m4"
	install "${WORKDIR}/m4/"*.m4 "${S}/m4"
	aclocal -I m4
}
