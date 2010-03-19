DESCRIPTION = "Firmware for MSM wl1251 wifi chipset (e.g. trout/HTC Dream)"
LICENCE = "Texas Instruments"

SRC_URI = "\
	http://ftp.o2s.ch/pub/openmoko/firmware-wl12xx/wl1251-fw.bin;name=fw \
	http://ftp.o2s.ch/pub/openmoko/firmware-wl12xx/wl1251-nvs.bin;name=nvs \
"

SRC_URI[fw.md5sum] = "ebf5c2036d37bc56b4d41ddcbda4311e"
SRC_URI[fw.sha156sum] = "c4b8a41024caa27218304d9cba4e3099900f365d3b006832457bfb8a563f740a"
SRC_URI[nvs.md5sum] = "e430dbf16bdc9fe6adfd9e108d059d76"
SRC_URI[nvs.sha156sum] = "67e4cf4d90fb65610125c2fded850d63900017aecafcadbaf50fe3d0369216f2"

S = "${WORKDIR}/"

do_install() {
	install -d ${D}${base_libdir}/firmware
	cp ${S}/wl1251-fw.bin ${D}${base_libdir}/firmware/wl1251-fw.bin
	cp ${S}/wl1251-nvs.bin ${D}${base_libdir}/firmware/wl1251-nvs.bin
}

PACKAGES = "${PN}"
FILES_${PN} += "${base_libdir}/firmware"

PACKAGE_ARCH = "all"
