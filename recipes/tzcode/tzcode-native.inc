DESCRIPTION = "tzcode, timezone zoneinfo utils -- zic, zdump, tzselect"
INC_PR = "r4"

SRC_URI = " \
        http://tzmirror.sunbase.org/tzfiles/oldtz/tzcode${PV}.tar.gz;name=tzcode-${PV} \
        http://tzmirror.sunbase.org/tzfiles/oldtz/tzdata${TZDATA_PV}.tar.gz;name=tzdata-${TZDATA_PV} \
	"

S = "${WORKDIR}"

inherit native

do_install () {
        install -d ${D}${bindir}
        install -m 755 zic ${D}${bindir}/
        install -m 755 zdump ${D}${bindir}/
        install -m 755 tzselect ${D}${bindir}/
}

NATIVE_INSTALL_WORKS = "1"
