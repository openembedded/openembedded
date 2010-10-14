DESCRIPTION = "Disko is an application framework, that can be used to develop GUI applications for embedded devices. It is closely connected to the DirectFB"
LICENSE = "LGPL"
PR = "r0"

require disko.inc

DEPENDS += "taglib directfb virtual/libx11 hal libxv libxxf86vm"

SRC_URI = "http://www.diskohq.com/repository/ubuntu/pool/${PN}_${PV}.tar.gz \
           file://mmsfiletransfer.patch \
	  "

do_compile() {
    if [ "${SCONS_FIX_ENV}" = "1" ] ; then
        if grep "toolchain-from-env" ${S}/SConstruct ; then
            echo "Toolchain overrides already applied"
        else
           cat ${STAGING_DATADIR_NATIVE}/scons/toolchain-from-env.SConscript >> ${S}/SConstruct
        fi
    fi

    ${STAGING_BINDIR_NATIVE}/scons ${PARALLEL_MAKE} CXX="${CXX}" PREFIX=${prefix} prefix=${prefix} graphics=all || \
    oefatal "scons build execution failed."
}

SRC_URI[md5sum] = "23162e567fd980c20ba40b574afd9276"
SRC_URI[sha256sum] = "9ec9f5c4c03716cc1d24cc8bce252f4d44ce56837e37f1b9cb6ddc44639dedfc"
