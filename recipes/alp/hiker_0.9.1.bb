DESCRIPTION = "Hiker Application Framework™"
LICENSE = "MPL"

DEPENDS = "gtk+ sqlite3 gnet dbus-glib openssl"

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


SRC_URI[md5sum] = "30efc3312b2e08e9ee9d73569cb987b2"
SRC_URI[sha256sum] = "3391a651df8c011dc2cb0f81118069ce22c2d13b86090b2c0ced4e80c4fa662d"
