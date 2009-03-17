DESCRIPTION = "Microwindows Graphical Engine"
SECTION = "x11/wm"
PRIORITY = "optional"
DEPENDS = "libpng jpeg zlib"
LICENSE = "GPL"

PR="r2"

PARALLEL_MAKE = ""

EXTRA_OEMAKE = " \
  -C ${S}/src \
  ARMTOOLSPREFIX=${TARGET_PREFIX}	\
  INCJPEG=${STAGING_INCDIR} \
  LIBJPEG=${STAGING_LIBDIR}/libjpeg.so \
  INCPNG=${STAGING_INCDIR} \
  LIBPNG=${STAGING_LIBDIR}/libpng.so \
  LIBZ=${STAGING_LIBDIR}/libz.so \
  INSTALL_PREFIX=${D}${prefix} \
  INSTALL_OWNER1= \
  INSTALL_OWNER2= \
 "

do_compile() {
  cp ${WORKDIR}/defconfig ${S}/src/config
  oe_runmake
}

do_stage() {
  install -m 0644 ${S}/src/include/nano-X.h ${STAGING_INCDIR}/
  install -m 0644 ${S}/src/include/mwtypes.h ${STAGING_INCDIR}/
  install -m 0644 ${S}/src/include/nxcolors.h ${STAGING_INCDIR}/
  install -m 0644 ${S}/src/include/nxdraw.h ${STAGING_INCDIR}/
  install -m 0755 ${S}/src/lib/*.so ${STAGING_LIBDIR}/
  install -m 0644 ${S}/src/lib/*.a ${STAGING_LIBDIR}/
}

do_install() {
  oe_runmake install all

# the next 3 lines are necessary for snapshot build since it has CVS cruft in the tarball
  rm -rf ${S}/src/lib/CVS
  rm -rf ${S}/src/bin/CVS
  rm -f ${S}/src/bin/fonts

# convbdf is a host tool - don't install it  
  mkdir ${S}/src/hostbin
  mv ${S}/src/bin/convbdf ${S}/src/hostbin

  install -d ${D}${bindir} ${D}$bindir}/fonts ${D}${libdir} 
  install -m 0755 ${S}/src/lib/*   ${D}${libdir}/
  install -m 0755 ${S}/src/bin/*   ${D}${bindir}/
}

FILES_${PN}="${bindir}/* ${libdir}/*"
