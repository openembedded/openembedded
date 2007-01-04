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

