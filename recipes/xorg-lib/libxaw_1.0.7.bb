require xorg-lib-common.inc

DESCRIPTION = "X Athena Widget Set"
DEPENDS += "xproto virtual/libx11 libxext xextproto libxt libxmu libxpm libxp printproto libxau"
PROVIDES = "xaw"
PR = "r2"
PE = "1"

XORG_PN = "libXaw"

do_install_append () {
	ln -sf libXaw6.so.6 ${D}${libdir}/libXaw.so.6
	ln -sf libXaw7.so.7 ${D}${libdir}/libXaw.so.7
	ln -sf libXaw7.so.7 ${D}${libdir}/libXaw.so
}

PACKAGES =+ "libxaw6 libxaw7 libxaw8"

# disable docs as groff detection doesn't work on some hosts while cross compilling
EXTRA_OECONF += " --disable-docs "

FILES_libxaw6 = "${libdir}/libXaw*.so.6*"
FILES_libxaw7 = "${libdir}/libXaw*.so.7*"
FILES_libxaw8 = "${libdir}/libXaw8.so.8*"
