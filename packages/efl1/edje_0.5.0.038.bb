DESCRIPTION = "Edje is a complex graphical design & layout library."
# can also install vim data files
DEPENDS = "eet evas ecore embryo edje-native"
LICENSE = "MIT"
PR = "r7"

inherit efl1 lib_package

SRC_URI += "${E_CVS};module=e17/libs/edje/m4;date=20060101"

do_configure_prepend() {
	install -d "${S}/m4"
	install "${WORKDIR}/m4/"*.m4 "${S}/m4"
	aclocal -I m4
}

FILES_${PN}-dev =+ "${bindir} ${datadir}"
FILES_${PN}-examples = ""
FILES_${PN}-bin = ""

