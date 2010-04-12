LICENSE = "GPL"
SECTION = "console/network"
PRIORITY = "standard"
DESCRIPTION = "Tools for zmodem/xmodem/ymodem file transfer"
DEPENDS = ""
PR = "r4"

SRC_URI = "http://www.ohse.de/uwe/releases/lrzsz-${PV}.tar.gz \
	   file://autotools.patch;patch=1 \
	   file://makefile.patch;patch=1 \
	   file://gettext.patch;patch=1"

inherit autotools gettext

do_install() {
	install -d ${D}${bindir}/
	install -m 0755 src/lrz src/lsz ${D}${bindir}/
}

pkg_postinst() {
	for util in rz rx rb; do
		update-alternatives --install ${bindir}/$util $util lrz 100
	done
	for util in sz sx sb; do
		update-alternatives --install ${bindir}/$util $util lsz 100
	done
}

pkg_postrm() {
	for util in rz rx rb; do
		update-alternatives --remove $util ${bindir}/lrz
	done
	for util in sz sx sb; do
		update-alternatives --remove $util ${bindir}/lsz
	done
}
SRC_URI[md5sum] = "b5ce6a74abc9b9eb2af94dffdfd372a4"
SRC_URI[sha256sum] = "c28b36b14bddb014d9e9c97c52459852f97bd405f89113f30bee45ed92728ff1"
