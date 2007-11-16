LICENSE = "LGPL"
DESCRIPTION = "Nokia MCE headers"

PR = "r0"

SRC_URI = "http://archive.ubuntu.com/ubuntu/pool/universe/m/mce-dev/mce-dev_${PV}.tar.gz"

inherit  pkgconfig 

do_compile() {
        :
}


do_install() {
        install -d ${D}${prefix}/include
	install -d ${D}${libdir}/pkgconfig
	cp -pPr include/* ${D}${prefix}/include
	cp *.pc ${D}${libdir}/pkgconfig/
}

do_stage() {
        cp -pPr include/* ${STAGING_INCDIR}/
}


