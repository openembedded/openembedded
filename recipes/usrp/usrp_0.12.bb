DESCRIPTION = "Support software for the Universal Software Radio Peripheral (USRP)"
LICENSE = "GPL"
HOMEPAGE = "http://comsec.com/wiki?UniversalSoftwareRadioPeripheral"
SECTION = "devel"
DEPENDS = "swig-native sdcc-native virtual/libusb0 python boost"
RDEPENDS = "python-core"
PR = "r1"

SRC_URI = "ftp://ftp.gnu.org/gnu/gnuradio/usrp-${PV}.tar.gz \
           file://fix_compile_h.patch;patch=1;pnum=3 \
           file://install_test.patch;patch=1"

SRC_URI_append_omap5912osk = "file://usb11.patch;patch=1"

S = "${WORKDIR}/usrp-${PV}"

inherit autotools pkgconfig python-dir

CXXFLAGS_powerpc += "-lstdc++"

export BUILD_SYS := "${BUILD_SYS}"
export HOST_SYS := "${HOST_SYS}"

do_stage () {
     oe_libinstall -so -C host/lib/.libs/ libusrp ${STAGING_LIBDIR}

     install -m 644 host/lib/usrp_basic.h ${STAGING_INCDIR}
     install -m 644 host/lib/usrp_bytesex.h ${STAGING_INCDIR}
     install -m 644 host/lib/usrp_config.h ${STAGING_INCDIR}
     install -m 644 host/lib/usrp_dbid.h ${STAGING_INCDIR}
     install -m 644 host/lib/usrp_prims.h ${STAGING_INCDIR}
     install -m 644 host/lib/usrp_slots.h ${STAGING_INCDIR}
     install -m 644 host/lib/usrp_standard.h ${STAGING_INCDIR}

     install -m 644 firmware/include/usrp_i2c_addr.h ${STAGING_INCDIR}
     install -m 644 firmware/include/usrp_spi_defs.h ${STAGING_INCDIR}
}

PACKAGES += "python-pyusrp-dbg python-pyusrp"
FILES_python-pyusrp-dbg += "${PYTHON_SITEPACKAGES_DIR}/.debug"
FILES_python-pyusrp = "${libdir}/python*"
