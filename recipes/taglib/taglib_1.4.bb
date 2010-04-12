DESCRIPTION = "TagLib is a library for reading and editing the meta-data of several popular audio formats"
SECTION = "libs/multimedia"
HOMEPAGE = "http://developer.kde.org/~wheeler/taglib.html"
LICENSE = "LGPL"
PR = "r2"

SRC_URI = "http://developer.kde.org/~wheeler/files/src/taglib-${PV}.tar.gz \
           file://taglib_1.4-8.diff.gz;patch=1"
S = "${WORKDIR}/taglib-${PV}"

inherit autotools pkgconfig binconfig

do_postpatch() {
	rm -rf patches && rm -rf .pc && mv -f debian/patches patches && quilt push -av
}
addtask postpatch after do_patch before do_configure

do_stage() {
	autotools_stage_all
}

PACKAGES =+ "${PN}-c"
FILES_${PN}-dbg += "${bindir}/taglib-config"
FILES_${PN}-c = "${libdir}/libtag_c.so.*"

SRC_URI[md5sum] = "dcd50ddb2544faeae77f194804559404"
SRC_URI[sha256sum] = "0ff805bb8dbf72a45d347f2310f7e5c86e2e7419a069d546e53cf5f221c196ab"
