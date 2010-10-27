DESCRIPTION = "Tools needed for cross building Ghostscript"
LICENSE = "GPLv2"
HOMEPAGE = "http://www.gnu.org/software/ghostscript/ghostscript.html"
DEPENDS = "zlib-native fontconfig-native"

S = "${WORKDIR}/ghostscript-${PV}~dfsg"
SRC_URI = "${DEBIAN_MIRROR}/main/g/ghostscript/ghostscript_${PV}~dfsg.orig.tar.gz;name=tarball"

inherit autotools native

SRC_URI[tarball.md5sum] = "e42706c2409815df5c959484080fd4a3"
SRC_URI[tarball.sha256sum] = "cc856d33cb781cdc3383b8eb4e0f390997f8359fe144a906b84297b5d377f03d"

EXTRA_OECONF = "--without-x --without-jasper"

do_compile() {
        mkdir -p obj
        for i in genarch genconf mkromfs echogs gendev genht; do
                oe_runmake obj/$i
        done
}

NATIVE_INSTALL_WORKS = "1"

do_install () {
	install -d ${D}${bindir}/gs-tools-${PV}
        for i in genarch genconf mkromfs echogs gendev genht; do
		install -m 755 obj/$i ${D}${bindir}/gs-tools-${PV}/$i
	done
}
