require xorg-lib-common.inc
DESCRIPTION = "X Athena Widget Set"
DEPENDS += "xproto virtual/libx11 libxext xextproto libxt libxmu libxpm libxp printproto libxau"
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "030fced589e9128c3cf57564d4a2e1ab"
SRC_URI[archive.sha256sum] = "3daeab01ee702cbc4ac91f11d553710ad31d4151510386093c186a94ccd4beba"

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

XORG_PN = "libXaw"
