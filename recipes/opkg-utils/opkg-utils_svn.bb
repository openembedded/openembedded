DESCRIPTION = "OPKG Package Manager Utilities"
SECTION = "base"
HOMEPAGE = "http://wiki.openmoko.org/wiki/Opkg"
PRIORITY = "optional"
RDEPENDS_${PN} = "python"
RDEPENDS_${PN}_virtclass-native = ""
SRCREV = "4747"
PV = "0.1.8+svnr${SRCPV}"
PR = "r5"

SRC_URI = "svn://svn.openmoko.org/trunk/src/host/;module=opkg-utils;proto=http \
           file://index-ignore-filenotfound.patch"

S = "${WORKDIR}/opkg-utils"

# Avoid circular dependencies from package_ipk.bbclass
PACKAGES_virtclass-native = ""

do_install() {
        oe_runmake PREFIX=${prefix} DESTDIR=${D} install
}

BBCLASSEXTEND = "native"
TARGET_CC_ARCH += "${LDFLAGS}"
