PACKAGES = "libviaXvMC libviaXvMCPro libviaXvMC-dev libviaXvMCPro-dev libviaXvMC-dbg libviaXvMCPro-dbg ${PN}-doc"

FILES_libviaXvMC = "${libdir}/libviaXvMC.so.*"
FILES_libviaXvMCPro = "${libdir}/libviaXvMCPro.so.*"
FILES_libviaXvMC-dev = "${libdir}/libviaXvMC.so ${libdir}/libviaXvMC.la"
FILES_libviaXvMCPro-dev = "${libdir}/libviaXvMCPro.so ${libdir}/libviaXvMCPro.la"
FILES_libviaXvMC-dbg += "${libdir}/.debug/libviaXvMC.so.*"
FILES_libviaXvMCPro-dbg += "${libdir}/.debug/libviaXvMCPro.so.*"

DEPENDS = "xserver-xorg libxvmc"

inherit autotools xorg-module

