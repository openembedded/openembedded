DESCRIPTION = "Hiker Application Framework™"
LICENSE = "MPL"

DEPENDS = "gtk+ sqlite3 gnet dbus-glib"

SRC_URI = "http://www.access-company.com/downloads/${P}.tar.gz"

inherit autotools pkgconfig lib_package

export CFLAGS += "-DALP_BUILD=ALP_BUILD_DEBUG"
export CXXFLAGS += "-DALP_BUILD=ALP_BUILD_DEBUG"

do_configure_prepend() {
	sed -i s:unittest::g utils/Makefile.am
}

PACKAGES =+ "libhiker libsqlfs"
FILES_libhiker += "${libdir}/libhiker*.so.*"
FILES_libsqlfs += "${libdir}/libsql*.so.*"

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "f4cbf05743ccb34282e4dc3aef489f72"
SRC_URI[sha256sum] = "6633c4124c41d9a1ca526161062fd276f352b4228bde4f565d38d35c15a3005c"
