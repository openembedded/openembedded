DESCRIPTION = "This package contains various hardware identification and configuration data, such as the pci.ids database, or the XFree86/xorg Cards database. It's needed for the kudzu hardware detection."
LICENSE = "GPL + X11"

PR = "r1"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/main/h/hwdata/hwdata_0.191.orig.tar.gz \
           http://archive.ubuntu.com/ubuntu/pool/main/h/hwdata/hwdata_0.191-1.diff.gz;patch=1 \
	   "

PACKAGE_ARCH = "all"
FILES_${PN} = "${datadir}"

do_install() {
	mkdir -p ${D}${datadir}/hwdata	
	install -m 644 MonitorsDB pci* usb.ids video* upgradelist  ${D}${datadir}/hwdata
}
