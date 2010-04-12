DESCRIPTION = "This package contains various hardware identification and configuration data, such as the pci.ids database, or the XFree86/xorg Cards database. It's needed for the kudzu hardware detection."
LICENSE = "GPL + X11"

PR = "r1"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/main/h/hwdata/hwdata_0.191.orig.tar.gz;name=archive \
           http://archive.ubuntu.com/ubuntu/pool/main/h/hwdata/hwdata_0.191-1.diff.gz;patch=1;name=patch \
	   "

PACKAGE_ARCH = "all"
FILES_${PN} = "${datadir}"

do_install() {
	mkdir -p ${D}${datadir}/hwdata	
	install -m 644 MonitorsDB pci* usb.ids video* upgradelist  ${D}${datadir}/hwdata
}

SRC_URI[archive.md5sum] = "7a261b9eb813406f73b5eca2570f949a"
SRC_URI[archive.sha256sum] = "3cc7f3ef2cd0f789ef1665102e214fe2e6b29b5eb285c3c8a3216c5c98fa563d"
SRC_URI[patch.md5sum] = "0719e6cccf5279b4d2fb0a3ddbecd874"
SRC_URI[patch.sha256sum] = "8276d76e45e3e827fc109940fcc3afe010ec8ddd583f44b3c946af6c29f2d828"
