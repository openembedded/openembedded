DESCRIPTION = "Opkg Package Manager"
DESCRIPTION_libopkg = "Opkg Package Manager Library"
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "curl gpgme"
PV = "0.1.4+svnr${SRCREV}"

SRC_URI = "svn://svn.openmoko.org/trunk/src/target/;module=opkg;proto=http \
           file://fix_endianness.patch;patch=1;maxrev=4246"
S = "${WORKDIR}/opkg"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
