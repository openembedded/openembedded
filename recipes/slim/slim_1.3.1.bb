DESCRIPTION="Simple Login Manager"
HOMEPAGE="http://slim.berlios.de"
LICENSE = "GPLv2+"

PR = "r1"

inherit update-rc.d

DEPENDS = "virtual/x11 libxmu libpng libjpeg libpam freetype sessreg"
RDEPENDS_${PN} = "perl libpam-meta xauth freetype sessreg"

SRC_URI = " \
  http://download.berlios.de/${PN}/${P}.tar.gz \
  file://fix-manpage.patch;apply=1 \
  file://ftbfs_gcc_4.4.patch;apply=1 \
  file://Makefile.patch;apply=1 \
  file://xauth_secret_support.patch;apply=1 \
  file://delay.patch;apply=1 \
  file://pam-unix2.patch;apply=1 \
  file://types.patch;apply=1 \
  file://rc.slim \
  file://slim-dynwm \
  file://update_slim_wmlist \
  file://Makefile.oe \
  file://slim.pamd \
"

EXTRA_OEMAKE += " \
  USE_PAM=1 \
  PREFIX=${prefix} \
  CFGDIR=${sysconfdir} \
  MANDIR=${mandir} \
  DESTDIR=${D} \
  CFLAGS+=-I${STAGING_INCDIR}/freetype2 \
  CXXFLAGS+=-I${STAGING_INCDIR}/freetype2 \
  LDFLAGS+=-lXft \
  LDFLAGS+=-lX11 \
  LDFLAGS+=-lfreetype \
  LDFLAGS+=-lXrender \
  LDFLAGS+=-lfontconfig \
  LDFLAGS+=-lpng12 \
  LDFLAGS+=-lz \
  LDFLAGS+=-lm \
  LDFLAGS+=-lcrypt \
  LDFLAGS+=-lXmu \
  LDFLAGS+=-lpng \
  LDFLAGS+=-ljpeg \
  LDFLAGS+=-lrt \
  LDFLAGS+=-lpam \
"

do_compile_prepend() {
  cp -pP ${WORKDIR}/Makefile.oe ${S}/Makefile
}

do_install() {
  oe_runmake install
  install -d ${D}${bindir}
  install -m 0755 ${WORKDIR}/slim-dynwm ${D}${bindir}/
  install -m 0755 ${WORKDIR}/update_slim_wmlist ${D}${bindir}/
  install -d ${D}${sysconfdir}/pam.d/
  install -m 0644 ${WORKDIR}/slim.pamd ${D}${sysconfdir}/pam.d/slim
  install -d ${D}${sysconfdir}/init.d/
  install -m 0755 ${WORKDIR}/rc.slim ${D}${sysconfdir}/init.d/slim-init

  echo 'sessionstart_cmd    /usr/bin/sessreg -a -l $DISPLAY %user' >> ${D}${sysconfdir}/slim.conf
  echo 'sessionstop_cmd     /usr/bin/sessreg -d -l $DISPLAY %user' >> ${D}${sysconfdir}/slim.conf
}

INITSCRIPT_NAME = "slim-init"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 20 0 1 6 ."

pkg_postinst_${PN} () {
# Register SLiM as default DM
mkdir -p ${sysconfdir}/X11/
echo "${bindir}/slim" > ${sysconfdir}/X11/default-display-manager
}

pkg_postrm_${PN} () {
sed -i /slim/d ${sysconfdir}/X11/default-display-manager || true
}

SRC_URI[md5sum] = "727d0acb24c0fbf0751134c37a9c895f"
SRC_URI[sha256sum] = "acd7a4024bfd7c2a4f3cd5d77ffed4956d13727a8f554042126d0568defe0f77"
