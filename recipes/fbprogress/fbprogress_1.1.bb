DESCRIPTION = "Bug framebuffer progress indicator"
AUTHOR = "Angel Roman"
HOMEPAGE = "http://www.buglabs.net/"
LICENSE = "GPL"
DEPENDS = "freetype zlib virtual/kernel"
SRCREV = "9118"
PR = "r1"

SRC_URI = "svn://svn.buglabs.net/bug/trunk;module=com.buglabs.bug.native.fbprogress;proto=svn \
           file://fbprogress-init"

S = "${WORKDIR}/com.buglabs.bug.native.fbprogress"

inherit update-rc.d

EXTRA_OEMAKE = "BUG_LINUX_SRC=${STAGING_KERNEL_DIR}"

do_install() {
  install -d ${D}/${sysconfdir}/fbprogress
  install -m 0644 ${S}/images/* ${D}/${sysconfdir}/fbprogress/
  install -d ${D}${layout_bindir}
  install -m 0755 fbprogress ${D}${layout_bindir}
  install -m 0755 fbprogress.sh ${D}${layout_bindir}
  install -d ${D}/${sysconfdir}/init.d
  install -m 0755 ${WORKDIR}/fbprogress-init ${D}/${sysconfdir}/init.d/fbprogress
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "bug"

INITSCRIPT_NAME = "fbprogress"
INITSCRIPT_PARAMS = "start 01 S . stop 15  0 1 2 3 4 5 6 ."
