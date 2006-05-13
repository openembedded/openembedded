DESCRIPTION = "Edje is a complex graphical design & layout library."
DEPENDS = "edje embryo-utils gcc"
LICENSE = "MIT"
PR = "r6"

inherit efl

PACKAGES = "edje-utils"
FILES_${PN} = "${bindir}/edje ${bindir}/edje_* ${datadir}/edje/data/template ${datadir}/edje/include"
RDEPENDS_${PN} += "embryo-utils cpp cpp-symlinks gcc gcc-symlinks"

SRC_URI = "${E_URI}/edje-${PV}.tar.gz \
           ${E_CVS};module=e17/libs/edje/m4;date=20060101"
S = "${WORKDIR}/edje-${PV}"

libraries = ""
headers = ""

do_configure_prepend() {
	install -d "${S}/m4"
	install "${WORKDIR}/m4/"*.m4 "${S}/m4"
	aclocal -I m4
}
