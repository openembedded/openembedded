DESCRIPTION = "Disko is an application framework, that can be used to develop GUI applications for embedded devices."
LICENSE = "LGPL"
DEPENDS = "sqlite3 libpng jpeg curl alsa-lib freetype libxml2 libsigc++-2.0 openssl taglib directfb virtual/libx11 libxv libxxf86vm"
INC_PR = "r1"

inherit scons pkgconfig

SRC_URI = "http://www.diskohq.com/repository/ubuntu/pool/${PN}_${PV}.tar.gz"

ARM_INSTRUCTION_SET = "arm"
LD = ${CXX}

do_compile() {
        ${STAGING_BINDIR_NATIVE}/scons ${PARALLEL_MAKE} graphics=all prefix=${prefix}/ || \
        oefatal "scons build execution failed."
}

#workaround for disko which creates .pc inside install
do_install_append () {

for i in `find ${S}/ ${D}/${libdir}/pkgconfig -name "*.pc" -type f` ; do \
            sed -i -e 's:${D}::g' $i
        done
}
