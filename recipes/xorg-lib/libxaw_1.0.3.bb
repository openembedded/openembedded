require xorg-lib-common.inc

DESCRIPTION = "X Athena Widget Set"
DEPENDS += "xproto virtual/libx11 libxext xextproto libxt libxmu libxpm libxp printproto libxau"
PROVIDES = "xaw"
PR = "r1"
PE = "1"

XORG_PN = "libXaw"

do_stage_append () {
	ln -sf libXaw6.so.6 ${STAGING_LIBDIR}/libXaw.so.6
	ln -sf libXaw7.so.7 ${STAGING_LIBDIR}/libXaw.so.7
	ln -sf libXaw7.so.7 ${STAGING_LIBDIR}/libXaw.so
}

PACKAGES =+ "libxaw6 libxaw7 libxaw8"

FILES_libxaw6 = "${libdir}/libXaw6.so.6*"
FILES_libxaw7 = "${libdir}/libXaw7.so.7*"
FILES_libxaw8 = "${libdir}/libXaw8.so.8*"

SRC_URI[archive.md5sum] = "ee215536ea78798268ab3a444d10135a"
SRC_URI[archive.sha256sum] = "45ca55bdac904a07b8118618c65ddb5bf8826e626c4c927e3c2508c58e231514"
