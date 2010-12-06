DESCRIPTION = "Bug framebuffer progress indicator"
AUTHOR = "Angel Roman"
HOMEPAGE = "http://www.buglabs.net/"
LICENSE = "GPL"
DEPENDS = "freetype zlib virtual/kernel"
SRCREV = "9405"
PR = "r2"

SRC_URI = "svn://bugcamp.net/bug/trunk;module=com.buglabs.bug.native.fbprogress;proto=svn \
           file://fbprogress-init"

S = "${WORKDIR}/com.buglabs.bug.native.fbprogress"

inherit update-rc.d

TARGET_CXXFLAGS += "-I${STAGING_INCDIR}/freetype2 -I${STAGING_KERNEL_DIR}/include"
TARGET_LDFLAGS  += "-L${STAGING_LIBDIR} -lfreetype -lz"

do_install() {
  install -d ${D}/${datadir}/fbprogress
  install -m 0644 ${S}/images/* ${D}/${datadir}/fbprogress/

  install -d ${D}${bindir}
  install -m 0755 fbprogress ${D}${bindir}
  install -m 0755 fbprogress.sh ${D}${bindir}

  install -d ${D}/${sysconfdir}/init.d
  install -m 0755 ${WORKDIR}/fbprogress-init ${D}/${sysconfdir}/init.d/fbprogress
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "bug"

INITSCRIPT_NAME = "fbprogress"
INITSCRIPT_PARAMS = "start 01 S . stop 15  0 1 2 3 4 5 6 ."
