DESCRIPTION = "A GPS moving map application featuring OpenStreetMap tiles"
HOMEPAGE = "http://neo1973-germany.de/wiki/pylgrim"
AUTHOR = "Josch"
LICENSE = "GPL"
SECTION = "x11/navigation"
DEPENDS = "edje-native"
RDEPENDS = "task-python-efl python-textutils"
PV = "0.0+svnr${SRCREV}"
PE = "1"

SRC_URI = "svn://neo1973-germany.de/svn;module=pylgrim;proto=http"
S = "${WORKDIR}/pylgrim"

do_compile() {
	edje_cc pylgrim.edc
}

do_install() {
	install -d ${D}${datadir}/pylgrim
	for i in *.py pylgrim.edj; do
		install -m 0755 $i ${D}${datadir}/pylgrim/
	done
}

FILES_${PN} += "${datadir}"
