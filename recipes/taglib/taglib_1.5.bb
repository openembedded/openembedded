DESCRIPTION = "TagLib is a library for reading and editing the meta-data of several popular audio formats"
SECTION = "libs/multimedia"
HOMEPAGE = "http://developer.kde.org/~wheeler/taglib.html"
LICENSE = "LGPL"
PR = "r2"

SRC_URI = "http://developer.kde.org/~wheeler/files/src/taglib-${PV}.tar.gz \
           file://add_missing_exports_fix.diff;patch=1 \
	   file://gcc_visibility_feature.diff;patch=1 \
	   file://link_interface_libraries_fix.diff;patch=1 \
	  "

S = "${WORKDIR}/taglib-${PV}"

inherit cmake pkgconfig binconfig

do_stage() {
	 install -d ${STAGING_INCDIR}/${PN}
         install -m 0644 ${D}/${includedir}/${PN}/*.h ${STAGING_INCDIR}/${PN}
         install -m 0644 ${D}/${includedir}/${PN}/*.tcc ${STAGING_INCDIR}/${PN}
	 oe_libinstall -C ${PN} -so libtag ${STAGING_LIBDIR}
}

LEAD_SONAME = "libtag.so.1"

PACKAGES =+ "${PN}-c"

FILES_${PN} = "${libdir}/libtag.so.*"
FILES_${PN}-c = "${libdir}/libtag_c.so.*"

SRC_URI[md5sum] = "7b557dde7425c6deb7bbedd65b4f2717"
SRC_URI[sha256sum] = "ba610716ec539d4858133e008d079728953820c583b200ff0936e36fc0550ec2"
