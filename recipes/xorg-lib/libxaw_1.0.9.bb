require xorg-lib-common.inc
DESCRIPTION = "X Athena Widget Set"
DEPENDS += "xproto virtual/libx11 libxext xextproto libxt libxmu libxpm libxp printproto libxau"
PE = "1"
PR = "${INC_PR}.1"

SRC_URI[archive.md5sum] = "ccc57478c41b7a75b9702241b889b1d4"
SRC_URI[archive.sha256sum] = "a83977546b78e24ac5dca86affc10b6404a87c16272405b05386feca1a2db037"

# disable docs as groff detection doesn't work on some hosts while cross compilling
EXTRA_OECONF += " --disable-docs "

do_install_append () {
        ln -sf libXaw6.so.6 ${D}${libdir}/libXaw.so.6
        ln -sf libXaw7.so.7 ${D}${libdir}/libXaw.so.7
        ln -sf libXaw7.so.7 ${D}${libdir}/libXaw.so
}

PACKAGES =+ "libxaw6 libxaw7 libxaw8"

FILES_libxaw6 = "${libdir}/libXaw*.so.6*"
FILES_libxaw7 = "${libdir}/libXaw*.so.7*"
FILES_libxaw8 = "${libdir}/libXaw8.so.8*"

# fix -dev depchains
ALLOW_EMPTY_${PN} = 1

XORG_PN = "libXaw"
